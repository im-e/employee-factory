package com.sparta.udonunit.employeefactory;

import java.time.LocalDate;

/**
 * @param dob Date of Birth
 */
public record Employee(int empId, String title, String firstName, String middleInitial, String lastName, String gender,
                       String email, LocalDate dob, LocalDate hireDate, int salary) {

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
