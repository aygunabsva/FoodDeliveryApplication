package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.dto.request.*;
import com.example.fooddeliveryapp.dto.response.ProductDTO;
import com.example.fooddeliveryapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductReqDTO productReqDTO) {
        ProductDTO createdProduct = productService.createProduct(productReqDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductUpdateRequestDTO requestDTO) {
        ProductDTO updatedProduct = productService.updateProduct(requestDTO);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }
    @GetMapping("/name/{productName}")
    public ResponseEntity<List<ProductDTO>> readProductByName(@PathVariable String productName) {
        List<ProductDTO> products = productService.readProductByName(productName);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/category/{foodCategory}")
    public ResponseEntity<List<ProductDTO>> searchProductsByCategory(@PathVariable String foodCategory) {
        List<ProductDTO> products = productService.readProductByCategory(foodCategory);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteProduct(@RequestBody ProductDeleteRequestDTO requestDTO) {
        productService.deleteProduct(requestDTO.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
