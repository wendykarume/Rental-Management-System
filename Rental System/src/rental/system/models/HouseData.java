// Class package
package rental.system.models;

// JavaFx imports
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/*
    Public class that acts as a data model for parsing values obtained from the
    database to facilitate outputting them into a table
*/
public class HouseData {
    
    // Variables for parsing the data obtained to be used
    private final SimpleIntegerProperty houseid;
    private final SimpleStringProperty housetype;
    private final SimpleStringProperty houselocation;
    private final SimpleIntegerProperty houseprice;
    private final SimpleStringProperty housestatus;

    // Constructor that will use all the values and set them equivalent to those
    // parsed in the constructor
    public HouseData(int id, String type, String location, int price,
                    String status){
        
        // Initialising the variables
        this.houseid = new SimpleIntegerProperty(id);
        this.housetype = new SimpleStringProperty(type);
        this.houselocation = new SimpleStringProperty(location);
        this.houseprice = new SimpleIntegerProperty(price);
        this.housestatus = new SimpleStringProperty(status);

    }
    
    // Constructor that will use all the values but the id and set them 
    // equivalent to those parsed in the constructor
    public HouseData(String type, String location, int price,
                    String status){

        // Initialising vaariables with values apart from the id. To handle a 
        // different case of input
        this.houseid = new SimpleIntegerProperty();
        this.housetype = new SimpleStringProperty(type);
        this.houselocation = new SimpleStringProperty(location);
        this.houseprice = new SimpleIntegerProperty(price);
        this.housestatus = new SimpleStringProperty(status);

    }

    // Getter getting the houseid
    public int getHouseid() {
        return houseid.get();
    }

    // Setter setting the houseid
    public void setHouseid(int houseid) {
        this.houseid.set(houseid);
    }

    // Getter getting the house type
    public String getHousetype() {
        return housetype.get();
    }

    // Setter setting the house type
    public void setHousetype(String housetype) {
        this.housetype.set(housetype);
    }

    // Geter getting the house location
    public String getHouselocation() {
        return houselocation.get();
    }

    // Setter setting the house location
    public void setHouselocation(String houselocation) {
        this.houselocation.set(houselocation);
    }

    // Getter getting the house price
    public int getHouseprice() {
        return houseprice.get();
    }

    // Setter setting the house price
    public void setHouseprice(int houseprice) {
        this.houseprice.set(houseprice);
    }

    // Getter getting the house status
    public String getHousestatus() {
        return housestatus.get();
    }

    // Setter setting the house status
    public void setHousestatus(String housestatus) {
        this.housestatus.set(housestatus);
    }

}
