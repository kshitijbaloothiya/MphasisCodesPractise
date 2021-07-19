package com.mphaiss.main.cui;

import sun.rmi.runtime.Log;

import java.util.logging.Level;
import java.util.logging.Logger;

class Process{


    public Process execute1(){
        System.out.println("Executing1");
        return this;
    }
    public Process execute2(){
        System.out.println("Executing2");

        return this;
    }
    public Process execute3(){
        System.out.println("Executing3");
        return this;
    }
    public void execute4(){
        System.out.println("Executing4");

    }
}
public class Main {

    public static void main(String[] args) {
	Process process = new Process();
	process.execute1().execute2().execute3().execute4();
    }
}
