package feathersandphotos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DustBill extends JFrame implements ActionListener {

    private JComboBox<String> divisionComboBox;
    private JComboBox<String> areaComboBox;
    private JTextField houseNumberField, holdingNumberField, amountField;
    private JComboBox<String> paymentMethodComboBox;
    private JButton payButton, cancelButton;

    private String[][] areas = {
            {"Dhaka", "Kishoregonj", "Manikgonj", "Narshingdi", "Narayngonj"},
            {"Chittagong", "Cox's Bazar", "Bandharban", "Khaghrachori", "Feni", "Brammanbaria"},
            {"Khulna", "Jessore", "Satkhira", "Bagherhat"},
            {"Rajshahi", "Bogura", "Naogaon", "Natore"},
            {"Barisal", "Patuakhali", "Bhola", "Borguna"},
            {"Sylhet", "Moulvibazar", "Habiganj", "Sunamgonj"},
            {"Rangpur", "Dinajpur", "Thakurgaon", "Panchagarh"},
            {"Mymensingh", "Jamalpur", "Netrokona"}
    };

    public DustBill() {
        setTitle("Dust Bill Payment");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Use a modern, soft color scheme
        Color backgroundColor = new Color(240, 248, 255); // Soft blue
        Color buttonColor = new Color(60, 179, 113); // Soft green for buttons

        // Set a standard layout with padding and alignment
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(backgroundColor);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;

        // Division label and combo box
        JLabel divisionLabel = new JLabel("Division:");
        divisionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridy = 0;
        mainPanel.add(divisionLabel, gbc);

        String[] divisions = {"Dhaka", "Chittagong", "Khulna", "Rajshahi", "Barisal", "Sylhet", "Rangpur", "Mymensingh"};
        divisionComboBox = new JComboBox<>(divisions);
        divisionComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        divisionComboBox.addActionListener(this);
        gbc.gridx = 1;
        mainPanel.add(divisionComboBox, gbc);

        // Area label and combo box
        JLabel areaLabel = new JLabel("Area:");
        areaLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(areaLabel, gbc);

        areaComboBox = new JComboBox<>();
        areaComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        updateAreaComboBox(0);
        gbc.gridx = 1;
        mainPanel.add(areaComboBox, gbc);

        // House Number label and field
        JLabel houseNumberLabel = new JLabel("House Number:");
        houseNumberLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(houseNumberLabel, gbc);

        houseNumberField = new JTextField(20);
        houseNumberField.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        mainPanel.add(houseNumberField, gbc);

        // Holding Number label and field
        JLabel holdingNumberLabel = new JLabel("Holding Number:");
        holdingNumberLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(holdingNumberLabel, gbc);

        holdingNumberField = new JTextField(20);
        holdingNumberField.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        mainPanel.add(holdingNumberField, gbc);

        // Amount label and field
        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(amountLabel, gbc);

        amountField = new JTextField(20);
        amountField.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        mainPanel.add(amountField, gbc);

        // Payment Method label and combo box
        JLabel paymentMethodLabel = new JLabel("Payment Method:");
        paymentMethodLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(paymentMethodLabel, gbc);

        String[] methods = {"Credit Card", "Bank Transfer", "Cash"};
        paymentMethodComboBox = new JComboBox<>(methods);
        paymentMethodComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        mainPanel.add(paymentMethodComboBox, gbc);

        // Pay and Cancel buttons with custom styles
        payButton = new JButton("Pay");
        payButton.setBackground(buttonColor);
        payButton.setForeground(Color.WHITE);
        payButton.setFont(new Font("Arial", Font.BOLD, 16));
        payButton.setFocusPainted(false);

        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.RED);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Arial", Font.BOLD, 16));
        cancelButton.setFocusPainted(false);

        // Button panel for alignment
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(backgroundColor);
        buttonPanel.add(payButton);
        buttonPanel.add(cancelButton);

        // Add action listeners
        payButton.addActionListener(this);
        cancelButton.addActionListener(this);

        // Adding components to the frame
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    private void updateAreaComboBox(int divisionIndex) {
        areaComboBox.removeAllItems();
        for (String area : areas[divisionIndex]) {
            areaComboBox.addItem(area);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == divisionComboBox) {
            int selectedIndex = divisionComboBox.getSelectedIndex();
            updateAreaComboBox(selectedIndex);
        } else if (e.getSource() == payButton) {
            String area = (String) areaComboBox.getSelectedItem();
            String houseNumber = houseNumberField.getText();
            String holdingNumber = holdingNumberField.getText();
            String amount = amountField.getText();
            String paymentMethod = (String) paymentMethodComboBox.getSelectedItem();

            JOptionPane.showMessageDialog(this, "Payment Processed:\nArea: " + area +
                    "\nHouse Number: " + houseNumber +
                    "\nHolding Number: " + holdingNumber +
                    "\nAmount: " + amount +
                    "\nPayment Method: " + paymentMethod);
        } else if (e.getSource() == cancelButton) {
            new CityBill().setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DustBill().setVisible(true));
    }
}
