package controller.components;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import object.Product;

public class ProductComponentController implements Initializable{
	
	private Product product;
	
    public ProductComponentController(Product product) {
		this.product = product;
	}

    @FXML
    private Label lbCategory;

    @FXML
    private Hyperlink lbPrice;

    @FXML
    private Label lbProduct;

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
		this.lbProduct.setText(this.product.getProduct());
		this.lbPrice.setText(this.product.getPrice().toString());
		this.lbCategory.setText(this.product.getCategorie());
	}

}

