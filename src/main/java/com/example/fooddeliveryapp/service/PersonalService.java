package com.example.fooddeliveryapp.service;

import com.example.fooddeliveryapp.dto.request.PersonalRegisterDTO;
import com.example.fooddeliveryapp.dto.response.CustomerDTO;
import com.example.fooddeliveryapp.dto.response.PersonalDTO;

import java.util.List;

public interface PersonalService {
    PersonalDTO register(PersonalRegisterDTO personalRegisterDTO);

    List<PersonalDTO> getAll();
}
