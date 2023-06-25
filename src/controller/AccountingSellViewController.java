package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BubbleChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class AccountingSellViewController {

    @FXML
    private Button btnExport;

    @FXML
    private CheckBox cbRealPrice;

    @FXML
    private BubbleChart<?, ?> chSell;

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
    private TableView<?> tbSell;

    @FXML
    void exportSell(ActionEvent event) {

    }

}
