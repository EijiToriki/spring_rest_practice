package com.udemy.spring_rest_DB.repo;

import com.udemy.spring_rest_DB.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
}
