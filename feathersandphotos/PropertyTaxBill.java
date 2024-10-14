package feathersandphotos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PropertyTaxBill extends JFrame implements ActionListener {

    private JTextField propertyIdField, amountField;
    private JComboBox<String> paymentMethodComboBox;
    private JButton payButton, cancelButton;

    public PropertyTaxBill() {
        setTitle("Property Tax Bill");
        setSize(800, 500);  // Set the window size to 800x500
        setLocationRelativeTo(null);  // Center the window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set a standard layout with padding and alignment
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Padding between components
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Make components fill horizontally
        gbc.gridx = 0;  // Start from the first column

        // Property ID label and field
        JLabel propertyIdLabel = new JLabel("Property ID:");
        gbc.gridy = 0;  // First row
        gbc.gridwidth = 1;
        mainPanel.add(propertyIdLabel, gbc);

        propertyIdField = new JTextField(20);  // Set a standard width for input
        gbc.gridx = 1;  // Move to the second column
        mainPanel.add(propertyIdField, gbc);

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

        String[] methods = {"Credit Card", "Bank Transfer", "Cash"};
        paymentMethodComboBox = new JComboBox<>(methods);
        gbc.gridx = 1;
        mainPanel.add(paymentMethodComboBox, gbc);

        // Pay and Cancel buttons
        payButton = new JButton("Pay");
        cancelButton = new JButton("Back");

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
            String propertyId = propertyIdField.getText();
            String amount = amountField.getText();
            String paymentMethod = (String) paymentMethodComboBox.getSelectedItem();

            // In a real application, here you'd validate and process the payment
            JOptionPane.showMessageDialog(this, "Payment Processed:\nProperty ID: " + propertyId +
                    "\nAmount: " + amount + "\nPayment Method: " + paymentMethod);
        } else if (e.getSource() == cancelButton) {
            new CityBill().setVisible(true);
            dispose();  // Close the window
        }
    }
}
