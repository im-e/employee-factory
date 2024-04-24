package com.sparta.udonunit.employeefactory;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository {
    Employee getEmployeeByID(Integer id);
    List<Employee> getEmployeesByHiredDateRange(LocalDate startDate, LocalDate endDate);
    List<Employee> getEmployeesByLastName(String lastName);
    List<Employee> getEmployeeByAgeRange(Integer minAge, Integer maxAge);
}
