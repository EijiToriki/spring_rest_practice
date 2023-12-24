package com.udemy.spring_rest_DB.service;

import com.udemy.spring_rest_DB.model.Item;
import com.udemy.spring_rest_DB.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Cacheable("getItems")
    public List<Item> getAllItems(){
        List<Item> allItems = new ArrayList<>();

        try {
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }

        itemRepository.findAll().forEach(allItems::add);

        return allItems;
    }

    @Cacheable(value = "getItem", key = "#itemId")
    public Optional<Item> getItem(Long itemId){
        try {
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return itemRepository.findById(itemId);
    }

    @CacheEvict(value = "getItems", allEntries = true)
    public void addItem(Item item){
        itemRepository.save(item);
    }

    @Caching(evict = {
            @CacheEvict(value = "getItem", key = "#itemId"),
            @CacheEvict(value = "getItems", allEntries = true)
    })
    public void updateItem(Long itemId, Item item){
        if(itemRepository.findById(itemId).get() != null) {
            itemRepository.save(item);
        }
    }

    @Caching(evict = {
            @CacheEvict(value = "getItem", key = "#itemId"),
            @CacheEvict(value = "getItems", allEntries = true)
    })
    public void deleteItem(Long itemId){
        itemRepository.deleteById(itemId);
    }

}
