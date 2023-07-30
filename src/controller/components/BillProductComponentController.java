package controller.components;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import controller.DataSingleton;
import controller.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import object.Product;

public class BillProductComponentController implements Initializable{
	
	private Product product;
	
    public BillProductComponentController(Product product) {
		this.product = product;
	}

	@FXML
    private Label lbProduct;

    @FXML
    private Hyperlink lbPrice;

    @FXML
    private Label lbCategory;

    @FXML
    void addObject(ActionEvent event) {
    	this.addToList(Long.valueOf(1));
    	this.addToView();
    }
    
    private void addToView() {
    	DataSingleton.getInstance().getPnAuxiliar().getChildren().clear();
    	List<Product> products = DataSingleton.getInstance().getBillProducts();
    	for(Product product : products) {
    			Utils.getUtils().addObject(
				"/view/components/BillProductAuxiliarComponent.fxml",
				new BillProductAuxiliarComponentController(product), 
				DataSingleton.getInstance().getPnAuxiliar());
    	}
    }
    
    
    
    private void addToList(Long quantity) {
    	List<Product> billProducts = DataSingleton.getInstance().getBillProducts();
    	List<Product> billProductsNew = new ArrayList<>();
    	for(Product product: billProducts) {
    		if(product.getId()!=this.product.getId()) {
    			billProductsNew.add(product);
    		}else {
    			quantity += product.getQuantity();
    		}
    	}
    	this.product.setQuantity(quantity);
    	billProductsNew.add(this.product);
    	DataSingleton.getInstance().setBillProducts(billProductsNew);
    }
    
    private void initView() {
    	this.lbProduct.setText(this.product.getProduct());
    	this.lbPrice.setText(this.product.getPrice().toString());
    	this.lbCategory.setText(this.product.getCategorie());
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.initView();
	}

}
