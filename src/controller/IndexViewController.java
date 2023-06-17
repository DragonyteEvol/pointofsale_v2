package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class IndexViewController {

	@FXML
    private Button btnAccounting;

    @FXML
    private Button btnCalculator;

    @FXML
    private Button btnCashRegister;

    @FXML
    private Button btnConfig;

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnInventory;

    @FXML
    private Button btnNotify;

    @FXML
    private Button btnTrade;

    @FXML
    private BorderPane pnIndex;

    @FXML
    private Label txtPrivileges;

    @FXML
    private Hyperlink txtUser;

    @FXML
    void loadAccounting(ActionEvent event) {

    }

    @FXML
    void loadConfig(ActionEvent event) {

    }

    @FXML
    void loadDashboard(ActionEvent event) {
    	loadPage("/view/DashboardView");
    }

    @FXML
    void loadInventory(ActionEvent event) {

    }

    @FXML
    void loadTrade(ActionEvent event) {

    }

    @FXML
    void openCashRegister(ActionEvent event) {

    }

    @FXML
    void showCalculator(ActionEvent event) {

    }

    @FXML
    void showNotify(ActionEvent event) {

    }

    // Carga una pagina en el panel principal
	private void loadPage(String page) {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource(page+".fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pnIndex.setCenter(root);
	}
}
