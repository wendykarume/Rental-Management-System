package rental.system;

import java.sql.*;

public class Models {

// JDBC driver name and database URL
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
static final String DB_URL = "jdbc:mysql://localhost/rental_system";

// Database credentials
static final String USER = "test";
static final String PASS = "test";

public static void main(String[] args) throws ClassNotFoundException {
Connection conn = null;
Statement stmt = null;
    try
    {
        //JDBC driver
        Class.forName("com.mysql.jdbc.Driver");
        
        //Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
        //Execute a query
        System.out.println("Creating statement...");
        stmt = conn.createStatement();
        
        String sql;
        sql = "SELECT * FROM users";
//        sql = "SELECT providersid, firstname, lastname, email, password FROM Providers";
//        sql = "SELECT houseid, housetype, houselocation, houseprice, houseimage, housestatus FROM Houses";
     
        ResultSet rs = stmt.executeQuery(sql);
            //Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                
                int id = rs.getInt("UserID");
                String firstname = rs.getString("FirstName");
                String lastname = rs.getString("LastName");
                String email = rs.getString("Email");
                String password = rs.getString("Password");
                
                //Display values
                System.out.println("UsersID: " + id);
                System.out.println("FirstName: " + firstname);
                System.out.println("LastName: " + lastname);
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
            }
        rs.close();
        stmt.close();
        conn.close();
    }catch(SQLException se){
        se.printStackTrace();

    }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
    //finally block used to close resources
        try{
            
            if(stmt!=null)
            stmt.close();
            
        }catch(SQLException se2){
        }// nothing we can do
        try{
            if(conn!=null)
                conn.close();
        }catch(SQLException se){
            //code
    }//end finally try
    }//end try
    System.out.println("Goodbye!");
}
    
}
