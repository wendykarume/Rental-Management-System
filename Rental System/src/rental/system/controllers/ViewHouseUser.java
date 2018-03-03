package rental.system.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import rental.system.models.House;
import rental.system.models.HouseData;

public class ViewHouseUser implements Initializable{
    
    @FXML private AnchorPane view_house_user;
    @FXML private TableView<HouseData> house_view;
    @FXML private TableColumn<HouseData, String> house_type;
    @FXML private TableColumn<HouseData, String> house_location;
    @FXML private TableColumn<HouseData, Integer> house_price;
    @FXML private TableColumn<HouseData, String> house_status;
    
    // Class objects to be used
    House house = new House();

    @Override
    public void initialize(URL location, ResourceBundle resources){
     
        try {
            house_type.setCellValueFactory(
                    new PropertyValueFactory<>("housetype"));
            house_location.setCellValueFactory(
                    new PropertyValueFactory<>("houselocation"));
            house_price.setCellValueFactory(
                    new PropertyValueFactory<>("houseprice"));
            house_status.setCellValueFactory(
                    new PropertyValueFactory<>("housestatus"));

            house_view.setItems(getHouses());
        
        } catch (SQLException ex) {
            Logger.getLogger(ViewHouseUser.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
    }
    
    private ObservableList<HouseData> getHouses() throws SQLException{
        
        ObservableList<HouseData> housedata = 
                FXCollections.observableArrayList();
        
        ResultSet rs = house.allHouses();
        
        if (rs != null){
        
            while (rs.next()){

                String type = rs.getString("HouseType");
                String place = rs.getString("HouseLocation");
                int price = rs.getInt("HousePrice");
                String status = rs.getString("HouseStatus");

                housedata.add(new HouseData(type, place, price, status));

            }

            return housedata;
        }
        
        return null;
        
    }
    
    @FXML private void back(ActionEvent event){
        
        try{
            // Running code to catch exception
            AnchorPane pane = FXMLLoader.load(getClass().
                    getResource("/rental/system/views/userdash.fxml"));
            view_house_user.getChildren().setAll(pane);
        }catch (IOException e) {
            // Output exception
            Logger.getLogger(ViewHouseUser.class.getName()).
                    log(Level.SEVERE, null, e);
            
        }
        
    }
    
    // Exit function
    @FXML private void exit(ActionEvent event){
        
        System.exit(0);
        
    }
    
}
