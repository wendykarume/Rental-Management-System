package rental.system.controllers;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import java.net.URL;
import javafx.event.ActionEvent;
//import java.util.List;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ViewHouseProvider implements Initializable{
    
    @FXML private TableView houseview;
    @FXML private TableColumn house_type_col;
    @FXML private TableColumn house_location_col;
    @FXML private TableColumn house_price_col;
    @FXML private TableColumn house_status_col;

    
    Stage primaryStage = new Stage();
    FXMLLoader loader = new FXMLLoader(); // obj to load fxml
    
    // Exit function
    @FXML private void exit(ActionEvent event){
        
        System.exit(0);
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
     
        house_type_col.setCellValueFactory(new PropertyValueFactory("id"));
        house_location_col.setCellValueFactory(new PropertyValueFactory("id"));
        house_price_col.setCellValueFactory(new PropertyValueFactory("id"));
        house_status_col.setCellValueFactory(new PropertyValueFactory("id"));
        
//        houseview.getItems().setAll(parseUserList());
        
    }
    
//    private List parseUserList(){
//        
//        //code
//        
//    }
    
    
    public void show(){
    
    try {
            loader.setLocation(getClass().
                    getResource("/rental/system/ui/viewhouseprovider.fxml"));
            // getting the location
            Parent root = loader.load(); // defining root as the Parent
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);// setting the scene
            primaryStage.setTitle("View Houses ~ Provider | Rental Management System");
            // setting the title
            primaryStage.show(); // displaying the window
            
        } catch (IOException ex) {
            Logger.getLogger(ViewHouseProvider.class.getName()).log(Level.SEVERE, null, ex);
            // catching exception if fxml not found
        }
    
    }
    
    public void close(){
        
        primaryStage.close();
        
    }
    
}
