package com.sparta.udonunit.employeefactory;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository {
    Employee getEmployeeByID(Integer id);
    List<Employee> getEmployeesByHiredDateRange(LocalDate startDate, LocalDate endDate);
    List<Employee> getEmployeeByAgeRange(Integer minAge, Integer maxAge);
    List<Employee> getEmployeeByEitherPartialOrFullLastName(String partialLastName);

}
