package rental.system.uicontrollers;

import javafx.fxml.FXML;

public class Welcome{
    
    Signup signup = new Signup();
    Login login = new Login();
    
    @FXML private void signup(){

        signup.show();
        
    }
    
    @FXML private void login(){
        
        login.show();
        
    }

}
