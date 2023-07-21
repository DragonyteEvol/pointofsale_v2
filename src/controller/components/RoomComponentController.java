package controller.components;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import object.Target;

public class RoomComponentController implements Initializable{
	
	private Target target;
	
	public RoomComponentController(Target target) {
		this.target = target;
	}

	@FXML
    private MenuItem mnEdit;

    @FXML
    private MenuItem mnDelete;

    @FXML
    private MenuItem mnAddEvent;

    @FXML
    private Label lbTarget;

    @FXML
    private Label lbPrice;

    @FXML
    private Hyperlink btnSell;

    @FXML
    void addEvent(ActionEvent event) {

    }

    @FXML
    void deleteObject(ActionEvent event) {

    }

    @FXML
    void editObject(ActionEvent event) {

    }

    @FXML
    void sell(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initView();
	}
	
	private void initView() {
		this.lbTarget.setText("Habitacion " + target.getTarget().toString());
		this.lbPrice.setText(this.target.getPrice().toString());
	}

}
