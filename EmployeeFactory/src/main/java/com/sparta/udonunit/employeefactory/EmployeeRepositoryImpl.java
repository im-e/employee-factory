package com.sparta.udonunit.employeefactory;

import com.sparta.udonunit.logging.Log;

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
        Log.config("Getting employee with the ID of :" + id.toString(), EmployeeRepositoryImpl.class.getSimpleName());
        return employees.stream().filter(employee -> employee.empId().equals(id)).findFirst().orElse(null);
    }

    //Retrieves employees hired within the specified date range
    @Override
    public List<Employee> getEmployeesByHiredDateRange(LocalDate startDate, LocalDate endDate) {
        Log.config("Getting employees within hiring date range: " + startDate.toString() + " -> " + endDate.toString(), EmployeeRepositoryImpl.class.getSimpleName());
        List<Employee> employeesResult = new ArrayList<>();

        boolean employeeFound = false;
        for (Employee employee : employees) {
            if (employeeIsHiredWithinDateRange(employee, startDate, endDate)) {
                Log.fine("Employee found within date range: " + employee.hireDate(), EmployeeRepositoryImpl.class.getSimpleName());
                employeesResult.add(employee);
                employeeFound = true;
            }
        }
        if (!employeeFound) {
            Log.fine("No employee found within date range", EmployeeRepositoryImpl.class.getSimpleName());
            employeesResult.add(returnNullEmployee());
        }
        Log.config("End of search.", EmployeeRepositoryImpl.class.getSimpleName());
        return employeesResult;
    }

    //Retrieves employees within a specified age range
    @Override
    public List<Employee> getEmployeeByAgeRange(Integer minAge, Integer maxAge) {
        Log.config("Getting employees within age range: " + minAge + " -> " + maxAge, EmployeeRepositoryImpl.class.getSimpleName());
        List<Employee> showEmployeeData = new ArrayList<>();
        boolean employeeFound = false;
        for (Employee employee : employees) {
            LocalDate dateOfBirth = employee.dob();
            int age = calculateAge(dateOfBirth, LocalDate.now());
            if (age >= minAge && age <= maxAge) {
                Log.fine("Employee found: " + employee.empId(), EmployeeRepositoryImpl.class.getSimpleName());
                showEmployeeData.add(employee);
                employeeFound = true;
            }
        }
        if (!employeeFound) {
            Log.fine("No employee found within age range: " + minAge + " -> " + maxAge, EmployeeRepositoryImpl.class.getSimpleName());
            showEmployeeData.add(returnNullEmployee());
        }
        Log.config("End of search.", EmployeeRepositoryImpl.class.getSimpleName());
        return showEmployeeData;
    }

    //Retrieves employees with a partial or full last name match
    @Override
    public List<Employee> getEmployeeLastNameContaining(String partialOrFullLastName) {
        Log.config("Getting employee with the last name containing: " + partialOrFullLastName, EmployeeRepositoryImpl.class.getSimpleName());
        boolean employeeFound = false;
        List<Employee> showEmployeeData = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.lastName().contains(partialOrFullLastName)) {
                Log.fine("Employee found: " + employee.lastName(), EmployeeRepositoryImpl.class.getSimpleName());
                showEmployeeData.add(employee);
                employeeFound = true;
            }
        }
        if (!employeeFound) {
            Log.fine("No employee found that contains: " + partialOrFullLastName, EmployeeRepositoryImpl.class.getSimpleName());
            showEmployeeData.add(returnNullEmployee());
        }
        Log.config("End of search.", EmployeeRepositoryImpl.class.getSimpleName());
        return showEmployeeData;
    }

    @Override
    public List<Employee> getEmployeeBySalaryRange(Integer minSalary, Integer maxSalary) {
        Log.config("Getting employees within salary range: " + "£"+ minSalary + " -> " + "£" + maxSalary, EmployeeRepositoryImpl.class.getSimpleName());
        List<Employee> showEmployeeData = new ArrayList<>();
        boolean employeeFound = false;
        for (Employee employee : employees) {
            if (employee.salary() >= minSalary && employee.salary() <= maxSalary) {
                Log.fine("Employee found within salary range: " + employee.empId(), EmployeeRepositoryImpl.class.getSimpleName());
                showEmployeeData.add(employee);
                employeeFound = true;
            }
        }
        if (!employeeFound) {
            Log.fine("No employee found within salary range: " + "£"+ minSalary + " -> " + "£", EmployeeRepositoryImpl.class.getSimpleName());
            showEmployeeData.add(returnNullEmployee());
        }
        Log.config("End of search.", EmployeeRepositoryImpl.class.getSimpleName());
        return showEmployeeData;
    }

    private Employee returnNullEmployee() {
        Log.config("Returning a null employee object.", EmployeeRepositoryImpl.class.getSimpleName());
        return new Employee(-1, "No Employee Found", "-", '-', "-",
                '-', "-", null, null, -1);
    }

    //Retrieves the list of all employees
    public List<Employee> getEmployees() {
        return employees;
    }
}
