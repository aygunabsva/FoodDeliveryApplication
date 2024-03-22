package com.example.fooddeliveryapp.dto.response;

import com.example.fooddeliveryapp.enums.UserStatus;
import lombok.Data;

@Data
public class PersonalDTO {
    private Long personalId;
    private Long userId;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String phone;
    private String address;
    private UserStatus userStatus;
    private String authorities;
}
