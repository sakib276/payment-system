package feathersandphotos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class home extends JFrame implements ActionListener {
    private ImageIcon icon;
    private Container background;
    private JLabel label;
    private JPanel panel, bpanel, imagePanel;

    private JButton b1, b2, b3, b4, b5, exitButton; // Added exitButton

    public home() {
        // Set the application icon
        try {
            File input = new File("E:/ELECTIC BILL PAYMEM/payment-system/img file/logo.png");
            icon = new ImageIcon(input.getAbsolutePath());
            setIconImage(icon.getImage());
        } catch (Exception e) {
            System.out.println("ERROR IS IN " + e.getMessage());
        }

        // Set JFrame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Home Page");
        setSize(800, 600);
        setLocationRelativeTo(null); // Center window on screen
        setResizable(false);

        // Call method to set up background and layout
        Background();
    }

    void Background() {
        background = getContentPane();
        background.setLayout(new BorderLayout());
        background.setBackground(new Color(255, 255, 255)); // White background

        // Panel for the header
        panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(800, 100));

        // Label for the header
        label = new JLabel("WELCOME TO BILL PAYMENT SYSTEM");
        label.setForeground(Color.BLACK);
        Font font = new Font("Arial", Font.BOLD, 25);
        label.setFont(font);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);

        // Image panel for the picture
        imagePanel = new JPanel();
        imagePanel.setBackground(Color.WHITE);
        imagePanel.setLayout(new BorderLayout());

        // Load and scale the image
        ImageIcon homeImage = new ImageIcon("E:/ELECTIC BILL PAYMEM/payment-system/img file/home1.png");
        Image img = homeImage.getImage(); // Get the image
        Image scaledImage = img.getScaledInstance(400, 300, Image.SCALE_SMOOTH); // Scale image to 400x300
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage)); // Create label with scaled image
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        // Panel for buttons
        bpanel = new JPanel();
        bpanel.setPreferredSize(new Dimension(800, 50));
        bpanel.setLayout(new FlowLayout());
        bpanel.setBackground(Color.WHITE);

        // Electricity Bill button
        b1 = new JButton("ELECTRICITY BILL");
        b1.setBackground(Color.RED);
        b1.setForeground(Color.WHITE);
        customizeButton(b1);

        // Gas Bill button
        b2 = new JButton("GAS BILL");
        b2.setBackground(Color.GREEN);
        b2.setForeground(Color.WHITE);
        customizeButton(b2);

        // Water Bill button
        b3 = new JButton("WATER BILL");
        b3.setBackground(Color.BLUE);
        b3.setForeground(Color.WHITE);
        customizeButton(b3);

        // Wifi Bill button
        b4 = new JButton("WIFI BILL");
        b4.setBackground(Color.ORANGE);
        b4.setForeground(Color.WHITE);
        customizeButton(b4);

        // City Corporation button
        b5 = new JButton("CITY CORPORATION");
        b5.setBackground(new Color(128, 0, 128)); // Custom purple
        b5.setForeground(Color.WHITE);
        customizeButton(b5);

        // Exit button (Gray background, white text)
        exitButton = new JButton("EXIT");
        exitButton.setBackground(Color.GRAY);
        exitButton.setForeground(Color.WHITE);
        customizeButton(exitButton);

        // Add buttons to the panel
        bpanel.add(b1);
        bpanel.add(b2);
        bpanel.add(b3);
        bpanel.add(b4);
        bpanel.add(b5);
        bpanel.add(exitButton); // Add the exit button

        // Add components to the background
        background.add(panel, BorderLayout.NORTH);
        background.add(imagePanel, BorderLayout.CENTER); // Center the image
        background.add(bpanel, BorderLayout.SOUTH); // Place buttons at the bottom
    }

    // Helper method to customize button properties
    private void customizeButton(JButton button) {
        button.setFocusPainted(false);
        button.setFocusable(true);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBorderPainted(false);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            new ElectricityBill().setVisible(true); // Open ElectricityBill frame
            dispose();
        } else if (e.getSource() == b2) {
            new GasBill().setVisible(true); // Open GasBill frame
            dispose();
        } else if (e.getSource() == b3) {
            new WaterBill().setVisible(true); // Open WaterBill frame
            dispose();
        } else if (e.getSource() == b4) {
            new WifiBill().setVisible(true); // Open WifiBill frame
            dispose();
        } else if (e.getSource() == b5) {
            new CityBill().setVisible(true); // Open CityBill frame
            dispose();
        } else if (e.getSource() == exitButton) {
            System.exit(0); // Exit the application
        }
    }
}
