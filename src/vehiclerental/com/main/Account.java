package vehiclerental.com.main;

import vehiclerental.com.utils.Contact;
import vehiclerental.com.enums.AccountStatus;
import vehiclerental.com.enums.AccountType;
import java.time.LocalDateTime;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public abstract class Account {
    private final String accountId;
    private String username;
    private String passwordHash;
    private String email;
    private Contact contact;
    private AccountType accountType;
    private AccountStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime lastLogin;

    public Account(String username, String password, String email, Contact contact, AccountType accountType) {
        this.accountId = UUID.randomUUID().toString();
        this.username = username;
        this.email = email;
        this.contact = contact;
        this.accountType = accountType;
        this.status = AccountStatus.ACTIVE;
        this.createdAt = LocalDateTime.now();
        setPassword(password);
    }

    private void setPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            this.passwordHash = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Password hashing failed", e);
        }
    }

    public boolean verifyPassword(String inputPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(inputPassword.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return this.passwordHash.equals(sb.toString());
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }

    public void updatePassword(String oldPassword, String newPassword) {
        if (verifyPassword(oldPassword)) {
            setPassword(newPassword);
        } else {
            throw new SecurityException("Invalid current password");
        }
    }

    public void updateContact(Contact newContact) {
        this.contact = newContact;
    }

    public void updateAccountStatus(AccountStatus newStatus) {
        this.status = newStatus;
    }

    public void recordLogin() {
        this.lastLogin = LocalDateTime.now();
    }

    // Getters
    public String getAccountId() {
        return accountId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Contact getContact() {
        return contact;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    // Abstract method to be implemented by subclasses
    public abstract void displayAccountDetails();
}