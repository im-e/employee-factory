package com.sparta.udonunit.employeefactory;

import com.sparta.udonunit.logger.Log;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class EmployeeSearcher {

    private static EmployeeRepositoryImpl employeeRepository;

    public static void init() throws IOException {
        // Init Logger
        Log.init();
        Log.setClassName(EmployeeSearcher.class.getSimpleName());
        Log.info("Program Started...");
        // New instance of employeeDataHandler
        EmployeeDataHandler employeeDataHandler = new EmployeeDataHandler();
        // employee repository is passed generated list of employees from EmployeeList
        employeeRepository = new EmployeeRepositoryImpl(employeeDataHandler.getEmployeeList());
        //getEmployeeByID is passed the id of the first employee on the generated employee list, and returns the corresponding employee
        //System.out.println(employeeRepository.getEmployeesByHiredDateRange());
    }

    public static void searchEmployeeByID(int employeeID) {
        //get employee by id
        Employee employeeResult = employeeRepository.getEmployeeByID(employeeID);
        if(employeeResult != null) {
            // print employee
        }
        else{
            //return no employee found
        }
    }
}
