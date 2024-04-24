package com.example.store;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
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
    public void save(ProductRequest.SaveDTO reqDTO) {
        //네이티브쿼리 -> 삽입에는 테이블명()
        Query query = em.createNativeQuery("insert into product_tb(name, price, qty, created_at) values (?,?,?,now())");
        query.setParameter(1, reqDTO.getName()); //
        query.setParameter(2, reqDTO.getPrice()); //
        query.setParameter(3, reqDTO.getQty());
        query.executeUpdate();

    }

    public Product findById(int id) {
        Query query = em.createNativeQuery("select * from product_tb where id = ?", Product.class);
        query.setParameter(1, id);
        return (Product) query.getSingleResult();
    }

    public void updateById(Integer id, ProductRequest.UpdateDTO requestDTO) {
        Query query = em.createNativeQuery("update product_tb set price=?, qty=? where id=?");
        query.setParameter(1, requestDTO.getPrice());
        query.setParameter(2, requestDTO.getQty());
        query.setParameter(3, id);
        query.executeUpdate();
    }

    public void deleteById(Integer id) {
        Query query = em.createNativeQuery("delete from product_tb where id = ?");
        query.setParameter(1, id);

        query.executeUpdate();
    }

}
