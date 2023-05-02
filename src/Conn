package bankmanagementsystem;
import java.sql.*;
public class Conn {

//   Statement is declared globally because it is used in SignUpOne class - Through Objects --> that will execute this file --> That's why Main method is not required.  
  Statement s;
  
// create connection 
    public Conn(){  
      Connection c;
//    Exception handling
        try{

//        Register Driver
          
//        Not required to create explicitily the MySQL jar library will handle 
//        Class.forName(com.mysql.cj.jdbc.Driver);
    
//        create connection 
            c = DriverManager.getConnection("jdbc:mysql:///bankManagementSystem","root","admin");
            
//        create Statement
            s = c.createStatement();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}

/* 5 Steps for connecting Database
    1.Register the Driver
    2.Create Connection
    3.Create Statement
    4.Execute the Query
    5.Close

Step 1 is not required as MySQL Connector Java is used in this, it will automatically register it.
*/
