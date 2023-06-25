package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class AccountingMoneyViewController {

    @FXML
    private Button btnExport;

    @FXML
    private Button btnGenerateCut;

    @FXML
    private BarChart<?, ?> chMoney;

    @FXML
    private DatePicker dpEndDate;

    @FXML
    private DatePicker dpStartDate;

    @FXML
    private Label lbDaySell;

    @FXML
    private Label lbMonthSell;

    @FXML
    private Label lbYearSell;

    @FXML
    private TableView<?> tbCost;

    @FXML
    void exportSell(ActionEvent event) {

    }

}
