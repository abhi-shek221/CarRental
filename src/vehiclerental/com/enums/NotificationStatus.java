package com.vehiclerental.enums;

public enum NotificationStatus {
    SENT("Successfully Sent"),
    PENDING("Awaiting Transmission"),
    FAILED("Transmission Failed"),
    RETRIED("Retry Attempted"),
    DELIVERED("Confirmed Delivery");

    private final String status;

    NotificationStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}