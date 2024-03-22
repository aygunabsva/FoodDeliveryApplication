package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.dto.request.LoginReq;
import com.example.fooddeliveryapp.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @ResponseBody
    @PostMapping("/sign-in")
    public ResponseEntity<?> login(@RequestBody @Valid LoginReq loginReq) {
        return authService.authenticate(loginReq);
    }

}

