package com.example.store;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final EntityManager em;

    //상품 목록보기
    public List<ProductResponse.ListDTO> getProductList(){
        return productRepository.findAll();
    }
    //상품 등록

    //상품 업데이트

    //상품 삭제
}
