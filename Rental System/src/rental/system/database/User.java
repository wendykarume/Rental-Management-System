package rental.system.database;
import java.sql.*;

public class User {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/HOUSE_RENTAL_SYSTEM";

   //  Database credentials
   static final String USER = "test";
   static final String PASS = "R3ntal_Syst3m";
   
   public void create(){
       
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql;
            sql = "CREATE TABLE IF NOT EXISTS User(UserID INTEGER AUTO_INCREMENT, " +
                        " FirstName TEXT, LastName TEXT, " + 
                        " Email TEXT, Password TEXT,"+
                        " PRIMARY KEY(UserID))";
            stmt.executeUpdate(sql);
            
        }catch(SQLException se){
            
           se.printStackTrace();
           
        }catch(Exception e){
            
           e.printStackTrace();
           
        }finally{
            
           try{
               
                if(stmt!=null)
                    
                    conn.close();
                
           }catch(SQLException se){
           
           }
           try{
               
                if(conn!=null)
                    
                    conn.close();
           
           }catch(SQLException se){
                
               se.printStackTrace();
           
           }
        
        }

    }
   
   public void insert(){
       String sql = "INSERT INTO Users (UserID, FirstName, LastName, password, email)"
               + " VALUES (?, ?, ?, ?, ?)";
 
       
       
       
   }
   
   public void get(String email, String password){
       String sql = "SELECT * FROM Users WHERE ((Email = ?) and (Password = ?))"
               + "(email, password)";
 
       
       
       
   }

}
