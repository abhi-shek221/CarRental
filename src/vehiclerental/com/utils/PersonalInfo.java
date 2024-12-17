package com.vehiclerental.utils;

import java.time.LocalDate;

public class PersonalInfo {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;

    public PersonalInfo(String firstName, String lastName, LocalDate dateOfBirth, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public int getAge() {
        return LocalDate.now().getYear() - dateOfBirth.getYear();
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Validation methods
    public boolean isAdult() {
        return getAge() >= 18;
    }
}