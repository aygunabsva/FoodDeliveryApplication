package com.example.fooddeliveryapp.service;

import com.example.fooddeliveryapp.dto.request.PersonalRegisterDTO;
import com.example.fooddeliveryapp.dto.response.PersonalDTO;

public interface PersonalService {
    PersonalDTO register(PersonalRegisterDTO personalRegisterDTO);
}
