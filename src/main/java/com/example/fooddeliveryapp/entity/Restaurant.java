package com.example.fooddeliveryapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToOne(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Menu menu;
}
