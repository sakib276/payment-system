
package feathersandphotos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficFineBill extends JFrame implements ActionListener {

    private JTextField licensePlateField, amountField;
    private JComboBox<String> paymentMethodComboBox;
    private JTextArea violationDescriptionArea;
    private JButton payButton, cancelButton;

    public TrafficFineBill() {
        setTitle("Traffic Fine Bill");
        setSize(800, 500);  // Set the window size to 800x500
        setLocationRelativeTo(null);  // Center the window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set a standard layout with padding and alignment
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Padding between components
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Make components fill horizontally
        gbc.gridx = 0;  // Start from the first column

        // License Plate label and field
        JLabel licensePlateLabel = new JLabel("License Plate:");
        gbc.gridy = 0;  // First row
        gbc.gridwidth = 1;
        mainPanel.add(licensePlateLabel, gbc);

        licensePlateField = new JTextField(20);  // Set a standard width for input
        gbc.gridx = 1;  // Move to the second column
        mainPanel.add(licensePlateField, gbc);

        // Amount label and field
        JLabel amountLabel = new JLabel("Amount:");
        gbc.gridx = 0;
        gbc.gridy = 1;  // Move to the second row
        mainPanel.add(amountLabel, gbc);

        amountField = new JTextField(20);
        gbc.gridx = 1;
        mainPanel.add(amountField, gbc);

        // Description of Violation label and text area
        JLabel violationDescriptionLabel = new JLabel("Description of Violation:");
        gbc.gridx = 0;
        gbc.gridy = 2;  // Move to the third row
        mainPanel.add(violationDescriptionLabel, gbc);

        violationDescriptionArea = new JTextArea(5, 20);  // 5 rows, 20 columns
        violationDescriptionArea.setLineWrap(true);
        violationDescriptionArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(violationDescriptionArea);
        gbc.gridx = 1;
        mainPanel.add(scrollPane, gbc);

        // Payment Method label and dropdown
        JLabel paymentMethodLabel = new JLabel("Payment Method:");
        gbc.gridx = 0;
        gbc.gridy = 3;  // Move to the fourth row
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == payButton) {
            String licensePlate = licensePlateField.getText().trim();
            String amount = amountField.getText().trim();
            String paymentMethod = (String) paymentMethodComboBox.getSelectedItem();
            String violationDescription = violationDescriptionArea.getText().trim();

            // Validate input
            if (licensePlate.isEmpty() || amount.isEmpty() || violationDescription.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // In a real application, here you'd validate and process the payment
            JOptionPane.showMessageDialog(this, "Payment Processed:\nLicense Plate: " + licensePlate +
                    "\nAmount: " + amount +
                    "\nDescription: " + violationDescription +
                    "\nPayment Method: " + paymentMethod);
        } else if (e.getSource() == cancelButton) {
            new CityBill().setVisible(true);
            dispose();  // Close the window
        }
    }


}
