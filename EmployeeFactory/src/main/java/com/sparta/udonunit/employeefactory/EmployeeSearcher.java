package com.sparta.udonunit.employeefactory;

import com.sparta.udonunit.logging.Log;
import com.sparta.udonunit.logging.ResultHandler;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
        Log.info("Employee searcher initialised", EmployeeSearcher.class.getSimpleName());
        Log.info("Beginning searches...", EmployeeSearcher.class.getSimpleName());
    }

    public static String searchEmployeeByID(int employeeID) {
        //get employee by id
        Employee employeeResult = employeeRepository.getEmployeeByID(employeeID);
        ResultHandler.printSearchValue("Searching for employee under ID: ", String.valueOf(employeeID));
        if (employeeResult != null) {
            Log.config("Employee found under ID: " + employeeID, EmployeeSearcher.class.getSimpleName());
            ResultHandler.printCorrectResult(employeeResult.toString());
            ResultHandler.endOfSearch();
            Log.fine("End of search.", EmployeeSearcher.class.getSimpleName());
            return employeeResult.toString();
        } else {
            Log.config("No employee found with ID:  " + employeeID, EmployeeSearcher.class.getSimpleName());
            ResultHandler.printInvalidResult("No employee found with ID: " + employeeID);
            ResultHandler.endOfSearch();
            Log.fine("End of search.", EmployeeSearcher.class.getSimpleName());
            return "No employee found with ID: " + employeeID;
        }

    }

    public static String searchEmployeesHiredWithinDateRange(String rangeStart, String rangeEnd) {
        StringBuilder result = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/y");

        LocalDate startRange;
        LocalDate endRange;
        try {
            startRange = LocalDate.parse(rangeStart, formatter);
            endRange = LocalDate.parse(rangeEnd, formatter);
        } catch (Exception e) {
            Log.warning(e.toString(), EmployeeSearcher.class.getSimpleName());
            ResultHandler.printInvalidResult("Incorrect range format of (M/DD/YYYY): " + rangeStart);
            return "Invalid date entered";
        }

        List<Employee> employeesResult = employeeRepository.getEmployeesByHiredDateRange(startRange, endRange);

        ResultHandler.printSearchValue("Searching for employee within the hiring range: ", rangeStart + " -> " + rangeEnd);
        for (Employee employee : employeesResult) {
            if (employee.empId() != -1) {
                ResultHandler.printCorrectResult(employee.toString());
                result.append(employee.toString());
            } else {
                ResultHandler.printInvalidResult("No employees found within the hiring range: " + rangeStart + " -> " + rangeEnd);
                result.append("No employees found within the hiring range: ").append(rangeStart).append(" -> ").append(rangeEnd);
            }
        }
        ResultHandler.endOfSearch();
        return result.toString();
    }

    public static String searchEmployeesByAgeRange(Integer rangeStart, Integer rangeEnd) {
        StringBuilder result = new StringBuilder();
        List<Employee> employeesResult = employeeRepository.getEmployeeByAgeRange(rangeStart, rangeEnd);
        ResultHandler.printSearchValue("Searching for employee within the age range: ", rangeStart + " -> " + rangeEnd);
        for (Employee employee : employeesResult) {
            if (employee.empId() != -1) {
                ResultHandler.printCorrectResult(employee.toString());
                result.append(employee.toString());
            } else {
                ResultHandler.printInvalidResult("No employees found within the age range: " + rangeStart + " -> " + rangeEnd);
                result.append("No employees found within the age range: ").append(rangeStart).append(" -> ").append(rangeEnd);
            }
        }
        ResultHandler.endOfSearch();
        return result.toString();
    }

    public static String searchEmployeesByLastNameContains(String lastNameContains) {
        StringBuilder result = new StringBuilder();
        List<Employee> employeesResult = employeeRepository.getEmployeeLastNameContaining(lastNameContains);
        ResultHandler.printSearchValue("Searching for employee with the last name containing: ", lastNameContains);
        for (Employee employee : employeesResult) {
            if (employee.empId() != -1) {
                ResultHandler.printCorrectResult(employee.toString());
                result.append(employee.toString());
            } else {
                ResultHandler.printInvalidResult("No employees found with the last name containing: " + lastNameContains);
                result.append("No employees found with the last name containing: ").append(lastNameContains);
            }
        }
        ResultHandler.endOfSearch();
        return result.toString();
    }

    public static String searchEmployeesBySalaryRange(Integer rangeStart, Integer rangeEnd) {
        StringBuilder result = new StringBuilder();
        List<Employee> employeesResult = employeeRepository.getEmployeeBySalaryRange(rangeStart, rangeEnd);
        ResultHandler.printSearchValue("Searching for employee within the salary range: ", "£"+rangeStart + " -> " + "£"+rangeEnd);
        for (Employee employee : employeesResult) {
            if (employee.empId() != -1) {
                ResultHandler.printCorrectResult(employee.toString());
                result.append(employee.toString());
            } else {
                ResultHandler.printInvalidResult("No employees found within the salary range: " + "£"+rangeStart + " -> " + "£"+rangeEnd);
                result.append("No employees found within the salary range: ").append("£").append(rangeStart).append(" -> ").append("£").append(rangeEnd);
            }
        }
        ResultHandler.endOfSearch();
        return result.toString();
    }

    public static Employee getRandomEmployee() {
        int randomIndex = (int) (Math.random() * employeeRepository.getEmployees().size());
        return  employeeRepository.getEmployees().get(randomIndex);
    }

    public static int searchAllEmployees() {
        ResultHandler.printSearchValue("Searching for all employees: ", String.valueOf(employeeRepository.getEmployees().size()));
        for (Employee employee : employeeRepository.getEmployees()) {
            ResultHandler.printCorrectResult(employee.toString());
        }
        ResultHandler.endOfSearch();
        Log.fine("End of search.", EmployeeSearcher.class.getSimpleName());
        return employeeRepository.getEmployees().size();
    }

}
