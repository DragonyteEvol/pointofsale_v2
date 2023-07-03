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

public class TableComponentController implements Initializable{
	
	private Target target;
	
	public TableComponentController(Target target) {
		this.target = target;
	}

    @FXML
    private Hyperlink btnSell;

    @FXML
    private Label lbTarget;

    @FXML
    private MenuItem mnAddEvent;

    @FXML
    private MenuItem mnDelete;

    @FXML
    private MenuItem mnEdit;

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
		this.lbTarget.setText("Mesa " + target.getTarget().toString());
	}

}
