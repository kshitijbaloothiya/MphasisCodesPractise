package com.company.main.cui;

import com.company.entities.Date;

public class Main {

    public static void main(String[] args) {
        Date date = new Date(11,11,11);
        System.out.println(date);
        date.setMonth(10);
        System.out.println(date);
        date.setMonth(14);
        System.out.println(date);
        String dob = date.toString();
        System.out.println(dob);
    }
}
