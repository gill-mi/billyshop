package com.example.billyshop.comtroller;


import com.example.billyshop.domain.Item;
import com.example.billyshop.dto.ItemResponseDto;
import com.example.billyshop.dto.ItemSaveRequestDto;
import com.example.billyshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/item")
    public void create(@RequestBody ItemSaveRequestDto itemDto){
        itemService.createItem(itemDto);
    }

    @GetMapping("/item")
    public List<Item> findAll(){
        return itemService.findAll();
    }

    //id로 검색
    @GetMapping("/item/{id}")
    public ItemResponseDto findById(@PathVariable Long id){

        return itemService.findById(id);
    }

    //품명조회
    @GetMapping("item/title/{title}")
    public List<ItemResponseDto> gettitle(@PathVariable String title){
        {
            return itemService.titleSearch(title);
        }
    }

    //내용으로 조회
    @GetMapping("/item/content/{content}")
    public List<ItemResponseDto> getcontent(@PathVariable String content){

        return itemService.contentSearch(content);
    }

    @DeleteMapping("/{id}")
    void deleteItem(@PathVariable Long id){
        itemService.deleteById(id);
    }

}
