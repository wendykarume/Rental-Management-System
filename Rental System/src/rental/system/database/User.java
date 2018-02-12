package rental.system.database;
import java.sql.*;

public class User {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/HOUSE_RENTAL_SYSTEM";

   //  Database credentials
   static final String USER = "test";
   static final String PASS = "R3ntal_Syst3m";
   
   public static void create() {
   Connection conn = null;
   Statement stmt = null;
   try{
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Connecting to a given database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      
      
      //STEP 4: Execute a query
      System.out.println("Creating table in given database...");
      stmt = conn.createStatement();
      
      String sql;
      sql = "CREATE TABLE Users(UserID INTEGER not NULL AUTOINCREMENT, " +
                   " FirstName TEXT(255), LastName TEXT(255), " + 
                   " Email VARCHAR(255), Password VARCHAR(255),"+
                   " PRIMARY KEY ( UserID ))";
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
   
   public void insert(String FirstName,String LastName,String Email,String Password,Integer UserID){
       
      String std = "INSERT INTO Users (FirstName, LastName, Password, email,UserID) VALUES (?, ?, ?, ?,?)";
   }
   
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT UsersID, FirstName, LastName, Email,Password FROM Users";
      ResultSet rs = stmt.executeQuery(sql);

      
      while(rs.next()){
         //Retrieve by column name
         int UsersID  = rs.getInt("UsersID");
         String Email = rs.getInt("Email");
         String FirstName = rs.getString("FirstName");
         String LastName = rs.getString("LastName");
         String Password = rs.getString("Paswsword");

         
}//end JDBCExample
