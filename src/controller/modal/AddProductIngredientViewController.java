package controller.modal;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controller.DataSingleton;
import controller.Utils;
import controller.components.ProductIngredientComponentController;
import dao.IngredientDaoImpl;
import dao.ProductDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import log.Log;
import object.Ingredient;
import object.Product;

public class AddProductIngredientViewController implements Initializable{
	
	private Product product;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClean;

    @FXML
    private FlowPane pnIndex;

    @FXML
    private VBox pnLeft;

    @FXML
    private TextField txtSearch;
    
    
    public AddProductIngredientViewController() {
		this.product = DataSingleton.getInstance().getProduct();
	}

    //AÑADE EL OBJECTO A LA BASE DE DATOS
	@FXML
    void addObject(ActionEvent event) {
		Long id = new ProductDaoImpl().insert(product,DataSingleton.getInstance().getProductIngredients());
		if(id>0) {
			this.product.setId(id);
			DataSingleton.getInstance().setProduct(product);
			Utils.getUtils().closeView(btnAdd);
		}	
    }

	//LIMPIA EL FORMULARIO 
    @FXML
    void cleanForm(ActionEvent event) {
    	this.txtSearch.setText(null);
    	this.pnLeft.getChildren().clear();
    	DataSingleton.getInstance().setProductIngredients(new ArrayList<>());
    }

    //BUSCA UN OBJECTO EN BASE DE DATOS
    @FXML
    void searchObject(KeyEvent event) {
    	String search = this.txtSearch.getText();
    	List<Ingredient> ingredients = new IngredientDaoImpl().search(search);
    	this.pnIndex.getChildren().clear();
		for(Ingredient ingredient : ingredients) {
			this.addObject(ingredient);
		}
    }

    //AÑADE UN INGREDIENTE AL PANEL
    private void addObject(Ingredient ingredient){
    	if(product!=null) {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/components/ProductIngredientComponent.fxml"));
    		fxmlLoader.setController(new ProductIngredientComponentController(ingredient));
        	try {
    			pnIndex.getChildren().add(fxmlLoader.load());
    		} catch (IOException e) {
    			Log.getLogger(getClass()).error(e.getMessage());
    		}
    	}
    }
    
    //AÑADE UN BOTON DE CATEGORIA AL PANEL SUPERIOR
    /*private void addObject(Category category){
    	if(product!=null) {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/components/ButtonComponent.fxml"));
    		fxmlLoader.setController(new ButtonCategoryComponentController(category));
        	try {
    			pnTop.getChildren().add(fxmlLoader.load());
    		} catch (IOException e) {
    			Log.getLogger(getClass()).error(e.getMessage());
    		}
    	}
    }*/
    
    //CARGA LAS UNIDADES A LA VISTA
    private void loadObjects() {
    	//INGREDIENTES
		List<Ingredient> ingredients = new IngredientDaoImpl().getAll();
		for(Ingredient ingredient: ingredients) {
			this.addObject(ingredient);
		}
		//CATEGORIAS
		/*List<Category> categories = new CategoryDaoImpl().getAll();
		for(Category category : categories) {
			this.addObject(category);
		}*/
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		DataSingleton.getInstance().setPnAuxiliar(pnLeft);
		DataSingleton.getInstance().setPnIndex(pnIndex);
		this.loadObjects();
	}

}
