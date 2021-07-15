package com.mphasis.payroll.entities;

public class finance {
    public void process(employee emp){
        if (emp!= null){
            emp.netPay();
        }
        if (emp instanceof permanent){
            ((permanent) emp).transport();
        }



    }
}
