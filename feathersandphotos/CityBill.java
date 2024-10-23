package feathersandphotos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class CityBill extends JFrame implements ActionListener {
    private ImageIcon icon;
    private Container background;
    private JLabel titleLabel, imageLabel;
    private JPanel headerPanel, buttonPanel, footerPanel;

    private JButton propertyTaxButton, trafficFineButton, dustBillButton, telephoneButton, backButton;

    public CityBill() {
        setTitle("City Bill");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        setIconImage(loadIcon());

        // Initialize layout
        initializeComponents();
    }

    private Image loadIcon() {
        try {
            File input = new File("E:/ELECTIC BILL PAYMEM/payment-system/img file/logo.png");
            icon = new ImageIcon(input.getAbsolutePath());
            return icon.getImage();
        } catch (Exception e) {
            System.out.println("ERROR IS IN: " + e.getMessage());
            return null; // Return null if icon loading fails
        }
    }

    //just checking whether the fork works or not
    private void initializeComponents() {
        // Set up background container
        background = getContentPane();
        background.setLayout(new BorderLayout());
        background.setBackground(new Color(245, 245, 245)); // Light gray background for contrast

        // Create header panel
        headerPanel = createHeaderPanel();
        background.add(headerPanel, BorderLayout.NORTH);

        // Create button panel
        buttonPanel = createButtonPanel();
        background.add(buttonPanel, BorderLayout.CENTER); // Center the button panel

        // Create footer panel
        footerPanel = createFooterPanel();
        background.add(footerPanel, BorderLayout.SOUTH); // Add footer at the bottom
    }

    private JPanel createHeaderPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 144, 255)); // Soft blue background
        panel.setLayout(new BorderLayout());

        titleLabel = new JLabel("CITY CORPORATION BILL");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36)); // Increase font size for better visibility
        titleLabel.setForeground(Color.WHITE); // White text color for contrast
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Add vertical padding

        // Load and display city corporation image
        ImageIcon cityImage = new ImageIcon("E:/ELECTIC BILL PAYMEM/payment-system/img file/citycorporatio.jpg");
        Image scaledCityImage = cityImage.getImage().getScaledInstance(800, 200, Image.SCALE_SMOOTH);
        imageLabel = new JLabel(new ImageIcon(scaledCityImage));
        imageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some padding

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(imageLabel, BorderLayout.CENTER); // Add the image to the header panel

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // Use GridBagLayout to center the buttons
        panel.setBackground(new Color(240, 240, 240)); // Light gray background for button panel
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding around the panel

        // Create buttons with standardized styling
        propertyTaxButton = createStandardButton("Property Tax");
        trafficFineButton = createStandardButton("Traffic Fine");
        dustBillButton = createStandardButton("Dust Bill");
        telephoneButton = createStandardButton("Telephone");
        backButton = createStandardButton("Back"); // Create back button

        // Create a GridBagConstraints instance for centering
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Make buttons stretch horizontally
        gbc.weightx = 1; // Allow buttons to grow horizontally
        gbc.insets = new Insets(10, 10, 10, 10); // Padding around buttons

        // Add buttons to the panel
        gbc.gridx = 0; // Column 0
        gbc.gridy = 0; // Row 0
        panel.add(propertyTaxButton, gbc);

        gbc.gridy++;
        panel.add(trafficFineButton, gbc);

        gbc.gridy++;
        panel.add(dustBillButton, gbc);

        gbc.gridy++;
        panel.add(telephoneButton, gbc);

        gbc.gridy++;
        panel.add(backButton, gbc); // Add back button

        return panel;
    }

    private JPanel createFooterPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 245, 245)); // Light gray background
        panel.setLayout(new FlowLayout());

        JLabel footerLabel = new JLabel("© 2024 City Corporation. All rights reserved.");
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        footerLabel.setForeground(Color.GRAY);
        panel.add(footerLabel);

        return panel;
    }

    private JButton createStandardButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.WHITE); // White background for buttons
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setForeground(new Color(30, 144, 255)); // Soft blue text for buttons
        button.setFont(new Font("Arial", Font.BOLD, 18)); // Button text size
        button.addActionListener(this); // Add action listener
        button.setBorder(BorderFactory.createLineBorder(new Color(30, 144, 255), 2)); // Soft blue border

        // Add mouse listeners for hover effects
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(30, 144, 255)); // Change to soft blue on hover
                button.setForeground(Color.WHITE); // Change text color on hover
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.WHITE); // Reset to original background
                button.setForeground(new Color(30, 144, 255)); // Reset text color
            }
        });

        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == propertyTaxButton) {
            new PropertyTaxBill().setVisible(true);
            dispose(); // Close the current window
        } else if (e.getSource() == trafficFineButton) {
            new TrafficFineBill().setVisible(true);
            dispose(); // Close the current window
        } else if (e.getSource() == dustBillButton) {
            new DustBill().setVisible(true);
            dispose(); // Close the current window
        } else if (e.getSource() == telephoneButton) {
            new TelephoneBill().setVisible(true);
            dispose(); // Close the current window
        } else if (e.getSource() == backButton) { // Handle back button click
            new home().setVisible(true); // Ensure the Home class is named correctly
            dispose(); // Close the current window
        }
    }


}
