package controller.components;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import object.Ingredient;

public class IngredientComponentController implements Initializable{
	
	private Ingredient ingredient;
	
    public IngredientComponentController(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	@FXML
    private Label lbCategory;

    @FXML
    private Label lbIngredient;

    @FXML
    private Label lbUnit;

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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.initView();
	}
	
	private void initView() {
		this.lbIngredient.setText(this.ingredient.getIngredient());
		this.lbCategory.setText(this.ingredient.getCategorie());
		this.lbUnit.setText(this.ingredient.getUnit());
	}

}

