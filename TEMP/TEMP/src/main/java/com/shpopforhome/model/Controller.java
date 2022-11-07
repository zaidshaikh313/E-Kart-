package com.shpopforhome.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/temp")
public class Controller {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public Product get(){
        Product product=restTemplate.getForObject("http://product-service/prod/get/1", Product.class);

        return product;
    }

}
