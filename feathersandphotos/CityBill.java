package feathersandphotos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class CityBill extends JFrame implements ActionListener {
    private ImageIcon icon;
    private Container background;
    private JLabel label;
    private JPanel headerPanel, buttonPanel;

    private JButton propertyTaxButton, trafficFineButton, dustBillButton, telephoneButton;

    public CityBill() {
        setTitle("City Bill");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set window icon
        setIconImage(loadIcon());

        // Initialize layout
        initializeComponents();
    }

    private Image loadIcon() {
        try {
            File input = new File("E:/ELECTIC BILL PAYMEM/Electric bill generate system/src/feathersandphotos/logo.png");
            icon = new ImageIcon(input.getAbsolutePath());
            return icon.getImage();
        } catch (Exception e) {
            System.out.println("ERROR IS IN: " + e.getMessage());
            return null; // Return null if icon loading fails
        }
    }

    private void initializeComponents() {
        // Set up background container
        background = getContentPane();
        background.setLayout(new BorderLayout());
        background.setBackground(new Color(255, 165, 0)); // Set background to orange

        // Create header panel
        headerPanel = createHeaderPanel();
        background.add(headerPanel, BorderLayout.NORTH);

        // Create button panel and add vertical glue to center it
        buttonPanel = createButtonPanel();
        background.add(buttonPanel, BorderLayout.CENTER);
    }

    private JPanel createHeaderPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 140, 0)); // Darker shade of orange
        panel.setLayout(new BorderLayout());

        label = new JLabel("CITY CORPORATION BILL");
        label.setFont(new Font("Arial", Font.BOLD, 40)); // Increase font size for better visibility
        label.setForeground(Color.WHITE); // White text color for contrast
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Add vertical padding
        panel.add(label, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Use BoxLayout to arrange buttons vertically
        panel.setBackground(Color.WHITE); // Button panel background white

        // Create buttons with standardized styling
        propertyTaxButton = createStandardButton("Property Tax");
        trafficFineButton = createStandardButton("Traffic Fine");
        dustBillButton = createStandardButton("Dust Bill");
        telephoneButton = createStandardButton("Telephone");

        // Center align buttons
        propertyTaxButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        trafficFineButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        dustBillButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        telephoneButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add vertical glue above and below the button panel to center it
        panel.add(Box.createVerticalGlue());
        panel.add(propertyTaxButton);
        panel.add(Box.createVerticalStrut(20)); // Add space between buttons
        panel.add(trafficFineButton);
        panel.add(Box.createVerticalStrut(20)); // Add space between buttons
        panel.add(dustBillButton);
        panel.add(Box.createVerticalStrut(20)); // Add space between buttons
        panel.add(telephoneButton);
        panel.add(Box.createVerticalGlue()); // Add vertical glue below

        return panel;
    }

    private JButton createStandardButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(255, 204, 0)); // Light orange for buttons
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(300, 50)); // Set a standard size for all buttons
        button.setForeground(Color.BLACK); // Black text for buttons
        button.setFont(new Font("Arial", Font.BOLD, 24)); // Button text size
        button.addActionListener(this); // Add action listener
        button.setMargin(new Insets(5, 5, 5, 5)); // Add padding to buttons
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == propertyTaxButton) {
            new PropertyTaxBill().setVisible(true);
        } else if (e.getSource() == trafficFineButton) {
            new TrafficFineBill().setVisible(true);
        } else if (e.getSource() == dustBillButton) {
            new DustBill().setVisible(true);
        } else if (e.getSource() == telephoneButton) {
            new TelephoneBill().setVisible(true);
        }
        dispose(); // Close the current window
    }


}
