package com.mphasis.main.cui;

import com.mphasis.payroll.entities.HR;
import com.mphasis.payroll.entities.employee;
import com.mphasis.payroll.entities.finance;
import com.mphasis.payroll.entities.permanent;

public class Main {
    public static void main(String[] args){
        employee[] Employee = new employee[3] ;

        HR hr = new HR();
        finance fin = new finance();
        Employee[0]  = hr.recruit('p');
        Employee[1] = hr.recruit('c');
        Employee[2] = hr.recruit('i');
        for(employee  emp:Employee){
            fin.process(emp);
        }
    }
}
