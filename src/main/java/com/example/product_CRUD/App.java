package com.example.product_CRUD;

public class App {
    public static void main(String[] args) {

        ProductDAO.insertProducts();     // STEP 2
        ProductDAO.sortByPrice();        // STEP 3
        ProductDAO.paginationExample();  // STEP 4
        ProductDAO.aggregateQueries();   // STEP 5
    }
}
