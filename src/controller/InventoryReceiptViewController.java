package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InventoryReceiptViewController {

    @FXML
    private Button btnAcept;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClean;

    @FXML
    private VBox pnBill;

    @FXML
    private HBox pnIngredient;

    @FXML
    private TextField txtSearch;

    @FXML
    void exportSell(ActionEvent event) {

    }

}
