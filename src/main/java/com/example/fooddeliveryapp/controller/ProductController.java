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
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO add(@RequestBody ProductReqDTO productReqDTO) {
        return productService.createProduct(productReqDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<ProductDTO> update(@RequestBody ProductUpdateRequestDTO requestDTO) {
        ProductDTO updatedProduct = productService.updateProduct(requestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
    }
    @GetMapping("/name/{productName}")
    public List<ProductDTO> getByName(@PathVariable String productName) {
        return productService.readProductByName(productName);
    }

    @GetMapping("/category/{foodCategory}")
    public List<ProductDTO> getByCategory(@PathVariable String foodCategory) {
        return productService.readProductByCategory(foodCategory);
    }

    @GetMapping("/price/{maxPrice}")
    public List<ProductDTO> getByPrice(@PathVariable int maxPrice) {
        return productService.findByPrice(maxPrice);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteProduct(@RequestBody ProductDeleteRequestDTO requestDTO) {
        productService.deleteProduct(requestDTO.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
