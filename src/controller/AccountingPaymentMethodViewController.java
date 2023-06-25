package controller;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;

public class AccountingPaymentMethodViewController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnPrint;

    @FXML
    private BarChart<?, ?> chPaymentMethod;

    @FXML
    private DatePicker dpEndDate;

    @FXML
    private DatePicker dpStartDate;

    @FXML
    private HBox pnPaymentMethod;

}
