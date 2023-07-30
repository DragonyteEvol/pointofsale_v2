package controller.components;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import log.Log;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.DataSingleton;
import dao.ProductDaoImpl;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import object.Category;
import object.Product;

public class ButtonCategoryComponentController implements Initializable {
	
	private Category category;
	
    public ButtonCategoryComponentController(Category category) {
		this.category = category;
	}

	@FXML
    private Button btnAction;

    @FXML
    void runAction(ActionEvent event) {
    	DataSingleton.getInstance().getPnIndex().getChildren().clear();
    	List<Product> products = new ProductDaoImpl().searchByCategory(this.category.getId());
    	for(Product product : products) {
    		this.addObject(product);
    	}
    }
    
    private void addObject(Product product){
    	if(product!=null) {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/components/BillProductComponent.fxml"));
    		fxmlLoader.setController(new BillProductComponentController(product));
    		Platform.runLater(() -> {
    			try {
    				DataSingleton.getInstance().getPnIndex().getChildren().add(fxmlLoader.load());
    			} catch (IOException e) {
    				Log.getLogger(getClass()).error(e.getMessage());
    			}
    		});
    	}
    }
    
    private void initView() {
    	this.btnAction.setText(this.category.getCategorie());
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.initView();
	}
}