package controller.modal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddTableViewController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClean;

    @FXML
    private Spinner<?> spCapacity;

    @FXML
    private Spinner<?> spPrice;

    @FXML
    private TextArea txtDescription;

    @FXML
    private TextField txtTarget;

    @FXML
    void addObject(ActionEvent event) {

    }

    @FXML
    void cleanForm(ActionEvent event) {
    	
    }

}
