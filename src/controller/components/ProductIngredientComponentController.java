package controller.components;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controller.DataSingleton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;
import log.Log;
import object.Ingredient;

public class ProductIngredientComponentController implements Initializable{
	
	private Ingredient ingredient;
	
    public ProductIngredientComponentController(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	@FXML
    private Label lbCategory;

    @FXML
    private Label lbIngredient;

    @FXML
    private Spinner<Integer> spQuantity;

    @FXML
    void addItem(MouseEvent event) {
    	Long quantity = spQuantity.getValue().longValue();
    	this.ingredient.setQuantity(quantity);
    	DataSingleton.getInstance().getProductIngredients().add(this.ingredient);
    	this.loadList();
    	this.reloadObjects();
    }
    
    //CARGA UN INGREDIENTE A LA LISTA, REMPLAZA EL OBJETO SI YA EXISTE EN LA LISTA
    private void loadList() {
    	List<Ingredient> ingredients = DataSingleton.getInstance().getProductIngredients();
    	List<Ingredient> ingredients_new = new ArrayList<>();
    	for(Ingredient ingredient : ingredients) {
    		if(ingredient.getId()!=this.ingredient.getId()) {
    			ingredients_new.add(ingredient);
    		}
    	}
    	if(this.ingredient.getQuantity()!=0) {
    		ingredients_new.add(this.ingredient);
    	}
    	DataSingleton.getInstance().setProductIngredients(ingredients_new);
    }
    
    private void reloadObjects() {
    	DataSingleton.getInstance().getPnAuxiliar().getChildren().clear();
    	List<Ingredient> ingredients = DataSingleton.getInstance().getProductIngredients();
    	for(Ingredient ingredient : ingredients) {
    		this.addObject(ingredient);
    	}
    }
    
    private void addObject(Ingredient ingredient){
    	if(ingredient!=null) {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/components/ProductIngredientAuxiliarComponent.fxml"));
    		fxmlLoader.setController(new ProductIngredientAuxiliarComponentController(ingredient));
        	try {
    			DataSingleton.getInstance().getPnAuxiliar().getChildren().add(fxmlLoader.load());
    		} catch (IOException e) {
    			Log.getLogger(getClass()).error(e.getMessage());
    		}
    	}
    }
    
    private void initView() {
    	SpinnerValueFactory<Integer> spinnerValueFactoryQuantity = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE, 0);
    	this.lbIngredient.setText(this.ingredient.getIngredient());
    	this.lbCategory.setText(this.ingredient.getCategorie());
    	this.spQuantity.setValueFactory(spinnerValueFactoryQuantity);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.initView();
	}

}


