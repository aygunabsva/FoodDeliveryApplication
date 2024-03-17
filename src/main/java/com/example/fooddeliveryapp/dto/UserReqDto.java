package com.example.fooddeliveryapp.dto;


import com.example.fooddeliveryapp.entity.Authority;
import com.example.fooddeliveryapp.enums.UserStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserReqDto {
    private Long id;
    private String name;
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus status;
    private Set<Authority> authorities = new HashSet<>();
}
