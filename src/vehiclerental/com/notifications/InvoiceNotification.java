package vehiclerental.com.notifications;

import vehiclerental.com.main.User;
import vehiclerental.com.services.Invoice;
import java.time.LocalDateTime;

public class InvoiceNotification {
    private Invoice invoice;
    private User recipient;
    private LocalDateTime sentDateTime;
    private boolean isDelivered;

    public InvoiceNotification(Invoice invoice, User recipient) {
        this.invoice = invoice;
        this.recipient = recipient;
        this.sentDateTime = LocalDateTime.now();
        this.isDelivered = false;
        sendNotification();
    }

    private void sendNotification() {
        try {
            // Simulate sending email or SMS
            System.out.println("Invoice Notification Sent:");
            System.out.println("To: " + recipient.getEmail());
            System.out.println("Invoice ID: " + invoice.getInvoiceId());
            System.out.println("Total Amount: $" + invoice.getTotalAmount());
            
            this.isDelivered = true;
        } catch (Exception e) {
            this.isDelivered = false;
            System.err.println("Failed to send invoice notification: " + e.getMessage());
        }
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public LocalDateTime getSentDateTime() {
        return sentDateTime;
    }
}