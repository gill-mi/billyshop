package com.example.billyshop.service;

import com.example.billyshop.domain.Item;
import com.example.billyshop.dto.ItemResponseDto;
import com.example.billyshop.dto.ItemSaveRequestDto;
import com.example.billyshop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public void createItem(ItemSaveRequestDto itemDto){
        itemRepository.save(itemDto.toEntity());
    }

    public List<Item> findAllItems(){
        return itemRepository.findAll();
    }

    public ItemResponseDto findById(Long id){
        Item entity = itemRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시물이 없습니다. id ="+id));
        return new ItemResponseDto(entity);
    }

    public void deleteById(Long id){
        itemRepository.deleteById(id);
    }

    public List<Item> findAll(){
        return itemRepository.findAll();
    }

    public List<ItemResponseDto> titleSearch(String keyword){
        List<Item> itemList = itemRepository.findByTitleContaining(keyword);
        List<ItemResponseDto> itemDtoList = new ArrayList<>();

        if(itemList.isEmpty()) return itemDtoList;

        for(Item item : itemList){
            itemDtoList.add(new ItemResponseDto(item));
        }
        return itemDtoList;
    }

    //By내용
    public List<ItemResponseDto> contentSearch(String keyword){
        List<Item> itemList = itemRepository.findByContentContaining(keyword);
        List<ItemResponseDto> itemDtoList = new ArrayList<>();

        if (itemList.isEmpty()) return itemDtoList;

        for (Item item : itemList){
            itemDtoList.add(new ItemResponseDto(item));
        }
        return itemDtoList;
    }

}