package com.shopforhome.ekart.repository;

import com.shopforhome.ekart.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepos extends JpaRepository<Product,Integer> {

    List<Product> findAllByCategory(String category);
}
