/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    Choice typeofcar;
    JCheckBox viewAll;
    
    Pickup(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Pickup Service");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel lblbed = new JLabel("Type Of Car");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);
        
        typeofcar = new Choice();
        typeofcar.setBounds(150,100,200,25);
        add(typeofcar);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()){
                typeofcar.add(rs.getString("model"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(30,160,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(200,160,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(330,160,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Company");
        l4.setBounds(460,160,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Model");
        l5.setBounds(630,160,100,20);
        add(l5);
        
         JLabel l6 = new JLabel("Availability");
        l6.setBounds(740,160,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Location");
        l7.setBounds(890,160,100,20);
        add(l7);
        
        viewAll = new JCheckBox("View All Drivers");
        viewAll.setBounds(450,100,150,25);
        viewAll.setBackground(Color.WHITE);
        add(viewAll);
        
        
        table = new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs =c.s.executeQuery("select * from driver");
       
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(300,520,120,30);
        submit.addActionListener(this);
        add(submit);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(500,520,120,30);
        back.addActionListener(this);
        add(back);
        
        setBounds(300,200,1000,600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }else if (ae.getSource()==submit){
            try{
                String query1 = "select * from driver where model = '"+typeofcar.getSelectedItem()+"'";
                String query3 = "select * from driver";
                
                Conn c = new Conn();
                ResultSet rs;
                if(viewAll.isSelected()){
                    rs = c.s.executeQuery(query3);}
                else{
                    rs = c.s.executeQuery(query1);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        new Pickup();
    }
}
