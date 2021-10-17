package com.example.billyshop.dto;


import com.example.billyshop.domain.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemSaveRequestDto {

    private String title;
    private String content;
    private int price;

    @Builder
    public ItemSaveRequestDto(String title, String content, int price){
        this.title = title;
        this.content = content;
        this.price =price;
    }

    public Item toEntity(){
        return Item.builder()
                .title(title)
                .content(content)
                .price(price)
                .build();
    }
}
