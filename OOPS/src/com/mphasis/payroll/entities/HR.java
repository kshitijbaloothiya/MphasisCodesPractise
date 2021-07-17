package com.mphasis.payroll.entities;

public class HR {
    public employee recruit(char type){
        if (type == 'p'){
            return new permanent();
        }else if(type == 'i'){
            return new intern();
        }else if(type == 'c'){
            return new contract();
        }
        return  null;
    }
}
