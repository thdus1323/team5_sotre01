package com.example.store;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final EntityManager em;

    //상품 목록보기
    public List<ProductResponse.ListDTO> getProductList() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(ProductResponse.ListDTO::new)
                .collect(Collectors.toList());
    }

    //상품 상세 보기
    public ProductResponse.DetailDTO getProductDetail(int id){
       Product product = productRepository.findById(id);
       return new ProductResponse.DetailDTO(product);
    }

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
