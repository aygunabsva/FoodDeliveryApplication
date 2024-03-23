package com.example.fooddeliveryapp.service;

import com.example.fooddeliveryapp.dto.request.ProductReqDTO;
import com.example.fooddeliveryapp.dto.request.ProductUpdateRequestDTO;
import com.example.fooddeliveryapp.dto.response.ProductDTO;

public interface ProductService {

    ProductDTO createProduct(ProductReqDTO productReqDTO);

    void deleteProduct(Long productId);

    ProductDTO updateProduct(ProductUpdateRequestDTO requestDTO);
}
