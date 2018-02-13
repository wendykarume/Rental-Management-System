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

public class Signup{
    
    Alert alert = new Alert();

    @FXML private JFXTextField first_name;
    
    @FXML private JFXTextField last_name;
    
    @FXML private JFXTextField email;
    
    @FXML private JFXPasswordField password;
    
    @FXML private JFXPasswordField confirm;
    
    @FXML JFXRadioButton userbutton;
    
    @FXML JFXRadioButton providerbutton;
    
    Stage signup = new Stage();
    FXMLLoader loader = new FXMLLoader(); // obj to load fxml
    
    public void show(){
    
    try {
            loader.setLocation(getClass().
                    getResource("/rental/system/ui/signup.fxml"));
            // getting the location
            Parent sign_up = loader.load(); // defining root as the Parent
            Scene scene = new Scene(sign_up);
            signup.setScene(scene);// setting the scene
            signup.setTitle("Signup | Rental Management System");
            // setting the title
            signup.show(); // displaying the window
            
        } catch (IOException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
            // catching exception if fxml not found
        }
    
}
    
    @FXML private void toDash(){
        
        if (!userbutton.isSelected() || !providerbutton.isSelected() || 
                (first_name.getLength() == 0) || (last_name.getLength() == 0)
                || (email.getLength() == 0) || (password.getLength() == 0) || 
                (confirm.getLength() == 0)){
            // make sure fields are not empty
                alert.display("Invalid", "Choose User or Provider!");
            
        }
        else{
            
            if (userbutton.isSelected()){
                //to validate from database
                User user = new User();
                user.create();
                UserDash userdash = new UserDash();
                userdash.show();
                
            }
            
            else{
                //tovalidate from database
                Provider provider = new Provider();
                provider.create();
                ProviderDash providerdash = new ProviderDash();
                providerdash.show();
                
            }
            
        }
    
    }
}
