package com.sparta.udonunit.employeefactory;

public class DTO {
    private int empId;
    private String title;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String gender;
    private String email;
    private String dob; // Date of Birth
    private String hireDate;
    private int salary;

    // Constructor, getters, and setters
    // Constructor
    public DTO(int empId, String title, String firstName, String middleInitial, String lastName, String gender, String email, String dob, String hireDate, int salary) {
        this.empId = empId;
        this.title = title;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dob = dob;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    // Getters and Setters
    // ...
}
