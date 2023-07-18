package controller.components;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import object.Category;

public class ButtonCategoryComponentController implements Initializable {
	
	private Category category;
	
    public ButtonCategoryComponentController(Category category) {
		this.category = category;
	}

	@FXML
    private Button btnAction;

    @FXML
    void runAction(ActionEvent event) {

    }
    
    private void initView() {
    	this.btnAction.setText(this.category.getCategorie());
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.initView();
	}
}