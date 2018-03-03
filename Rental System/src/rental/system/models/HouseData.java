
package rental.system.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class HouseData {
    
        private final SimpleIntegerProperty houseid;
        private final SimpleStringProperty housetype;
        private final SimpleStringProperty houselocation;
        private final SimpleIntegerProperty houseprice;
        private final SimpleStringProperty housestatus;

        public HouseData(int id, String type, String location, int price,
                        String status){

            this.houseid = new SimpleIntegerProperty(id);
            this.housetype = new SimpleStringProperty(type);
            this.houselocation = new SimpleStringProperty(location);
            this.houseprice = new SimpleIntegerProperty(price);
            this.housestatus = new SimpleStringProperty(status);

        }
        
        public HouseData(String type, String location, int price,
                        String status){

            this.houseid = new SimpleIntegerProperty();
            this.housetype = new SimpleStringProperty(type);
            this.houselocation = new SimpleStringProperty(location);
            this.houseprice = new SimpleIntegerProperty(price);
            this.housestatus = new SimpleStringProperty(status);

        }


        public int getHouseid() {
            return houseid.get();
        }

        public void setHouseid(int houseid) {
            this.houseid.set(houseid);
        }

        public String getHousetype() {
            return housetype.get();
        }

        public void setHousetype(String housetype) {
            this.housetype.set(housetype);
        }

        public String getHouselocation() {
            return houselocation.get();
        }

        public void setHouselocation(String houselocation) {
            this.houselocation.set(houselocation);
        }

        public int getHouseprice() {
            return houseprice.get();
        }

        public void setHouseprice(int houseprice) {
            this.houseprice.set(houseprice);
        }

        public String getHousestatus() {
            return housestatus.get();
        }

        public void setHousestatus(String housestatus) {
            this.housestatus.set(housestatus);
        }
    
    }
