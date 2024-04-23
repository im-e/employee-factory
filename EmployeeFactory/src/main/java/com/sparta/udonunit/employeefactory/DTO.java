package com.sparta.udonunit.employeefactory;

import java.time.LocalDate;

public class DTO {
    private final int empId;
    private final String title;
    private final String firstName;
    private final String middleInitial;
    private final String lastName;
    private final String gender;
    private final String email;
    private final LocalDate dob; // Date of Birth
    private final LocalDate hireDate;
    private final int salary;


    public DTO(int empId, String title, String firstName, String middleInitial, String lastName, String gender,
               String email, LocalDate dob, LocalDate hireDate, int salary) {
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

    public int getEmpId() {
        return empId;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "DTO{" +
                "empId=" + empId +
                ", title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleInitial='" + middleInitial + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                '}';
    }
}
