package com.example.store;

import lombok.Data;

public class ProductRequest {
    @Data
    public static class SaveDTO{
        private String name;
        private int price;
        private int qty;

        public Product toEntity() {
            return Product.builder()
                    .name(name)
                    .price(price)
                    .qty(qty)
                    .build();

        }
    }
    @Data
    public static class UpdateDTO {
        private String name;
        private Integer price;
        private Integer qty;
    }
}
