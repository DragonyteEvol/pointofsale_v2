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
import javafx.stage.Stage;
import log.Log;
import model.ConfigModel;
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
    		
    		if(this.login()) {
    			this.changeView("/view/IndexView.fxml");
    		}
    	}
    	if(source==btnRegister) {
    		
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
   
    //------------------------------------------------------------------------------
  //VALIDA QUE LA INFORMACION DEL USUARIO SEA CORRECTA
    private boolean login() {
    	UserDao  userDao = new UserDaoImpl();
		User user = userDao.getByMail(txtUser.getText());
		//VALIDACION DE EXISTENCIA DE USUARIO
		if(user==null) {
			return false;
		}
		//VALIDACION DE CONTRASEÑA
		if(user.getPassword().equals(txtPassword.getText())) {
			ConfigModel.setUser(user);
			Log.getLogger(getClass()).info("Usuario:" + user.getUser() + "logeado correctamente en el sistema");
			return true;
		}else {
			return false;
		}	
    }
    
  //CABIA LA VISTA AL MODULO PRINCIPAL
    private void changeView(String view) {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource(view));
    		Stage stage = (Stage) this.btnLogin.getScene().getWindow();
    		Scene scene = new Scene(root);
    		stage.setScene(scene);
    		stage.show();
    	}catch(Exception e) {
			Log.getLogger(getClass()).error(e.getMessage());
		}
    }

}