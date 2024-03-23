package com.example.fooddeliveryapp.service.impl;

import com.example.fooddeliveryapp.dto.request.ProductReqDTO;
import com.example.fooddeliveryapp.dto.request.ProductUpdateRequestDTO;
import com.example.fooddeliveryapp.dto.response.ProductDTO;
import com.example.fooddeliveryapp.entity.Product;
import com.example.fooddeliveryapp.exception.NotFoundException;
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

    @Override
    public void deleteProduct(Long productId) {
        log.info("product delete method started");
        productRepository.deleteById(productId);
        log.info("product delete method finished");
    }

    @Override
    public ProductDTO updateProduct(ProductUpdateRequestDTO requestDTO) {
        log.info("product update method started");
        Product existingProduct = productRepository.findById(requestDTO.getId())
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + requestDTO.getId()));

        productMapper.updateProductFromDTO(requestDTO, existingProduct);

        Product savedProduct = productRepository.save(existingProduct);
        ProductDTO productDTO = productMapper.toDTO(savedProduct);
        log.info("product update method finished");
        return productDTO;
    }
}
