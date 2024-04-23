package com.example.store;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final EntityManager em;
    //상품 목록보기
    public List<Product> findAll() {
        List<Product> productList = productRepository.findAll();

        return productList;
    }

    //상품 상세 보기


    //상품 등록

    //상품 업데이트

    //상품 삭제
//    @Transactional
//    public void save(String name, Integer price, Integer qty) {
//    }
//
////    public Product findById(Integer id) {
////        return Product
////    }
//
//    @Transactional
//    public void updateById(Integer id, String name, Integer price, Integer qty) {
//    }
//
//    public Product findById(Integer id) {
//    }


}
