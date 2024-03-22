package com.example.fooddeliveryapp.service;

import com.example.fooddeliveryapp.dto.request.LoginReq;
import org.springframework.http.ResponseEntity;


public interface AuthService {
    ResponseEntity<?> authenticate(LoginReq loginReq);

}
