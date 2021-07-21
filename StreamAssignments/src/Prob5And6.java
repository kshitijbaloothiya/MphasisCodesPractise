

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employees implements Comparable<Employees>{

    private String name;
    private int age;
    private List<String> listOfCities;

    public Employees(String name, int age, List<String> listOfCities) {
        super();
        this.name = name;
        this.age = age;
        this.listOfCities = listOfCities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getListOfCities() {
        return listOfCities;
    }

    public void setListOfCities(List<String> listOfCities) {
        this.listOfCities = listOfCities;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "name='" + name  +
                ", age=" + age +

                '}';
    }

    @Override
    public int compareTo(Employees employees) {
       //return this.name.compareTo(employees.name);
        return Integer.compare(this.age, employees.age);
    }
}
public class Prob5And6 {
    public static void main(String[] args){

        List<Employees> employeesList = getListOfEmployees().stream()
                .sorted(Employees::compareTo)
                .collect(Collectors.toList());

        System.out.println("Employees sorted on basis of age:");
        employeesList.forEach(System.out::println);

        List<Employees> threeEmployees = getListOfEmployees().stream()
                                            .limit(3)
                                            .collect(Collectors.toList());
        System.out.println("\nThe three employees are following:");
        threeEmployees.forEach(System.out::println);
    }
    public static List<Employees> getListOfEmployees(){
        List<Employees> listOfEmployees = new ArrayList<>();
        Employees e1 = new Employees("Mohan",24, Arrays.asList("Newyork","banglore"));
        Employees e2 = new Employees("John",27, Arrays.asList("paris","london"));
        Employees e3 = new Employees("Vaibhav",32, Arrays.asList("pune","seattle"));
        Employees e4 = new Employees("Amit",22, Arrays.asList("chennai","hyderabad"));

        listOfEmployees.add(e1);
        listOfEmployees.add(e2);
        listOfEmployees.add(e3);
        listOfEmployees.add(e4);
        return listOfEmployees;
    }
}