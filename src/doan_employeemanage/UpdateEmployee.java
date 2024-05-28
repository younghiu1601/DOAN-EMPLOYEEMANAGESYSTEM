/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doan_employeemanage;

import DatabaseConnection.Database_connection;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfsalary;
    JLabel lblId;
    JButton add, back;
    String Id;
    JComboBox tfposition;
    JDateChooser dcdob;
    
    UpdateEmployee(String Id) {
        this.Id = Id;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("CẬP NHẬT THÔNG TIN");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        
        
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
        tfposition = new JComboBox(courses);
        tfposition.setBackground(Color.WHITE);
        tfposition.setBounds(600, 300, 150, 30);
        add(tfposition);
        
        
        
        JLabel labelempId = new JLabel("Id:");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        lblId = new JLabel();
        lblId.setBounds(200, 400, 150, 30);
        lblId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblId);
        
        
        
        try {
            Database_connection c = new Database_connection();
            String query = "select * from employee where Id = '"+Id+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                tfname.setText(rs.getString("Name"));
                tffname.setText(rs.getString("Fname"));
                String format = "MMM d, yyyy";

                SimpleDateFormat sdf = new SimpleDateFormat(format);
                java.util.Date date = sdf.parse(rs.getString("DOB"));
                System.out.println(rs.getString("DOB"));
                dcdob.setDate(date);
                
                tfaddress.setText(rs.getString("Address"));
                tfsalary.setText(rs.getString("Salary"));
                tfphone.setText(rs.getString("Phone"));
                tfemail.setText(rs.getString("Email"));
                lblId.setText(rs.getString("Id"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        add = new JButton("CẬP NHẬT");
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
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String position = (String) tfposition.getSelectedItem();
            
            try {
                Database_connection conn = new Database_connection();
                String query = "update employee set Name = '"+name+"', Fname = '"+fname+"', DOB = '"+dob+"', Salary = '"+salary+"', Address = '"+address+"', Phone = '"+phone+"', Email =  '"+email+"', Position = '"+position+"' where Id = '"+Id+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new ViewEmployee();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new ViewEmployee();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
