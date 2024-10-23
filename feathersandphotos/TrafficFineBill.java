package feathersandphotos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TrafficFineBill extends JFrame implements ActionListener {
    private JTextField licensePlateField;
    private JTextField amountField;
    private JComboBox<String> paymentMethodComboBox;
    private JTextArea violationDescriptionArea;
    private JButton payButton;
    private JButton cancelButton;

    public TrafficFineBill() {
        setTitle("Traffic Fine Bill Payment");
        setSize(800, 500);
        setLocationRelativeTo(null);  // Center the window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Define colors and styles
        Color backgroundColor = new Color(245, 245, 245);
        Color buttonColor = new Color(70, 130, 180);
        Color hoverColor = new Color(100, 149, 237);
        Color textColor = Color.WHITE;

        // Create main panel with GridBagLayout for layout control
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(backgroundColor);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // License Plate Label and Field
        JLabel licensePlateLabel = new JLabel("License Plate:");
        licensePlateLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(licensePlateLabel, gbc);

        licensePlateField = new JTextField(20);
        licensePlateField.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        mainPanel.add(licensePlateField, gbc);

        // Amount Label and Field
        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(amountLabel, gbc);

        amountField = new JTextField(20);
        amountField.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        mainPanel.add(amountField, gbc);

        // Violation Description Label and TextArea
        JLabel violationDescriptionLabel = new JLabel("Description of Violation:");
        violationDescriptionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(violationDescriptionLabel, gbc);

        violationDescriptionArea = new JTextArea(5, 20);
        violationDescriptionArea.setLineWrap(true);
        violationDescriptionArea.setWrapStyleWord(true);
        violationDescriptionArea.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(violationDescriptionArea);
        gbc.gridx = 1;
        mainPanel.add(scrollPane, gbc);

        // Payment Method Label and ComboBox
        JLabel paymentMethodLabel = new JLabel("Payment Method:");
        paymentMethodLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(paymentMethodLabel, gbc);

        String[] paymentMethods = {"Credit Card", "Bank Transfer", "Cash"};
        paymentMethodComboBox = new JComboBox<>(paymentMethods);
        paymentMethodComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        mainPanel.add(paymentMethodComboBox, gbc);

        // Pay and Cancel Buttons
        payButton = new JButton("Pay");
        cancelButton = new JButton("Cancel");

        styleButton(payButton, buttonColor, hoverColor, textColor);
        styleButton(cancelButton, Color.RED, new Color(255, 69, 69), textColor);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(backgroundColor);
        buttonPanel.add(payButton);
        buttonPanel.add(cancelButton);

        // Add action listeners
        payButton.addActionListener(this);
        cancelButton.addActionListener(this);

        // Add panels to the frame
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

        // Add hover effect
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
            String licensePlate = licensePlateField.getText().trim();
            String amount = amountField.getText().trim();
            String paymentMethod = (String) paymentMethodComboBox.getSelectedItem();
            String violationDescription = violationDescriptionArea.getText().trim();

            // Input validation
            if (licensePlate.isEmpty() || amount.isEmpty() || violationDescription.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Display payment details
            JOptionPane.showMessageDialog(this, "Payment Processed:\nLicense Plate: " + licensePlate +
                    "\nAmount: " + amount + "\nDescription: " + violationDescription + "\nPayment Method: " + paymentMethod);
        } else if (e.getSource() == cancelButton) {
            new CityBill().setVisible(true);
            dispose();  // Close the window
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TrafficFineBill().setVisible(true));
    }
}
