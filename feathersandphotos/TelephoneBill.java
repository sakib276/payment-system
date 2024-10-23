package feathersandphotos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelephoneBill extends JFrame implements ActionListener {
    private JTextField telephoneField;
    private JTextField amountField;
    private JComboBox<String> paymentMethodComboBox;
    private JRadioButton postpaidRadioButton;
    private JRadioButton prepaidRadioButton;
    private JButton payButton;
    private JButton cancelButton;

    public TelephoneBill() {
        setTitle("Telephone Bill Payment System");
        setSize(800, 500);
        setLocationRelativeTo(null);  // Center the window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set modern colors for the background and buttons
        Color backgroundColor = new Color(245, 245, 245);  // Light gray
        Color buttonColor = new Color(70, 130, 180);  // Steel blue for buttons
        Color hoverColor = new Color(100, 149, 237);  // Light steel blue on hover
        Color textColor = Color.WHITE;  // White text for buttons

        // Create main panel with GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(backgroundColor);  // Set background color
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Padding between components
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;

        // Telephone Number label and field
        JLabel telephoneLabel = new JLabel("Telephone Number:");
        telephoneLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy = 0;
        mainPanel.add(telephoneLabel, gbc);

        telephoneField = new JTextField(20);
        telephoneField.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        mainPanel.add(telephoneField, gbc);

        // Amount label and field
        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(amountLabel, gbc);

        amountField = new JTextField(20);
        amountField.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        mainPanel.add(amountField, gbc);

        // Payment Method label and dropdown
        JLabel paymentMethodLabel = new JLabel("Payment Method:");
        paymentMethodLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(paymentMethodLabel, gbc);

        String[] methods = {"Credit Card", "Bank Transfer", "Mobile Payment"};
        paymentMethodComboBox = new JComboBox<>(methods);
        paymentMethodComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        mainPanel.add(paymentMethodComboBox, gbc);

        // Account Type label and radio buttons
        JLabel accountTypeLabel = new JLabel("Account Type:");
        accountTypeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(accountTypeLabel, gbc);

        postpaidRadioButton = new JRadioButton("Postpaid");
        prepaidRadioButton = new JRadioButton("Prepaid");
        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(postpaidRadioButton);
        accountTypeGroup.add(prepaidRadioButton);

        JPanel accountTypePanel = new JPanel(new FlowLayout());
        accountTypePanel.setBackground(backgroundColor);
        accountTypePanel.add(postpaidRadioButton);
        accountTypePanel.add(prepaidRadioButton);
        gbc.gridx = 1;
        mainPanel.add(accountTypePanel, gbc);

        // Pay and Cancel buttons
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
            String telephoneNumber = telephoneField.getText();
            String amount = amountField.getText();
            String paymentMethod = (String) paymentMethodComboBox.getSelectedItem();
            String accountType = postpaidRadioButton.isSelected() ? "Postpaid" : "Prepaid";

            // Display payment details in a dialog
            JOptionPane.showMessageDialog(this, "Payment Processed:\nTelephone Number: " + telephoneNumber +
                    "\nAmount: " + amount + "\nPayment Method: " + paymentMethod + "\nAccount Type: " + accountType);
        } else if (e.getSource() == cancelButton) {
            dispose();  // Close the window
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelephoneBill().setVisible(true));
    }
}
