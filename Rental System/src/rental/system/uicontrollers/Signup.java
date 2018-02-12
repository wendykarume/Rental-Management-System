package rental.system.uicontrollers;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Signup{

    @FXML private JFXTextField first_name;
    
    @FXML private JFXTextField last_name;
    
    @FXML private JFXTextField email;
    
    @FXML private JFXPasswordField password;
    
    @FXML private JFXPasswordField confirm;
    
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
        
        System.out.println(first_name.getText());
        System.out.println(last_name.getText());
        System.out.println(email.getText());
        System.out.println(password.getLength());
        System.out.println(confirm.getText());
        
    }
    
}
