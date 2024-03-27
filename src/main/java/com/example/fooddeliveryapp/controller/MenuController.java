package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.dto.request.MenuReqDTO;
import com.example.fooddeliveryapp.dto.request.MenuUpdateRequestDTO;
import com.example.fooddeliveryapp.dto.response.MenuDTO;
import com.example.fooddeliveryapp.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public MenuDTO add(@RequestBody MenuReqDTO menuReqDTO) {
        return menuService.add(menuReqDTO);
    }

    @PutMapping("/edit")
    @ResponseStatus(HttpStatus.OK)
    public MenuDTO edit(@RequestBody MenuUpdateRequestDTO requestDTO) {
        return menuService.edit(requestDTO);
    }

    @DeleteMapping("/{menuId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Void delete(@PathVariable Long menuId) {
        menuService.delete(menuId);
        return null;
    }

}
