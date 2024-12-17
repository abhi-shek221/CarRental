package com.vehiclerental.addons;

public class Navigation extends VehicleAddon {
    public Navigation() {
        super("GPS Navigation", "Advanced GPS navigation system", 10.0);
    }

    public void displayDetails() {
        System.out.println("Addon: " + getName());
        System.out.println("Description: " + getDescription());
        System.out.println("Cost: $" + getCost());
    }
}