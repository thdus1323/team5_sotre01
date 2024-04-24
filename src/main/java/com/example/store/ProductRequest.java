package com.example.store;

import lombok.Data;

import javax.swing.plaf.PanelUI;

public class ProductRequest {

    @Data
    public static class SaveDTO{
        private String name;
        private Integer price;
        private Integer qty;

//        public Product toEntity(Product product){
//            return Product.builder()
//                    .name(name)
//                    .price(price)
//                    .qty(qty)
//                    .build();
//        }
    }

    @Data
    public static class UpdateDTO{
        private Integer price;
        private Integer qty;
    }

}
