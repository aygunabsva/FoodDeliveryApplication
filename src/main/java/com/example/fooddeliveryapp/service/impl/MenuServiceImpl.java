package com.example.fooddeliveryapp.service.impl;

import com.example.fooddeliveryapp.dto.request.MenuReqDTO;
import com.example.fooddeliveryapp.dto.response.MenuDTO;
import com.example.fooddeliveryapp.entity.Menu;
import com.example.fooddeliveryapp.mapper.MenuMapper;
import com.example.fooddeliveryapp.repository.MenuRepository;
import com.example.fooddeliveryapp.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;
    public MenuDTO createMenu(MenuReqDTO menuReqDTO) {
        Menu menu = menuMapper.toEntity(menuReqDTO);
        Menu savedMenu = menuRepository.save(menu);
        return menuMapper.toDTO(savedMenu);
    }

    public void deleteMenu(Long menuId) {
        menuRepository.deleteById(menuId);
    }
}
