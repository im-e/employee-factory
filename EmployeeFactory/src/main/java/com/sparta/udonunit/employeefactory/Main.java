package com.sparta.udonunit.employeefactory;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.asList(EmployeeFactory.getEmployees(20)));
    }
}
