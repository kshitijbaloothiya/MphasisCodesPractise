package com.company.main.cui;
interface Printer{
    public void print(String str);
}
public class Main {

    public static void main(String[] args) {
        new Printer(){ //Anonymous class

            @Override
            public void print(String str) {
                System.out.println(str);
            }
        }.print("India");

        Printer printer2 = (str) ->  System.out.println(str); //Lambda function
        printer2.print("Canada");

        Printer printer3 = System.out::println;
        printer3.print("UK");

        execute((name) -> System.out.println(name),  "Iceland"); //Lambda expression is used here
        //Here name is passed onto the execute which takes it to function below and after which it is printed using sout

    }
    public static void execute(Printer printer, String country){
        printer.print(country);
    }
}
