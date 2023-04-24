/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Reception extends JFrame implements ActionListener{
    JButton newCustomer, rooms, department,logout,allEmployee, managerinfo,customers, search,update,roomStatus,pickup,checkout;
    Reception(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        newCustomer  = new JButton("New Customer Form");
        newCustomer.setBounds(10,30,200,30);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.addActionListener(this);
        add(newCustomer);
        
        rooms  = new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setForeground(Color.WHITE);
        rooms.setBackground(Color.BLACK);
        rooms.addActionListener(this);
        add(rooms);
        
        department  = new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setForeground(Color.WHITE);
        department.setBackground(Color.BLACK);
        department.addActionListener(this);
        add(department);
        
        allEmployee  = new JButton("All Employees");
        allEmployee.setBounds(10,150,200,30);
        allEmployee.setForeground(Color.WHITE);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.addActionListener(this);
        add(allEmployee);
        
        customers  = new JButton("Customer Info");
        customers.setBounds(10,190,200,30);
        customers.setForeground(Color.WHITE);
        customers.setBackground(Color.BLACK);
        customers.addActionListener(this);
        add(customers);
        
        managerinfo  = new JButton("Manager Info");
        managerinfo.setBounds(10,230,200,30);
        managerinfo.setForeground(Color.WHITE);
        managerinfo.setBackground(Color.BLACK);
        managerinfo.addActionListener(this);
        add(managerinfo);
        
        checkout  = new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setForeground(Color.WHITE);
        checkout.setBackground(Color.BLACK);
        checkout.addActionListener(this);
        add(checkout);
        
        update  = new JButton("Update status");
        update.setBounds(10,310,200,30);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.addActionListener(this);
        add(update);
        
        roomStatus  = new JButton("Update Room Status");
        roomStatus.setBounds(10,350,200,30);
        roomStatus.setForeground(Color.WHITE);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.addActionListener(this);
        add(roomStatus);
        
        pickup  = new JButton("Pickup Service");
        pickup.setBounds(10,390,200,30);
        pickup.setForeground(Color.WHITE);
        pickup.setBackground(Color.BLACK);
        pickup.addActionListener(this);
        add(pickup);
        
        search  = new JButton("Search Room");
        search.setBounds(10,430,200,30);
        search.setForeground(Color.WHITE);
        search.setBackground(Color.BLACK);
        search.addActionListener(this);
        add(search);
        
        logout  = new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setForeground(Color.RED);
        logout.setBackground(Color.BLACK);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/reception.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(250,30,500,470);
        add(image);
   
        
        setBounds(350,200,800,570);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== newCustomer){
            setVisible(false);
            new AddCustomer();
        }else if (ae.getSource()== rooms){
            setVisible(false);
            new Room();
        }else if(ae.getSource()== department){
            setVisible(false);
            new Department();
        }else if (ae.getSource()== logout){
            setVisible(false);
            System.exit(0);
        }else if (ae.getSource()== allEmployee){
            setVisible(false);
            new EmployeeInfo();
        }else if (ae.getSource()== managerinfo){
            setVisible(false);
            new ManagerInfo();
        }else if (ae.getSource()== customers){
            setVisible(false);
            new CustomerInfo();
        }else if (ae.getSource()== search){
            setVisible(false);
            new SearchRoom();
        }else if (ae.getSource()== update){
            setVisible(false);
            new UpdateCheck();
        }else if (ae.getSource()== roomStatus){
            setVisible(false);
            new UpdateRoom();
        }else if (ae.getSource()== pickup){
            setVisible(false);
            new Pickup();
        }else if (ae.getSource()== checkout){
            setVisible(false);
            new Checkout();
        }
    }
    
    public static void main(String[] args){
        new Reception();
    }
}
