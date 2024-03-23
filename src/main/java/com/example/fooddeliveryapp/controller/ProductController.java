package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.dto.request.ProductDeleteRequestDTO;
import com.example.fooddeliveryapp.dto.request.ProductReqDTO;
import com.example.fooddeliveryapp.dto.request.ProductUpdateRequestDTO;
import com.example.fooddeliveryapp.dto.response.ProductDTO;
import com.example.fooddeliveryapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteProduct(@RequestBody ProductDeleteRequestDTO requestDTO) {
        productService.deleteProduct(requestDTO.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
