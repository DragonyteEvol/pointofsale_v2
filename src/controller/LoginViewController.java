package controller;

import dao.UserDao;
import dao.UserDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import object.User;
public class LoginViewController {

	@FXML
    private Button btnLogin;

    @FXML
    private Hyperlink btnRegister;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUser;

    @FXML
    void eventAction(ActionEvent event) {
    	Object source = event.getSource();
    	if(source==txtUser) {
    		txtUser.selectAll();
    	}
    	if(source==txtPassword) {
    		txtPassword.selectAll();
    	}
    	if(source==btnLogin) {
    		/*UserDao  userDao = new UserDaoImpl();
    		User user = userDao.getByMail(txtUser.getText());
    		System.out.print(user.getUser());*/
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