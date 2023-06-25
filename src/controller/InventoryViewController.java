package controller;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class InventoryViewController {

    @FXML
    private PieChart chInventory;

    @FXML
    private VBox pnTop;

    @FXML
    private TableView<?> tbInventory;

    @FXML
    private TextField txtSearch;

}
