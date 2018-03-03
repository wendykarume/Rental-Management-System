package rental.system.controllers;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import rental.system.models.House;
import rental.system.models.HouseData;

public class ViewHouseProvider implements Initializable{
    
    @FXML private AnchorPane view_house_provider;
    
    @FXML private TableView<HouseData> house_view;
    @FXML private TableColumn<HouseData, Integer> house_id;
    @FXML private TableColumn<HouseData, String> house_type;
    @FXML private TableColumn<HouseData, String> house_location;
    @FXML private TableColumn<HouseData, Integer> house_price;
    @FXML private TableColumn<HouseData, String> house_status;
    
    House house = new House();
    
    FXMLLoader loader = new FXMLLoader(); // obj to load fxml
    
    // Exit function
    @FXML private void exit(ActionEvent event){
        
        System.exit(0);
        
    }
    
    @FXML private void back(ActionEvent event){
        
        try{
            AnchorPane pane = FXMLLoader.load(getClass().
                        getResource("/rental/system/views/providerdash.fxml"));
            view_house_provider.getChildren().setAll(pane);
            
        }catch (IOException e){
            // Output exception
            Logger.getLogger(ViewHouseProvider.class.getName()).
                    log(Level.SEVERE, null, e);
            
        }
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
     
        try {
            ResultSet rs = house.allHouses();
            while (rs.next()){
                
                int id = rs.getInt("HouseID");
                String type = rs.getString("HouseType");
                String place = rs.getString("HouseLocation");
                int price = rs.getInt("HousePrice");
                String status = rs.getString("HouseStatus");
            
                ObservableList<HouseData> data = FXCollections.observableArrayList(

                        new HouseData(id, type, place, price, status)

                );
            }
            
            house_id.setCellValueFactory(
                    new PropertyValueFactory<>("houseid"));
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
            Logger.getLogger(ViewHouseProvider.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ObservableList<HouseData> getHouses() throws SQLException{
        
        ObservableList<HouseData> housedata = 
                FXCollections.observableArrayList();
        
        ResultSet rs = house.allHouses();
        
        while (rs.next()){
            
            int id = rs.getInt("HouseID");
            String type = rs.getString("HouseType");
            String place = rs.getString("HouseLocation");
            int price = rs.getInt("HousePrice");
            String status = rs.getString("HouseStatus");
            
            housedata.add(new HouseData(id, type, place, price, status));
    
        }
        
        return housedata;
        
    }
}
