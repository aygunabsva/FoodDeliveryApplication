package com.example.fooddeliveryapp.dto.request;

import com.example.fooddeliveryapp.entity.Authority;
import com.example.fooddeliveryapp.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerRegisterDTO {
    @NotBlank(message = "Username cannot be empty or null")
    @Size(max = 50)
    @Pattern(regexp = "[A-Za-z0-9_.]+$")
    private String username;

    @NotBlank(message = "Name cannot be empty or null")
    @Size(max = 50)
    @Pattern(regexp = "[A-Za-z0-9_.]+$")
    private String name;

    @NotBlank(message = "Surname cannot be empty or null")
    @Size(max = 50)
    @Pattern(regexp = "[A-Za-z0-9_.]+$")
    private String surname;

    @NotBlank(message = "Password cannot be empty or null")
    @Size(min = 3)
    @Pattern(regexp = "[A-Za-z0-9_.]+")
    private String password;

    @Email
    @NotBlank(message = "Email cannot be empty or null")
    @Size(max = 40)
    private String email;

    @NotBlank(message = "Phone can not be empty or null")
    @Pattern(regexp = "^\\+994[0-9]{9}$", message = "Invalid phone format")
    private String phone;

    @Size(max = 40)
    private String address;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
}
