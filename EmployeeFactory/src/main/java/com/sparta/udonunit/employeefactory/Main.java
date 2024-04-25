package com.sparta.udonunit.employeefactory;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.sparta.udonunit.logger.Log;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Log.init(Main.class.getSimpleName());
        Log.fine("This is a fine log");
        Log.info("This is some info");
        Log.config("This is a config log");
        Log.warning("This is a warning log");
        Log.severe("This is a severe warning log");


        //System.out.println(Arrays.asList(EmployeeFactory.getEmployees(20)));
        // New instance of EmployeeList
        EmployeeList employeeList = new EmployeeList();
        // employee repository is passed generated list of employees from EmployeeList
        EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl(employeeList.getEmployeeList());
        //getEmployeeByID is passed the id of the first employee on the generated employee list, and returns the coresponding employee
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
