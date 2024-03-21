package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.dto.request.CustomerRegisterDTO;
import com.example.fooddeliveryapp.dto.response.CustomerDTO;
import com.example.fooddeliveryapp.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid CustomerRegisterDTO customerRegisterDTO) {
        customerService.register(customerRegisterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/customers")
    public List<CustomerDTO> getAll(){
        return customerService.getAll();
    }
}
