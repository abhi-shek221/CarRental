package com.vehiclerental.services;

import com.vehiclerental.main.User;
import com.vehiclerental.main.HireableVehicle;
import com.vehiclerental.main.VehicleReservation;
import com.vehiclerental.enums.VehicleReservationType;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reservation {
    private List<VehicleReservation> reservations;

    public Reservation() {
        this.reservations = new ArrayList<>();
    }

    public VehicleReservation createReservation(User user, 
                                                HireableVehicle vehicle, 
                                                LocalDateTime startDateTime, 
                                                VehicleReservationType reservationType) {
        // Check for any conflicting reservations
        boolean isVehicleAvailable = isVehicleAvailableForReservation(vehicle, startDateTime);
        
        if (!isVehicleAvailable) {
            throw new IllegalStateException("Vehicle is not available for the selected time period");
        }

        VehicleReservation newReservation = new VehicleReservation(
            user, vehicle, startDateTime, reservationType
        );

        reservations.add(newReservation);
        return newReservation;
    }

    public boolean isVehicleAvailableForReservation(HireableVehicle vehicle, 
                                                    LocalDateTime proposedStartTime) {
        return reservations.stream()
            .filter(r -> r.getVehicle().equals(vehicle))
            .noneMatch(r -> isTimeOverlap(r, proposedStartTime));
    }

    private boolean isTimeOverlap(VehicleReservation existingReservation, 
                                   LocalDateTime proposedStartTime) {
        LocalDateTime existingStart = existingReservation.getStartDateTime();
        LocalDateTime existingEnd = existingReservation.getEndDateTime();

        return (proposedStartTime.isAfter(existingStart) && 
                proposedStartTime.isBefore(existingEnd));
    }

    public List<VehicleReservation> getUserReservations(User user) {
        return reservations.stream()
            .filter(r -> r.getUser().equals(user))
            .collect(Collectors.toList());
    }

    public List<VehicleReservation> getVehicleReservations(HireableVehicle vehicle) {
        return reservations.stream()
            .filter(r -> r.getVehicle().equals(vehicle))
            .collect(Collectors.toList());
    }

    public void cancelReservation(VehicleReservation reservation) {
        if (reservations.contains(reservation)) {
            reservation.cancelReservation();
            reservations.remove(reservation);
        } else {
            throw new IllegalArgumentException("Reservation not found");
        }
    }

    public List<VehicleReservation> getActiveReservations() {
        return reservations.stream()
            .filter(VehicleReservation::isActive)
            .collect(Collectors.toList());
    }

    public List<VehicleReservation> getReservationsByDateRange(
        LocalDateTime startDate, LocalDateTime endDate) {
        return reservations.stream()
            .filter(r -> !r.getStartDateTime().isBefore(startDate) && 
                         !r.getStartDateTime().isAfter(endDate))
            .collect(Collectors.toList());
    }

    public void generateReservationReport() {
        System.out.println("Reservation Report:");
        System.out.println("Total Reservations: " + reservations.size());
        System.out.println("Active Reservations: " + 
            reservations.stream().filter(VehicleReservation::isActive).count());
        
        // Group reservations by vehicle type
        reservations.stream()
            .collect(Collectors.groupingBy(r -> r.getVehicle().getType(), Collectors.counting()))
            .forEach((type, count) -> 
                System.out.println(type + " Reservations: " + count)
            );
    }
}