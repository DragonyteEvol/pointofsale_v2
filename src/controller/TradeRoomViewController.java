package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.components.RoomComponentController;
import controller.components.TableComponentController;
import dao.TargetDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import log.Log;
import object.Target;

public class TradeRoomViewController implements Initializable{

    @FXML
    private Button btnAdd;

    @FXML
    private FlowPane pnIndex;

    @FXML
    void addObject(ActionEvent event) {
    	Utils.getUtils().changeView("/view/modal/AddRoomView.fxml", true);
    	this.addObject(DataSingleton.getInstance().getTarget());
    }
 
    //CREA UN TABLE COMPONENENT EN LA VISTA
    private void addObject(Target target){
    	if(target!=null) {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/components/RoomComponent.fxml"));
    		fxmlLoader.setController(new RoomComponentController(target));
        	try {
    			pnIndex.getChildren().add(fxmlLoader.load());
    		} catch (IOException e) {
    			Log.getLogger(getClass()).error(e.getMessage());
    		}
    	}
    }
    
    //CARGA LAS MESAS CREADAS EN BASE DE DATOS EN LA VISTA
    private void loadObjects() {
		List<Target> targets = new TargetDaoImpl().getAll();
		for(Target target: targets) {
			//VALIDACION DE MESA
			if(target.getRoom()) {
				this.addObject(target);
			}
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.loadObjects();
	}
}
