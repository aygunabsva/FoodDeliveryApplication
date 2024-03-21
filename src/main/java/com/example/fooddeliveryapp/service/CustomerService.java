package com.example.fooddeliveryapp.service;

import com.example.fooddeliveryapp.dto.LoginReq;
import com.example.fooddeliveryapp.dto.request.CustomerRegisterDTO;
import com.example.fooddeliveryapp.dto.response.CustomerDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface CustomerService {
    CustomerDTO register(CustomerRegisterDTO customerRegisterDTO);

    List<CustomerDTO> getAll();

}
