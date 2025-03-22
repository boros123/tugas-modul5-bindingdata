/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class MainController implements Initializable {
    
     // Login
    @FXML
    private Label labelerorr;

    @FXML
    private TextField inputUsername;

    @FXML
    private PasswordField inputPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private void handleButtonLoginAction(ActionEvent event) {
        checklog();
    }

    private void checklog() {
        if (inputUsername.getText().equals("admin") && inputPassword.getText().equals("admin123")) {
            labelerorr.setText("Login berhasil");

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) btnLogin.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (inputUsername.getText().isEmpty() || inputPassword.getText().isEmpty()) {
            labelerorr.setText("Isi username dan password");
        } else {
            labelerorr.setText("Password dan username salah");
        }
    }

    // Hyperlink
  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
