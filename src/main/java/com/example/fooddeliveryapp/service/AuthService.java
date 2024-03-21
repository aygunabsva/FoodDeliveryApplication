package com.example.fooddeliveryapp.service;

import com.example.fooddeliveryapp.dto.LoginReq;
import com.example.fooddeliveryapp.dto.UserReqDto;
import org.springframework.http.ResponseEntity;


public interface AuthService {
    ResponseEntity<?> authenticate(LoginReq loginReq);

}
