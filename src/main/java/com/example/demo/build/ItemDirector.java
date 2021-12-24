package com.example.demo.build;

public class ItemDirector {

    private ItemBuilder itemBuilder;

    public ItemDirector(ItemBuilder itemBuilder){
        this.itemBuilder = itemBuilder;
    }

    public Item normalConstruct(){
        itemBuilder.buildNormal();
        return itemBuilder.getResult();
    }
    public Item cardConstruct(){
        itemBuilder.buildCard();
        return itemBuilder.getResult();
    }
    public Item videolConstruct(){
        itemBuilder.buildVideo();
        return itemBuilder.getResult();
    }

}
