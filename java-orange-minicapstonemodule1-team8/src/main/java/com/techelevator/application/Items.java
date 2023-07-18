package com.techelevator.application;

import java.math.BigDecimal;

public class Items implements Singable{
    private String name;
    private BigDecimal price;
    private String button;
    private String category;
    private int quantity = 6;
    private String message;

    public Items(){

    }

    public Items(String message){
        this.message = message;
    }

    public Items(String button, String name, BigDecimal price, String category) {
        this.button = button;
        this.name = name;
        this.price = price;
        this.category = category;
    }

//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString(){
        return getButton() + " " + getQuantity() + " remaining: " + getName() + " $" + getPrice();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
