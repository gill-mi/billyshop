package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemUpdateRequestDto {

    private String title;
    private String content;
    private int price;
    //private Long fileId;

    @Builder
    public ItemUpdateRequestDto(String title, String content, int price){
        this.title = title;
        this.content = content;
        this.price = price;
        //this.fileId = fileId;
    }
}
