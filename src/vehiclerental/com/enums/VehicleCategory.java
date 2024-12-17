package com.vehiclerental.enums;

public enum VehicleCategory {
    PASSENGER("Personal Passenger Vehicle"),
    COMMERCIAL("Business and Transport Vehicle"),
    UTILITY("Utility and Work Vehicles"),
    LUXURY("High-End Luxury Vehicles");

    private final String description;

    VehicleCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}