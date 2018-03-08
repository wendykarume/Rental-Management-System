// Class package
package rental.system.controllers;

// SQL imports
import java.sql.ResultSet;

// Exception handling imports
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;

// JavaFX imports
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.PieChart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

// Class imports
import rental.system.models.House;

/*
    Class that will facilitate the display of statistics to a provider. Utilises
    Initializable class that will enable it to override initialize class that 
    ensures the pie chart starts up with values
*/
public class Stats {
    
    // FXML Objects to be used
    @FXML private PieChart piechart;
    @FXML private AnchorPane stats;
    @FXML private Label select;
    @FXML private JFXComboBox choose;
    
    // Class objects to be used
    House house = new House();
    
    // Observable list instance to be used
    private final ObservableList <PieChart.Data> piechartdata = 
            FXCollections.observableArrayList();   

    // Creating a timestamp
    String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(
            Calendar.getInstance().getTime());
    
    
    String t1 = "", t2 = "", t3 = "", t4 = "", t5 = "", t6 = "",
            t7 = "", t8 = "", t9 = "", t10 = "";
    double p1 = 0, p2 = 0, p3 = 0, p4 = 0, p5 = 0, p6 = 0, 
            p7 = 0, p8 = 0, p9 = 0, p10 = 0;
    
    String title = "", chosen = "", type;
    double price, total;
    
