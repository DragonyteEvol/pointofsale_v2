package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
public class LoginViewController {

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUser;

    @FXML
    void eventAction(ActionEvent event) {
    	Object source = event.getSource();
    	if(source==txtUser) {
    		
    	}
    	if(source==txtPassword) {
    		
    	}
    }

    @FXML
    void eventKey(KeyEvent event) {
    	Object source = event.getSource();
    	if(source==txtUser) {
    		if(event.getCharacter()==" ") {
    			event.consume();
    		}
    	}
    	if(source==txtPassword) {
    		if(event.getCharacter()==" ") {
    			event.consume();
    		}
    	}
    }

}