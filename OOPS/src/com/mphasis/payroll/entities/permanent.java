package com.mphasis.payroll.entities;

public class permanent extends employee{


    @Override
    public void netPay() {
        System.out.println("permanent");
    }
    public void transport(){
        System.out.println("Transportation avalied");
    }
}
