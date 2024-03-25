package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.dto.request.ProductDeleteRequestDTO;
import com.example.fooddeliveryapp.dto.request.ProductReqDTO;
import com.example.fooddeliveryapp.dto.request.ProductUpdateRequestDTO;
import com.example.fooddeliveryapp.dto.response.ProductDTO;
import com.example.fooddeliveryapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO add(@RequestBody ProductReqDTO productReqDTO) {
        return productService.create(productReqDTO);
    }

    @PutMapping("/edit")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO edit(@RequestBody ProductUpdateRequestDTO requestDTO) {
        return productService.edit(requestDTO);
    }

    @GetMapping("/name/{productName}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getByName(@PathVariable String productName) {
        return productService.readByName(productName);
    }

    @GetMapping("/category/{foodCategory}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getByCategory(@PathVariable String foodCategory) {
        return productService.readByCategory(foodCategory);
    }

    @GetMapping("/price/{maxPrice}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getByPrice(@PathVariable int maxPrice) {
        return productService.readByPrice(maxPrice);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Void deleteProduct(@RequestBody ProductDeleteRequestDTO requestDTO) {
        productService.delete(requestDTO.getId());
        return null;
    }
}
