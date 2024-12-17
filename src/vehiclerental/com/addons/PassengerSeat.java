package vehiclerental.com.addons;

public class PassengerSeat extends VehicleAddon {
    private int passengerCount;

    public PassengerSeat(int passengerCount) {
        super("Additional Passenger", 
              "Extra seat for additional passengers", 
              passengerCount * 5.0);
        this.passengerCount = passengerCount;
    }

    public void displayDetails() {
        System.out.println("Addon: " + getName());
        System.out.println("Description: " + getDescription());
        System.out.println("Passengers: " + passengerCount);
        System.out.println("Cost: $" + getCost());
    }
}