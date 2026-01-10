package com.example.product_CRUD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private String description;
private double price;
private int quantity;

public Product() {}

public Product(String name, String description, double price, int quantity) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.quantity = quantity;
}

public int getId() { return id; }
public String getName() { return name; }
public String getDescription() { return description; }
public double getPrice() { return price; }
public int getQuantity() { return quantity; }
}
