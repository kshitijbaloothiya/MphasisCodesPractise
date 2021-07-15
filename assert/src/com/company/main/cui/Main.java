package com.company.main.cui;
class Arithmethic{
    public int sum(int num1, int num2){
        return num1*num2;
    }
}
public class Main {

    public static void main(String[] args) {
        System.out.println("Begin");
        assert (new Arithmethic().sum(5,5)==10):"Please check the sum";
        System.out.println("end");
    }
}
