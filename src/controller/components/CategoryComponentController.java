package controller.components;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import object.Category;

public class CategoryComponentController implements Initializable {
	
	private Category category;
	
    public CategoryComponentController(Category category) {
		this.category = category;
	}

	@FXML
    private Label lbCategory;

    @FXML
    private Hyperlink lbTarget;

    @FXML
    private MenuItem mnDelete;

    @FXML
    private MenuItem mnEdit;

    @FXML
    void deleteObject(ActionEvent event) {

    }

    @FXML
    void editObject(ActionEvent event) {

    }

    private void initView() {
    	this.lbCategory.setText(this.category.getCategorie());
    	this.lbTarget.setText(String.valueOf(this.category.getTarget()));
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.initView();
	}
}