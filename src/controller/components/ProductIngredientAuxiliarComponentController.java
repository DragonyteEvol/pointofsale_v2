package controller.components;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.DataSingleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import object.Ingredient;

public class ProductIngredientAuxiliarComponentController implements Initializable{
	
	private Ingredient ingredient;
	
    public ProductIngredientAuxiliarComponentController(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
    
    @FXML
    private VBox pnIndex;

	@FXML
    private Label lbIngredient;

    @FXML
    private Label lbQuantity;

    @FXML
    private Label lbUnit;

    @FXML
    private Button btnDelete;

    
    //BORRA EL OBJETO ACTUAL DE LA VISTA Y DE LA LISTA
    @FXML
    void deleteObject(ActionEvent event) {
    	//ELIMINAR DE LISTA
    	List<Ingredient> ingredients = DataSingleton.getInstance().getProductIngredients();
    	ingredients.remove(this.ingredient);
    	DataSingleton.getInstance().setProductIngredients(ingredients);
    	//ELIMINAR DE VISTA
    	DataSingleton.getInstance().getPnAuxiliar().getChildren().remove(this.pnIndex);
    }

    private void initView() {
    	this.lbIngredient.setText(this.ingredient.getIngredient());
    	this.lbQuantity.setText(this.ingredient.getQuantity().toString());
    	this.lbUnit.setText(this.ingredient.getUnit());
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.initView();
	}
}


