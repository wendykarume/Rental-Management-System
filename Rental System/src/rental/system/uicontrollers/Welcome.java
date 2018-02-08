package rental.system.uicontrollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
public class Welcome{

    Signup signup = new Signup();
    Login login = new Login();
    
    @FXML
    private void signup(ActionEvent event){

        signup.signup();
        
    }
    @FXML
    private void login(ActionEvent event){
        
        login.login();
        
    }

}
