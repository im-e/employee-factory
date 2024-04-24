package com.sparta.udonunit.employeefactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryTests {

    List<Employee> employees;
    EmployeeRepositoryImpl employeeRepository;

    @BeforeEach
    public void setUpBeforeClass() throws Exception {
        Employee e1 = new Employee(198429,"Mrs.","Serafina","I","Bumgarner",
                "F","serafina.bumgarner@exxonmobil.com",
                LocalDate.parse("9/21/1982", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                LocalDate.parse("2/1/2008", DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                ,69294);
        Employee e2 = new Employee(178566,"Mrs.","Juliette","M","Rojo",
                "F","juliette.rojo@yahoo.co.uk",
                LocalDate.parse("5/8/1967", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                LocalDate.parse("26/4/2011", DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                ,193912);
        Employee e3 = new Employee(540293,"Mrs.","Jerafina","I","Bumjarner",
                "F","jerafina.bumjarner@exxonmobil.com",
                LocalDate.parse("9/21/1982", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                LocalDate.parse("2/1/2008", DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                ,69295);

        employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        employeeRepository = new EmployeeRepositoryImpl(employees);
    }

    //Employee ID tests start
    @Test
    @DisplayName("Given the employee id, search will return with employee with that ID")
    void givenTheEmployeeIdSearchWillReturnWithEmployeeWithThatId() {
        int givenID = 198429;
        String expectedFirstName = "Serafina";
        String searchedFirstName = employeeRepository.getEmployeeByID(givenID).firstName();
        Assertions.assertEquals(expectedFirstName,searchedFirstName);
    }

    //Last name tests start
    @Test
    @DisplayName("Given an employee last name, search will return an employee with that last name")
    void givenAnEmployeeLastNameSearchWillReturnAnEmployeeWithThatLastName() {
        String givenLastName = "Bumgarner";
        int expectedID = 198429;
        boolean matchedExpectedID = false;
        List<Employee> expectedEmployees = employeeRepository.getEmployeesByLastName(givenLastName);
        for(Employee employee : expectedEmployees) {
            if (employee.empId() == expectedID) {
                matchedExpectedID = true;
                break;
            }
        }
        Assertions.assertTrue(matchedExpectedID);
    }

    @Test
    @DisplayName("Given a partial last name, search will return all employees matching the partial last name")
    void givenAPartialLastNameSearchWillReturnAllEmployeesMatchingThePartialLastName() {
        String givenPartialLastName = "Bum";
        final int expectedID1 = 198429;
        final int expectedID2 = 540293;
        boolean matchedExpectedID1 = false;
        boolean matchedExpectedID2 = false;
        List<Employee> expectedEmployees = employeeRepository.getEmployeesByLastName(givenPartialLastName);
        for(Employee employee : expectedEmployees) {
            switch(employee.empId()){
                case expectedID1 -> matchedExpectedID1 = true;
                case expectedID2 -> matchedExpectedID2 = true;
            }
        }
        Assertions.assertTrue(matchedExpectedID1);
        Assertions.assertTrue(matchedExpectedID2);

    }


    @Test
    @DisplayName("Given two dates should return all employees hired within those dates")
    void givenTwoDateShouldReturnAllEmployeesHiredWithThoseDates(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String strStartDate = "1/1/2008";
        LocalDate startDate = LocalDate.parse(strStartDate, formatter);
        String strEndDate = "3/1/2008";
        LocalDate endDate = LocalDate.parse(strEndDate, formatter);

        List<Employee> result = employeeRepository.getEmployeesByHiredDateRange(startDate, endDate);

        List<Employee> expectedEmployees = new ArrayList<>(employees);

        Assertions.assertEquals(expectedEmployees.size(), result.size());
        Assertions.assertTrue(result.containsAll(expectedEmployees));


    }
}
