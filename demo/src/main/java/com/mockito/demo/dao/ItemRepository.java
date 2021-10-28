package com.mockito.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mockito.demo.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

	List<Item> findAll();

}
