package com.udemy_rest.spring_rest.service;

import com.udemy_rest.spring_rest.model.Item;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ItemService {
    private List<Item> allItems = Arrays.asList(
            new Item("10001", "ネックレス", "ジュエリー"),
            new Item("10002", "パーカー", "ファッション"),
            new Item("10003", "フェイスクリーム", "ビューティー"),
            new Item("10004", "サプリメント", "ヘルス"),
            new Item("10005", "ブルーベリー", "フード")
    );

    public List<Item> getAllItems(){
        return allItems;
    }

    public Item getItem(String itemId){
        for(int i = 0; i < allItems.size(); i++){
            if(allItems.get(i).getItemId().equals(itemId)){
                return (Item) allItems.get(i);
            }
        }
        return null;
    }

}
