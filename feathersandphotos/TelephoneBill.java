package feathersandphotos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelephoneBill extends JFrame implements ActionListener {
    private JTextField telephoneField, amountField;
    private JComboBox<String> paymentMethodComboBox;
    private JRadioButton postpaidRadioButton, prepaidRadioButton;
    private JButton payButton, cancelButton;

    public TelephoneBill() {
        setTitle("Telephone Bill Payment System");
        setSize(800, 500);  // Set the window size to 800x500
        setLocationRelativeTo(null);  // Center the window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set a standard layout with padding and alignment
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Padding between components
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Make components fill horizontally
        gbc.gridx = 0;  // Start from the first column

        // Telephone Number label and field
        JLabel telephoneLabel = new JLabel("Telephone Number:");
        gbc.gridy = 0;  // First row
        mainPanel.add(telephoneLabel, gbc);

        telephoneField = new JTextField(20);  // Set a standard width for input
        gbc.gridx = 1;  // Move to the second column
        mainPanel.add(telephoneField, gbc);

        // Amount label and field
        JLabel amountLabel = new JLabel("Amount:");
        gbc.gridx = 0;
        gbc.gridy = 1;  // Move to the second row
        mainPanel.add(amountLabel, gbc);

        amountField = new JTextField(20);
        gbc.gridx = 1;
        mainPanel.add(amountField, gbc);

        // Payment Method label and dropdown
        JLabel paymentMethodLabel = new JLabel("Payment Method:");
        gbc.gridx = 0;
        gbc.gridy = 2;  // Move to the third row
        mainPanel.add(paymentMethodLabel, gbc);

        String[] methods = {"Credit Card", "Bank Transfer", "Mobile Payment"};
        paymentMethodComboBox = new JComboBox<>(methods);
        gbc.gridx = 1;
        mainPanel.add(paymentMethodComboBox, gbc);

        // Account Type label and radio buttons
        JLabel accountTypeLabel = new JLabel("Account Type:");
        gbc.gridx = 0;
        gbc.gridy = 3;  // Move to the fourth row
        mainPanel.add(accountTypeLabel, gbc);

        // Create radio buttons for Postpaid and Prepaid
        postpaidRadioButton = new JRadioButton("Postpaid");
        prepaidRadioButton = new JRadioButton("Prepaid");
        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(postpaidRadioButton);
        accountTypeGroup.add(prepaidRadioButton);

        JPanel radioPanel = new JPanel(new FlowLayout());
        radioPanel.add(postpaidRadioButton);
        radioPanel.add(prepaidRadioButton);

        gbc.gridx = 1;
        mainPanel.add(radioPanel, gbc);

        // Pay and Cancel buttons
        payButton = new JButton("Pay");
        cancelButton = new JButton("Cancel");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));  // Button layout
        buttonPanel.add(payButton);
        buttonPanel.add(cancelButton);

        // Add action listeners
        payButton.addActionListener(this);
        cancelButton.addActionListener(this);

        // Adding everything to the frame
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == payButton) {
            String telephoneNumber = telephoneField.getText();
            String amount = amountField.getText();
            String paymentMethod = (String) paymentMethodComboBox.getSelectedItem();
            String accountType = postpaidRadioButton.isSelected() ? "Postpaid" : "Prepaid";

            // In a real application, here you'd validate and process the payment
            JOptionPane.showMessageDialog(this, "Payment Processed:\nTelephone Number: " + telephoneNumber +
                    "\nAmount: " + amount + "\nPayment Method: " + paymentMethod +
                    "\nAccount Type: " + accountType);
        } else if (e.getSource() == cancelButton) {
            dispose();  // Close the window
        }
    }

}
