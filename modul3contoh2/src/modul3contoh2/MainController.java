/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package modul3contoh2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Lenovo
 */
public class MainController implements Initializable {
    
    @FXML
    private Label labelerorr;
    
    @FXML
    private TextField inputUsername;
    
    @FXML
    private PasswordField inputPassword;
    
    @FXML
    private Button btnLogin;
    
    
    @FXML
    private void handleButtonLoginAction(ActionEvent event)throws Exception{
        checklog();
    }
    
    private void checklog()throws Exception {
        if (inputUsername.getText().equals("admin") && inputPassword.getText().equals("admin123")) {
            labelerorr.setText("Login berhasil");
            Main main = new Main();
            main.changeScene("Dashboard.fxml");
        } else if(inputUsername.getText().isEmpty() && inputPassword.getText().isEmpty()) {
            labelerorr.setText("Isi username dan password");
        }else{
        labelerorr.setText("Password dan username salah");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
