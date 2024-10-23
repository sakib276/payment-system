package feathersandphotos;


import javax.swing.*;
import server.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.ExceptionListener;
import java.io.File;

public class Registration  extends JFrame implements ActionListener ,Verification  {
    private ImageIcon icon;
    private Container background;
    private JPanel panel,panel2;
    private JLabel n,n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,s1,ph,n11,n12,n13,n14,n15,n16,n17,n18;
    private JButton sub,can;
    private ImageIcon pht;
    private JTextField nameframe,meternum,age,id,mail,phn,dis,div,rel,address;
    private JPasswordField pas,copas;

    private JComboBox bg;
private JRadioButton male,female,other,m,um;
    ImageIcon icon1;
    public Registration()
    {
        try
        {
            File input= new File("E:/ELECTIC BILL PAYMEM/payment-system/img file/logo.png");
            icon = new ImageIcon(input.getAbsolutePath());
            setIconImage(icon.getImage());
        }catch (Exception e)
        {
            System.out.println(" ERROR IS IN  "+e.getMessage());
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle(" Registration ");
        setSize(1000,850);
        setLocationRelativeTo(null);
        setResizable(false);
        Background();

    }
    void Background()
    {
        background =getContentPane();
        background.setLayout(null);
        panel =new JPanel();
        panel.setBounds(0,0,990,130);
        panel.setBackground(Color.BLACK);
        panel.setLayout(new BorderLayout());




        try {

            File file = new File("E:/ELECTIC BILL PAYMEM/Electric bill generate system/src/feathersandphotos/reg-logo.jpeg");
            icon1 = new ImageIcon(file.getAbsolutePath());

            s1 = new JLabel(icon1);
            s1.setBounds(0, 0, icon1.getIconWidth(), icon1.getIconHeight());
            s1.setVerticalAlignment(SwingConstants.CENTER);
            s1.setHorizontalAlignment(SwingConstants.LEFT);


            panel.add(s1,BorderLayout.WEST);
        } catch (Exception e) {
            System.out.println("Error loading background image: " + e.getMessage());
        }


        n= new JLabel("Registration form".toUpperCase());
        Font f1= new Font("Thin 100",Font.BOLD,30);
        n.setSize(500,100);
        n.setForeground(Color.red);
        n.setFont(f1);
        n.setHorizontalAlignment(SwingConstants.CENTER);
        n.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(n,BorderLayout.CENTER);



        n1=new JLabel(" Name* ");
        try
        {
            System.out.println("test");

        }catch (Exception e)
        {
            System.out.println(" error is in "+e.getMessage());
        }

        Font ff= new Font("Arial ",Font.BOLD,20);
        Font f= new Font("Arial ",Font.PLAIN,18);
        n1.setFont(ff);
        n1.setBounds(55,150,200 ,16);
        n1.setForeground(new Color(12345));


        nameframe =new JTextField();
        nameframe.setBounds(55,175,291,31);
        nameframe.setFont(f);

        n2=new JLabel(" Meter No* ");
        Font fff= new Font("Arial",Font.BOLD,20);
        n2.setFont(fff);
        n2.setBounds(500,150,200,16);
        n2.setForeground(new Color(12345));

        meternum= new JTextField();
        meternum.setBounds(500,175,291,31);
        meternum.setFont(f);

        n3=new JLabel(" Date of Birth (yyyy-mm-dd) ");
        Font ffff= new Font(" Arial ",Font.BOLD,20);
        n3.setFont(ffff);
        n3.setBounds(55,213,300,16);
        n3.setForeground(new Color(12345));

        age= new JTextField();
        age.setBounds(55,238,291,31);
        age.setForeground(Color.BLACK);
        age.setFont(f);

        n4= new JLabel(" National Id Card Number* ");
        Font fffff= new Font("Arial",Font.BOLD,20);
        n4.setFont(fffff);
        n4.setBounds(500,213,300,16);
        n4.setForeground(Color.BLACK);

        id=new JTextField();
        id.setBounds(500,238,291,31);
        id.setForeground(Color.BLACK);


        n5= new JLabel(" E-Mail* ");
        n5.setFont(fffff);
        n5.setBounds(55,275,200,16);
        n5.setForeground(Color.BLACK);

        mail=new JTextField();
        mail.setBounds(55,300,291,31);
        mail.setForeground(Color.BLACK);
        mail.setFont(f);


        n6= new JLabel(" Phone Number* ");
        n6.setFont(fffff);
        n6.setBounds(500,275,200,16);
        n6.setForeground(Color.BLACK);

        phn=new JTextField();
        phn.setBounds(500,300,291,31);
        phn.setForeground(Color.BLACK);
        phn.setFont(f);

        n7= new JLabel(" District  ");
        n7.setFont(fffff);
        n7.setBounds(55,335,200,16);
        n7.setForeground(Color.BLACK);

        dis=new JTextField();
        dis.setBounds(55,360,291,31);
        dis.setForeground(Color.BLACK);
        dis.setFont(f);


        n8= new JLabel(" Division ");
        n8.setFont(fffff);
        n8.setBounds(500,335,200,16);
        n8.setForeground(Color.BLACK);

        div=new JTextField();
        div.setBounds(500,360,291,31);
        div.setForeground(Color.BLACK);
        div.setFont(f);



        n9= new JLabel(" Religion  ");
        n9.setFont(fffff);
        n9.setBounds(55,398,200,16);
        n9.setForeground(Color.BLACK);

        rel=new JTextField();
        rel.setBounds(55,425,291,31);
        rel.setForeground(Color.BLACK);
        rel.setFont(f);

        n10= new JLabel(" Blood Group");
        n10.setFont(fffff);
        n10.setBounds(55,467,200,16);
        n10.setForeground(Color.BLACK);

        String [] bloodgroup= {"A+","A-","B+","B-","O+","O-","AB+","AB-"};
        bg = new JComboBox(bloodgroup);
        bg.setBounds(55,490,200,30);
        bg.setSelectedIndex(0);




        n11= new JLabel(" Address*  ");
        n11.setFont(fffff);
        n11.setBounds(55,539,200,16);
        n11.setForeground(Color.BLACK);

        address=new JTextField();
        address.setBounds(55,571,291,65);
        address.setForeground(Color.BLACK);
        address.setFont(f);


        n12= new JLabel(" Gender  ");
        n12.setFont(fffff);
        n12.setBounds(500,404,200,16);
        n12.setForeground(Color.BLACK);


        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");


        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);


        male.setBounds(500, 427, 60, 20);
        female.setBounds(570, 427, 70, 20);
        other.setBounds(650, 427, 70, 20);


        n13= new JLabel(" Status  ");
        n13.setFont(fffff);
        n13.setBounds(500,455,200,16);
        n13.setForeground(Color.BLACK);

        m= new JRadioButton("Married ");
        um= new JRadioButton("Unmarried");

        ButtonGroup bt= new ButtonGroup();
        bt.add(m);
        bt.add(um);

        m.setBounds(500,474,73,20);
        um.setBounds(580,474,89,20);

        n14= new JLabel(" Password* ");
        n14.setFont(fffff);
        n14.setBounds(500,510,200,16);
        n14.setForeground(Color.BLACK);

        pas=new JPasswordField();
        pas.setBounds(500,535,291,31);
        pas.setForeground(Color.BLACK);
        pas.setFont(f);


        n15= new JLabel(" Confirm Password* ");
        n15.setFont(fffff);
        n15.setBounds(500,575,200,16);
        n15.setForeground(Color.black);

        copas=new JPasswordField();
        copas.setBounds(500,602,291,31);
        copas.setForeground(Color.BLACK);
        copas.setFont(f);


       n16= new JLabel(" You must fill in all the blanks marked with an asterisk(*) in this form ");
       Font fk= new Font(" Arial",Font.BOLD,14);
       n16.setFont(fk);
       n16.setBounds(444,680,550,15);
       n16.setForeground(Color.BLACK);
       background.add(n16);

       sub= new JButton("SIGN-UP");
       sub.setBounds(500,720,100,45);
       sub.setForeground(Color.BLACK);
       background.add(sub);
       sub.addActionListener(this);


       can= new JButton("Back");
       can.setBounds(650,720,100,45);
       can.setForeground(Color.BLACK);
       background.add(can);
       can.addActionListener(this);















        background.add(panel);
        background.add(n1);
        background.add(nameframe);
        background.add(n2);
        background.add(meternum);
        background.add(n3);
        background.add(age);
        background.add(n4);
        background.add(id);
        background.add(n5);
        background.add(mail);
        background.add(n6);
        background.add(phn);
        background.add(n7);
        background.add(dis);
        background.add(n8);
        background.add(div);
        background.add(n9);
        background.add(rel);
        background.add(n10);
        background.add(bg);
        background.add(n11);
        background.add(address);
        background.add( n12);
        background.add( male);
        background.add( female);
        background.add( other);
        background.add( n13);
        background.add( m);
        background.add( um);
        background.add( n14);
        background.add( pas);
        background.add( n15);
        background.add( copas);




    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sub) {

            String name = nameframe.getText();
            String meterNo = meternum.getText();
            String dob = age.getText();
            String nidNo = id.getText();
            String email = mail.getText();
            String phone = phn.getText();
            String district = dis.getText();
            String division = div.getText();
            String religion = rel.getText();
            String addressText = address.getText();
            String password = new String(pas.getPassword());
            String confirmPassword = new String(copas.getPassword());


            String gender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : "Other";
            String status = m.isSelected() ? "Married" : um.isSelected() ? "Unmarried" : "";


            boolean isValid = true;
            StringBuilder errorMessage = new StringBuilder("Please correct the following errors:\n");

            if (!Verification.namevf(name)) {
                isValid = false;
                errorMessage.append("Invalid name.\n");
            }
            if (!Verification.meternovf(meterNo)) {
                isValid = false;
                errorMessage.append("Invalid meter number.\n");
            }
            if (!Verification.dobvf(dob)) {
                isValid = false;
                errorMessage.append("Invalid date of birth. Use yyyy-MM-dd format.\n");
            }
            if (!Verification.nidnovf(nidNo)) {
                isValid = false;
                errorMessage.append("Invalid National ID number.\n");
            }
            if (!Verification.emailvf(email)) {
                isValid = false;
                errorMessage.append("Invalid email address.\n");
            }
            if (!Verification.meternovf(meterNo)) { // Assuming a similar check for phone number
                isValid = false;
                errorMessage.append("Invalid phone number.\n");
            }
            if (!Verification.addressvf(addressText)) {
                isValid = false;
                errorMessage.append("Invalid address.\n");
            }
            if (password.isEmpty() || confirmPassword.isEmpty() || !password.equals(confirmPassword) || !Verification.passwordvf(password)) {
                isValid = false;
                errorMessage.append("Password and confirm password must match and meet the requirements.\n");
            }

            if (isValid) {

                Datastore datastore = new Datastore();
                boolean isSaved = datastore.saveUser(name, meterNo, dob, nidNo, email, phone, district, division, religion, addressText, gender, status, password);

                if (isSaved) {


                    new login().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Error saving data. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {

                JOptionPane.showMessageDialog(this, errorMessage.toString(), "Validation Errors", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == can) {
            new login().setVisible(true);
            dispose();
        }
    }

}

