package com.sparta.udonunit.employeefactory;


import com.sparta.udonunit.logger.Log;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init Logger

        Log.init();
        Log.setClassName(Main.class.getSimpleName());
        Log.info("Program Started...");
        // New instance of employeeDataHandler
        EmployeeDataHandler employeeDataHandler = new EmployeeDataHandler();
        // employee repository is passed generated list of employees from EmployeeList
        EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl(employeeDataHandler.getEmployeeList());
        //getEmployeeByID is passed the id of the first employee on the generated employee list, and returns the corresponding employee
        //System.out.println(employeeRepository.getEmployeeByID(employeeDataHandler.getEmployeeList().getFirst().empId()));
        System.out.println(employeeRepository.getEmployeeByAgeRange(32, 33));


    }
}
