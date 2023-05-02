package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//  The javax package is an extension of Java

//  Inheritance
public class Login extends JFrame implements ActionListener{
    // Constructor
    // 
    JButton login,signUp,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
//  By default, it uses the border layout. Using --> Custom layout.
        setLayout(null);
        
     // ImageIcon class object
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        
     // Image class object used for scaling
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
                
        ImageIcon i3 = new ImageIcon(i2);
// Need to place the label on the frame, so Label.
// Can pass an image icon to the JLabel, but can't directly give image.

//        JLabel label = new JLabel(i1);

       JLabel label = new JLabel(i3);
// Need to set the position of the label, so use the setBounds() method using " label." only 
       label.setBounds(70,10,100,100);
// It will remain same as the default layout is Border Layout, change setLayout(null) --> Custom Layout       
        add(label);
        
// Adding contents to the frame.
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel cardNo = new JLabel("Card No : ");
        cardNo.setFont(new Font("Raleway",Font.BOLD,28));
        cardNo.setBounds(120,150,150,30);
        add(cardNo);
         
        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
         
        JLabel pin = new JLabel("PIN : ");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,150,40);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        signUp = new JButton("SIGN UP");
        signUp.setBounds(300,350,230,30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.white);
        signUp.addActionListener(this);
        add(signUp);
        
        getContentPane().setBackground(Color.WHITE);           
        
// Setting the size of the frame
        setSize(800,480); 
// By Default frame opens at Top Left       
        setLocation(200,200);
// Setting the frame visible, by deafult it is hidden for users.
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == login){
                Conn connectDB = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
//            DDL Command
            String query = "select * from login where cardnumber ='"+cardNumber+"' and pin = '"+pinNumber+"'";        
            try{
//                resultSet is an object present in java.sql --> package.
                ResultSet rs = connectDB.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                } else{
                    JOptionPane.showMessageDialog(null,"Card Number & Password Do Not Match");
                }
            }catch(Exception exce){
                System.out.println(exce);                                
            }
        
        }else if(e.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(e.getSource() == signUp){
                setVisible(false);
//            object of sign up class
               new SignUpOne().setVisible(true);
        }
    }
    public static void main(String args[]) {
//   Object of Class
        new Login();
//   After creating object, it calls the constructor --> code written in constructor.        
    }
}


