package com.sparta.udonunit.employeefactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
    private static List<Employee> employeeList;

    // Constructor populates employeeList by calling EmployeeFactory.
    public EmployeeList(){
        String[] employeeData = EmployeeFactory.getEmployees(1000);
        employeeList = new ArrayList<>(convertEmployeeDataListIntoObjects(employeeData));
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    private List<Employee> convertEmployeeDataListIntoObjects(String[] employeeData) {
        List<Employee> employees = new ArrayList<>();

        for (String data : employeeData) {
            String[] values = data.split(",");

            int empId = Integer.parseInt(values[0]);
            String prefix = values[1];
            String firstName = values[2];
            String middleInitial = values[3];
            String lastName = values[4];
            String gender = values[5];
            String email = values[6];
            LocalDate dob = LocalDate.parse(values[7], DateTimeFormatter.ofPattern("M/d/y"));
            LocalDate hireDate = LocalDate.parse(values[8], DateTimeFormatter.ofPattern("M/d/y"));
            int salary = Integer.parseInt(values[9]);

            Employee employee = new Employee(empId, prefix, firstName, middleInitial, lastName,
                    gender, email, dob, hireDate, salary);
            employees.add(employee);
        }

        return employees;
    }

}

