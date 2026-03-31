package com.sparktech.InstaGet.product.dto;

import com.sparktech.InstaGet.product.entity.Product;

public class ProductDto {

    private int id;
    private String name;
    private double price;

    public ProductDto() {}

    public ProductDto(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static ProductDto fromProduct(Product product) {
        return new ProductDto(product.getId(), product.getName(), product.getPrice());
    }

    public Product toProduct() {
        return new Product(this.name, this.price);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
