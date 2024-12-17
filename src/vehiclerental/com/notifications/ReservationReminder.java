package vehiclerental.com.notifications;

import vehiclerental.com.main.User;
import vehiclerental.com.main.VehicleReservation;
import java.time.LocalDateTime;

public class ReservationReminder {
    private VehicleReservation reservation;
    private User recipient;
    private LocalDateTime reminderTime;
    private boolean sent;

    public ReservationReminder(VehicleReservation reservation, User recipient) {
        this.reservation = reservation;
        this.recipient = recipient;
        this.reminderTime = LocalDateTime.now();
        this.sent = false;
        sendReminder();
    }

    private void sendReminder() {
        try {
            // Simulate sending reminder
            System.out.println("Reservation Reminder:");
            System.out.println("To: " + recipient.getEmail());
            System.out.println("Reservation ID: " + reservation.getReservationId());
            System.out.println("Vehicle: " + reservation.getVehicle().getMake() + " " + 
                               reservation.getVehicle().getModel());
            System.out.println("Start Time: " + reservation.getStartDateTime());
            System.out.println("End Time: " + reservation.getEndDateTime());
            
            this.sent = true;
        } catch (Exception e) {
            this.sent = false;
            System.err.println("Failed to send reservation reminder: " + e.getMessage());
        }
    }

    public boolean isSent() {
        return sent;
    }

    public LocalDateTime getReminderTime() {
        return reminderTime;
    }
}