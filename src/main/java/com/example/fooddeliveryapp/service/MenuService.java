package com.example.fooddeliveryapp.service;

import com.example.fooddeliveryapp.dto.request.MenuReqDTO;
import com.example.fooddeliveryapp.dto.request.MenuUpdateRequestDTO;
import com.example.fooddeliveryapp.dto.response.MenuDTO;

public interface MenuService {
    MenuDTO createMenu(MenuReqDTO menuReqDTO);
    void deleteMenu(Long menuId);

    MenuDTO updateMenuName(MenuUpdateRequestDTO requestDTO);
}
