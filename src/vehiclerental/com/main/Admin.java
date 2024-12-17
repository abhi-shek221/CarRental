package vehiclerental.com.main;

import vehiclerental.com.enums.AccountType;
import vehiclerental.com.utils.Contact;

public class Admin extends Account {
    private String department;
    private String[] permissions;

    public Admin(String username, String password, String email, 
                 Contact contact, String department) {
        super(username, password, email, contact, AccountType.ADMIN);
        this.department = department;
        this.permissions = new String[]{"READ", "WRITE", "DELETE"};
    }

    public void assignPermissions(String[] newPermissions) {
        this.permissions = newPermissions;
    }

    public boolean hasPermission(String permission) {
        for (String p : permissions) {
            if (p.equalsIgnoreCase(permission)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Admin Account Details:");
        System.out.println("Username: " + getUsername());
        System.out.println("Email: " + getEmail());
        System.out.println("Department: " + department);
        System.out.println("Permissions: " + String.join(", ", permissions));
    }

    public String getDepartment() {
        return department;
    }

    public String[] getPermissions() {
        return permissions.clone();
    }
}