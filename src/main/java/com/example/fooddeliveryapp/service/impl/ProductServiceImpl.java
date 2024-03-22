package com.example.fooddeliveryapp.service.impl;

import com.example.fooddeliveryapp.dto.request.ProductReqDTO;
import com.example.fooddeliveryapp.dto.response.ProductDTO;
import com.example.fooddeliveryapp.entity.Product;
import com.example.fooddeliveryapp.mapper.ProductMapper;
import com.example.fooddeliveryapp.repository.ProductRepository;
import com.example.fooddeliveryapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @Override
    public ProductDTO createProduct(ProductReqDTO productReqDTO) {
        log.info("product add method started");
        Product product = productMapper.toEntity(productReqDTO);
        productRepository.save(product);
        ProductDTO productDTO = productMapper.toDTO(product);
        log.info("product add method finished");
        return productDTO;
    }
}
