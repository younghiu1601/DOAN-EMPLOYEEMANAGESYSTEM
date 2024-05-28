/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doan_employeemanage;
import DatabaseConnection.Database_connection;
import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
/**
 *
 * @author congh
 */
public class AddEmployee extends JFrame implements ActionListener{

    
    JTextField tfid,tfname, tffname, tfaddress, tfphone, tfemail, tfsalary;
    JDateChooser dcdob;
    JComboBox position;
    JButton add, back;
    
    AddEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("THÊM NHÂN VIÊN");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        
        JLabel labelempId = new JLabel("ID");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        tfid = new JTextField();
        tfid.setBounds(200, 400, 150, 30);
        add(tfid);
        
        
        JLabel labelname = new JLabel("Tên");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        
        JLabel labelfname = new JLabel("Họ");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);
        
        
        JLabel labeldob = new JLabel("Ngày sinh");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);
        
        
        JLabel labelsalary = new JLabel("Lương");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        tfsalary = new JTextField(); 
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);
        
        
        JLabel labeladdress = new JLabel("Địa chỉ");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        
        JLabel labelphone = new JLabel("Số điện thoại");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        
        JLabel lableposition = new JLabel("Vị trí");
        lableposition.setBounds(400, 300, 150, 30);
        lableposition.setFont(new Font("serif", Font.PLAIN, 20));
        add(lableposition);
        
        String courses[] = {"HR", "IT", "Dev", "Marketing"};
        position = new JComboBox(courses);
        position.setBackground(Color.WHITE);
        position.setBounds(600, 300, 150, 30);
        add(position);
        
        
        add = new JButton("Thêm nhân viên");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Trở về");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
        setTitle("EMPLOYEE MANAGE SYSTEM");
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String Id = tfid.getText();
            String Name = tfname.getText();
            String Fname = tffname.getText();
            String DOB = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String Salary = tfsalary.getText();
            String Address = tfaddress.getText();
            String Phone = tfphone.getText();
            String Email = tfemail.getText();
            String Position = (String) position.getSelectedItem();
            
            
            try {
                Database_connection conn = new Database_connection();
                String query = "insert into employee values('"+Id+"', '"+Name+"', '"+Fname+"','"+DOB+"', '"+Salary+"', '"+Address+"', '"+Phone+"', '"+Email+"', '"+Position+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
