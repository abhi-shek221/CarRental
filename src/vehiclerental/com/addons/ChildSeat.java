package com.vehiclerental.addons;

public class ChildSeat extends VehicleAddon {
    public ChildSeat() {
        super("Child Seat", "Child safety seat for young passengers", 15.0);
    }

    public void displayDetails() {
        System.out.println("Addon: " + getName());
        System.out.println("Description: " + getDescription());
        System.out.println("Cost: $" + getCost());
    }
}