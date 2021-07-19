package com.mphasis.main.cui;

import java.io.*;

class Data implements Serializable{
    private static final long SerialVersionUID = 100L;
    public int id;
    public String name;
    public transient float salary;
    public String address;

    public Data(int id, String name, float salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}
public class Main {

    public static void main(String[] args) {
        Data data = new Data(10,"Ravi",256.1f);

        try( FileOutputStream fos = new FileOutputStream("Objectstore.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             FileInputStream fis = new FileInputStream("Objectstore.txt");
             ObjectInputStream ois = new ObjectInputStream(fis);
                ) {//inside try catch we essentially close the files to free up the memoery
            //Serlisation


            oos.writeObject(data);
//            //Deserlisation


            Data dataRestored = (Data)ois.readObject();
            System.out.println("Deserilised ID: "+dataRestored.id+" name:"+dataRestored.name+ dataRestored.salary);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
