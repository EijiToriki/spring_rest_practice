package com.udemy.spring_rest_DB.exception;

public class ItemNotFountException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ItemNotFountException(Long itemId){
        super("商品コード: " + itemId + "は 見つかりません。" );
    }
}
