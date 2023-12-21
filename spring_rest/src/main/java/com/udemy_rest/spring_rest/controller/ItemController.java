package com.udemy_rest.spring_rest.controller;

import com.udemy_rest.spring_rest.model.Item;
import com.udemy_rest.spring_rest.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    public Item getItem(@PathVariable("itemId") String itemId) {
        return itemService.getItem(itemId);
    }

    @PostMapping(value = "/items")
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
    }

    @PutMapping(value = "/items/{itemId}")
    public void updateItem(
            @RequestBody Item item,
            @PathVariable("itemId") String itemId
    ) {
        itemService.updateItem(itemId, item);
    }

    @DeleteMapping(value = "/items/{itemId}")
    public void deleteItem(@PathVariable("itemId") String itemId) {
        itemService.deleteItem(itemId);
    }

}