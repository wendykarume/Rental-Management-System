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

public class Login{
    
    @FXML JFXTextField email;
    
    @FXML JFXPasswordField password;
    
    @FXML JFXRadioButton user;
    
    @FXML JFXRadioButton provider;

    Stage login = new Stage();
    FXMLLoader loader = new FXMLLoader(); // obj to load fxml
    
    ProviderDash providerdash = new ProviderDash();
    UserDash userdash = new UserDash();
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
        
        // Validate from database
        
        System.out.println(email.getText());
        System.out.println(password.getText());
        if (!user.isSelected() || !provider.isSelected() || (email.getLength() == 0) || (password.getLength() ==0)){
            // make sure fields are not empty
            alert.display("Invalid", "Choose User or Provider!");
            
        }
        else{
            
            if (user.isSelected()){
                //to validate from database
                userdash.show();
                
            }
            
            else{
                //tovalidate from database
                providerdash.show();
                
            }
            
        }
            
    }
    
}
