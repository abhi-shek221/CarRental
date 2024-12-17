package com.vehiclerental.enums;

public enum VehicleStatus {
    AVAILABLE("Ready for Rent"),
    BOOKED("Currently Reserved"),
    IN_USE("Currently Being Used"),
    MAINTENANCE("Under Repair"),
    UNAVAILABLE("Not Available for Rent");

    private final String status;

    VehicleStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}