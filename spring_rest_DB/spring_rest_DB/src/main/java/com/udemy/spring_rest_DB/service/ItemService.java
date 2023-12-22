package com.udemy.spring_rest_DB.service;

import com.udemy.spring_rest_DB.model.Item;
import com.udemy.spring_rest_DB.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

//    private List<Item> allItems = new ArrayList<> (Arrays.asList(
//            new Item("10001", "ネックレス", "ジュエリー"),
//            new Item("10002", "パーカー", "ファッション"),
//            new Item("10003", "フェイスクリーム", "ビューティー"),
//            new Item("10004", "サプリメント", "ヘルス"),
//            new Item("10005", "ブルーベリー", "フード")
//    ));

    public List<Item> getAllItems(){
        List<Item> allItems = new ArrayList<>();
        itemRepository.findAll().forEach(allItems::add);

        return allItems;
    }

    public Optional<Item> getItem(Long itemId){
        return itemRepository.findById(itemId);
    }


    public void addItem(Item item){
        itemRepository.save(item);
    }

    public void updateItem(Long itemId, Item item){
        if(itemRepository.findById(itemId).get() != null){
            itemRepository.save(item);
        }
    }

    public void deleteItem(Long itemId){
        itemRepository.deleteById(itemId);
    }

}
