package com.company.main.cui;

import com.company.types.Apples;

public class Main {

    public static void main(String[] args) {
        Apples apple;
        apple = Apples.GOLDEN_DEL;
        System.out.println(apple);
        Apples[] apples = Apples.values();
        for (Apples ap:apples){
            System.out.println(ap.getPrice());
        }
    }
}
