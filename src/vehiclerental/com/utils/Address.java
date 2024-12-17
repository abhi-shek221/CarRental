package vehiclerental.com.utils;

public class Address {
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private String postalCode;

    public Address(String streetAddress, String city, String state, String country, String postalCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
    }

    // Getters and setters
    public String getFullAddress() {
        return String.format("%s, %s, %s, %s %s", 
            streetAddress, city, state, country, postalCode);
    }

    // Validation method
    public boolean isValid() {
        return streetAddress != null && !streetAddress.isEmpty() &&
               city != null && !city.isEmpty() &&
               state != null && !state.isEmpty() &&
               country != null && !country.isEmpty() &&
               postalCode != null && !postalCode.isEmpty();
    }
}