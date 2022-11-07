package com.shopforhome.ekart.service.impl;

import com.shopforhome.ekart.dto.ServerResponse;
import com.shopforhome.ekart.entities.Product;
import com.shopforhome.ekart.exceptions.ProductNotFoundException;
import com.shopforhome.ekart.repository.ProductRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepos productRepos;

    public List<Product> getAll() {
        return productRepos.findAll();

    }

    public List<Product> byCategory(String cat) {
        return productRepos.findAllByCategory(cat);
    }

    public Product getById(int id) {
        return productRepos.findById(id).get();

    }

    public ServerResponse save(MultipartFile file) {
        try {
            List<Product> products = CsvHelper.csvToTutorials(file.getInputStream());
            productRepos.saveAll(products);
            return new ServerResponse( HttpStatus.OK,"Products added");
        } catch (IOException e) {
            return new ServerResponse(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }
    public ServerResponse deleteProduct(int pid){
       Product product= productRepos.findById(pid).orElseThrow(() ->new ProductNotFoundException("Product not found"));

        productRepos.deleteById(pid);
            return new ServerResponse(HttpStatus.ACCEPTED, "Product deleted successfully");

    }
    public ServerResponse updateProd(int pid,Product product){
        Product prod= productRepos.findById(pid).orElseThrow(() ->new ProductNotFoundException("Product not found"));

        productRepos.save(product);
        return new ServerResponse(HttpStatus.ACCEPTED, "Product deleted successfully");


    }
}
