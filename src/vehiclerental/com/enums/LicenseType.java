package com.vehiclerental.enums;

public enum LicenseType {
    PRIVATE_CAR("Private Car License"),
    COMMERCIAL("Commercial Vehicle License"),
    MOTORCYCLE("Motorcycle License"),
    HEAVY_VEHICLE("Heavy Vehicle License"),
    INTERNATIONAL("International Driving Permit");

    private final String description;

    LicenseType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}