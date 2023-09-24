package com.bikash.java.DepartmentService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class TestRun {

    private static  List<Employee> emp = Arrays.asList(
            new Employee(1,"bikash", 40, "DEP1"),
            new Employee(2,"rishav", 8, "DEP1"),
            new Employee(3,"rosalin", 33, "DEP2"),
            new Employee(4,"ramesh", 25, "DEP2"),
            new Employee(5,"suresh", 23, "DEP3"),
            new Employee(6,"harish", 45, "DEP3")
    );

    public static void main(String[] args) {
//        Map<String, Double> collect = emp.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getAge)));
//        collect.forEach((department, averageAge) -> {
//            System.out.println(department + ": " + averageAge);
//        });

//        Stream<Employee> employeeStream = emp.stream().filter((item) -> item.getAge() > value);
        Double value = emp.stream().mapToDouble(Employee::getAge).average().orElse(0);
        Stream<Employee> employeeStream = emp.stream().filter((item) -> item.getAge() > value);

        Double collect = emp.stream().collect(Collectors.averagingDouble(item -> item.getAge()));
        System.out.println("Value "+ value);
        System.out.println("Double "+ collect);


    }
}



@Data
@AllArgsConstructor
@NoArgsConstructor
class Employee {
    private int id;
    private  String name;
    private  int age;
    private  String department;
}
