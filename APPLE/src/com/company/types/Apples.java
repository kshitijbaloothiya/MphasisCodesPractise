package com.company.types;

public enum Apples {
    GOLDEN_DEL(54), RED_DEL(36);
    public int price ;

    Apples(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
