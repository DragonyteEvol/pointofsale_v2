package controller;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedAreaChart;

public class DashboardViewController {

    @FXML
    private LineChart<?, ?> chDaySell;

    @FXML
    private StackedAreaChart<?, ?> chEntryMoney;

    @FXML
    private StackedAreaChart<?, ?> chMovementMoney;

    @FXML
    private PieChart chPaymentMethod;

    @FXML
    private LineChart<?, ?> chPopulation;

    @FXML
    private PieChart chProductSell;

    @FXML
    private BarChart<?, ?> chWaiterSell;

}