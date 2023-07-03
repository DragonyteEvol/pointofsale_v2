package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.components.UnitComponentController;
import dao.UnitDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import log.Log;
import object.Unit;

public class InventoryUnitViewController implements Initializable{

    @FXML
    private Button btnAdd;

    @FXML
    private FlowPane pnIndex;

    @FXML
    private TextField txtSearch;

    @FXML
    void addObject(ActionEvent event) {
    	Utils.getUtils().changeView("/view/modal/AddUnitView.fxml", true);
    	this.addObject(DataSingleton.getInstance().getUnit());
    }

    //CREA UNA UNIDAD EN LA VISTA
    private void addObject(Unit unit){
    	if(unit!=null) {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/components/UnitComponent.fxml"));
    		fxmlLoader.setController(new UnitComponentController(unit));
        	try {
    			pnIndex.getChildren().add(fxmlLoader.load());
    		} catch (IOException e) {
    			Log.getLogger(getClass()).error(e.getMessage());
    		}
    	}
    }
    
    //CARGA LAS UNIDADES A LA VISTA
    private void loadObjects() {
		List<Unit> units = new UnitDaoImpl().getAll();
		for(Unit unit: units) {
			this.addObject(unit);
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.loadObjects();
	}
}
