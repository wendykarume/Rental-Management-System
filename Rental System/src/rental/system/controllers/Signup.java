// Class package
package rental.system.controllers;

// Custom UI package imports
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

// Imports for exception handling
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

// JavaFX imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
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
    @FXML private Label radio_check, fname, lname, mail, pass, pass_confirm, 
            sign_up;
    
    // Database objects
    User user = new User();
    Provider provider = new Provider();
    
    // Private method to dashboard after signup
    @FXML private void toDash(ActionEvent event) throws SQLException{
        
        // Clearing fields
        radio_check.setText("");
        fname.setText("");
        lname.setText("");
        mail.setText("");
        pass.setText("");
        pass_confirm.setText("");
        sign_up.setText("");
        
        try{
            // Checking user input
            
            // Making sure a radiobutton is selected
            if (!userbutton.isSelected() && !providerbutton.isSelected()){
                
                // Setting messge for user
                radio_check.setText("Select to proceed");
            
            // Making sure the first name is not empty upon submission
            } else if (first_name.getLength() == 0){
                
                // Setting error message
                fname.setText("Required field");
                
            // Making sure the last name field is not empty upon submission
            }else if (last_name.getLength() == 0){
                
                // Outputting error message
                lname.setText("Required field");                

            // Checking email
            } else if (email.getLength() == 0){
                
                // Outputting message
                mail.setText("Required field");
                
            // Making sure email has the @ symbol
            } else if (!email.getText().contains("@")){
                
                // Outputting text
                mail.setText("Invalid email");
                
            // Checking length of password
            }else if(password.getLength() < 8){
                
                // Outputting message
                pass.setText("Invalid, input 8 or more characters");
                
            // Checking length of confirm
            } else if (confirm.getLength() < 8){
                
                // Outputting message
                pass_confirm.setText("Invalid, input 8 or more characters");
                
            }else if (!password.getText().equals(confirm.getText())){
                
                pass.setText("Passwords do not match");
                pass_confirm.setText("Passwords do not match");
                
                // Clearing fields
                password.clear();
                confirm.clear();
                
            }else{
                // Validating from and inserting into database                
                
                // If user button is selected 
                if (userbutton.isSelected()){
                    
                    // Getting email from database
                    ResultSet user_rs = user.fetch(email.getText());
                    
                    if (user_rs != null){
                        
                        // Alerting the user
                        mail.setText("Email exists, use another");
                        sign_up.setText("You should Login");
                        
                    }else{
                        // Creating database tables
                        user.create();
                        
                        // inserting userdata
                        user.insert(first_name.getText(), last_name.getText(), 
                                email.getText(), password.getText());

                        // Afterwards displaying UserDash
                        AnchorPane pane = FXMLLoader.load(getClass().
                            getResource("/rental/system/views/userdash.fxml"));
                        signup.getChildren().setAll(pane);
                        
                    }
                        
                }else if(providerbutton.isSelected()){
                    // Getting provider data from database
                    ResultSet provider_rs = provider.fetch(email.getText());
                    
                    if (provider_rs != null){
                        
                        // Alerting the user
                        mail.setText("Email exists, use another");
                        sign_up.setText("You should Login");
                        
                    }else{
                        // Creating tables
                        provider.create();
                        
                        // Inserting data
                        provider.insert(first_name.getText(), 
                                last_name.getText(), email.getText(), 
                                password.getText());

                        // Catch exception if present
                        AnchorPane pane = FXMLLoader.load(getClass().
                                getResource
                                ("/rental/system/views/providerdash.fxml"));
                        signup.getChildren().setAll(pane);
                        
                    }
                        
                }else{
                    // Loading Alert Window for miscellaneous error
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
    
    // Exit function
    @FXML private void exit(ActionEvent event){
        
        System.exit(0);
        
    }
    
}
