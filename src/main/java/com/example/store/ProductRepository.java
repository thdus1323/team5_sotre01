package com.example.store;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private final EntityManager em;

    public List<Product> findAll() {
    Query query = em.createNativeQuery("select * from product_tb order by id desc", Product.class);
    return query.getResultList();
    }

//    public void save() {
//    }
//
//    public void findById() {
//    }
//
//    public void updateById() {
//    }
//
//    public void deleteById() {
//    }
//
//

}
