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
import jakarta.transaction.Transactional;
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
    @Override
    public MenuDTO add(MenuReqDTO menuReqDTO) {
        log.info("Menu add method started");
        Menu menu = menuMapper.toEntity(menuReqDTO);
        Menu savedMenu = menuRepository.save(menu);
        MenuDTO menuDTO = menuMapper.toDTO(savedMenu);
        log.info("Created a new menu: {}", menuReqDTO.getName());
        return menuDTO;
    }

    @Override
    @Transactional
    public void delete(Long menuId) {
        log.info("Menu delete method started");

//        menuRepository.deleteById(menuId);
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new NotFoundException("Menu not found with id: " + menuId));
        System.out.println(menu.getId());
        menuRepository.deleteById(menu.getId());
        log.info("Deleted a menu with the ID: {}", menu.getId());
    }

    @Override
    public MenuDTO edit(MenuUpdateRequestDTO requestDTO) {
        log.info("Menu update method started");
        Menu existingMenu = menuRepository.findById(requestDTO.getId())
                .orElseThrow(() -> new NotFoundException("Menu not found with id: " + requestDTO.getId()));
        existingMenu.setName(requestDTO.getNewName());
        Restaurant restaurant = restaurantRepository.findById(requestDTO.getRestaurantId())
                .orElseThrow(() -> new NotFoundException("Restaurant not found with id: " + requestDTO.getRestaurantId()));
        existingMenu.setRestaurant(restaurant);
        Menu savedMenu = menuRepository.save(existingMenu);
        MenuDTO menuDTO = menuMapper.toDTO(savedMenu);
        log.info("Updated menu with ID: {}", requestDTO.getId());
        return menuDTO;
    }
}
