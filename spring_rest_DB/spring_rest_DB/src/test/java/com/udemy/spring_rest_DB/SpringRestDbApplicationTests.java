package com.udemy.spring_rest_DB;

import com.udemy.spring_rest_DB.controller.ItemController;
import com.udemy.spring_rest_DB.repo.ItemRepository;
import com.udemy.spring_rest_DB.service.ItemService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SpringRestDbApplicationTests {

	@Autowired
	private ItemController itemController;

	@Autowired
	private ItemService itemService;

	@Autowired
	private ItemRepository itemRepository;

	@Test
	@DisplayName("アプリケーションがspringコンテキストを正常にロードできたか検証")
	void contextLoads() {
		assertThat(itemController).isNotNull();
		assertThat(itemService).isNotNull();
		assertThat(itemRepository).isNotNull();
	}

}
