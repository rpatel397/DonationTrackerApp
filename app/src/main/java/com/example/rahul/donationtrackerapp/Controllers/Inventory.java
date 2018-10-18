package com.example.rahul.donationtrackerapp.Controllers;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> itemList;

    public Inventory(){
        itemList = new ArrayList<>();
    }

    public Inventory(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public boolean addItem(Item item) {
        return itemList.add(item);
    }

    public boolean removeItem(Item item) {
        return itemList.remove(item);
    }
}
