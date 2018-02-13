package rental.system.uicontrollers;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rental.system.database.Provider;
import rental.system.database.User;

public class Login{
    
    @FXML JFXTextField email;
    
    @FXML JFXPasswordField password;
    
    @FXML JFXRadioButton userbutton;
    
    @FXML JFXRadioButton providerbutton;

    Stage login = new Stage();
    FXMLLoader loader = new FXMLLoader(); // obj to load fxml
    
    Alert alert = new Alert();
    
    public void show(){

        try {
                loader.setLocation(getClass().getResource(""
                        + "/rental/system/ui/login.fxml"));
                // getting the location
                Parent log_in = loader.load(); // defining root as the Parent
                Scene scene = new Scene(log_in);
                login.setScene(scene);// setting the scene
                login.show(); // displaying the window
                login.setTitle("Login | Rental Management System");
                // setting the title
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                // catching exception if fxml not found
            }

        }
    
    @FXML private void toDash(){
        Provider provider = new Provider();
        User user = new User();
        user.create();
        provider.create();
        
        // Validate from database
        if (!userbutton.isSelected() || !providerbutton.isSelected() 
                || (email.getLength() == 0) || (password.getLength() ==0)){
            // make sure fields are not empty
            alert.display("Invalid", "Choose User or Provider!");
            
        }
        else{
            
            if (userbutton.isSelected()){
                //to validate from database
                UserDash userdash = new UserDash();
                userdash.show();
                
            }
            
            else{
                //tovalidate from database
                ProviderDash providerdash = new ProviderDash();
                providerdash.show();
                
            }
            
        }
            
    }
    
}
