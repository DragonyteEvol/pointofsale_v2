package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class IndexViewController {
	
	@FXML
    private MenuButton btnAccounting;

    @FXML
    private Button btnCalculator;

    @FXML
    private Button btnCashRegister;

    @FXML
    private Button btnConfig;

    @FXML
    private Button btnDashboard;

    @FXML
    private MenuButton btnInventory;

    @FXML
    private Button btnNotify;

    @FXML
    private MenuButton btnTrade;

    @FXML
    private MenuItem mnCash;

    @FXML
    private MenuItem mnExpense;

    @FXML
    private MenuItem mnIngredient;

    @FXML
    private MenuItem mnInventory;

    @FXML
    private MenuItem mnPaymentMethod;

    @FXML
    private MenuItem mnProduct;

    @FXML
    private MenuItem mnReceipt;

    @FXML
    private MenuItem mnReport;

    @FXML
    private MenuItem mnRoom;

    @FXML
    private MenuItem mnSell;

    @FXML
    private MenuItem mnTable;

    @FXML
    private MenuItem mnUnit;

    @FXML
    private BorderPane pnIndex;

    @FXML
    private Label txtPrivileges;

    @FXML
    private Hyperlink txtUser;
    
    @FXML
    void loadInventory(ActionEvent event) {
    	Object source = event.getSource();
    	if(source==mnInventory) {
    		loadPage("/view/InventoryView");
    	}
    }

    @FXML
    void loadAccounting(ActionEvent event) {
    	Object source = event.getSource();
    	if(source==this.mnSell) {
    		loadPage("/view/AccountingSellView");
    	}
    	if(source==this.mnExpense) {
    		loadPage("/view/AccountingCostView");
    	}
    	if(source==this.mnCash) {
    		loadPage("/view/AccountingMoneyView");
    	}
    	if(source==this.mnPaymentMethod) {
    		loadPage("/view/AccountingPaymentMethodView");
    	}
    }
    
    @FXML
    void loadTrade(ActionEvent event) {
    	Object source = event.getSource();
    	if(source==this.mnRoom) {
    		loadPage("/view/TradeRoomView");
    	}
    	if(source==this.mnTable) {
    		loadPage("/view/TradeTableView");
    	}
    }


    @FXML
    void loadConfig(ActionEvent event) {
    	loadPage("/view/ConfigView");
    }

    @FXML
    void loadDashboard(ActionEvent event) {
    	loadPage("/view/DashboardView");
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
