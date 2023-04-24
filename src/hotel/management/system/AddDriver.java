
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener{
    JButton add, cancel;
    JRadioButton rbmale, rbfemale;
    JTextField tfname, tfage,tfcompany,tfmodel,tflocation;
    JComboBox cbavailable;
    
    AddDriver(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //heading add rooms
        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,10,200,20);
        add(heading);
        
        //name
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblname.setBounds(60,70,120,30);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,70,150,30);
        add(tfname);
       
        //age
        JLabel lblage = new JLabel("Age");
        lblage.setFont(new Font("Tahoma",Font.PLAIN ,16));
        lblage.setBounds(60,110,120,30);
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200,110,150,30);
        add(tfage);
        
        
        //Gender
        JLabel lblgender= new JLabel("Gender");
        lblgender.setFont(new Font("Tahoma",Font.PLAIN ,16));
        lblgender.setBounds(60,150,120,30);
        add(lblgender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200,150,70,30);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280,150,70,30);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup();  //for deselecting the other option
        bg.add(rbmale);
        bg.add(rbfemale);
        
        //Car Company
         JLabel lblcompany = new JLabel("Car Company");
        lblcompany.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblcompany.setBounds(60,190,120,30);
        add(lblcompany);
        
        tfcompany = new JTextField();
        tfcompany.setBounds(200,190,150,30);
        add(tfcompany);
        
        //Car Model
        JLabel lblmodel= new JLabel("Car Model");
        lblmodel.setFont(new Font("Tahoma",Font.PLAIN ,16));
        lblmodel.setBounds(60,230,120,30);
        add(lblmodel);
        
        tfmodel = new JTextField();
        tfmodel.setBounds(200,230,150,30);
        add(tfmodel);
        
        //availability
        JLabel lblavailable= new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN ,16));
        lblavailable.setBounds(60,270,120,30);
        add(lblavailable);
        
         
        String strg[] = { "Available", "Busy" };
        cbavailable = new JComboBox(strg);
        cbavailable.setBounds(200,270 , 150, 30);
        cbavailable.setBackground(Color.WHITE);
        add(cbavailable);
        
        //location
        JLabel lbllocation= new JLabel("Location");
        lbllocation.setFont(new Font("Tahoma",Font.PLAIN ,16));
        lbllocation.setBounds(60,310,120,30);
        add(lbllocation);
        
        tflocation = new JTextField();
        tflocation.setBounds(200,310,150,30);
        add(tflocation);
        
        
        //Buttons
        add = new JButton("Add Driver");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60,370,130,30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,370,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,30,500,350);
        add(image);
        
        setBounds(300,200,980,470);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
        String name = tfname.getText();
        String age = tfage.getText();
        String company = tfcompany.getText();
        String model = tfmodel.getText();
        String availability = (String)cbavailable.getSelectedItem();
        String location = tflocation.getText();
        
        String gender = null;
        if(rbmale.isSelected()){
            gender = "Male";
        }else if(rbfemale.isSelected()){
            gender = "Female";
        }
        
        try{
             Conn c = new Conn();
                String str = "insert into driver values('"+name+"', '"+age+"', '"+gender+"', '"+company+"', '"+model+"','"+availability+"', '"+location+"' )";
                
                c.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null, "New Driver Added Successfully");
                
                setVisible(false);
        }catch(Exception e ){
            e.printStackTrace();
        }
        }else{
            setVisible(false);
        }
        
    }
    
    public static void main(String[] args){
        new AddDriver();
    }
}
