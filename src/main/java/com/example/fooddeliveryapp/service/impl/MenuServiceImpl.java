package com.example.fooddeliveryapp.service.impl;

import com.example.fooddeliveryapp.dto.request.MenuReqDTO;
import com.example.fooddeliveryapp.dto.request.MenuUpdateRequestDTO;
import com.example.fooddeliveryapp.dto.response.MenuDTO;
import com.example.fooddeliveryapp.entity.Menu;
import com.example.fooddeliveryapp.entity.Restaurant;
import com.example.fooddeliveryapp.exception.NotFoundException;
import com.example.fooddeliveryapp.mapper.MenuMapper;
import com.example.fooddeliveryapp.repository.MenuRepository;
import com.example.fooddeliveryapp.repository.RestaurantRepository;
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
    private final RestaurantRepository restaurantRepository;

    public MenuDTO createMenu(MenuReqDTO menuReqDTO) {
        log.info("menu add method started");
        Menu menu = menuMapper.toEntity(menuReqDTO);
        Menu savedMenu = menuRepository.save(menu);
        MenuDTO menuDTO = menuMapper.toDTO(savedMenu);
        log.info("restaurant add method finished");
        return menuDTO;
    }

    public void deleteMenu(Long menuId) {
        log.info("menu delete method started");
        menuRepository.deleteById(menuId);
        log.info("menu delete method finished");
    }

    @Override
    public MenuDTO updateMenuName(MenuUpdateRequestDTO requestDTO) {
        log.info("menu update method started");
        Menu existingMenu = menuRepository.findById(requestDTO.getId())
                .orElseThrow(() -> new NotFoundException("Menu not found with id: " + requestDTO.getId()));

        existingMenu.setName(requestDTO.getNewName());

        Restaurant restaurant = restaurantRepository.findById(requestDTO.getRestaurantId())
                .orElseThrow(() -> new NotFoundException("Restaurant not found with id: " + requestDTO.getRestaurantId()));
        existingMenu.setRestaurant(restaurant);

        Menu savedMenu = menuRepository.save(existingMenu);
        MenuDTO menuDTO = menuMapper.toDTO(savedMenu);
        log.info("menu update method finished");
        return menuDTO;
    }
}
