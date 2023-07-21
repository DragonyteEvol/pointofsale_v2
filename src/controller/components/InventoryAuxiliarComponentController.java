package controller.components;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import object.Inventory;

public class InventoryAuxiliarComponentController implements Initializable{
	
	private Inventory inventory;
	
    public InventoryAuxiliarComponentController(Inventory inventory) {
		this.inventory = inventory;
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

    @FXML
    void deleteObject(ActionEvent event) {
    	
    }

    private void initView() {
    	this.lbIngredient.setText(this.inventory.getIngredient());
    	this.lbQuantity.setText(this.inventory.getQuantity().toString());
    	this.lbUnit.setText(this.inventory.getUnit());
    	this.btnDelete.setVisible(false);
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.initView();
	}
}


