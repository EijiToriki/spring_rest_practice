package com.udemy.spring_rest_DB.controller;

import com.udemy.spring_rest_DB.exception.ItemNotFountException;
import com.udemy.spring_rest_DB.model.Item;
import com.udemy.spring_rest_DB.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping(value = "/items")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping(value = "/items/{itemId}")
    public Item getItem(@PathVariable("itemId") Long itemId) {
        return itemService.getItem(itemId).orElseThrow(() -> new ItemNotFountException(itemId));
    }

    @PostMapping(value = "/items")
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
    }

    @PutMapping(value = "/items/{itemId}")
    public void updateItem(
            @RequestBody Item item,
            @PathVariable("itemId") Long itemId
    ) {
        itemService.updateItem(itemId, item);
    }

    @DeleteMapping(value = "/items/{itemId}")
    public void deleteItem(@PathVariable("itemId") Long itemId) {
        itemService.deleteItem(itemId);
    }

}