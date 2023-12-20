package com.udemy_rest.spring_rest.controller;

import com.udemy_rest.spring_rest.model.Item;
import com.udemy_rest.spring_rest.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;
    @GetMapping(value = "/items")
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }

    @GetMapping(value = "/items/{itemId}")
    public Item getItem(@PathVariable("itemId") String itemId){
        return itemService.getItem(itemId);
    }

}
