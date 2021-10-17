package com.example.billyshop.repository;


import com.example.billyshop.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByContentContaining(String keyword);
    List<Item> findByTitleContaining(String keyword);
}
