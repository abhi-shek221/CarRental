package com.vehiclerental.main;

import com.vehiclerental.enums.AccountType;
import com.vehiclerental.enums.LicenseType;
import com.vehiclerental.utils.Contact;
import com.vehiclerental.utils.PersonalInfo;
import java.time.LocalDate;

public class User extends Account {
    private PersonalInfo personalInfo;
    private LicenseType licenseType;
    private LocalDate licenseExpiryDate;
    private double accountBalance;
    private int totalReservations;
    private boolean isVerified;

    public User(String username, String password, String email, 
                Contact contact, PersonalInfo personalInfo, 
                LicenseType licenseType, LocalDate licenseExpiryDate) {
        super(username, password, email, contact, AccountType.USER);
        this.personalInfo = personalInfo;
        this.licenseType = licenseType;
        this.licenseExpiryDate = licenseExpiryDate;
        this.accountBalance = 0.0;
        this.totalReservations = 0;
        this.isVerified = false;
    }

    public void addFunds(double amount) {
        if (amount > 0) {
            this.accountBalance += amount;
        }
    }

    public boolean withdrawFunds(double amount) {
        if (amount > 0 && this.accountBalance >= amount) {
            this.accountBalance -= amount;
            return true;
        }
        return false;
    }

    public void incrementReservationCount() {
        this.totalReservations++;
    }

    public void verifyAccount() {
        this.isVerified = true;
    }

    public boolean isLicenseValid() {
        return LocalDate.now().isBefore(licenseExpiryDate);
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("User Account Details:");
        System.out.println("Name: " + personalInfo.getFullName());
        System.out.println("Email: " + getEmail());
        System.out.println("License Type: " + licenseType);
        System.out.println("Account Balance: $" + accountBalance);
        System.out.println("Total Reservations: " + totalReservations);
        System.out.println("Verified: " + (isVerified ? "Yes" : "No"));
    }

    // Getters
    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public LicenseType getLicenseType() {
        return licenseType;
    }

    public LocalDate getLicenseExpiryDate() {
        return licenseExpiryDate;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public int getTotalReservations() {
        return totalReservations;
    }

    public boolean isVerified() {
        return isVerified;
    }
}