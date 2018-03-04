// Class package
package rental.system.controllers;

// Custom user interface package imports
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

// Imports for exception handling
import java.io.IOException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

// JavaFX imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

// Application imports
import rental.system.models.Provider;
import rental.system.models.User;
import rental.system.sources.BCrypt;

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
    @FXML private Label log_in, pass, mail, radio_check;
    @FXML private AnchorPane login;
    @FXML private JFXTextField email;
    @FXML private JFXPasswordField password;
    @FXML private JFXRadioButton userbutton, providerbutton;
    
    // Checking hash
    private String hashed;
    
    // Private function that validates and redirects to the right dashboard
    @FXML private void toDash(ActionEvent event) throws Exception {
                
        try{
            // Validating input by user
            
            // Clearing labels
            log_in.setText("");
            radio_check.setText("");
            pass.setText("");
            mail.setText("");
            
            // Making sure neither radiobuttons are not selected
            if (!userbutton.isSelected() && !providerbutton.isSelected()){
   
                // Alerting user
                radio_check.setText("Select to continue");
            
            // Making sure the email is not empty
            }else if ((email.getLength() == 0)){
                
                // Alerting upon empty email field
                mail.setText("Required field");
                
                // Clearing email
                email.clear();
                
            // Making sure the email has the @ symbol
            }else if (!email.getText().contains("@")) {
                                
                // Alerting upon invalid email
                mail.setText("Invalid email");
                
                // Clearing email
                email.clear();
                
            // Setting suitable length for password
            }else if((password.getLength() == 0) || (password.getLength() < 8)){
                              
                // Alerting upon empty password field
                pass.setText("Length of 8 or more");
                                
                // Clearing password
                password.clear();
                
            }else{
                // Vailidating from database
                
                // Alerting that credetials are not in database or invalid
                if (userbutton.isSelected()){
                    // Checking password hash
                    hashed = BCrypt.hashpw(password.getText(), 
                            BCrypt.gensalt(12));
                    
                    // Getting User data from database
                    ResultSet user_rs = 
                        user.fetch(email.getText(), hashed);
                    
                    if (user_rs == null){
                        // Setting texts for alerting the user
                        log_in.setText("Have you signed up?");
                        mail.setText("Invalid Email");
                        pass.setText("Invalid Password");

                        // Deselecting the radio buttons
                        userbutton.setSelected(false);
                        providerbutton.setSelected(false);

                        // Clearing fields
                        email.clear();
                        password.clear();
                        
                        // Closing connection
                        user.closeConnection();
                        
                    // Proceeding to UserDash upon all conditions being met
                    } else {
                        // Closing connection
                        user.closeConnection();
                        
                        // Display window
                        AnchorPane pane = FXMLLoader.load(getClass().
                            getResource("/rental/system/views/userdash.fxml"));
                        login.getChildren().setAll(pane);
                    
                    }
                
                }else if(providerbutton.isSelected()){
                    // Checking password hash
                    hashed = BCrypt.hashpw(password.getText(), 
                            BCrypt.gensalt(12));
                    
                    // Getting Provider data from database
                    ResultSet provider_rs = 
                        provider.fetch(email.getText(), hashed);
                    
                    if (provider_rs == null){
                        // Setting alert texts
                        log_in.setText("Have you signed up?");
                        mail.setText("Invalid Email");
                        pass.setText("Invalid Password");

                        // Deselecting the radio buttons
                        userbutton.setSelected(false);
                        providerbutton.setSelected(false);

                        // Clearing fields
                        email.clear();
                        password.clear();
                    
                        // Closing connection
                        provider.closeConnection();
                        
                    // Proceeding to ProviderDash upon all cases being met
                    }else{
                        // Closing connection
                        provider.closeConnection();
                        
                        // Catch exception if present
                        AnchorPane pane = FXMLLoader.load(getClass().
                        getResource("/rental/system/views/providerdash.fxml"));
                        
                        login.getChildren().setAll(pane);   
                    
                    }
                                    
                // Alerting that a miscellaneous error occurred
                }else{
                    
                    // Loading Alert Window
                    AnchorPane pane = FXMLLoader.load(getClass().
                            getResource("/rental/system/views/alert.fxml"));
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
    
    // Exit function
    @FXML private void exit(ActionEvent event){
        
        System.exit(0);
        
    }
    
}
