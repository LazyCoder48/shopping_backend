package com.shop.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.ProductDto;
import com.shop.model.Product;
import com.shop.repository.ProductRepository;
import com.shop.service.AuthService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/products/")
@Log4j2
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private AuthService auth;

    private Marker marker;

    @PostMapping(value = "/saveNewProduct", consumes = "application/json")
    public ResponseEntity<List<Product>> createProduct(@RequestBody List<ProductDto> dtoList) throws IllegalAccessException {
        log.info(marker, "dtoList: " + dtoList.toString());
        List<Product> productList = new ArrayList<>();
        for (ProductDto dto : dtoList) {
            log.info("Saving a new product: " + dto.toString());
            Product product = new Product();
            product.setProductCode(dto.getProductCode());
            product.setProductName(dto.getProductName());
            product.setProductPrice(dto.getProductPrice());
            product.setProductCount(dto.getProductCount());
            product.setProductType(dto.getProductType());
            product.setProductOffer(dto.getProductOffer());
            product.setCreatedOn(new Timestamp(new Date().getTime()));
            productList.add(product);
        }
        User user = auth.getCurrentUser().orElseThrow(() -> new IllegalAccessException("No User is logged in"));
        productRepo.saveAll(productList);
        log.info("User: " + user.getUsername() + " with role: " + user.getAuthorities() + " added product(s)" + productList.toString());
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<List<Product>> updateProduct(@RequestBody List<ProductDto> dtoList) throws IllegalAccessException {
        List<Product> productList = new ArrayList<>();
        for (ProductDto dto : dtoList) {
            Product product = productRepo.findByProductCode(dto.getProductCode()).orElseThrow(() -> new IllegalAccessException("No Product with productCode: " + dto.getProductCode()));
            log.info("Existing Product: " + product.toString());
            product.setProductName(dto.getProductName());
            product.setProductPrice(dto.getProductPrice());
            product.setProductOffer(dto.getProductOffer());
            product.setProductCount(dto.getProductCount());
            product.setUpdatedOn(new Timestamp(new Date().getTime()));
            product.setProductType(dto.getProductType());
            productList.add(product);
        }
        User user = auth.getCurrentUser().orElseThrow(() -> new IllegalAccessException("No User is logged in"));
        productRepo.saveAll(productList);
        log.info("Updated to Products: " + productList.toString() + " by user: " + user.getUsername() + " with role: " + user.getAuthorities());
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PostMapping("/deleteProduct")
    public void deleteProduct(@RequestBody List<String> productCodeList) throws IllegalAccessException {
        User user = auth.getCurrentUser().orElseThrow(() -> new IllegalAccessException("No User is logged in"));

        List<Product> toBeDeletedProducts = productRepo.findAllById(productCodeList);
        productRepo.deleteAll(toBeDeletedProducts);

        log.info(marker, "User: " + user.getUsername() + " deleted product codes: " + productCodeList);

    }

}
