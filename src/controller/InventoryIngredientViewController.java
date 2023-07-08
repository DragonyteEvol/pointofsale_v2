package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.components.IngredientComponentController;
import dao.IngredientDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import log.Log;
import object.Ingredient;

public class InventoryIngredientViewController implements Initializable{

    @FXML
    private Button btnAdd;

    @FXML
    private HBox pnIndex;

    @FXML
    private TextField txtSearch;

    @FXML
    void addObject(ActionEvent event) {
    	Utils.getUtils().changeView("/view/modal/AddIngredientView.fxml", true);
    	this.addObject(DataSingleton.getInstance().getIngredient());
    }

  //CREA UNA UNIDAD EN LA VISTA
    private void addObject(Ingredient ingredient){
    	if(ingredient!=null) {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/components/IngredientComponent.fxml"));
    		fxmlLoader.setController(new IngredientComponentController(ingredient));
        	try {
    			pnIndex.getChildren().add(fxmlLoader.load());
    		} catch (IOException e) {
    			Log.getLogger(getClass()).error(e.getMessage());
    		}
    	}
    }
    
    //CARGA LAS UNIDADES A LA VISTA
    private void loadObjects() {
		List<Ingredient> ingredients = new IngredientDaoImpl().getAll();
		for(Ingredient ingredient: ingredients) {
			this.addObject(ingredient);
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.loadObjects();
	}
}
