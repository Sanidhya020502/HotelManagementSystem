
package hotel.management.system;

import java.sql.*;

public class Conn {
    //5 steps in JDBC connectivity
    
    Connection c;  //step 2 creating the connection
    Statement s; //step 3 creating a statement to run mysql queries
    Conn(){
        //step 1 register the driver class
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
         //step 2 Creating the connection
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","02iAsAsh!");
        s = c.createStatement();
        //step 4 executing mysql queuries
    }catch(Exception e){
        e.printStackTrace();
    }
       
        
}
}
