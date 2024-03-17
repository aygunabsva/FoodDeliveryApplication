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
            "/auth/**"
    };

    static String[] adminUrls = {
            "/books/readAll",
    };

    static String[] restaurantUrls = {
            "/authors/readByID"
    };

    static String[] customerUrls = {
            "/books/readById"
    };

    static String[] restaurantAndCustomerUrls = {

    };

    static String[] anyAuthenticated = {
            "/authors/readAllAuthors"
    };
}
