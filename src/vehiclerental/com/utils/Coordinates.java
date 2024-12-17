package com.vehiclerental.utils;

public class Coordinates {
    private double latitude;
    private double longitude;

    public Coordinates(double latitude, double longitude) {
        if (!isValidLatitude(latitude) || !isValidLongitude(longitude)) {
            throw new IllegalArgumentException("Invalid coordinates");
        }
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private boolean isValidLatitude(double latitude) {
        return latitude >= -90 && latitude <= 90;
    }

    private boolean isValidLongitude(double longitude) {
        return longitude >= -180 && longitude <= 180;
    }

    public double distanceTo(Coordinates other) {
        final int EARTH_RADIUS = 6371; // kilometers
        
        double lat1 = Math.toRadians(this.latitude);
        double lon1 = Math.toRadians(this.longitude);
        double lat2 = Math.toRadians(other.latitude);
        double lon2 = Math.toRadians(other.longitude);

        double dlat = lat2 - lat1;
        double dlon = lon2 - lon1;

        double a = Math.sin(dlat/2) * Math.sin(dlat/2) +
                   Math.cos(lat1) * Math.cos(lat2) *
                   Math.sin(dlon/2) * Math.sin(dlon/2);
        
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        
        return EARTH_RADIUS * c;
    }
}