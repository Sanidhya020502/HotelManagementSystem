/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class HotelManagementSystem extends JFrame implements ActionListener{
    
    HotelManagementSystem(){
        setSize(1366,565); //setting size of frame
        setLocation(100,100); 
        setLayout(null);
        
     
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1366,565,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1366, 565); //mix of setSize and setlocation
        add(image);
        
        
        
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,430,1000,90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN,50));
        image.add(text);
        
        JButton next = new JButton("Next");
        next.setBounds(1150,450,150,50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.MAGENTA);
        next.addActionListener(this);
        next.setFont(new Font("serif", Font.PLAIN,20));
        image.add(next);
        
        setVisible(true);
        
        while(true){   //dipper functionality
            text.setVisible(false);
            try{
                Thread.sleep(500);
            } catch (Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
   }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new HotelManagementSystem();
        
    }
    
}
