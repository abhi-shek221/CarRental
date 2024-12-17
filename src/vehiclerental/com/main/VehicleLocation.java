package com.vehiclerental.main;

import com.vehiclerental.utils.Coordinates;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class VehicleLocation {
    private Coordinates coordinates;
    private String locationName;
    private int capacity;
    private List<HireableVehicle> vehicles;

    public VehicleLocation(String locationName, Coordinates coordinates, int capacity) {
        this.locationName = locationName;
        this.coordinates = coordinates;
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(HireableVehicle vehicle) {
        if (vehicles.size() < capacity) {
            vehicles.add(vehicle);
        } else {
            throw new IllegalStateException("Location capacity reached");
        }
    }

    public void removeVehicle(HireableVehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public List<HireableVehicle> getAvailableVehicles() {
        return vehicles.stream()
                .filter(v -> v.getStatus().equals(VehicleStatus.AVAILABLE))
                .collect(Collectors.toList());
    }

    public List<HireableVehicle> getVehiclesByType(VehicleType type) {
        return vehicles.stream()
                .filter(v -> v.getType().equals(type))
                .collect(Collectors.toList());
    }

    public void displayLocationDetails() {
        System.out.println("Location: " + locationName);
        System.out.println("Coordinates: " + coordinates);
        System.out.println("Total Capacity: " + capacity);
        System.out.println("Current Vehicles: " + vehicles.size());
        System.out.println("Available Vehicles: " + getAvailableVehicles().size());
    }

    // Getters
    public Coordinates getCoordinates() {
        return coordinates;
    }

    public String getLocationName() {
        return locationName;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<HireableVehicle> getAllVehicles() {
        return new ArrayList<>(vehicles);
    }
}