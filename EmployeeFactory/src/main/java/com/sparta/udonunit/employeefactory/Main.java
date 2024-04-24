package com.sparta.udonunit.employeefactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //System.out.println(Arrays.asList(EmployeeFactory.getEmployees(20)));
        EmployeeList employeeList = new EmployeeList();
        EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl(employeeList.getEmployeeList());
        System.out.println(employeeRepository.getEmployeeByID(employeeList.getEmployeeList().getFirst().empId()));


       //System.out.println(Arrays.toString(employeeData));
       //System.out.println("");
       //System.out.println(employeeList.convertEmployeeDataListIntoObjects(employeeData));

       //System.out.println(employeeList.convertEmployeeDataListIntoObjects(employeeData).getFirst().empId());

//        Employee e1 = new Employee(198429,"Mrs.","Serafina","I","Bumgarner",
//                "F","serafina.bumgarner@exxonmobil.com",
//                LocalDate.parse("9/21/1982", DateTimeFormatter.ofPattern("M/d/y")),
//                LocalDate.parse("2/1/2008", DateTimeFormatter.ofPattern("M/d/y"))
//                ,69294);
//
//        List<Employee> employees = new ArrayList<>();
//        employees.add(e1);
//
//        EmployeeRepositoryImpl employeeRepositoryFake = new EmployeeRepositoryImpl(employees);


    }
}
