package feathersandphotos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

public class ElectricityBill extends JFrame {
    private ImageIcon icon;
    private Container background;
    private JLabel l1, l2;
    private JTextField f1, f2;
    private JButton submitButton, paymentButton, BACK;
    private JTable table;
    private DefaultTableModel tableModel;
    private String paymentMethod = "Not Selected";

    public ElectricityBill() {
        try {
            File input = new File("E:/ELECTIC BILL PAYMEM/Electric bill generate system/src/feathersandphotos/logo.png");
            icon = new ImageIcon(input.getAbsolutePath());
            setIconImage(icon.getImage());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Electricity Bill");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setResizable(false);

        initBackground();
        initTable();
    }

    private void initBackground() {
        background = getContentPane();

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 800));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 6, 14));

        l1 = new JLabel("Enter your meter number:");
        Font font = new Font("Arial", Font.BOLD, 16);
        l1.setFont(font);
        f1 = new JTextField();
        f1.setPreferredSize(new Dimension(200, 30));

        l2 = new JLabel("Enter your unit number:");
        l2.setFont(font);
        f2 = new JTextField();
        f2.setPreferredSize(new Dimension(200, 30));

        submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(200, 30));
        submitButton.addActionListener(e -> {
            addDataToTable();

        });

        paymentButton = new JButton("Payment Method");
        paymentButton.setPreferredSize(new Dimension(200, 30));
        paymentButton.addActionListener(e -> choosePaymentMethod());
        BACK = new JButton("BACK");
        BACK.setPreferredSize(new Dimension(200, 30));
        BACK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new home().setVisible(true);
                dispose();
            }
        });

        panel.add(l1);
        panel.add(f1);
        panel.add(l2);
        panel.add(f2);
        panel.add(paymentButton);
        panel.add(submitButton);
        panel.add(BACK);

        background.add(panel, BorderLayout.WEST);
    }

    private void initTable() {
        String[] columnNames = {"Meter Number", "Unit Number", "Amount", "Payment Method"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        background.add(scrollPane, BorderLayout.CENTER);
    }

    private void addDataToTable() {
        String meterNumber = f1.getText();
        String unitNumber = f2.getText();

        // Simple calculation for the amount based on unit number
        int units = Integer.parseInt(unitNumber);
        String amount = (units * 10) + " TK";  // Example: $0.5 per unit

        tableModel.addRow(new Object[]{meterNumber, unitNumber, amount, paymentMethod});

        // Clear the text fields after submission
        f1.setText("");
        f2.setText("");
        paymentMethod = "Not Selected";  // Reset payment method after submission
    }

    private void choosePaymentMethod() {
        JDialog dialog = new JDialog(this, "Payment Method", true);
        dialog.setLayout(new GridLayout(0, 1));
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(this);

        String[] options = {"Credit Card", "Debit Card", "Bkash", "Rocket", "UPI"};

        for (String option : options) {
            JButton button = new JButton(option);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    paymentMethod = option;
                    dialog.dispose();

                        openPaymentDetailsDialog(option);

                }
            });
            dialog.add(button);
        }

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paymentMethod = "Not Selected";
                dialog.dispose();
            }
        });

        dialog.add(cancelButton);
        dialog.setVisible(true);
    }

    private void openPaymentDetailsDialog(String method) {
        JDialog detailsDialog = new JDialog(this, method + " Details", true);
        detailsDialog.setLayout(new GridLayout(3, 2));
        detailsDialog.setSize(350, 150);
        detailsDialog.setLocationRelativeTo(this);

        JLabel phoneLabel = new JLabel("Phone Number:");
        JTextField phoneField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    detailsDialog.dispose();


            }
        });

        detailsDialog.add(phoneLabel);
        detailsDialog.add(phoneField);
        detailsDialog.add(passwordLabel);
        detailsDialog.add(passwordField);
        detailsDialog.add(new JLabel());  // Empty space
        detailsDialog.add(submitButton);

        detailsDialog.setVisible(true);
    }
}
