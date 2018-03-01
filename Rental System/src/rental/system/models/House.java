package rental.system.models;
import java.sql.*;

public class House {
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
            sql = "CREATE TABLE IF NOT EXISTS House"
                    + "(HouseID INTEGER AUTO_INCREMENT, "
                    + " HouseLocation TEXT, HouseType TEXT, "
                    + " HousePrice INTEGER, HouseStatus TEXT "
                    + " PRIMARY KEY(HouseID))";
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
      String sql = "INSERT INTO Houses (HouseID, HouseType, HouseLocation,"
            + " HouseStatus, HousePrice)"
            + " VALUES (?, ?, ?, ?, ?)";
  
       
       
   }
   public void get(String type, String location,Integer price,String status){
       String sql = "SELECT * FROM Users WHERE ((type = ?) and (location = ?) and (status = ?) and (price = ?))"
               + "(type, location, status, price)";
 
  
       
       
       
   }

}
