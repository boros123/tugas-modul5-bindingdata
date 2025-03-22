/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package modul3contoh2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class DashboardController implements Initializable {

    /**
     * Initializes the controller class.
     */
   
    
    @FXML
    private Button btnLogout;
    
    
    @FXML
    private void handleButtonLogoutAction(ActionEvent event)throws Exception{
        Main main = new Main ();
        main.changeScene("Main.fxml");    
    }
    
    @FXML
    private Hyperlink linkmaster;

    @FXML
    private void handleLink(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MasterData.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) linkmaster.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
