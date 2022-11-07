package com.shpopforhome.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

    private String category;
    private String name;
    private float price;

    private String description;
    private int quantity;
    private float rating;

    private String review;



    public Product(String category, String name, float price, String description, int quantity, float rating, String review) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.rating = rating;
        this.review = review;

    }
}
