package vehiclerental.com.enums;

public enum AccountStatus {
    ACTIVE("Active"),      // Account is fully functional
    PENDING("Pending"),    // Account awaiting verification
    SUSPENDED("Suspended"),// Account temporarily disabled
    CLOSED("Closed"),      // Account permanently closed
    BLOCKED("Blocked");    // Account blocked due to violations

    private final String description;

    AccountStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}