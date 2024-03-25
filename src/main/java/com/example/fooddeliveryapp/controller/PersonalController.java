package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.dto.request.PersonalRegisterDTO;
import com.example.fooddeliveryapp.dto.response.PersonalDTO;
import com.example.fooddeliveryapp.service.PersonalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/personal")
public class PersonalController {
    private final PersonalService personalService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonalDTO register(@RequestBody @Valid PersonalRegisterDTO personalRegisterDTO) {
        return personalService.register(personalRegisterDTO);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<PersonalDTO> getAll() {
        return personalService.getAll();
    }
}
