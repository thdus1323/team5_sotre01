package com.example.store;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;


    //상품목록보기완료
    @GetMapping({"/product", "/"})
    public String list(HttpServletRequest request){
        List<ProductResponse.ListDTO> productList = productService.getProductList();
        request.setAttribute("productList", productList);
        return "product/list";
    }

    //상세보기완료
    @GetMapping("/product/{id}")
    public String detail(@PathVariable Integer id, HttpServletRequest request) {
        ProductResponse.DetailDTO product = productService.getProductDetail(id);
        request.setAttribute("product",product);
        return "product/detail";
    }
    
    //상품등록 완료
    @PostMapping("/product/save")
    public String save(String name, Integer price, Integer qty) {
        productRepository.save(name, price, qty);
        return "redirect:/";
    }
    
    @GetMapping("/product/save-form")
    public String saveForm() {
        return "product/save-form";
    }
    

    @GetMapping("/product/{id}/update-form")
    public String updateForm(@PathVariable Integer id, HttpServletRequest request) {
//        Product product = productService.findById(id);
//        request.setAttribute("product", product);

        return "product/update-form";
    }


    @PostMapping("/product/{id}/update")
    public String update(@PathVariable Integer id, String name, Integer price, Integer qty) {
//        productService.updateById(id, name,price,qty);
        return "redirect:/product/" + 1;
    }

    @PostMapping("/product/{id}/delete")
    public String delete() {
        return "redirect:/product";
    }
}
