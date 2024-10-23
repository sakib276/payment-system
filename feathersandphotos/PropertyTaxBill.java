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
        setSize(800, 500);
        setLocationRelativeTo(null);  // Center the window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set a modern, soft color scheme
        Color backgroundColor = new Color(245, 245, 245);  // Light gray background
        Color buttonColor = new Color(70, 130, 180);  // Steel blue color for buttons
        Color buttonHoverColor = new Color(100, 149, 237);  // Light steel blue on hover

        // Set a layout with padding and alignment
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(backgroundColor);  // Set background color
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);  // Padding between components
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;

        // Property ID label and field
        JLabel propertyIdLabel = new JLabel("Property ID:");
        propertyIdLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy = 0;  // First row
        mainPanel.add(propertyIdLabel, gbc);

        propertyIdField = new JTextField(20);
        propertyIdField.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        mainPanel.add(propertyIdField, gbc);

        // Amount label and field
        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 1;  // Second row
        mainPanel.add(amountLabel, gbc);

        amountField = new JTextField(20);
        amountField.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        mainPanel.add(amountField, gbc);

        // Payment Method label and dropdown
        JLabel paymentMethodLabel = new JLabel("Payment Method:");
        paymentMethodLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 2;  // Third row
        mainPanel.add(paymentMethodLabel, gbc);

        String[] methods = {"Credit Card", "Bank Transfer", "Cash"};
        paymentMethodComboBox = new JComboBox<>(methods);
        paymentMethodComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        mainPanel.add(paymentMethodComboBox, gbc);

        // Pay and Cancel buttons with custom styles
        payButton = new JButton("Pay");
        styleButton(payButton, buttonColor, buttonHoverColor, Color.WHITE);

        cancelButton = new JButton("Back");
        styleButton(cancelButton, Color.RED, new Color(255, 69, 69), Color.WHITE);

        // Button panel for alignment
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(backgroundColor);
        buttonPanel.add(payButton);
        buttonPanel.add(cancelButton);

        // Add action listeners
        payButton.addActionListener(this);
        cancelButton.addActionListener(this);

        // Add components to the frame
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    // Method to style buttons with custom colors and fonts
    private void styleButton(JButton button, Color backgroundColor, Color hoverColor, Color textColor) {
        button.setBackground(backgroundColor);
        button.setForeground(textColor);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setOpaque(true);

        // Button hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(hoverColor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(backgroundColor);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == payButton) {
            String propertyId = propertyIdField.getText();
            String amount = amountField.getText();
            String paymentMethod = (String) paymentMethodComboBox.getSelectedItem();

            JOptionPane.showMessageDialog(this, "Payment Processed:\nProperty ID: " + propertyId +
                    "\nAmount: " + amount + "\nPayment Method: " + paymentMethod);
        } else if (e.getSource() == cancelButton) {
            new CityBill().setVisible(true);
            dispose();  // Close the window
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PropertyTaxBill().setVisible(true));
    }
}
