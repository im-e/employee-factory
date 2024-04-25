package com.sparta.udonunit.employeefactory;

import org.junit.jupiter.api.*;

public class EmployeeSearcherTests {

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        EmployeeSearcher.init();
    }

    @Test
    @DisplayName("given only valid employees should be returned, an error message should be returned if no employee is found when searching by id")
    void givenOnlyValidEmployeesShouldBeReturnedAnErrorMessageShouldBeReturnedIfNoEmployeeIsFoundWhenSearchingById() {
        int employeeID = 230937595;
        String expectedResult = "No employee found with ID: " + employeeID;
        String actualResult = EmployeeSearcher.searchEmployeeByID(employeeID);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("check to see if correct error message shows if no employees found when searching by age range")
    void checkToSeeIfCorrectErrorMessageShowsIfNoEmployeesFoundWhenSearchingByAgeRange() {
        int rangeStart = 1;
        int rangeEnd = 2;
        String expectedResult = "No employees found within the age range: " + rangeStart + " -> " + rangeEnd;
        String actualResult = EmployeeSearcher.searchEmployeesByAgeRange(rangeStart, rangeEnd);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("check to see if correct message returns if no employees found when searching by hire date range")
    void checkToSeeIfCorrectMessageReturnsIfNoEmployeesFoundWhenSearchingByHireDateRange() {
        String startDate = "1/1/1800";
        String endDate = "3/1/1801";
        String expectedResult = "No employees found within the hiring range: " + startDate + " -> " + endDate;
        String actualResult = EmployeeSearcher.searchEmployeesHiredWithinDateRange(startDate, endDate);

        Assertions.assertEquals(expectedResult, actualResult);

    }

    @Test
    @DisplayName("given that a valid date is required when searching for employees, an error message should be returned if invalid date is entered")
    void givenThatAValidDateIsRequiredWhenSearchingForEmployeesAnErrorMessageShouldBeReturnedIfInvalidDateIsEntered() {
        String expectedResult = "Invalid date entered";
        String actualResult = EmployeeSearcher.searchEmployeesHiredWithinDateRange("invalidDate", "invalidDate");

        Assertions.assertEquals(expectedResult, actualResult);

    }

    @Test
    @DisplayName("test if correct message if shows if no employees found with particular last name")
    void testIfCorrectMessageIfShowsIfNoEmployeesFoundWithParticularLastName() {
        String inputtedQuery = "ThisIsAFakeLastName";
        String expectedResult = "No employees found with the last name containing: " + inputtedQuery;
        String actualResult = EmployeeSearcher.searchEmployeesByLastNameContains(inputtedQuery);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("test to see if correct message shows if no employees found within a particular salary range")
    void testToSeeIfCorrectMessageShowsIfNoEmployeesFoundWithinAParticularSalaryRange() {
        int rangeStart = 1;
        int rangeEnd = 2;
        String expectedResult = "No employees found within the salary range: " + "£"+rangeStart + " -> " + "£"+rangeEnd;
        String actualResult = EmployeeSearcher.searchEmployeesBySalaryRange(rangeStart, rangeEnd);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("test if all employees are returned when all employees are searched")
    void testIfAllEmployeesAreReturnedWhenAllEmployeesAreSearched() {
        int expectedResult = 1000;
        int actualResult = EmployeeSearcher.searchAllEmployees();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("get random employee will return an existing random employee")
    void getRandomEmployeeWillReturnAnExistingRandomEmployee() {
        boolean employeeIsNotNull = EmployeeSearcher.getRandomEmployee() != null;
        Assertions.assertTrue(employeeIsNotNull);

    }

}
