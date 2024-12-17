package vehiclerental.com.main;

import vehiclerental.com.utils.Coordinates;
import vehiclerental.com.enums.VehicleCategory;
import vehiclerental.com.enums.VehicleStatus;
import vehiclerental.com.enums.VehicleType;
import java.util.UUID;

public class HireableVehicle {
    private final String vehicleId;
    private String licensePlate;
    private String make;
    private String model;
    private VehicleType type;
    private VehicleCategory category;
    private VehicleStatus status;
    private Coordinates location;
    private double rentalRate;
    private int year;
    private String color;
    private int mileage;
    private boolean isInsured;

    public HireableVehicle(String licensePlate, String make, String model, 
                            VehicleType type, VehicleCategory category, 
                            Coordinates location, double rentalRate, 
                            int year, String color) {
        this.vehicleId = UUID.randomUUID().toString();
        this.licensePlate = licensePlate;
        this.make = make;
        this.model = model;
        this.type = type;
        this.category = category;
        this.status = VehicleStatus.AVAILABLE;
        this.location = location;
        this.rentalRate = rentalRate;
        this.year = year;
        this.color = color;
        this.mileage = 0;
        this.isInsured = true;
    }

    public void updateLocation(Coordinates newLocation) {
        this.location = newLocation;
    }

    public void updateMileage(int additionalMileage) {
        if (additionalMileage > 0) {
            this.mileage += additionalMileage;
        }
    }

    public void reserve() {
        if (status == VehicleStatus.AVAILABLE) {
            this.status = VehicleStatus.BOOKED;
        } else {
            throw new IllegalStateException("Vehicle is not available for reservation");
        }
    }

    public void release() {
        this.status = VehicleStatus.AVAILABLE;
    }

    public void markForMaintenance() {
        this.status = VehicleStatus.MAINTENANCE;
    }

    public void renewInsurance() {
        this.isInsured = true;
    }

    // Comprehensive vehicle information display
    public void displayVehicleDetails() {
        System.out.println("Vehicle Details:");
        System.out.println("ID: " + vehicleId);
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Type: " + type);
        System.out.println("Category: " + category);
        System.out.println("Current Status: " + status);
        System.out.println("Rental Rate: $" + rentalRate + " per hour");
        System.out.println("Mileage: " + mileage + " miles");
        System.out.println("Insured: " + (isInsured ? "Yes" : "No"));
    }

    // Getters
    public String getVehicleId() {
        return vehicleId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public VehicleType getType() {
        return type;
    }

    public VehicleCategory getCategory() {
        return category;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public Coordinates getLocation() {
        return location;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public int getMileage() {
        return mileage;
    }

    public boolean isInsured() {
        return isInsured;
    }
}