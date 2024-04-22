package com.example.store;

import lombok.Data;

public class ProductResponse {

    @Data
    public static class UpdateDTO{
        private int id;
        private String name;
        private int price ;
        private int qty;

        public UpdateDTO(Product product){
            this.id = product.getId();
            this.name = product.getName();
            this.price = product.getPrice();
            this.qty = product.getQty();
        }
    }

    @Data
    public static class SaveDTO{
        private int id;
        private String name;
        private int price ;
        private int qty;
        public SaveDTO(Product product){
            this.id = product.getId();
            this.name = product.getName();
            this.price = product.getPrice();
            this.qty = product.getQty();
        }
    }

    @Data
    public static class DetailDTO{
        private int id;
        private String name;
        private int price ;
        private int qty;

        public DetailDTO(Product product){
            this.id = product.getId();
            this.name = product.getName();
            this.price = product.getPrice();
            this.qty = product.getQty();
        }
    }


    @Data
    public static class ListDTO{
        private int id;
        private String name;
        private int price;
        private int qty;
    }
}
