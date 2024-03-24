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
            "/product/name/**",
            "/product/category/**",
            "/restaurant/all",
            "/restaurant/**",
            "/product/price/**"

    };

    static String[] adminUrls = {
            "/admin/**",
            "/personal/register",
            "/restaurant/create",
            "/restaurant/delete",
            "/personal/all",
            "/customer/all"
    };

    static String[] personalUrls = {
            "/product/**",
            "/menu/**"
    };

    static String[] customerUrls = {
            "/rating/add",

    };

//    static String[] anyAuthenticated = {
//
//    };
}
