package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.dto.request.MenuDeleteRequestDTO;
import com.example.fooddeliveryapp.dto.request.MenuReqDTO;
import com.example.fooddeliveryapp.dto.request.MenuUpdateRequestDTO;
import com.example.fooddeliveryapp.dto.response.MenuDTO;
import com.example.fooddeliveryapp.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;

    @PostMapping("/create")
    public ResponseEntity<MenuDTO> createMenu(@RequestBody MenuReqDTO menuReqDTO) {
        MenuDTO createdMenu = menuService.createMenu(menuReqDTO);
        return new ResponseEntity<>(createdMenu, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<MenuDTO> updateMenuName(@RequestBody MenuUpdateRequestDTO requestDTO) {
        MenuDTO updatedMenu = menuService.updateMenuName(requestDTO);
        return new ResponseEntity<>(updatedMenu, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteMenu(@RequestBody MenuDeleteRequestDTO requestDTO) {
        menuService.deleteMenu(requestDTO.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
