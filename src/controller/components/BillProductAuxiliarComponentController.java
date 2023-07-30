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
import object.Product;

public class BillProductAuxiliarComponentController implements Initializable{
	
	private Product product;

    public BillProductAuxiliarComponentController(Object object) {
		this.product = (Product) object;
	}

	@FXML
    private Label lbProduct;

    @FXML
    private Label lbPrice;

    @FXML
    private Button btnDelete;

    @FXML
    private Label lbQuantity;
    
    @FXML
    private VBox pnIndex;

    @FXML
    void deleteObject(ActionEvent event) {
    	//ELIMINAR DE LISTA
    	List<Product> products = DataSingleton.getInstance().getBillProducts();
    	products.remove(this.product);
    	DataSingleton.getInstance().setBillProducts(products);
    	//ELIMINAR DE VISTA
    	DataSingleton.getInstance().getPnAuxiliar().getChildren().remove(this.pnIndex);
    }
    
    private void initView() {
    	this.lbProduct.setText(this.product.getProduct());
    	this.lbPrice.setText(this.product.getPrice().toString());
    	this.lbQuantity.setText(this.product.getQuantity().toString());
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.initView();
	}

}
