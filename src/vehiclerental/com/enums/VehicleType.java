package vehiclerental.com.enums;

public enum VehicleType {
    SEDAN("Standard Passenger Car"),
    SUV("Sport Utility Vehicle"),
    HATCHBACK("Compact City Car"),
    LUXURY("Premium Luxury Vehicle"),
    TRUCK("Commercial Truck"),
    VAN("Passenger or Cargo Van"),
    MOTORCYCLE("Two-Wheeled Vehicle"),
    ELECTRIC("Electric Vehicle"), HOURLY("Hourly Rental"), FOUR_HOURS("Four Hours Rental"), EIGHT_HOURS("Eight Hours Rental"), DAY("Daily Rental"), MONTH("Monthly Rental"), CAR("Car");

    private final String description;

    VehicleType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}