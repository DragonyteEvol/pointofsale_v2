package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.components.InventoryAuxiliarComponentController;
import dao.InventoryDaoImpl;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import log.Log;
import object.Inventory;

public class InventoryViewController implements Initializable,Runnable{
	
	private List<Inventory> inventories;

    @FXML
    private PieChart chInventory;

    @FXML
    private VBox pnTop;

    @FXML
    private TableView<Inventory> tbInventory;
    
    @FXML
    private TableColumn<Inventory, String> colIngredient;

    @FXML
    private TableColumn<Inventory, Long> colQuantity;

    @FXML
    private TableColumn<Inventory, String> colUnit;

    @FXML
    private TableColumn<Inventory, String> colDate;

    @FXML
    private TextField txtSearch;
    
    

    
  //BUSCA UN OBJECTO EN BASE DE DATOS
    @FXML
    void searchObject(KeyEvent event) {
    	
    }
    
    ObservableList<Inventory> dataTable = FXCollections.observableArrayList();
    ObservableList<PieChart.Data> dataPieChart = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		new Thread(this).start();
	}
	
	private void loadTable() {
		this.colDate.setCellValueFactory(new PropertyValueFactory<Inventory, String>("created_at"));
		this.colIngredient.setCellValueFactory(new PropertyValueFactory<Inventory, String>("ingredient"));
		this.colUnit.setCellValueFactory(new PropertyValueFactory<Inventory, String>("unit"));
		this.colQuantity.setCellValueFactory(new PropertyValueFactory<Inventory, Long>("quantity"));
		dataTable.addAll(inventories);
		Platform.runLater(() ->{
			tbInventory.setItems(dataTable);
		});
		
	}

	private void loadChart() {
		for(int i =0;i<10;i++) {
			try {
				Inventory inventory = inventories.get(i);
				dataPieChart.add(new PieChart.Data(inventory.getIngredient(), inventory.getQuantity()));
			}catch(Exception e) {
				Log.getLogger(getClass()).warn(e.getMessage());
			}	
		}
		Platform.runLater(() ->{
			chInventory.getData().addAll(dataPieChart);
		});
	}
	
	private void loadTop() {
		for(int i =0;i<10;i++) {
			try {
				Inventory inventory = inventories.get(i);
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/components/ProductIngredientAuxiliarComponent.fxml"));
	    		fxmlLoader.setController(new InventoryAuxiliarComponentController(inventory));
	    		Platform.runLater(() ->{
	    			try {
						this.pnTop.getChildren().add(fxmlLoader.load());
					} catch (IOException e) {
						e.printStackTrace();
					}
	    		});
			}catch(Exception e) {
				Log.getLogger(getClass()).warn(e.getMessage());
			}	
		}
	}

	@Override
	public void run() {
		this.inventories = new InventoryDaoImpl().getAll();
		this.loadChart();
		this.loadTable();
		this.loadTop();
	}
}
