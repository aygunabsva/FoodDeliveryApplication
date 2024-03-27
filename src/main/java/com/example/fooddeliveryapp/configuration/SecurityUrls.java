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
            "/customer/register",
            "/personal/register",
            "/product/**",
            "/restaurant/**",
            "/rating/**"
    };

    static String[] adminUrls = {
            "/restaurant/new",
            "/restaurant/delete",
            "/personal/all",
            "/customer/all"
    };

    static String[] personalUrls = {
            "/product/new",
            "/product/edit",
            "/product/delete",
            "/menu/**"
    };

    static String[] customerUrls = {
            "/rating/new",
            "/basket/**",
            "/order/**"
    };


//    static String[] anyAuthenticated = {
//
//    };
}
