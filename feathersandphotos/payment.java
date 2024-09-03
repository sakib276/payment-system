package feathersandphotos;

import javax.swing.*;
import java.awt.*;

public class payment extends JDialog {
    private String paymentMethod = "Not Selected";

    public payment(Frame parent) {
        super(parent, "Payment Method", true);
        initUI();
    }

    private void initUI() {
        setLayout(new GridLayout(0, 1));
        setSize(300, 200);
        setLocationRelativeTo(getParent());

        String[] options = {"Credit Card", "Debit Card", "Bkash", "Rocket", "UPI"};

        for (String option : options) {
            JButton button = new JButton(option);
            button.addActionListener(e -> {
                paymentMethod = option;
                dispose();

                openPaymentDetailsDialog(option);
            });
            add(button);
        }

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> {
            paymentMethod = "Not Selected";
            dispose();
        });

        add(cancelButton);
    }

    private void openPaymentDetailsDialog(String method) {
        JDialog detailsDialog = new JDialog(this, method + " Details", true);
        detailsDialog.setLayout(new GridLayout(3, 2));
        detailsDialog.setSize(350, 150);
        detailsDialog.setLocationRelativeTo(this);

        JLabel phoneLabel = new JLabel("Phone Number:");
        JTextField phoneField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            String phoneNumber = phoneField.getText();
            String password = new String(passwordField.getPassword());

            // Add validation logic for phone number and password here if needed

            detailsDialog.dispose();
            dispose();  // Close the payment method dialog after entering details
        });

        detailsDialog.add(phoneLabel);
        detailsDialog.add(phoneField);
        detailsDialog.add(passwordLabel);
        detailsDialog.add(passwordField);
        detailsDialog.add(new JLabel());  // Empty space
       detailsDialog.add(submitButton);

        detailsDialog.setVisible(true);
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
