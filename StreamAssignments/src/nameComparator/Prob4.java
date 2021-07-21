package nameComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee implements Comparable<Employee>{

    private String name;
    private int age;
    private List<String> listOfCities;

    public Employee(String name, int age, List<String> listOfCities) {
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
    public int compareTo(Employee employee) {
        return this.name.compareTo(employee.name);
    }
}
public class Prob4 {
    public static void main(String[] args){

        List<Employee> employeesList = getListOfEmployees().stream()
                .sorted(Employee::compareTo)
                .collect(Collectors.toList());

        System.out.println("Employees sorted on basis of name:");
        employeesList.forEach(System.out::println);


    }
    public static List<Employee> getListOfEmployees(){
        List<Employee> listOfEmployees = new ArrayList<>();
        Employee e1 = new Employee("Mohan",24, Arrays.asList("Newyork","banglore"));
        Employee e2 = new Employee("John",27, Arrays.asList("paris","london"));
        Employee e3 = new Employee("Vaibhav",32, Arrays.asList("pune","seattle"));
        Employee e4 = new Employee("Amit",22, Arrays.asList("chennai","hyderabad"));

        listOfEmployees.add(e1);
        listOfEmployees.add(e2);
        listOfEmployees.add(e3);
        listOfEmployees.add(e4);
        return listOfEmployees;
    }
}



