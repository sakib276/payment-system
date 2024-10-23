package feathersandphotos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WaterBill extends JFrame {

    private ImageIcon icon;
    private Container background;
    private JLabel l1, l2, l3, imageLabel; // Added imageLabel for the image
    private JTextField f1;
    private JComboBox<String> monthComboBox, amountComboBox;
    private JButton submitButton, paymentButton;
    private JTable table;
    private DefaultTableModel tableModel;
    private String paymentMethod = "Not Selected";

    public WaterBill() {
        try {
            File input = new File("E:/ELECTIC BILL PAYMEM/payment-system/img file/logo.png");
            icon = new ImageIcon(input.getAbsolutePath());
            setIconImage(icon.getImage());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Water Bill");
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

        // Load and display the water image
        ImageIcon waterImage = new ImageIcon("E:/ELECTIC BILL PAYMEM/payment-system/img file/water.jpeg");
        Image scaledWaterImage = waterImage.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        imageLabel = new JLabel(new ImageIcon(scaledWaterImage));

        // Add imageLabel to the panel
        panel.add(imageLabel);

        l1 = new JLabel("Enter your house number:");
        Font font = new Font("Arial", Font.BOLD, 16);
        l1.setFont(font);
        f1 = new JTextField();
        f1.setPreferredSize(new Dimension(200, 30));

        l2 = new JLabel("Select the month:");
        l2.setFont(font);
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        monthComboBox = new JComboBox<>(months);
        monthComboBox.setPreferredSize(new Dimension(200, 30));

        l3 = new JLabel("Select the amount:");
        l3.setFont(font);
        String[] amounts = {"500 TK", "1000 TK", "1500 TK", "2000 TK"};
        amountComboBox = new JComboBox<>(amounts);
        amountComboBox.setPreferredSize(new Dimension(200, 30));

        submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(200, 30));
        submitButton.addActionListener(e -> {
            addDataToTable();
            saveDataToCSV();
        });

        paymentButton = new JButton("Payment Method");
        paymentButton.setPreferredSize(new Dimension(200, 30));
        paymentButton.addActionListener(e -> choosePaymentMethod());

        JButton BACK = new JButton("BACK");
        BACK.setPreferredSize(new Dimension(200, 30));
        BACK.addActionListener(e -> {
            new home().setVisible(true);
            dispose();
        });

        panel.add(l1);
        panel.add(f1);
        panel.add(l2);
        panel.add(monthComboBox);
        panel.add(l3);
        panel.add(amountComboBox);
        panel.add(paymentButton);
        panel.add(submitButton);
        panel.add(BACK);

        background.add(panel, BorderLayout.WEST);
    }

    private void initTable() {
        String[] columnNames = {"House Number", "Month", "Amount", "Payment Method"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        background.add(scrollPane, BorderLayout.CENTER);
    }

    private void addDataToTable() {
        String houseNumber = f1.getText();
        String month = monthComboBox.getSelectedItem().toString();
        String amount = amountComboBox.getSelectedItem().toString();

        tableModel.addRow(new Object[]{houseNumber, month, amount, paymentMethod});

        // Clear the input fields after submission
        f1.setText("");
        amountComboBox.setSelectedIndex(0);
        paymentMethod = "Not Selected";  // Reset payment method after submission
    }

    private void choosePaymentMethod() {
        String[] options = {"Credit Card", "Debit Card", "Net Banking", "UPI"};
        paymentMethod = (String) JOptionPane.showInputDialog(
                this,
                "Choose Payment Method",
                "Payment Method",
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );

        if (paymentMethod == null) {
            paymentMethod = "Not Selected";
        }
    }

    private void saveDataToCSV() {
        try (FileWriter writer = new FileWriter("water_bill_data.csv", true)) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    writer.append(tableModel.getValueAt(i, j).toString());
                    if (j < tableModel.getColumnCount() - 1) {
                        writer.append(',');
                    }
                }
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
