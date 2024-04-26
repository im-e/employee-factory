package com.sparta.udonunit.employeefactory;


import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        EmployeeSearcher.init();

        EmployeeSearcher.searchEmployeeByID(EmployeeSearcher.getRandomEmployee().empId());
        EmployeeSearcher.searchEmployeeByID(00000);

        EmployeeSearcher.searchAllEmployees();

        EmployeeSearcher.searchEmployeesByAgeRange(25, 27);
        EmployeeSearcher.searchEmployeesByAgeRange(10, 12);

        EmployeeSearcher.searchEmployeesByLastNameContains("Fr");
        EmployeeSearcher.searchEmployeesByLastNameContains("Xisf");

        EmployeeSearcher.searchEmployeesHiredWithinDateRange("1/23/1999", "4/1/1999");
        EmployeeSearcher.searchEmployeesHiredWithinDateRange("1/23/1800", "2/1/1850");
        //EmployeeSearcher.searchEmployeesHiredWithinDateRange("hello", "2/1/1850");

        EmployeeSearcher.searchEmployeesBySalaryRange(95000, 98000);
        EmployeeSearcher.searchEmployeesBySalaryRange(10, 50);

    }
}
