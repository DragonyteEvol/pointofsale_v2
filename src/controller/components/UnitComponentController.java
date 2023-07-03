package controller.components;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import object.Unit;

public class UnitComponentController implements Initializable{
	
	private Unit unit;
	
	public UnitComponentController(Unit unit) {
		this.unit = unit;
	}

    @FXML
    private Label lbPrefix;

    @FXML
    private Hyperlink lbUnit;

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
    
    private void initView() {
    	this.lbPrefix.setText(this.unit.getPrefix());
    	this.lbUnit.setText(this.unit.getUnit());
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.initView();
	}

}
