package controller.components;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Utils;
import controller.modal.AddBillViewController;
import dao.BillDaoImpl;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import object.Bill;
import object.Target;

public class TableComponentController implements Initializable,Runnable{
	
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
    	Utils.getUtils().changeView("/view/modal/AddBillView.fxml",new AddBillViewController(target), true);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initView();
	}
	
	private void initView() {
		this.lbTarget.setText("Mesa " + target.getTarget().toString());
		//PRECIOS Y USUARIOS
		new Thread(this).start();
	}

	private void setStatus() {
		Bill bill = new BillDaoImpl().getByTarget(this.target.getId());
		if(bill==null) {
			Platform.runLater(() ->{
				btnSell.setText("Libre");
			});
		}else {
			Platform.runLater(() ->{
				btnSell.setText(bill.getTotal().toString());
			});
		}
	}
	
	@Override
	public void run() {
		this.setStatus();
	}

}
