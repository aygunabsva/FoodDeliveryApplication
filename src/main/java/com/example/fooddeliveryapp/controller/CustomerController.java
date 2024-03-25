package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.dto.request.CustomerRegisterDTO;
import com.example.fooddeliveryapp.dto.response.CustomerDTO;
import com.example.fooddeliveryapp.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO register(@RequestBody @Valid CustomerRegisterDTO customerRegisterDTO) {
        return customerService.register(customerRegisterDTO);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDTO> getAll() {
        return customerService.getAll();
    }
}
