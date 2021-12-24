package com.example.demo.build;


public class Item {


    private String itemName;

    private Integer type;

    private String code;

    private String url;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Item(String itemName, Integer type, String code, String url) {
        this.itemName = itemName;
        this.type = type;
        this.code = code;
        this.url = url;
    }

    public Item() {
    }
}
