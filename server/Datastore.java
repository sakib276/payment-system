package server;

import java.io.*;

public class Datastore {

    // Method to save user registration data in CSV format
    public boolean saveUser(String name, String meterNo, String dob, String nidNo, String email, String phone,
                            String district, String division, String religion, String address,
                            String gender, String status, String password) {
        // Construct a CSV line with user details
        String userData = String.join(",",
                escapeSpecialCharacters(name),
                escapeSpecialCharacters(meterNo),
                escapeSpecialCharacters(dob),
                escapeSpecialCharacters(nidNo),
                escapeSpecialCharacters(phone),
                escapeSpecialCharacters(district),
                escapeSpecialCharacters(division),
                escapeSpecialCharacters(religion),
                escapeSpecialCharacters(address),
                escapeSpecialCharacters(gender),
                escapeSpecialCharacters(status)
        );

        String userEmail = String.join(",", escapeSpecialCharacters(email), escapeSpecialCharacters(password));

        // Write user data to the CSV files
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("E:/ELECTIC BILL PAYMEM/payment-system/server/user_data.csv", true));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E:/ELECTIC BILL PAYMEM/payment-system/server/user_email.csv", true))) {

            writer.write(userData);
            writer.newLine();

            bufferedWriter.write(userEmail);
            bufferedWriter.newLine();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Escape special characters in CSV fields
    private String escapeSpecialCharacters(String data) {
        if (data == null) {
            return "";
        }
        // Escape double quotes by doubling them
        data = data.replace("\"", "\"\"");
        // Enclose data in double quotes if it contains commas or quotes
        if (data.contains(",") || data.contains("\"")) {
            data = "\"" + data + "\"";
        }
        return data;
    }



    public static boolean checkUserCredentials(String email, String password) {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("E:/ELECTIC BILL PAYMEM/payment-system/server/user_email.csv"))) {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String storedEmail = parts[0];
                    String storedPassword = parts[1];
                    if (storedEmail.equals(email) && storedPassword.equals(password)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
