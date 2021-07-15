package com.mphasis.payroll.entities;

public class contract extends employee{
    @Override
    public void netPay() {
        System.out.println("contract employee's salary");
    }
}
