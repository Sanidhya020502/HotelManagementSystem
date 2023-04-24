/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener{
    
    JComboBox comboid;
    JTextField tfnumber,tfname,tfcountry,tfdeposit;
    JRadioButton rbmale,rbfemale;
    Choice croom;
    JLabel checkintime;
    JButton add, back;
    
    AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //heading
        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Raleway", Font.PLAIN,20));
        add(text);
        
        //Id
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(35,80,100,20);
        lblid.setFont(new Font("Raleway", Font.PLAIN,20));
        add(lblid);
        
        String options[] = {"Aadhar Card","Driving License","Voter Id Card","Passport"};
        comboid = new JComboBox(options);
        comboid.setBackground(Color.WHITE);
        comboid.setBounds(200,80,150,25);
        add(comboid);
        
        //number
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(35,120,100,20);
        lblnumber.setFont(new Font("Raleway", Font.PLAIN,20));
        add(lblnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);
        
        //name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(35,160,100,20);
        lblname.setFont(new Font("Raleway", Font.PLAIN,20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);
        
         //gender
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(35,200,100,20);
        lblgender.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblgender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200,200,60,25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(270,200,100,20);       
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup();  //for deselecting the other option
        bg.add(rbmale);
        bg.add(rbfemale);
        
        //country
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(35,240,100,25);
        lblcountry.setFont(new Font("Raleway", Font.PLAIN,20));
        add(lblcountry);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);
        
        //room
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(35,280,150,25);
        lblroom.setFont(new Font("Raleway", Font.PLAIN,20));
        add(lblroom);
        
         croom = new Choice();
         try{
             Conn c = new Conn();
             String query = "select * from room where availability = 'Available'";
             //if the query return something we have to store in resultset
             ResultSet rs = c.s.executeQuery(query); 
             while(rs.next()){
                 croom.add(rs.getString("roomnumber"));
             }
             
         }catch(Exception e ){
             e.printStackTrace();
         }
         croom.setBounds(200,280,150,25);
         add(croom);
        
        
         //checkin time
        JLabel lbltime = new JLabel("Checkin time");
        lbltime.setBounds(35,320,150,25);
        lbltime.setFont(new Font("Raleway", Font.PLAIN,20));
        add(lbltime);
        
        Date date = new Date();
        
        checkintime = new JLabel(" "+date);
        checkintime.setBounds(180,320,230,25);
        checkintime.setFont(new Font("Raleway", Font.PLAIN,16));
        add(checkintime);
        
        //deposit
        JLabel lbldeposit = new JLabel("Deposit");
        lbldeposit.setBounds(35,360,150,25);
        lbldeposit.setFont(new Font("Raleway", Font.PLAIN,20));
        add(lbldeposit);
        
        tfdeposit = new JTextField();
        tfdeposit.setBounds(200,360,150,25);
        add(tfdeposit);
        
        //buttons
        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50,410,120,30);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,410,120,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/customer.png"));
        Image i2 = i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,50,400,400);
        add(image);
        
        
        
        
        setBounds(350,200,800,550);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String id = (String)comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;
            if(rbmale.isSelected()){
                gender = "Male";
            }else{
                gender = "Female";
            }
            
            String country = tfcountry.getText();
            String room = croom.getSelectedItem(); //no tyoecasting for choice class
            String time = checkintime.getText();
            String deposit = tfdeposit.getText();
            
            try{
                String query = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String query2 = "update room set availability = 'Occupied' where roomnumber = '"+room+"'";
                Conn c = new Conn();
                
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"New Customer Added Successfully");
               
                setVisible(false);
                new Reception();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){
        new AddCustomer();
    }
}
