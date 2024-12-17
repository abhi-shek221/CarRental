package vehiclerental.com.main;

import vehiclerental.com.enums.VehicleType;
import vehiclerental.com.addons.AddonService;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VehicleReservation {
    private final String reservationId;
    private User user;
    private HireableVehicle vehicle;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private VehicleType reservationType;
    private List<AddonService> addons;
    private double totalCost;
    private boolean isPaid;
    private boolean isActive;

    public VehicleReservation(User user, HireableVehicle vehicle, 
                               LocalDateTime startDateTime, 
                               VehicleType reservationType) {
        this.reservationId = UUID.randomUUID().toString();
        this.user = user;
        this.vehicle = vehicle;
        this.startDateTime = startDateTime;
        this.reservationType = reservationType;
        this.addons = new ArrayList<>();
        calculateEndDateTime();
        calculateReservationCost();
    }

    private void calculateEndDateTime() {
        switch (reservationType) {
            case HOURLY:
                this.endDateTime = startDateTime.plusHours(1);
                break;
            case FOUR_HOURS:
                this.endDateTime = startDateTime.plusHours(4);
                break;
            case EIGHT_HOURS:
                this.endDateTime = startDateTime.plusHours(8);
                break;
            case DAY:
                this.endDateTime = startDateTime.plusDays(1);
                break;
            case MONTH:
                this.endDateTime = startDateTime.plusMonths(1);
                break;
        }
    }

    private void calculateReservationCost() {
        long duration = ChronoUnit.HOURS.between(startDateTime, endDateTime);
        double baseCost = vehicle.getRentalRate() * duration;
        
        double addonCost = addons.stream()
                               .mapToDouble(AddonService::getCost)
                               .sum();
        
        this.totalCost = baseCost + addonCost;
    }

    public void addAddonService(AddonService addon) {
        addons.add(addon);
        calculateReservationCost();
    }

    public boolean processPayment() {
        if (user.withdrawFunds(totalCost)) {
            this.isPaid = true;
            this.isActive = true;
            user.incrementReservationCount();
            vehicle.reserve();
            return true;
        }
        return false;
    }

    public void cancelReservation() {
        if (!isPaid) {
            throw new IllegalStateException("Cannot cancel an unpaid reservation");
        }
        
        long hoursBetween = ChronoUnit.HOURS.between(LocalDateTime.now(), startDateTime);
        
        // Refund policy
        double refundPercentage = hoursBetween > 24 ? 0.8 : 
                                   hoursBetween > 12 ? 0.5 : 
                                   hoursBetween > 6 ? 0.2 : 0;
        
        double refundAmount = totalCost * refundPercentage;
        user.addFunds(refundAmount);
        
        this.isActive = false;
        vehicle.release();
    }

    // Getters
    public String getReservationId() {
        return reservationId;
    }

    public User getUser() {
        return user;
    }

    public HireableVehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public boolean isActive() {
        return isActive;
    }
}