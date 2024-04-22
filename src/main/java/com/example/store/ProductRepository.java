package com.example.store;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private final EntityManager em;

    //상품삭제
    @Transactional
    public void deleteById(int id) {
        Query query =
                em.createQuery("delete from Product p where p.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public Product save(Product product) {
        em.persist(product);
        return product;
    }

    public ProductResponse.DetailDTO findById(int id) {
        Product product = em.find(Product.class, id);
        return new ProductResponse.DetailDTO(product);
    }

    public List<ProductResponse.ListDTO> findAll() {
        Query query =
                em.createQuery("select p from Product p order by p.id desc", Product.class);
        return query.getResultList();
    }
}
