package com.sparta.udonunit.employeefactory;



import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        EmployeeSearcher.init();

        EmployeeSearcher.searchEmployeeByID(294034);
        //print employee
        //log result to a file



    }
}
