package rental.system.uicontrollers;

import javafx.fxml.FXML;


public class Welcome{
    
    ProviderWelcome provider = new ProviderWelcome();
    UserWelcome user = new UserWelcome();
    
    @FXML private void provider(){

        provider.show();
        
    }
    
    @FXML private void user(){
        
        user.show();
        
    }

}
