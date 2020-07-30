package com.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    Optional<Product> findByProductCode(String productCode);

    void deleteByProductCode(String productCode);

}
