package controller;


import domain.Item;
import dto.ItemResponseDto;
import dto.ItemSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.ItemRepository;
import service.ItemService;

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
            List<ItemResponseDto> itemTitle = itemService.titleSearch(title);
            return itemTitle;
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
