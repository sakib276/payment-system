package feathersandphotos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

public class GasBill extends JFrame {
    private ImageIcon icon;
    private Container background;
    private JLabel l1, l2;
    private JTextField f1, f2;
    private JButton submitButton, paymentButton;
    private JTable table;
    private DefaultTableModel tableModel;
    private String paymentMethod = "Not Selected";

    public GasBill() {
        try {
            File input = new File("E:/ELECTIC BILL PAYMEM/payment-system/img file/logo.png");
            icon = new ImageIcon(input.getAbsolutePath());
            setIconImage(icon.getImage());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Gas Bill");
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

        // Load and resize the gas image
        ImageIcon gasImage = new ImageIcon("E:/ELECTIC BILL PAYMEM/payment-system/img file/Gas.png");
        Image scaledImage = gasImage.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH); // Adjust size as needed
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));

        panel.add(imageLabel); // Add the image label to the panel

        l1 = new JLabel("Enter your meter number:");
        Font font = new Font("Arial", Font.BOLD, 16);
        l1.setFont(font);
        f1 = new JTextField();
        f1.setPreferredSize(new Dimension(200, 30));

        l2 = new JLabel("Enter your gas units consumed:");
        l2.setFont(font);
        f2 = new JTextField();
        f2.setPreferredSize(new Dimension(200, 30));

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
        String[] columnNames = {"Meter Number", "Gas Units Consumed", "Amount", "Payment Method"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        background.add(scrollPane, BorderLayout.CENTER);
    }

    private void addDataToTable() {
        String meterNumber = f1.getText();
        String gasUnits = f2.getText();

        // Simple calculation for the amount based on gas units consumed
        int units = Integer.parseInt(gasUnits);
        String amount = (units * 1.5) + " TK";

        tableModel.addRow(new Object[]{meterNumber, gasUnits, amount, paymentMethod});

        // Clear the text fields after submission
        f1.setText("");
        f2.setText("");
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
        try (FileWriter writer = new FileWriter("gas_bill_data.csv", true)) {
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
