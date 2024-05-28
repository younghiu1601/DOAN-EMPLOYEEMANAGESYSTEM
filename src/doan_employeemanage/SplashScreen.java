/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doan_employeemanage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author congh
 */
public class SplashScreen extends JFrame implements ActionListener {

     SplashScreen() {
        
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80, 30, 1200, 60);
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.black);
        add(heading);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);
        
        
        JButton clickhere = new JButton("WELCOME!");
        clickhere.setBounds(400, 400, 300, 70);
        clickhere.addActionListener(this);
        image.add(clickhere);
        
        setTitle("EMPLOYEE MANAGE SYSTEM");
        setSize(1170, 650);
        setLocation(200,50);
        setVisible(true);
        

    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }
    
    public static void main(String args[]) {
        new SplashScreen();
    }
}
    
