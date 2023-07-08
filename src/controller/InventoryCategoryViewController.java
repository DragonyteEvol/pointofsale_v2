package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.components.CategoryComponentController;
import dao.CategoryDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import log.Log;
import object.Category;

public class InventoryCategoryViewController implements Initializable{

    @FXML
    private Button btnAdd;

    @FXML
    private FlowPane pnIndex;

    @FXML
    private TextField txtSearch;

    @FXML
    void addObject(ActionEvent event) {
    	Utils.getUtils().changeView("/view/modal/AddCategoryView.fxml", true);
    	this.addObject(DataSingleton.getInstance().getCategory());
    }

    //CREA UNA UNIDAD EN LA VISTA
    private void addObject(Category category){
    	if(category!=null) {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/components/CategoryComponent.fxml"));
    		fxmlLoader.setController(new CategoryComponentController(category));
        	try {
    			pnIndex.getChildren().add(fxmlLoader.load());
    		} catch (IOException e) {
    			Log.getLogger(getClass()).error(e.getMessage());
    		}
    	}
    }
    
    //CARGA LAS UNIDADES A LA VISTA
    private void loadObjects() {
		List<Category> categories = new CategoryDaoImpl().getAll();
		for(Category category: categories) {
			this.addObject(category);
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.loadObjects();
	}

}