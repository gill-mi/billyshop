package dto;

import domain.Item;
import lombok.Getter;

@Getter
public class ItemResponseDto {

    private Long id;
    private String title;
    private String content;
    private int price;

    public ItemResponseDto(Item entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.price = entity.getPrice();
    }
}