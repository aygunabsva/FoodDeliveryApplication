package com.example.fooddeliveryapp.service;

import com.example.fooddeliveryapp.dto.request.ProductReqDTO;
import com.example.fooddeliveryapp.dto.request.ProductUpdateRequestDTO;
import com.example.fooddeliveryapp.dto.response.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO createProduct(ProductReqDTO productReqDTO);

    void deleteProduct(Long productId);

    ProductDTO updateProduct(ProductUpdateRequestDTO requestDTO);

    List<ProductDTO> readProductByName(String name);

    List<ProductDTO> readProductByCategory(String foodCategory);

    List<ProductDTO> findByPrice(int maxPrice);

}
