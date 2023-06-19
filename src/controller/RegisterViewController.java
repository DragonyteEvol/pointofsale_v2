package controller;

import dao.UserDao;
import dao.UserDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import object.User;

public class RegisterViewController {

    @FXML
    private Button btnRegister;

    @FXML
    private TextField txtMail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUser;
    
    //CREA UNA INSTANCIA DEL USUARIO A PARTIR DE LOS TEXTFIELD
    private User createUser() {
    	User user = new User();
    	user.setUser(txtUser.getText());
    	user.setMail(txtMail.getText());
    	user.setPassword(txtPassword.getText());
    	return user;
    }

    @FXML
    void insertUser(ActionEvent event) {
    	UserDao userDao = new UserDaoImpl();
    	userDao.insert(this.createUser());
    	//CERRA VENTANA
    	Utils.getUtils().closeView(btnRegister);
    }

}

