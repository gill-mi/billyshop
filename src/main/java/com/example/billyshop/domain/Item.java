package com.example.billyshop.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "item")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String title;

    @Column
    private int price;

    @Column
    private String content;



    @Builder
    public Item(String title, String content, int price){
        this.title = title;
        this.content = content;
        this.price = price;
        //this.fileId = fileId;

    }

    public void update(String title, String content, int price){
        this.title = title;
        this.content = content;
        this.price = price;
        //this.fileId = fileId;
    }
}
