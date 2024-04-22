package com.example.store;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final EntityManager em;

    //상품 상세 보기
    public ProductResponse.DetailDTO getProductDetail(int id){
        return productRepository.findById(id);
    }
    //상품 목록보기
    public List<ProductResponse.ListDTO> getProductList(){
        return productRepository.findAll();
    }
    //상품 등록
    @Transactional
    public ProductResponse.SaveDTO saveProduct(ProductRequest.SaveDTO reqDTO) {
        Product product = productRepository.save(reqDTO.toEntity());
        return new ProductResponse.SaveDTO(product);
    }

    //상품 업데이트
    @Transactional
    public ProductResponse.UpdateDTO updateProduct(int id, ProductRequest.UpdateDTO reqDTO){
        Product product = productRepository.updateById(id, reqDTO);
        return new ProductResponse.UpdateDTO(product);
    }
    //상품 삭제
    @Transactional
    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }
}
