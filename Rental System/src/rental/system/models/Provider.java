// Class package
package rental.system.models;

// Universal import as many modules are to be used
import java.sql.*;

/*
    Provider class that will handle provider data to and fro the database
*/
public class Provider{
    
    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    private static final String 
            DB_URL = "jdbc:mysql://localhost/HOUSE_RENTAL_SYSTEM";

    //  Database credentials
    private static final String USER = "test";
    private static final String PASS = "R3ntal_Syst3m";
    
    // Default values for variables before use
    private Connection conn = null;
    private Statement stmt = null;
    
    // Public function used in other classes for database tables creation
    public void create() throws SQLException{
       
        try{
            // Catching a connection exception
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // Manually committing data
            conn.setAutoCommit(false);
            
            // Creating a statement to be used while on the connection
            stmt = conn.createStatement();
            
            // Creating statements to be executed
            String sql = "CREATE TABLE IF NOT EXISTS Provider" +
                        "(ProviderID INTEGER AUTO_INCREMENT, " +
                        " FirstName TEXT, LastName TEXT, " + 
                        " Email TEXT, Password TEXT,"+
                        " PRIMARY KEY(ProviderID))";
            
            // Executing statements
            stmt.executeUpdate(sql);
            
            // Save changes
            conn.commit();
            
        }catch(ClassNotFoundException se){
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
   
    // Public function to be called in other class to insert providers' data
    public void insert(String firstname, String lastname, String email, 
           String password) throws SQLException{

        try{
            // Catching a connection exception
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // Manually committing data
            conn.setAutoCommit(false);
            
            // Creating a statement to be used while on the connection
            stmt = conn.createStatement();
            
            // Creating statements to be executed
            String sql = "INSERT INTO Provider(FirstName, LastName, Email, " +
                        "Password) VALUES(?, ?, ?, ?)";
            
            // Creating a stating that will facilitate parsing of data
            PreparedStatement statement = conn.prepareStatement(sql);
            
            // Setting values parsed in function
            statement.setString(1, firstname);
            statement.setString(2, lastname);
            statement.setString(3, email);
            statement.setString(4, password);
            
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
   
    // Public method that returns a ResultSet obtained from the database
    public ResultSet fetch(String email, String password){
       
        try{
            // Catching a connection exception
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // Manually committing data
            conn.setAutoCommit(false);
            
            // Creating a statement to be used while on the connection
            stmt = conn.createStatement();
            
            // Creating statements to be executed
            String sql = "SELECT Email, Password FROM Provider WHERE "
                    + "((Email = ?) && (Password = ?))";
            
            // Creating a stating that will facilitate parsing of data
            PreparedStatement statement = conn.prepareStatement(sql);
            
            // Setting values parsed in function
            statement.setString(1, email);
            statement.setString(2, password);
            
            // Creating a resultset
            ResultSet rs = statement.executeQuery();
            
            // Returning the ResultSet
            return rs;
                      
        }catch(SQLException | ClassNotFoundException se){
               
        }
        
        return null;
        
    }
    
}
