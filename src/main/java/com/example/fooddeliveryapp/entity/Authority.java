package com.example.fooddeliveryapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Authority {
    @Id
    private String name;
}
