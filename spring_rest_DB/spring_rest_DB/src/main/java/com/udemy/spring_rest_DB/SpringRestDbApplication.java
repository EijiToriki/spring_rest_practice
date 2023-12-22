package com.udemy.spring_rest_DB;

import com.udemy.spring_rest_DB.model.Item;
import com.udemy.spring_rest_DB.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestDbApplication implements CommandLineRunner {

	@Autowired
	private ItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringRestDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		itemRepository.save(new Item("ネックレス", "ジュエリー"));
		itemRepository.save(new Item("パーカー", "ファッション"));
		itemRepository.save(new Item("フェイスクリーム", "ビューティ"));
		itemRepository.save(new Item("サプリメント", "ヘルス"));
		itemRepository.save(new Item("ブルーベリー", "フード"));
	}
}
