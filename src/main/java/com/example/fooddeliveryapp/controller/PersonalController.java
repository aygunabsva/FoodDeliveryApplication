package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.dto.request.PersonalRegisterDTO;
import com.example.fooddeliveryapp.service.PersonalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/personal")
public class PersonalController {
    private final PersonalService personalService;

    @PostMapping("/add")
    public ResponseEntity<Void> register(@RequestBody @Valid PersonalRegisterDTO personalRegisterDTO) {
        personalService.register(personalRegisterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
