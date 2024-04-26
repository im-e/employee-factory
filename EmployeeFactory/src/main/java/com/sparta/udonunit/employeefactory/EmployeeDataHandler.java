package com.sparta.udonunit.employeefactory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.sparta.udonunit.logging.Log;

public class EmployeeDataHandler {
    private static List<Employee> employeeList;


    // Constructor populates employeeList by calling EmployeeFactory.
    public EmployeeDataHandler() throws IOException {
        Log.config("Creating employee data handler...", EmployeeDataHandler.class.getSimpleName());
        Log.config("Populating employee data from employee factory", EmployeeDataHandler.class.getSimpleName());
        String[] employeeData = EmployeeFactory.getEmployees(1000);

        Log.config("Creating employee object list from employee data", EmployeeDataHandler.class.getSimpleName());
        employeeList = new ArrayList<>(convertEmployeeDataListIntoObjects(employeeData));
        Log.config("Employee list populated", EmployeeDataHandler.class.getSimpleName());
        Log.config("EmployeeSearcher can be used", EmployeeDataHandler.class.getSimpleName());
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    private List<Employee> convertEmployeeDataListIntoObjects(String[] employeeData) {
        Log.config("Converting employee data list into objects...", EmployeeDataHandler.class.getSimpleName());

        List<Employee> employees = new ArrayList<>();

        for (String data : employeeData) {
            String[] values = data.split(",");

            int empId = Integer.parseInt(values[0]);
            String prefix = values[1];
            String firstName = values[2];
            char middleInitial = values[3].charAt(0);
            String lastName = values[4];
            char gender = values[5].charAt(0);
            String email = values[6];
            LocalDate dob = LocalDate.parse(values[7], DateTimeFormatter.ofPattern("M/d/y"));
            LocalDate hireDate = LocalDate.parse(values[8], DateTimeFormatter.ofPattern("M/d/y"));
            int salary = Integer.parseInt(values[9]);

            Employee employee = new Employee(empId, prefix, firstName, middleInitial, lastName,
                    gender, email, dob, hireDate, salary);
            employees.add(employee);
        }
        Log.config("Employee total: " + employees.size(), EmployeeDataHandler.class.getSimpleName());

        return employees;
    }

}

