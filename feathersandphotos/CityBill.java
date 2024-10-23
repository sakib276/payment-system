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


    private void initializeComponents() {
        // Set up background container
        background = getContentPane();
        background.setLayout(new BorderLayout());
        background.setBackground(new Color(245, 245, 245));

        // Create header panel
        headerPanel = createHeaderPanel();
        background.add(headerPanel, BorderLayout.NORTH);

        // Create button panel
        buttonPanel = createButtonPanel();
        background.add(buttonPanel, BorderLayout.CENTER);

        // Create footer panel
        footerPanel = createFooterPanel();
        background.add(footerPanel, BorderLayout.SOUTH);
    }

    private JPanel createHeaderPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 144, 255));
        panel.setLayout(new BorderLayout());

        titleLabel = new JLabel("CITY CORPORATION BILL");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Load and display city corporation image
        ImageIcon cityImage = new ImageIcon("E:/ELECTIC BILL PAYMEM/payment-system/img file/citycorporatio.jpg");
        Image scaledCityImage = cityImage.getImage().getScaledInstance(800, 200, Image.SCALE_SMOOTH);
        imageLabel = new JLabel(new ImageIcon(scaledCityImage));
        imageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(imageLabel, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(240, 240, 240));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        propertyTaxButton = createStandardButton("Property Tax");
        trafficFineButton = createStandardButton("Traffic Fine");
        dustBillButton = createStandardButton("Dust Bill");
        telephoneButton = createStandardButton("Telephone");
        backButton = createStandardButton("Back");


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.insets = new Insets(10, 10, 10, 10);


        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(propertyTaxButton, gbc);

        gbc.gridy++;
        panel.add(trafficFineButton, gbc);

        gbc.gridy++;
        panel.add(dustBillButton, gbc);

        gbc.gridy++;
        panel.add(telephoneButton, gbc);

        gbc.gridy++;
        panel.add(backButton, gbc);

        return panel;
    }

    private JPanel createFooterPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 245, 245));
        panel.setLayout(new FlowLayout());

        JLabel footerLabel = new JLabel("© 2024 City Corporation. All rights reserved.");
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        footerLabel.setForeground(Color.GRAY);
        panel.add(footerLabel);

        return panel;
    }

    private JButton createStandardButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setForeground(new Color(30, 144, 255));
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.addActionListener(this); // Add action listener
        button.setBorder(BorderFactory.createLineBorder(new Color(30, 144, 255), 2));


        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(30, 144, 255));
                button.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.WHITE);
                button.setForeground(new Color(30, 144, 255));
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
        } else if (e.getSource() == backButton) {
            new home().setVisible(true);
            dispose();
        }
    }


}
