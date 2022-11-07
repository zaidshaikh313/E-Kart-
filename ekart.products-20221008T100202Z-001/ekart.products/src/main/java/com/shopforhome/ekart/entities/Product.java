package com.shopforhome.ekart.entities;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

    private String category;
    private String name;
    private float price;
    @Lob
    private String description;
    private int quantity;
    private float rating;
    @Lob
    private String review;

    @Lob
    private byte[] img;

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
