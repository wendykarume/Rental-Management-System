// Class package
package rental.system.controllers;

// Custom UI package imports
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

// Database imports
import rental.system.models.Provider;
import rental.system.models.User;

/*
    Class facilitating signup as user or provider
*/
public class Signup{
    
    // FXML Objects to be used
    @FXML private AnchorPane signup;
    @FXML private JFXTextField first_name, last_name, email;
    @FXML private JFXPasswordField password, confirm;
    @FXML private JFXRadioButton userbutton, providerbutton;
    
    // Database objects
    User user = new User();
    Provider provider = new Provider();
    
    // Private method to dashboard after signup
    @FXML private void toDash(ActionEvent event){
        
        try{
            // Making sure no field is empty upon submission
            if (!userbutton.isSelected() || !providerbutton.isSelected() || 
                    (first_name.getLength() == 0) || (last_name.getLength() == 0)
                    || (email.getLength() == 0) || (password.getLength() == 0) || 
                    (confirm.getLength() == 0)){

                    // Loading Alert Window
                    AnchorPane pane = FXMLLoader.load(getClass().
                            getResource("/rental/system/views/alert.fxml"));
                    signup.getChildren().setAll(pane);

            }else{
                // Appropriate data insertion to database
                if (userbutton.isSelected()){
                    //Validate from database
                    /* Code */
                    user.create();
                    
                    // Run code and catch exception if there
                    AnchorPane pane = FXMLLoader.load(getClass().
                            getResource("/rental/system/views/userdash.fxml"));
                    signup.getChildren().setAll(pane);

                }else if(providerbutton.isSelected()){
                    // Validate from database
                    /* Code */
                    provider.create();
                    /* Insert to database*/

                    // Catch exception if present
                    AnchorPane pane = FXMLLoader.load(getClass().
                            getResource
                            ("/rental/system/views/providerdash.fxml"));
                    signup.getChildren().setAll(pane);

                }else{
                    // Loading Alert Window
                    AnchorPane pane = FXMLLoader.load(getClass().
                            getResource("/rental/system/views/alert.fxml"));
                    signup.getChildren().setAll(pane);
                    
                }
                
            }
                
        }catch (IOException e){
            // Output exception
            Logger.getLogger(Signup.class.getName()).
                    log(Level.SEVERE, null, e);

                }
                
            }
    
    // private method to login if logged in
    @FXML private void login(ActionEvent event){
        
        try{
            // Loading window and catching exception if present
            AnchorPane pane = FXMLLoader.load(getClass().
                    getResource("/rental/system/views/login.fxml"));
            signup.getChildren().setAll(pane);
            
        }catch (IOException e) {
            // Output exception
            Logger.getLogger(Signup.class.getName()).
                            log(Level.SEVERE, null, e);
            
        }
        
    }
    
}
