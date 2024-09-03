package server;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.Period;
import java.util.regex.Pattern;

public interface Verification {

    // Static method for name validation
    public static boolean namevf(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        if (name.length() < 1 || name.length() > 50) {
            return false;
        }
        if (!name.matches("[a-zA-Z\\s]+")) {
            return false;
        }
        return true;
    }

    // Static method for DOB validation
    public static boolean dobvf(String dob) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate dateOfBirth = LocalDate.parse(dob, dateFormatter);
            if (dateOfBirth.isAfter(LocalDate.now())) {
                return false;
            }
            int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
            if (age < 0 || age > 120) {
                return false;
            }
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    // Static method for email validation
    public static boolean emailvf(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (!pattern.matcher(email).matches()) {
            return false;
        }
        return true;
    }

    // Static method for address validation
    public static boolean addressvf(String address) {
        if (address == null || address.isEmpty()) {
            return false;
        }
        if (address.length() < 5 || address.length() > 100) {
            return false;
        }
        return true;
    }

    // Static method for meter number validation
    public static boolean meternovf(String meterNo) {
        if (meterNo == null || meterNo.isEmpty()) {
            return false;
        }
        if (!meterNo.matches("\\d{6,10}")) { // Example: 6 to 10 digit number
            return false;
        }
        return true;
    }

    // Static method for NID number validation
    public static boolean nidnovf(String nidNo) {
        if (nidNo == null || nidNo.isEmpty()) {
            return false;
        }
        if (!nidNo.matches("\\d{10,17}")) { // Example: 10 to 17 digit number
            return false;
        }
        return true;
    }

    // Static method for password validation
    public static boolean passwordvf(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        if (password.length() < 8 || password.length() > 20) {
            return false;
        }
        // Check for at least one digit, one uppercase letter, one lowercase letter, and one special character
        if (!password.matches("^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#\\$%\\^&\\*]).{8,20}$")) {
            return false;
        }
        return true;
    }
}
