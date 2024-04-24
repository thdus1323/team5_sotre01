package com.example.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    //상품 목록보기
    public List<ProductResponse.ListDTO> getProductList() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(ProductResponse.ListDTO::new)
                .collect(Collectors.toList());
    }

    //상품 상세 보기
    public ProductResponse.DetailDTO getProductDetail(Integer id){
       Product product = productRepository.findById(id);
       return new ProductResponse.DetailDTO(product);
    }

    public Product findById(Integer id) {
        Product product =  productRepository.findById(id);
        return product;
    }

    //상품 등록
    @Transactional
    public void addProduct(ProductRequest.SaveDTO reqDTO) {
        productRepository.save(reqDTO);
    }
//
//    public Product findById(Integer id) {
//        return Product
//    }
//

    //상품 업데이트
//    @Transactional
//    public void updateById(Integer id, ProductRequest.UpdateDTO requestDTO){
//        productRepository.updateById(id, requestDTO);
//    }

    //상품 삭제
    @Transactional
    public void deleteById(Integer id){

    }





}