    @FXML private void statsUpdate(ActionEvent event){
        
        select.setText("");
        piechartdata.clear();
        title = "";
        if (choose.getSelectionModel().isEmpty() == true){
            
            select.setText("Select to display Stats");
            
             // Set title
            title = "Nothing to Display.\nSelect House Status or no data in "
                    + "House Status selected.";
            piechart.setTitle(title);
        
        }else{
            if (null != choose.getValue().toString())switch (choose.getValue().toString()) {
                case "Available":
                    chosen = choose.getValue().toString();
                    title = "Prospected Monthly Revenue: Available Rentals\nDate: " + timeStamp;
                    break;
                case "Occupied":
                    chosen = choose.getValue().toString();
                    title = "Monthly Revenue: Occupied Rentals\nDate: " + timeStamp;
                    break;
                case "Ordered":
                    chosen = choose.getValue().toString();
                    title = "Expected Monthly Revenue: Ordered Rentals\nDate: " + timeStamp;
                    break;
                case "Booked":
                    chosen = choose.getValue().toString();
                    title = "Expected Monthly Revenue: Booked Rentals\nDate: " + timeStamp;
                    break;
                case "Pending":
                    chosen = choose.getValue().toString();
                    title = "Unsorted Monthly Revenue: Pending Rentals\nDate: " + timeStamp;
                    break;
                default:
                    break;
            }
            try {
                // Get values from database in a ResultSet
                ResultSet rs = house.statsHouseSelected(chosen);

                if (rs != null){
                    t1 = ""; t2 = ""; t3 = ""; t4 = ""; t5 = ""; t6 = "";
                            t7 = ""; t8 = ""; t9 = ""; t10 = "";
                    p1 = 0; p2 = 0; p3 = 0; p4 = 0; p5 = 0; p6 = 0; 
                            p7 = 0; p8 = 0; p9 = 0; p10 = 0;
                    total = 0;
                    piechartdata.clear();
                            
                    // Loop through the ResultSet, getting values by columns
                    while (rs.next()){
                        type = rs.getString("HouseType");
                        price = rs.getInt("HousePrice");

                        if ("Mansion".equals(type)){

                            p1+=price;
                            t1 = rs.getString("HouseType");

                        }

                        if ("Mansionette".equals(type)){

                            p2+=price;
                            t2 = rs.getString("HouseType");

                        }
                        if ("Cottage".equals(type)){

                            p3+=price;
                            t3 = rs.getString("HouseType");

                        }

                        if ("Villa".equals(type)){

                            p4+=price;
                            t4 = rs.getString("HouseType");

                        }

                        if ("5+ - Bedroom".equals(type)){

                            p5+=price;
                            t5 = rs.getString("HouseType");

                        }
 
                        if ("4 - Bedroom".equals(type)){

                            p6+=price;
                            t6 = rs.getString("HouseType");

                        }

                        if ("3 - Bedroom".equals(type)){

                            p7+=price;
                            t7 = rs.getString("HouseType");

                        }

                        if ("2 - Bedroom".equals(type)){

                            p8+=price;
                            t8 = rs.getString("HouseType");

                        }

                        if ("1 - Bedroom".equals(type)){

                            p9+=price;
                            t9 = rs.getString("HouseType");

                        }

                        if ("BedSitter".equals(type)){

                            p10+=price;
                            t10 = rs.getString("HouseType");

                        }

                    }
                    
                // Adding values obtained to the list into the pie chart
                
                if ((!"".equals(t1)) && (p1 != 0)){

                    piechartdata.add(new PieChart.Data(t1, p1));

                }

                if ((!"".equals(t2)) && (p2 != 0)){

                    piechartdata.add(new PieChart.Data(t2, p2));

                }

                if ((!"".equals(t3)) && (p3 != 0)){

                    piechartdata.add(new PieChart.Data(t3, p3));

                }

                if ((!"".equals(t4)) && (p4 != 0)){

                    piechartdata.add(new PieChart.Data(t4, p4));

                }

                if ((!"".equals(t5)) && (p5 != 0)){

                    piechartdata.add(new PieChart.Data(t5, p5));

                }

                if ((!"".equals(t6)) && (p6 != 0)){

                    piechartdata.add(new PieChart.Data(t6, p6));

                }

                if ((!"".equals(t7)) && (p7 != 0)){

                    piechartdata.add(new PieChart.Data(t7, p7));

                }

                if ((!"".equals(t8)) && (p8 != 0)){

                    piechartdata.add(new PieChart.Data(t8, p8));

                }

                if ((!"".equals(t9)) && (p9 != 0)){

                    piechartdata.add(new PieChart.Data(t9, p9));

                }

                if ((!"".equals(t10)) && (p10 != 0)){

                    piechartdata.add(new PieChart.Data(t10, p10));

                }
                
                if ((!"".equals(t1)) && (p1 != 0) || (!"".equals(t6)) && (p6 != 0)
                         || (!"".equals(t2)) && (p2 != 0) || (!"".equals(t7)) && (p7 != 0)
                         || (!"".equals(t3)) && (p3 != 0) || (!"".equals(t8)) && (p8 != 0)
                         || (!"".equals(t4)) && (p4 != 0) || (!"".equals(t9)) && (p9 != 0)
                         || (!"".equals(t5)) && (p5 != 0) || (!"".equals(t10)) && (p10 != 0)){

                    piechartdata.forEach(data -> data.nameProperty().bind(
                            Bindings.concat(data.getName(), " : ", "Ksh. " , 
                                    data.pieValueProperty())));
                    // Setting totals
                    total = p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8 + p9 + p10;

                    // Setting title
                    piechart.setTitle(title + "\nTotal Revenue: Ksh. " + total);

                    // Adding the data in the list into the pie chart
                    piechart.setData(piechartdata);

                    // Clear Selected
                    choose.getSelectionModel().clearSelection();

                    // Close connection
                    house.closeConnection();
                }else{
                    piechartdata.clear();
                     // Set title
                    title = "Nothing to Display.\nNo data in " + choose.getValue().toString() + " Houses.";
                    piechart.setTitle(title);
                    choose.getSelectionModel().clearSelection();
                    
                }
            }else{
                    
                // clearing data
                piechartdata.clear();
                
                // Set title
                title = "Nothing to Display.\nSelect House Status or no data in "
                        + "House Status selected.";
                
                piechart.setTitle(title);

                // Closing the connection
                house.closeConnection();

                // clear Selected
                choose.getSelectionModel().clearSelection();
                
                }
            } catch (SQLException ex) {

                Logger.getLogger(Stats.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }
    
    // Private method for going back
    @FXML private void back(ActionEvent event){
        
        try{
            AnchorPane pane = FXMLLoader.load(getClass().
                        getResource("/rental/system/views/providerdash.fxml"));
            stats.getChildren().setAll(pane);
            
        }catch (IOException e){
            // Output exception
            Logger.getLogger(Stats.class.getName()).
                    log(Level.SEVERE, null, e);
            
        }
        
    }
    
    // Exit function
    @FXML private void exit(ActionEvent event){
        
        System.exit(0);
        
    }
    
}
