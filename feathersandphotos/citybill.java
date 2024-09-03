package feathersandphotos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public  class citybill extends JFrame implements ActionListener {
    private ImageIcon icon;
    private Container background;
    private JLabel label;
    private JPanel panel, bpanel;

    private JButton b1, b2, b3, b4;

    public citybill() {
        try {
            File input = new File("E:/ELECTIC BILL PAYMEM/Electric bill generate system/src/feathersandphotos/logo.png");
            icon = new ImageIcon(input.getAbsolutePath());
            setIconImage(icon.getImage());

        } catch (Exception e) {
            System.out.println(" ERROR IS IN  " + e.getMessage());
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle(" Home Page ");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        Background();
    }

    void Background() {
        background = getContentPane();
        background.setLayout(null);
        background.setBackground(new Color(666426294));

        panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new BorderLayout());
        panel.setBounds(0, 0, 800, 100);

        label = new JLabel("CITY CORPORATION BILL");
        label.setBounds(15, 10, 800, 60);
        label.setForeground(Color.BLACK);
        Font font = new Font("Arial ", Font.BOLD, 25);
        label.setFont(font);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);

            bpanel = new JPanel();
            bpanel.setBounds(0, 101, 800, 50);
          bpanel.setLayout(new FlowLayout());
            bpanel.setBackground(Color.white);

        b1 = new JButton(" ELECTRICITY BILL ");
        b1.setBackground(Color.white);
        b1.setFocusPainted(false);
        b1.setFocusable(true);
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b1.setBorderPainted(false);
        b1.addActionListener(this);

        b2 = new JButton(" GAS BILL ");
        b2.setBackground(Color.white);
        b2.setFocusPainted(false);
        b2.setFocusable(true);
        b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b2.setBorderPainted(false);
        b2.addActionListener(this);

        b3 = new JButton(" WATER BILL ");
        b3.setBackground(Color.white);
        b3.setFocusPainted(false);
        b3.setFocusable(true);
        b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b3.setBorderPainted(false);
        b3.addActionListener(this);

        b4 = new JButton(" WIFI BILL ");
        b4.setBackground(Color.white);
        b4.setFocusPainted(false);
        b4.setFocusable(true);
        b4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b4.setBorderPainted(false);
        b4.addActionListener(this);

        bpanel.add(b1);
        bpanel.add(b2);
        bpanel.add(b3);
        bpanel.add(b4);

        background.add(panel);
        background.add(bpanel);
    }


     @Override
     public void actionPerformed(ActionEvent e) {
         if (e.getSource() == b1) {
             new ElectricityBill().setVisible(true);
             dispose();
         } else if (e.getSource() == b2) {
             new GasBill().setVisible(true);
             dispose();
         } else if (e.getSource() == b3) {
             new WaterBill().setVisible(true);  // Connect to WaterBill
             dispose();
         } else if (e.getSource() == b4) {
             new WifiBill().setVisible(true);  // Connect to WifiBill
             dispose();
         }
     }
    public static void main(String[] args) {
        new citybill().setVisible(true);
    }


}
