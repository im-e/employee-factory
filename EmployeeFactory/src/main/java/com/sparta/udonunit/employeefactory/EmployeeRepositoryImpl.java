package com.sparta.udonunit.employeefactory;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    final private List<Employee> employees;

    public EmployeeRepositoryImpl(List<Employee> employees) {
        this.employees = employees;
    }

    private boolean employeeIsHiredWithinDateRange(Employee employee, LocalDate startDate, LocalDate endDate) {
        LocalDate hireDate = employee.hireDate();
        return !hireDate.isBefore(startDate) && !hireDate.isAfter(endDate);

    }

    public int calculateAge(LocalDate dob, LocalDate today){
        return Period.between(dob, today).getYears();
    }

    @Override
    public Employee getEmployeeByID(Integer id) {

        return employees.stream().filter(employee -> employee.empId().equals(id)).findFirst().orElse(null);

    }


    @Override
    public List<Employee> getEmployeesByHiredDateRange(LocalDate startDate, LocalDate endDate) {
        List<Employee> employeesResult = new ArrayList<>();
        // convert string input

        
        boolean employeeFound = false;
        for (Employee employee: employees) {
            if (employeeIsHiredWithinDateRange(employee, startDate, endDate)) {
                employeesResult.add(employee);
                employeeFound = true;
            }if(!employeeFound){
                employeesResult.add(new Employee(-1, "No Employee Found", "-", '-',"-",
                        '-',"-",null,null,-1));
            }
        }
        return employeesResult;
    }


    @Override
    public List<Employee> getEmployeeByAgeRange(Integer minAge, Integer maxAge) {
        List<Employee> showEmployeeData = new ArrayList<>();
        for (Employee employee : employees ){
            LocalDate dateOfBirth = employee.dob();
            int age = calculateAge(dateOfBirth, LocalDate.now());
            if(age>=minAge && age<=maxAge){
                showEmployeeData.add(employee);
            }
        }
        return showEmployeeData;
    }

    @Override
    public List<Employee> getEmployeeByEitherPartialOrFullLastName(String partialLastName) {
        List<Employee> showEmployeeData = new ArrayList<>();
        for(Employee employee : employees){
            if(employee.lastName().contains(partialLastName)){
                showEmployeeData.add(employee);
            }
        }
        return showEmployeeData;
    }


    public List<Employee> getEmployees() {
        return employees;
    }
}
