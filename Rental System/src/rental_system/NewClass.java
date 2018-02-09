package rental_system;
import java.sql.*;

public class NewClass {
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
      
      String sql = "CREATE TABLE CLIENTS " +
                   "(id INTEGER not NULL, " +
                   " firstname VARCHAR(255), " + 
                   " lastname VARCHAR(255), " + 
                   " email VARCHAR(255), " +
                   "providers VARCHAR(255),"+
                   " PRIMARY KEY ( id ))";
      stmt.executeUpdate(sql);
      System.out.println("Created table in given database...");
      
      String std = "CREATE TABLE PROVIDERS " +
                   "(id INTEGER not NULL, " +
                   " firstname VARCHAR(255), " + 
                   " lastname VARCHAR(255), " + 
                   " email VARCHAR(255), "+
                   "providers VARCHAR(255),"+
                   " PRIMARY KEY ( id ))"; 

      stmt.executeUpdate(std);
      System.out.println("Created table in given database...");
      String src = "CREATE TABLE HOUSES " +
                   "(id INTEGER not NULL, " +
                   " type TEXT, " + 
                   " location TEXT, " + 
                   " price INTEGER not NULL," +
                   " PRIMARY KEY ( id ))"; 

      stmt.executeUpdate(src);
      System.out.println("Created table in given database...");
      
      //STEP 4: Execute a query
      System.out.println("Inserting records into the table PROVIDERS");
      stmt = conn.createStatement();
      
  String sbs = "INSERT INTO Providers (firstname,lastname, email,password) VALUES (?, ?, ?, ?), (firstname,lastname,email,password)";
 
PreparedStatement statement = conn.prepareStatement(sql);
statement.setString(1, "Wendy");
statement.setString(2, "Karume");
statement.setString(3, "wendywambui3@gmail.com");
statement.setString(4, "Spongebob");
 
int rowsInserted = statement.executeUpdate();
if (rowsInserted > 0) {
    System.out.println("A new provider was inserted successfully!");
}
int count = 0;
 

 
   String sbm = "UPDATE providers firstname=?, lastname=?, email=?, password=? WHERE username=?";
 

statement.setString(1, "Wendy");
statement.setString(2, "Karume");
statement.setString(3, "wendywambui3@gmail.com");
statement.setString(4, "Spongebob");
 
int rowsUpdated = statement.executeUpdate();
if (rowsUpdated > 0) {
    System.out.println("An existing user was updated successfully!");
}
      
      
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
