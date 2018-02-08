package rental.system.uicontrollers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rental.system.Controller;

public class ProviderWelcome{
   
    LoginProvider login = new LoginProvider();
    SignupProvider signup = new SignupProvider();
    
    Stage primaryStage = new Stage();
    FXMLLoader loader = new FXMLLoader(); // obj to load fxml
    
    public void show(){

        try {
                loader.setLocation(getClass().getResource(""
                        + "/rental/system/ui/providerwelcome.fxml"));
                // getting the location
                Parent root = loader.load(); // defining root as the Parent
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);// setting the scene
                primaryStage.show(); // displaying the window
                primaryStage.setTitle("Welcome ~ Provider | Rental Management System");
                // setting the title
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                // catching exception if fxml not found
            }

        }
    
    @FXML
    public void login(){
        
        login.show();
        
    }
    
    @FXML
    public void signup(){
        
        signup.show();
        
    }
    
    public void close(){
        
        primaryStage.close();
        
    }
    
}
