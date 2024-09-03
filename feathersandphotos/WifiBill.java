package feathersandphotos;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class WifiBill extends JFrame {
    private JLabel l1, l2;
    private ArrayList<JCheckBox> wifiCheckboxes;
    private JComboBox<String> speedComboBox;
    private JComboBox<String> monthComboBox;
    private JButton submitButton, paymentButton, addWiFiButton;
    private JTable table;
    private DefaultTableModel tableModel;
    private String paymentMethod = "Not Selected";
    private JPanel wifiPanel;

    public WifiBill() {

        try {
            File input = new File("E:/ELECTIC BILL PAYMEM/Electric bill generate system/src/feathersandphotos/logo.png");
            ImageIcon icon = new ImageIcon(input.getAbsolutePath());
            setIconImage(icon.getImage());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("WiFi Bill");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setResizable(false);

        wifiCheckboxes = new ArrayList<>();
        initBackground();
        initTable();
    }

    private void initBackground() {
        Container background = getContentPane();
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 800));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 6, 14));

        l1 = new JLabel("Select your WiFi:");
        Font font = new Font("Arial", Font.BOLD, 16);
        l1.setFont(font);

        wifiPanel = new JPanel();
        wifiPanel.setLayout(new BoxLayout(wifiPanel, BoxLayout.Y_AXIS));
        addWiFiOption("SKY-NET WIFI");
        addWiFiOption("NEEF WIFI");
        addWiFiOption("CCN WIFI");

        addWiFiButton = new JButton("Add WiFi Name");
        addWiFiButton.setPreferredSize(new Dimension(200, 30));
        addWiFiButton.addActionListener(e -> addNewWiFiOption());

        l2 = new JLabel("Select your speed (Mbps):");
        l2.setFont(font);

        String[] speeds = {"5", "10", "20", "35"};
        speedComboBox = new JComboBox<>(speeds);

        JLabel l3 = new JLabel("Select the month:");
        l3.setFont(font);

        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        monthComboBox = new JComboBox<>(months);

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
        panel.add(wifiPanel);
        panel.add(addWiFiButton);
        panel.add(l2);
        panel.add(speedComboBox);
        panel.add(l3);
        panel.add(monthComboBox);
        panel.add(paymentButton);
        panel.add(submitButton);
        panel.add(BACK);

        background.add(panel, BorderLayout.WEST);
    }

    private void initTable() {
        String[] columnNames = {"WiFi Name", "Speed (Mbps)", "Month", "Amount", "Payment Method"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void addWiFiOption(String wifiName) {
        JCheckBox wifiCheckbox = new JCheckBox(wifiName);
        wifiCheckboxes.add(wifiCheckbox);
        wifiPanel.add(wifiCheckbox);
        wifiPanel.revalidate();
        wifiPanel.repaint();
    }

    private void addNewWiFiOption() {
        String newWifiName = JOptionPane.showInputDialog(this, "Enter new WiFi name:");
        if (newWifiName != null && !newWifiName.trim().isEmpty()) {
            addWiFiOption(newWifiName.trim());
        }
    }

    private void addDataToTable() {
        String wifiName = getSelectedWiFiName();
        String speedMbps = (String) speedComboBox.getSelectedItem();
        String month = (String) monthComboBox.getSelectedItem();

        if (wifiName == null) {
            JOptionPane.showMessageDialog(this, "Please select a WiFi name.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int mbps = Integer.parseInt(speedMbps);
        String amount = (mbps * 100) + " TK";

        tableModel.addRow(new Object[]{wifiName, speedMbps, month, amount, paymentMethod});

        resetSelections();
    }

    private String getSelectedWiFiName() {
        for (JCheckBox checkbox : wifiCheckboxes) {
            if (checkbox.isSelected()) {
                return checkbox.getText();
            }
        }
        return null;
    }

    private void resetSelections() {
        for (JCheckBox checkbox : wifiCheckboxes) {
            checkbox.setSelected(false);
        }
        speedComboBox.setSelectedIndex(0);
        monthComboBox.setSelectedIndex(0);
        paymentMethod = "Not Selected";
    }

    private void choosePaymentMethod() {
        payment paymentDialog = new payment(this);
        paymentDialog.setVisible(true);

        // After the payment dialog is closed, update the payment method and add the data to the table
        paymentMethod = paymentDialog.getPaymentMethod();
        if (!paymentMethod.equals("Not Selected")) {
            addDataToTable();
        }
    }

    private void saveDataToCSV() {
        try (FileWriter writer = new FileWriter("wifi_bill_data.csv", true)) {
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
