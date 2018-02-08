package rental.system.uicontrollers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import rental.system.Controllers;

public class Signup{
    
    @FXML
    private TextField first_name;
    
    @FXML
    private TextField last_name;
    
    @FXML
    private TextField email;
    
    @FXML
    private PasswordField pass;
    
    @FXML
    private PasswordField confirm;
    
    @FXML
    private ChoiceBox choice;
    
    Stage primaryStage = new Stage();
    FXMLLoader loader = new FXMLLoader(); // obj to load fxml
    
    public void signup(){
    
    try {
            loader.setLocation(getClass().
                    getResource("/rental/system/ui/signup.fxml"));
            // getting the location
            Parent root = loader.load(); // defining root as the Parent
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);// setting the scene
//            choice.setItems(FXCollections.observableArrayList("User", "Provider"));
            primaryStage.setTitle("Signup | Rental Management System");
            // setting the title
            primaryStage.show(); // displaying the window
            
        } catch (IOException ex) {
            Logger.getLogger(Controllers.class.getName()).log(Level.SEVERE, null, ex);
            // catching exception if fxml not found
        }
    
}
    
    
    
    @FXML
    private void getDetails(ActionEvent event){       
        
        System.out.println(first_name.getText());
        System.out.println(last_name.getText());
        System.out.println(email.getText());
//        System.out.println(confirm.getText());
        
    }
    
    private void putDetails(String first_name, String last_name, String email){
        
    }
    
    public void closeSignup(){
        
        primaryStage.close();
        
    }
    
}
