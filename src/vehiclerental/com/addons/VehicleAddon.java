package com.vehiclerental.addons;

public abstract class VehicleAddon implements AddonService {
    protected String name;
    protected String description;
    protected double cost;

    public VehicleAddon(String name, String description, double cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getCost() {
        return cost;
    }
}