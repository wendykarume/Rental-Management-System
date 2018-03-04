// Class package
package rental.system.models;

// Universal import as there are many sql imports required
import java.sql.*;

public class House {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/HOUSE_RENTAL_SYSTEM";

    //  Database credentials
    static final String USER = "test";
    static final String PASS = "R3ntal_Syst3m";
    
    // Initialising variables to null
    Connection conn = null;
    Statement stmt = null;
   
    // Public method that creates the house table
    public void create(){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            

            String sql;
            sql = "CREATE TABLE IF NOT EXISTS House"
                    + "(HouseID INTEGER AUTO_INCREMENT, "
                    + " HouseLocation TEXT, HouseType TEXT, "
                    + " HousePrice INTEGER, HouseStatus TEXT, "
                    + " PRIMARY KEY(HouseID))";
            stmt.executeUpdate(sql);
            
        }catch(SQLException se){
            
          se.printStackTrace();
           
        }catch(Exception e){
            
           e.printStackTrace();
           
        }

    }
   
    // Public method that inserts data into the data from the values parsed in
    // the parameters of the function
    public void insert(String type, String location, String status, int price)
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
            statement.setInt(4, price);
            
            // Executing statement
            statement.executeUpdate();
            
            // Save changes
            conn.commit();
            
        }catch(SQLException | ClassNotFoundException se){
            // Revert
            conn.rollback();
            
        }
       
   }
    
    // Public method that returns a ResultSet of the houses
    public ResultSet allHouses() throws SQLException{
        
        try{
            // Catching a connection exception
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // Manually committing data
            conn.setAutoCommit(false);
            
            // Creating a statement to be used while on the connection
            stmt = conn.createStatement();
            
            // Creating statements to be executed
            String sql = "SELECT * FROM House";
            
            // Creating a ResultSet with houses
            ResultSet rs = stmt.executeQuery(sql);
            
            // Returning the ResultSet
            return rs;
            
        }catch(SQLException | ClassNotFoundException se){
            // Revert
            conn.rollback();
            
        }
        // Returning nothing
        return null;
        
    }
    
    // Public method returning houses if they are available
    public ResultSet occupiedHouses() throws SQLException{
        
        try{
            // Catching a connection exception
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // Manually committing data
            conn.setAutoCommit(false);
            
            // Creating a statement to be used while on the connection
            stmt = conn.createStatement();
            
            // Creating statements to be executed
            String sql = "SELECT * FROM House WHERE HouseStatus = 'Available'";
            
            // Creating a ResultSet
            ResultSet rs = stmt.executeQuery(sql);
            
            // Returning the ResultSet
            return rs;
            
        }catch(SQLException | ClassNotFoundException se){
            // Revert
            conn.rollback();
            
        }
        // Returning nothing
        return null;
        
    }
    
    // Public method for closing the connection
    public void closeConnection(){    
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
