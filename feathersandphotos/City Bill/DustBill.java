package feathersandphotos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DustBill extends JFrame implements ActionListener {

    private JComboBox<String> divisionComboBox;  // ComboBox for divisions
    private JComboBox<String> areaComboBox;      // ComboBox for areas
    private JTextField houseNumberField, holdingNumberField, amountField;
    private JComboBox<String> paymentMethodComboBox;
    private JButton payButton, cancelButton;

    // Area lists corresponding to each division
    private String[][] areas = {
            {"Dhanmondi", "Gulshan", "Bashundhara"},  // Dhaka
            {"Chittagong", "Cox's Bazar", "Fatikchhari"},  // Chittagong
            {"Khulna", "Jessore", "Satkhira"},  // Khulna
            {"Rajshahi", "Bogura", "Naogaon"},  // Rajshahi
            {"Barisal", "Patuakhali", "Bhola"},  // Barisal
            {"Sylhet", "Moulvibazar", "Habiganj"},  // Sylhet
            {"Rangpur", "Dinajpur", "Thakurgaon"},  // Rangpur
            {"Mymensingh", "Jamalkandi", "Gafargaon"}  // Mymensingh
    };

    public DustBill() {
        setTitle("Dust Bill Payment");
        setSize(800, 500);  // Set the window size to 800x500
        setLocationRelativeTo(null);  // Center the window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set a standard layout with padding and alignment
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Padding between components
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Make components fill horizontally
        gbc.gridx = 0;  // Start from the first column

        // Division label and combo box
        JLabel divisionLabel = new JLabel("Division:");
        gbc.gridy = 0;  // First row
        gbc.gridwidth = 1;
        mainPanel.add(divisionLabel, gbc);

        String[] divisions = {"Dhaka", "Chittagong", "Khulna", "Rajshahi", "Barisal", "Sylhet", "Rangpur", "Mymensingh"};
        divisionComboBox = new JComboBox<>(divisions);  // Combo box for divisions
        divisionComboBox.addActionListener(this);  // Add action listener for division selection
        gbc.gridx = 1;  // Move to the second column
        mainPanel.add(divisionComboBox, gbc);

        // Area label and combo box
        JLabel areaLabel = new JLabel("Area:");
        gbc.gridx = 0;
        gbc.gridy = 1;  // Second row
        mainPanel.add(areaLabel, gbc);

        areaComboBox = new JComboBox<>();  // Combo box for areas
        updateAreaComboBox(0);  // Initialize with the first division's areas
        gbc.gridx = 1;
        mainPanel.add(areaComboBox, gbc);

        // House Number label and field
        JLabel houseNumberLabel = new JLabel("House Number:");
        gbc.gridx = 0;
        gbc.gridy = 2;  // Third row
        mainPanel.add(houseNumberLabel, gbc);

        houseNumberField = new JTextField(20);
        gbc.gridx = 1;
        mainPanel.add(houseNumberField, gbc);

        // Holding Number label and field
        JLabel holdingNumberLabel = new JLabel("Holding Number:");
        gbc.gridx = 0;
        gbc.gridy = 3;  // Fourth row
        mainPanel.add(holdingNumberLabel, gbc);

        holdingNumberField = new JTextField(20);
        gbc.gridx = 1;
        mainPanel.add(holdingNumberField, gbc);

        // Amount label and field
        JLabel amountLabel = new JLabel("Amount:");
        gbc.gridx = 0;
        gbc.gridy = 4;  // Fifth row
        mainPanel.add(amountLabel, gbc);

        amountField = new JTextField(20);
        gbc.gridx = 1;
        mainPanel.add(amountField, gbc);

        // Payment Method label and dropdown
        JLabel paymentMethodLabel = new JLabel("Payment Method:");
        gbc.gridx = 0;
        gbc.gridy = 5;  // Sixth row
        mainPanel.add(paymentMethodLabel, gbc);

        String[] methods = {"Credit Card", "Bank Transfer", "Cash"};
        paymentMethodComboBox = new JComboBox<>(methods);
        gbc.gridx = 1;
        mainPanel.add(paymentMethodComboBox, gbc);

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

    // Method to update the area combo box based on the selected division
    private void updateAreaComboBox(int divisionIndex) {
        areaComboBox.removeAllItems();  // Clear existing items
        for (String area : areas[divisionIndex]) {
            areaComboBox.addItem(area);  // Add new areas based on division
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == divisionComboBox) {
            // Get the index of the selected division and update the area combo box
            int selectedIndex = divisionComboBox.getSelectedIndex();
            updateAreaComboBox(selectedIndex);
        } else if (e.getSource() == payButton) {
            String area = (String) areaComboBox.getSelectedItem();  // Get selected area
            String houseNumber = houseNumberField.getText();
            String holdingNumber = holdingNumberField.getText();
            String amount = amountField.getText();
            String paymentMethod = (String) paymentMethodComboBox.getSelectedItem();

            // In a real application, here you'd validate and process the payment
            JOptionPane.showMessageDialog(this, "Payment Processed:\nArea: " + area +
                    "\nHouse Number: " + houseNumber +
                    "\nHolding Number: " + holdingNumber +
                    "\nAmount: " + amount +
                    "\nPayment Method: " + paymentMethod);
        } else if (e.getSource() == cancelButton) {
            new CityBill().setVisible(true);
            dispose();  // Close the window
        }
    }


}
