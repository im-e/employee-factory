package com.sparta.udonunit.employeefactory;

import java.time.LocalDate;
import java.util.List;

//Interface defining methods for accessing employee data
public interface EmployeeRepository {
    Employee getEmployeeByID(Integer id);

    List<Employee> getEmployeesByHiredDateRange(LocalDate startDate, LocalDate endDate);

    List<Employee> getEmployeeByAgeRange(Integer minAge, Integer maxAge);

    List<Employee> getEmployeeLastNameContaining(String partialLastName);

    List<Employee> getEmployeeBySalaryRange(Integer minSalary, Integer maxSalary);

}
