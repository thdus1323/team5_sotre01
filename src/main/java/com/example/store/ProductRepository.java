package com.example.store;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private final EntityManager em;

    //상품목록보기완료
    public List<Product> findAll() {
    Query query = em.createNativeQuery("select * from product_tb order by id desc", Product.class);
    return query.getResultList();
    }

    //상품등록 완료
    @Transactional
    public void save(String name, Integer price, Integer qty) {
        //네이티브쿼리 -> 삽입에는 테이블명()
        Query query = em.createNativeQuery("insert into product_tb(name, price, qty, created_at) values (?,?,?,now())");
        query.setParameter(1, name); //
        query.setParameter(2, price); //
        query.setParameter(3, qty);
        query.executeUpdate();

    }

    public Product findById(int id) {
        Query query = em.createNativeQuery("select * from product_tb where id = ?",Product.class);
        query.setParameter(1,id);
        return (Product) query.getSingleResult();
    }


//
//    public void updateById() {
//    }
//
//    public void deleteById() {
//    }
//
//

}
