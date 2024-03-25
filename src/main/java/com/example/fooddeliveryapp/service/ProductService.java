package com.example.fooddeliveryapp.service;

import com.example.fooddeliveryapp.dto.request.ProductReqDTO;
import com.example.fooddeliveryapp.dto.request.ProductUpdateRequestDTO;
import com.example.fooddeliveryapp.dto.response.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO create(ProductReqDTO productReqDTO);

    void delete(Long productId);

    ProductDTO edit(ProductUpdateRequestDTO requestDTO);

    List<ProductDTO> readByName(String name);

    List<ProductDTO> readByCategory(String foodCategory);

    List<ProductDTO> readByPrice(int maxPrice);

}
