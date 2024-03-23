package com.example.fooddeliveryapp.service.impl;

import com.example.fooddeliveryapp.dto.request.ProductReqDTO;
import com.example.fooddeliveryapp.dto.request.ProductUpdateRequestDTO;
import com.example.fooddeliveryapp.dto.response.ProductDTO;
import com.example.fooddeliveryapp.entity.Product;
import com.example.fooddeliveryapp.enums.FoodCategory;
import com.example.fooddeliveryapp.exception.NotFoundException;
import com.example.fooddeliveryapp.mapper.ProductMapper;
import com.example.fooddeliveryapp.repository.ProductRepository;
import com.example.fooddeliveryapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @Override
    public ProductDTO createProduct(ProductReqDTO productReqDTO) {
        log.info("Product add method started");
        Product product = productMapper.toEntity(productReqDTO);
        productRepository.save(product);
        ProductDTO productDTO = productMapper.toDTO(product);
        log.info("Created a new product: {}", productDTO.getName());
        return productDTO;
    }

    @Override
    public void deleteProduct(Long productId) {
        log.info("Product delete method started");
        productRepository.deleteById(productId);
        log.info("Deleted a product with the ID: {}", productId);
    }

    @Override
    public ProductDTO updateProduct(ProductUpdateRequestDTO requestDTO) {
        log.info("Product update method started");
        Product existingProduct = productRepository.findById(requestDTO.getId())
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + requestDTO.getId()));

        productMapper.updateProductFromDTO(requestDTO, existingProduct);

        Product savedProduct = productRepository.save(existingProduct);
        ProductDTO productDTO = productMapper.toDTO(savedProduct);
        log.info("Updated product with ID: {}", requestDTO.getId());
        return productDTO;
    }

    @Override
    public List<ProductDTO> readProductByName(String name) {
        log.info("Read product by name method started");
        List<Product> products = productRepository.findByNameIgnoreCase(name);
        if (products.isEmpty()) {
            throw new NotFoundException("Product in this name not found");
        }
        log.info("Found {} products with a name {}", products.size(), name);
        return products.stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> readProductByCategory(String foodCategory) {
        log.info("Read product by category method started");
        List<Product> products = productRepository.findByFoodCategory(FoodCategory.valueOf(foodCategory.toUpperCase()));
        if (products.isEmpty()) {
            throw new NotFoundException("Product in this category not found");
        }
        log.info("Found {} products with a category {}", products.size(), foodCategory);
        return products.stream()
                .map(productMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
