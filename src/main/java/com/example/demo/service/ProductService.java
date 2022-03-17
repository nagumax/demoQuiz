package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Bucket;
import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll();
    void addToUserBucket(Long productId, String username);

}
