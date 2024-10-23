package feathersandphotos;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import server.Datastore;

public class login extends JFrame implements ActionListener {

    private Container background;
    private ImageIcon icon, login;
    private JLabel s1,s2,s3;
    private JTextField f1;
    private JPasswordField p1;

    private JButton lb,rb;
   // private JPanel p1;

    public login() {
        try {
            //changed here
            File input = new File("E:/ELECTIC BILL PAYMEM/payment-system/img file/logo.png");
            icon = new ImageIcon(input.getAbsolutePath());
            setIconImage(icon.getImage());
        } catch (Exception e) {
            System.out.println("Error loading icon: " + e.getMessage());
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(500, 600);
        setTitle("BILL GENERATOR SYSTEM");
        setResizable(false);
        setLocationRelativeTo(null);


        Background();
    }

    void Background() {
        background = getContentPane();
        background.setLayout(null);
        background.setBackground(Color.white);

        try {
//updated that image path
            File file = new File("E:/ELECTIC BILL PAYMEM/payment-system/img file/login.jpg");
//            File file = new File("./login.jpg");

            login = new ImageIcon(file.getAbsolutePath());

            s1 = new JLabel(login);
            s1.setBounds(145, 20, login.getIconWidth(), login.getIconHeight());


            background.add(s1);
        } catch (Exception e) {
            System.out.println("Error loading background image: " + e.getMessage());
        }
            // panel
//        p1 =new JPanel();
//        p1.setBounds(0,login.getIconHeight()+10,500,600);
        s2= new JLabel("Email");
        try {
            Font f1= new Font("Thin 100",Font.BOLD,30);
            s2.setFont(f1);

        }catch(Exception e)
        {
            System.out.println("error front : "+e.getMessage());
        }
        s2.setBounds(200,login.getIconHeight()+50,250,50);
        s2.setForeground(new Color(12345));

        f1 = new JTextField();
        f1.setBounds(100,login.getIconHeight()+105,300,50);
        Font f2= new Font("Thin 100",Font.PLAIN,18);
        f1.setFont(f2);

        s3 = new JLabel("Password");
        s3.setBounds(170,login.getIconHeight()+160,300,50);
        Font g1= new Font("Thin 100",Font.BOLD,30);
        s3.setFont(g1);
        s3.setForeground(new Color(12345));

        p1 = new JPasswordField();
        p1.setBounds(100,login.getIconHeight()+205,300,50);
        Font f3= new Font("Thin 100",Font.PLAIN,18);
        p1.setFont(f3);

        lb = new JButton("Login ");
        lb.setBounds(200,login.getIconHeight()+270,120,50);
        lb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lb.setFocusPainted(false);
        lb.setBackground(Color.RED);
        lb.setForeground(Color.WHITE);
        lb.addActionListener(this);

        rb = new JButton(" Registration ");
        rb.setBounds(200,login.getIconHeight()+330,120,50);
        rb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        rb.setFocusPainted(false);
        rb.setBackground( Color.BLUE);
        rb.setForeground(Color.WHITE);
        rb.addActionListener(this);
        

        












// background
       background.add(s2);
       background.add(f1);
       background.add(s3);
       background.add(p1);
       background.add(lb);
       background.add(rb);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==lb)
        {
           // JOptionPane.showMessageDialog(null,"Not created yet !! ");
            String email = f1.getText();
            String password = new String(p1.getPassword());
            boolean isAuthenticated = Datastore.checkUserCredentials(email, password);

            if (isAuthenticated) {
                new home().setVisible(true);
                dispose();

                // Redirect to the next screen or functionality
            } else {
                JOptionPane.showMessageDialog(this, "Invalid email or password.");
            }


        }
        else if(e.getSource()==rb)
        {
            new Registration().setVisible(true);
            dispose();
        }
    }
}
