package com.udemy.spring_rest_DB.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udemy.spring_rest_DB.model.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("検索結果が期待値通りかをテスト")
    void testGetItem() throws Exception{
        int itemId = 1;
        String responseJsonString = mvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/items/{itemId}", itemId)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        Item responseItem = objectMapper.readValue(responseJsonString, Item.class);

        assertThat(responseItem.getItemId()).isEqualTo(1L);
        assertThat(responseItem.getItemName()).isEqualTo("ネックレス");
        assertThat(responseItem.getItemCategory()).isEqualTo("ジュエリー");
    }

}