// Class package
package rental.system;

// JavaFX imports
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

// Imports for Exception handling and output
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
    Controller class inheriting methods from JavaFX Application class by being
    subclassed
*/
public class Controller extends Application{
    
    // Decorator denoting use by FXML
    @FXML private AnchorPane welcome;
    
    @Override
    public void start(Stage stage){
        // Necessary override in Application class
        
        try{
            // Trying accessing fxml, if not found IOException is caught
            FXMLLoader load = new FXMLLoader();
            load.setLocation(getClass().
                    getResource("/rental/system/views/welcome.fxml"));
            
            // Defining the root window as welcome.fxml
            Parent root = load.load();
            Scene scene = new Scene(root);
            
            // Setting the scene
            stage.setScene(scene);
            
            // Displaying the window
            stage.show();
            
            // Setting the title
            stage.setTitle("Mandy | Rental Management System");

        }catch (IOException e){
            // Output exception
            Logger.getLogger(Controller.class.getName()).
                    log(Level.SEVERE, null, e);
            
        }
        
    }
    
    //private method that redirects to signup
    @FXML private void signup(ActionEvent event){
        
        try{
            // Trying this code before an exception is caught
            AnchorPane pane = FXMLLoader.load(getClass().
                    getResource("/rental/system/views/signup.fxml"));
            welcome.getChildren().setAll(pane);
            
        }catch (IOException e){
            // Output the exception
            Logger.getLogger(Controller.class.getName()).
                    log(Level.SEVERE, null, e);
            
        }
        
    }
    
    // private method that redirects for login
    @FXML private void login(ActionEvent event){
        
        try{
            // Running code in order to catch an exception if it is there
            AnchorPane pane = FXMLLoader.load(getClass().
                    getResource("/rental/system/views/login.fxml"));
            welcome.getChildren().setAll(pane);
            
        }catch (IOException e){
            // Output exception
            Logger.getLogger(Controller.class.getName()).
                    log(Level.SEVERE, null, e);
            
        }
        
    }
    
    public static void main(String[] args){
        // Initialising the start method that begins the application
        launch(args);
        
    }
    
}
