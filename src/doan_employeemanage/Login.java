/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doan_employeemanage;
import DatabaseConnection.Database_connection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author congh
 */
public class Login extends JFrame implements ActionListener{
    
    JTextField textusername;
    JPasswordField textpassword;
    
    Login() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Tên đăng nhập");
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);
        
        textusername = new JTextField();
        textusername.setBounds(150, 20, 150, 30);
        add(textusername);
        
        JLabel lblpassword = new JLabel("Mật khẩu");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);

        textpassword = new JPasswordField();
        textpassword.setEchoChar('*'); 
        textpassword.setBounds(150,70, 150, 30);
        add(textpassword);
        
        JButton login = new JButton("ĐĂNG NHẬP");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
        setTitle("EMPLOYEE MANAGE SYSTEM");
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            String username = textusername.getText();
            String password = textpassword.getText();
            
            Database_connection c = new Database_connection();
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
