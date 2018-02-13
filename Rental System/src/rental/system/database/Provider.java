package rental.system.database;
import java.sql.*;

public class Provider {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/HOUSE_RENTAL_SYSTEM";

   //  Database credentials
   static final String USER = "test";
   static final String PASS = "R3ntal_Syst3m";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a given database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating table in given database...");
      stmt = conn.createStatement();
      
      String sql;
      sql = "CREATE TABLE Providers(ProviderID INTEGER  AUTOINCREMENT, " +
                   " FirstName TEXT(45), LastName TEXT(45), " + 
                   " Email VARCHAR(75), Password VARCHAR(45),"+
                   " PRIMARY KEY ( ProviderID ))";
      
      stmt.executeUpdate(sql);
      System.out.println("Created table in given database...");
     
         
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample
public static void INSERT INTO USERS
