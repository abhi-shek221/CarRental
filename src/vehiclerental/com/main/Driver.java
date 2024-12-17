package vehiclerental.com.main;

import vehiclerental.com.enums.AccountType;
import vehiclerental.com.enums.LicenseType;
import vehiclerental.com.utils.Contact;
import vehiclerental.com.utils.PersonalInfo;
import java.time.LocalDate;

public class Driver extends Account {
    private PersonalInfo personalInfo;
    private LicenseType licenseType;
    private LocalDate licenseExpiryDate;
    private double driverRating;
    private int totalTrips;
    private boolean isAvailable;

    public Driver(String username, String password, String email, 
                  Contact contact, PersonalInfo personalInfo, 
                  LicenseType licenseType, LocalDate licenseExpiryDate) {
        super(username, password, email, contact, AccountType.DRIVER);
        this.personalInfo = personalInfo;
        this.licenseType = licenseType;
        this.licenseExpiryDate = licenseExpiryDate;
        this.driverRating = 5.0;
        this.totalTrips = 0;
        this.isAvailable = true;
    }

    public void updateRating(double rating) {
        if (rating >= 0 && rating <= 5) {
            this.driverRating = (this.driverRating * totalTrips + rating) / (totalTrips + 1);
        }
    }

    public void incrementTotalTrips() {
        this.totalTrips++;
    }

    public void toggleAvailability() {
        this.isAvailable = !this.isAvailable;
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Driver Account Details:");
        System.out.println("Name: " + personalInfo.getFullName());
        System.out.println("Email: " + getEmail());
        System.out.println("License Type: " + licenseType);
        System.out.println("Driver Rating: " + driverRating);
        System.out.println("Total Trips: " + totalTrips);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
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

    public double getDriverRating() {
        return driverRating;
    }

    public int getTotalTrips() {
        return totalTrips;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}