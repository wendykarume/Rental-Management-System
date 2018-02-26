// Class package
package rental.system.controllers;

// Custom user interface package
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

// Imports for exception handling
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

// JavaFX imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

// Application imports
import rental.system.models.Provider;
import rental.system.models.User;

/*
    Login class that facilitates the login of users and providers
*/
public class Login {
    
    // Dashboard user or provider
    ProviderDash providerdash = new ProviderDash(); 
    UserDash userdash = new UserDash();
    
    // Database Objects
    Provider provider = new Provider();
    User user = new User();
    
    // FXML Objects to be used
    @FXML private AnchorPane login;
    @FXML private JFXTextField email;
    @FXML private JFXPasswordField password;
    @FXML private JFXRadioButton userbutton, providerbutton;
    
    // Private function that validates and redirects to the right dashboard
    @FXML private void toDash(ActionEvent event) throws Exception {
                
        // Database objects to create tables before inserting data
        
        try{
            // Making sure fields are not empty upon submission
            if (!userbutton.isSelected() || !providerbutton.isSelected() 
                    || (email.getLength() == 0) || (password.getLength() ==0)){

                // Loading Alert Window
                AnchorPane pane = FXMLLoader.load(getClass().
                        getResource("/rental/system/views/alert.fxml"));
                login.getChildren().setAll(pane);

            }else{
                // Redirect to appropriate dashboard on radiobutton selection
                if (userbutton.isSelected()){
                    // Validating from database
                    /* Code */

                    // Run code and catch exception if there
                    AnchorPane pane = FXMLLoader.load(getClass().
                            getResource("/rental/system/views/userdash.fxml"));
                    login.getChildren().setAll(pane);

                }else if(providerbutton.isSelected()){
                    // Validating from database
                    /* Code */

                    // Catch exception if present
                    AnchorPane pane = FXMLLoader.load(getClass().
                            getResource("/rental/system/views/providerdash.fxml"));
                    login.getChildren().setAll(pane);
                    
                }
                
            }
                    
        }catch (IOException e){
            // Output exception
            Logger.getLogger(Login.class.getName()).
                    log(Level.SEVERE, null, e);
        }
                
            }
    
    // Back to signup if user not signed up
    @FXML private void signup(ActionEvent event){
        
        try{
            // Running code to catch exception
            AnchorPane pane = FXMLLoader.load(getClass().
                    getResource("/rental/system/views/signup.fxml"));
            login.getChildren().setAll(pane);
            
        }catch (IOException e) {
            // Output exception
            Logger.getLogger(Login.class.getName()).
                    log(Level.SEVERE, null, e);
            
        }
        
    }
    
}
