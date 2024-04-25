package com.sparta.udonunit.employeefactory;

import com.sparta.udonunit.logging.Log;
import com.sparta.udonunit.logging.ResultHandler;

import java.io.IOException;

public class EmployeeSearcher {

    private static EmployeeRepositoryImpl employeeRepository;

    public static void init() throws IOException {
        // Init Logger
        Log.init();
        Log.info("Program Started...", EmployeeSearcher.class.getSimpleName());
        // Init Result Handler
        ResultHandler.init();
        // New instance of employeeDataHandler
        EmployeeDataHandler employeeDataHandler = new EmployeeDataHandler();
        // employee repository is passed generated list of employees from EmployeeList
        employeeRepository = new EmployeeRepositoryImpl(employeeDataHandler.getEmployeeList());
        Log.config("Employee searcher init complete", EmployeeSearcher.class.getSimpleName());
        //getEmployeeByID is passed the id of the first employee on the generated employee list, and returns the corresponding employee
        //System.out.println(employeeRepository.getEmployeesByHiredDateRange());
        searchEmployeeByID(employeeRepository.getEmployees().getFirst().empId());
    }

    public static void searchEmployeeByID(int employeeID) {
        //get employee by id
        Employee employeeResult = employeeRepository.getEmployeeByID(employeeID);
        ResultHandler.printSearchValue("Searching for employee under ID: ", String.valueOf(employeeID));
        if(employeeResult != null) {
            ResultHandler.printCorrectResult(employeeResult.toString());
        }
        else{
            ResultHandler.printInvalidResult("No employee found with ID: " + employeeID);
        }
    }

    public static void searchEmployeeByName(String employeeName) {

    }


}
