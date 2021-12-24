package com.example.demo.build;

import java.util.UUID;

public class ItemConcreteBuilder extends ItemBuilder{
    @Override
    public void buildNormal() {
        item.setItemName("普通商品");
        item.setType(1);
    }

    @Override
    public void buildCard() {
        item.setItemName("卡券商品");
        item.setCode(UUID.randomUUID().toString());
        item.setType(2);
    }

    @Override
    public void buildVideo() {
        item.setItemName("视频商品");
        item.setType(3);
    }
}
