package com.vehiclerental;

import com.vehiclerental.main.*;
import com.vehiclerental.utils.*;
import com.vehiclerental.enums.*;
import com.vehiclerental.services.*;
import com.vehiclerental.addons.*;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class CarRentalApplication {
    public static void main(String[] args) {
        // Create Address
        Address userAddress = new Address(
            "123 Main Street", 
            "Cityville", 
            "State", 
            "Country", 
            "12345"
        );

        // Create Contact
        Contact userContact = new Contact(
            "+1234567890", 
            "user@example.com", 
            userAddress
        );

        // Create Personal Info
        PersonalInfo personalInfo = new PersonalInfo(
            "John", 
            "Doe", 
            LocalDate.of(1990, 1, 1), 
            "Male"
        );

        // Create User
        User user = new User(
            "johndoe", 
            "password123", 
            "user@example.com", 
            userContact, 
            personalInfo, 
            LicenseType.PRIVATE_CAR, 
            LocalDate.now().plusYears(5)
        );

        // Add funds to user account
        user.addFunds(1000.0);

        // Create Vehicle Location
        Coordinates locationCoords = new Coordinates(40.7128, -74.0060);
        VehicleLocation rentalLocation = new VehicleLocation(
            "New York Central", 
            locationCoords, 
            50
        );

        // Create Vehicle
        HireableVehicle vehicle = new HireableVehicle(
            "ABC123", 
            "Toyota", 
            "Camry", 
            VehicleType.SEDAN, 
            VehicleCategory.PASSENGER, 
            locationCoords, 
            50.0, 
            2022, 
            "Silver"
        );

        // Add vehicle to location
        rentalLocation.addVehicle(vehicle);

        // Create Reservation Service
        Reservation reservationService = new Reservation();

        // Create Reservation
        VehicleReservation reservation = reservationService.createReservation(
            user, 
            vehicle, 
            LocalDateTime.now(), 
            VehicleReservationType.DAY
        );

        // Add Addons
        reservation.addAddonService(new ChildSeat());
        reservation.addAddonService(new Navigation());

        // Process Payment
        boolean paymentSuccess = reservation.processPayment();
        
        // Generate Invoice
        Invoice invoice = new Invoice(reservation);
        
        // Display Results
        System.out.println("Reservation Created Successfully: " + paymentSuccess);
        user.displayAccountDetails();
        vehicle.displayVehicleDetails();
        invoice.displayInvoiceDetails();
    }
}