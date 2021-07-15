package com.mphasis.entities;

import com.mphasis.contracts.flyer;

public class Bird extends animal implements flyer  {
    @Override
    public void takeOff() {
        System.out.println("take off");

    }

    @Override
    public void fly() {
        System.out.println("flying");

    }

    @Override
    public void land() {
        System.out.println("landing");

    }
    public void layEggs(){
        System.out.println("eggs");
    }
    public void buildNests(){
        System.out.println("nests");
    }



}
