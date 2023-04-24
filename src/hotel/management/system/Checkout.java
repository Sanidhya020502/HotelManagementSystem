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
import java.util.Date;

public class Checkout extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JLabel lblcheckouttime,cname,cgender;
    JTextField tfroomnumber,tfcheckintime;
    JButton checkout,back,update;
    
    
    Checkout(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Checkout");
        text.setBounds(100,20,130,30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma",Font.BOLD,25));
        add(text);
        
        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30,80,100,30);
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(150,80,150,25);
        add(ccustomer);
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel tick = new JLabel(i3);
        tick.setBounds(310,80,20,20);
        add(tick);
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);
        
        cname = new JLabel("    ");
        add(cname);
        
        cgender = new JLabel("");
        add(cgender);
        
        tfroomnumber = new JTextField();
        tfroomnumber.setBounds(150,130,100,30);
        add(tfroomnumber);
        
        JLabel lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(30,180,100,30);
        add(lblcheckin);
        
        tfcheckintime = new JTextField();
        tfcheckintime.setBounds(145,180,165,30);
        add(tfcheckintime);
        
        JLabel lblcheckout = new JLabel("Checkout Time");
        lblcheckout.setBounds(30,230,100,30);
        add(lblcheckout);
        
        Date date = new Date();
        lblcheckouttime = new JLabel(date+"");
        lblcheckouttime.setBounds(150,230,160,30);
        add(lblcheckouttime);
        
        update = new JButton("Check");
        update.setBounds(30,280,120,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        checkout = new JButton("Checkout");
        checkout.setBounds(95,330,120,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);
        
        back = new JButton("Back");
        back.setBounds(170,280,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
       
         try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
               
            }
        }catch(Exception e){
            e.printStackTrace();
        }
         
          try{
                Conn c = new Conn();
                
                String id = ccustomer.getSelectedItem();
                 ResultSet rs = c.s.executeQuery("select * from customer where number = '"+id+"'");
                while(rs.next()){
                    cname.setText(rs.getString("name"));
                }
                
                String id2 = ccustomer.getSelectedItem();
                ResultSet rs2 = c.s.executeQuery("select * from customer where number = '"+id2+"' ");
                while(rs2.next()){
                    cgender.setText(rs2.getString("gender"));
                }
          }catch(Exception e){
              e.printStackTrace();
          }
                
             
         
    
        
         
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/checkout.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(350,50,400,250);
        add(image);
        
        
        
        setBounds(330,200,800,430);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== checkout){
            String query1 = "delete from customer where number = '"+ccustomer.getSelectedItem()+"' ";
            String query2 = "update room set availability = 'Available' where roomnumber = '"+tfroomnumber.getText()+"'";
            
            String query4 = "insert into database1 values('"+ccustomer.getSelectedItem()+"','"+cname.getText()+"','"+cgender.getText()+"','"+tfcheckintime.getText()+"','"+lblcheckouttime.getText()+"')";
            
            
         
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query4);
                
               
                
                
                JOptionPane.showMessageDialog(null,"Checkout Done");
                setVisible(false);
                new Reception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if (ae.getSource()==update){
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfroomnumber.setText(rs.getString("room"));
                }
                
                ResultSet rs2 = c.s.executeQuery("select * from customer where room = '"+tfroomnumber.getText()+"'");
                while(rs2.next()){
                    tfcheckintime.setText(rs2.getString("checkintime"));
                    
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new Checkout();
    }
    
}
