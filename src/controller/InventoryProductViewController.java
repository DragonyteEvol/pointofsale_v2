package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.components.ProductComponentController;
import dao.ProductDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import log.Log;
import object.Product;

public class InventoryProductViewController implements Initializable{

    @FXML
    private Button btnAdd;

    @FXML
    private FlowPane pnIndex;

    @FXML
    private TextField txtSearch;

    //DESPLIEGA EL FORMULARIO DE CREACION DE TARGET
    @FXML
    void addObject(ActionEvent event) {
    	Utils.getUtils().changeView("/view/modal/AddProductView.fxml", true);
    	this.addObject(DataSingleton.getInstance().getProduct());
    }
    
    
    //CREA UN TABLE COMPONENENT EN LA VISTA
    private void addObject(Product product){
    	if(product!=null) {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/components/ProductComponent.fxml"));
    		fxmlLoader.setController(new ProductComponentController(product));
        	try {
    			pnIndex.getChildren().add(fxmlLoader.load());
    		} catch (IOException e) {
    			Log.getLogger(getClass()).error(e.getMessage());
    		}
    	}
    }
    
    //CARGA LAS MESAS CREADAS EN BASE DE DATOS EN LA VISTA
    private void loadObjects() {
		List<Product> products = new ProductDaoImpl().getAll();
		for(Product product: products) {
			this.addObject(product);	
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.loadObjects();
	}

}
