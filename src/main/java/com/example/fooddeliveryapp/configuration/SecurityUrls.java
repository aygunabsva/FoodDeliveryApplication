package com.example.fooddeliveryapp.configuration;

public class SecurityUrls {
    static String[] whiteList = {
            "/api/v1/auth/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/swagger-ui/**",
            "/swagger-ui.html",
            "/auth/**",
            "/customer/register"
    };

    static String[] adminUrls = {
            "/admin/**",
            "/personal/register",
            "/restaurant/create",
            "/restaurant/delete"
    };

    static String[] personalUrls = {
            "/product/**",
            "/menu/**"
    };

    static String[] customerUrls = {
            "/customer/customers"
    };

//    static String[] anyAuthenticated = {
//
//    };
}
