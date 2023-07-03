package controller.modal;

import controller.DataSingleton;
import controller.Utils;
import dao.UnitDao;
import dao.UnitDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import object.Unit;

public class AddUnitViewController {
	
	private Unit unit;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClean;

    @FXML
    private TextField txtPrefix;

    @FXML
    private TextField txtUnit;

    @FXML
    void addObject(ActionEvent event) {
    	UnitDao unitDao = new UnitDaoImpl();
    	unitDao.insert(this.setObject());
    	Utils.getUtils().closeView(btnAdd);
    }

    @FXML
    void cleanForm(ActionEvent event) {
    	this.txtPrefix.setText(null);
    	this.txtUnit.setText(null);
    }
    
    private boolean validateForm(String unit,String prefix) {
    	if(unit.isBlank()) {
    		return false;
    	}
    	if(prefix.isBlank()) {
    		return false;
    	}
    	return true;
    }

    private Unit setObject() {
    	String unit = this.txtUnit.getText();
    	String prefix = this.txtPrefix.getText();
    	if(validateForm(unit, prefix)) {
    		this.unit= new Unit();
        	this.unit.setPrefix(prefix);
        	this.unit.setUnit(unit);
        	DataSingleton.getInstance().setUnit(this.unit);
    	}
    	return this.unit;
    }
}

