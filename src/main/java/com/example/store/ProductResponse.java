package com.example.store;

import lombok.Data;

public class ProductResponse {

    @Data
    public static class ListDTO{
        private int id;
        private String name;
        private int price;
        private int qty;
    }
}
