package com.shopforhome.ekart.controller;


import com.shopforhome.ekart.dto.ServerResponse;
import com.shopforhome.ekart.entities.Product;
import com.shopforhome.ekart.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/prod")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/upload")
    public ServerResponse upload(@RequestParam("file")MultipartFile file){
        return productService.save(file);



    }
    @GetMapping
    public List<Product> cgetALL(){
        return productService.getAll();
    }

    @GetMapping("/get/{id}")
    public Product returnProd(@PathVariable("id") int id){
        return productService.getById(id);
    }

    @DeleteMapping("/{pid}")
    public ServerResponse deleteProduct(@PathVariable("pid") int pid){
        try {
           return productService.deleteProduct(pid);
        } catch (Exception e) {
            return new ServerResponse(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }
    @PutMapping("/update/{id}")
    public ServerResponse updateProd( @PathVariable("id") int pid, @RequestBody Product product){
        return productService.updateProd(pid,product);
    }
}
