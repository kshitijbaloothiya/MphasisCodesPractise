package com.company.main.cui;

import com.company.exceptions.IllegalAgeException;

class Vote{
    public void register(int age) throws IllegalAgeException {
        if (age<18){
            throw new IllegalAgeException();
        }else
            System.out.println("Eligible to vote");
    }
}
public class Main {

    public static void main(String[] args) {
        Vote vote = new Vote();
        try {
            vote.register(18);
        } catch (IllegalAgeException e) {
            e.printStackTrace();
        }
    }
}
