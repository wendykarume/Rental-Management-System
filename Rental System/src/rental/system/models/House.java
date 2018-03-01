package rental.system.models;
import java.sql.*;

public class House {
    // JDBC driver name and database URL
     static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/HOUSE_RENTAL_SYSTEM";

    //  Database credentials
    static final String USER = "test";
    static final String PASS = "R3ntal_Syst3m";
    Connection conn = null;
    Statement stmt = null;
   
   public void create(){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            

            String sql;
            sql = "CREATE TABLE IF NOT EXISTS House"
                    + "(HouseID INTEGER AUTO_INCREMENT, "
                    + " HouseLocation TEXT, HouseType TEXT, "
                    + " HousePrice TEXT, HouseStatus TEXT, "
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
   
    public void insert(String type, String location, String status, String price)
            throws SQLException{

        try{
            // Catching a connection exception
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // Manually committing data
            conn.setAutoCommit(false);
            
            // Creating a statement to be used while on the connection
            stmt = conn.createStatement();
            
            // Creating statements to be executed
            String sql = "INSERT INTO House(HouseType,"
                        + " HouseLocation, HouseStatus,"
                        +" HousePrice) VALUES(?, ?, ?, ?)";
            
            // Creating a stating that will facilitate parsing of data
            PreparedStatement statement = conn.prepareStatement(sql);
            
            // Setting values parsed in function
            statement.setString(1, type);
            statement.setString(2, location);
            statement.setString(3, status);
            statement.setString(4, price);
            
            // Executing statement
            statement.executeUpdate();
            
            // Save changes
            conn.commit();
            
        }catch(SQLException | ClassNotFoundException se){
            // Revert
            conn.rollback();
            
        }finally{
            // Close connection if ...
            try{
                // there is no statement
                if(stmt != null)
                    // Close connection
                    conn.close();
                
            }catch(SQLException se){
           
            }
            try{
                // there are no database credentials
                if(conn != null)
                    // Close connection
                    conn.close();
           
            }catch(SQLException se){
               
            }
        
        }       
       
   }
       
       
}
