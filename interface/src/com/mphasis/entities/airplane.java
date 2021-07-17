package com.mphasis.entities;

import com.mphasis.contracts.flyer;

public class airplane extends vehicle implements flyer {

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
}
