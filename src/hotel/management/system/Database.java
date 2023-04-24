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
/**
 *
 * @author Sanidhya
 */
public class Database extends JFrame implements ActionListener {
     JTable table;
    JButton back;
    
    Database(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel l1 = new JLabel("ID");
        l1.setBounds(50,10,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Name");
        l2.setBounds(260,10,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(470,10,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Checkin Time");
        l4.setBounds(630,10,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Checkout Time");
        l5.setBounds(830,10,100,20);
        add(l5);
        
        table = new JTable();
        table.setBounds(0,40,1000,400);
        add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs =c.s.executeQuery("select * from database1");
       
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(420,500,120,30);
        back.addActionListener(this);
        add(back);
        
        setBounds(300,200,1000,600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
    
public static void main(String[] args){
    new Database();
}

}

