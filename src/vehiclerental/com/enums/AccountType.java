package com.vehiclerental.enums;

public enum AccountType {
    USER("Regular User"),
    ADMIN("System Administrator"),
    DRIVER("Professional Driver"),
    SUPPORT("Customer Support");

    private final String role;

    AccountType(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}