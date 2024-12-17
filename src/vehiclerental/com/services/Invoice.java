package vehiclerental.com.services;

import vehiclerental.com.main.VehicleReservation;
import java.time.LocalDateTime;
import java.util.UUID;

public class Invoice {
    private String invoiceId;
    private VehicleReservation reservation;
    private LocalDateTime invoiceDate;
    private double totalAmount;
    private boolean isPaid;

    public Invoice(VehicleReservation reservation) {
        this.invoiceId = UUID.randomUUID().toString();
        this.reservation = reservation;
        this.invoiceDate = LocalDateTime.now();
        this.totalAmount = reservation.getTotalCost();
        this.isPaid = false;
    }

    public void markAsPaid() {
        this.isPaid = true;
    }

    public void displayInvoiceDetails() {
        System.out.println("Invoice Details:");
        System.out.println("Invoice ID: " + invoiceId);
        System.out.println("Reservation ID: " + reservation.getReservationId());
        System.out.println("Invoice Date: " + invoiceDate);
        System.out.println("Total Amount: $" + totalAmount);
        System.out.println("Status: " + (isPaid ? "Paid" : "Unpaid"));
    }

    // Getters
    public String getInvoiceId() {
        return invoiceId;
    }

    public VehicleReservation getReservation() {
        return reservation;
    }

    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isPaid() {
        return isPaid;
    }
}