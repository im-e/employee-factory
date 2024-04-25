package com.sparta.udonunit.employeefactory;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

//Implementation of the EmployeeRepository interface that provides methods for accessing and manipulating employee data
public class EmployeeRepositoryImpl implements EmployeeRepository {
    final private List<Employee> employees;

    public EmployeeRepositoryImpl(List<Employee> employees) {
        this.employees = employees;
    }

    //Checks if an employee is hired within the specified date range
    private boolean employeeIsHiredWithinDateRange(Employee employee, LocalDate startDate, LocalDate endDate) {
        LocalDate hireDate = employee.hireDate();
        return !hireDate.isBefore(startDate) && !hireDate.isAfter(endDate);

    }

    //Calculates the age of an employee based on their date of birth and a given date
    public int calculateAge(LocalDate dob, LocalDate today) {
        return Period.between(dob, today).getYears();
    }

    //Retrieves an employee by their ID
    @Override
    public Employee getEmployeeByID(Integer id) {

        return employees.stream().filter(employee -> employee.empId().equals(id)).findFirst().orElse(null);

    }

    //Retrieves employees hired within the specified date range
    @Override
    public List<Employee> getEmployeesByHiredDateRange(LocalDate startDate, LocalDate endDate) {
        List<Employee> employeesResult = new ArrayList<>();

        boolean employeeFound = false;
        for (Employee employee : employees) {
            if (employeeIsHiredWithinDateRange(employee, startDate, endDate)) {
                employeesResult.add(employee);
                employeeFound = true;
            }
        }
        if (!employeeFound) {
            employeesResult.add(returnNullEmployee());
        }
        return employeesResult;
    }

    //Retrieves employees within a specified age range
    @Override
    public List<Employee> getEmployeeByAgeRange(Integer minAge, Integer maxAge) {
        List<Employee> showEmployeeData = new ArrayList<>();
        boolean employeeFound = false;
        for (Employee employee : employees) {
            LocalDate dateOfBirth = employee.dob();
            int age = calculateAge(dateOfBirth, LocalDate.now());
            if (age >= minAge && age <= maxAge) {
                showEmployeeData.add(employee);
                employeeFound = true;
            }
        }
        if (!employeeFound) {
            showEmployeeData.add(returnNullEmployee());
        }
        return showEmployeeData;
    }

    //Retrieves employees with a partial or full last name match
    @Override
    public List<Employee> getEmployeeLastNameContaining(String partialOrFullLastName) {
        boolean employeeFound = false;
        List<Employee> showEmployeeData = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.lastName().contains(partialOrFullLastName)) {
                showEmployeeData.add(employee);
                employeeFound = true;
            }
        }
        if (!employeeFound) {
            showEmployeeData.add(returnNullEmployee());
        }
        return showEmployeeData;
    }

    @Override
    public List<Employee> getEmployeeBySalaryRange(Integer minSalary, Integer maxSalary) {
        List<Employee> showEmployeeData = new ArrayList<>();
        boolean employeeFound = false;
        for (Employee employee : employees) {
            if (employee.salary() >= minSalary && employee.salary() <= maxSalary) {
                showEmployeeData.add(employee);
                employeeFound = true;
            }
        }
        if (!employeeFound) {
            showEmployeeData.add(returnNullEmployee());
        }
        return showEmployeeData;
    }

    private Employee returnNullEmployee() {
        return new Employee(-1, "No Employee Found", "-", '-', "-",
                '-', "-", null, null, -1);
    }

    //Retrieves the list of all employees
    public List<Employee> getEmployees() {
        return employees;
    }
}
