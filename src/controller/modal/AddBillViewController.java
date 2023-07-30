package controller.modal;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.DataSingleton;
import controller.components.BillProductComponentController;
import controller.components.ButtonCategoryComponentController;
import dao.BillDaoImpl;
import dao.CategoryDaoImpl;
import dao.ProductDaoImpl;
import dao.UserDaoImpl;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import log.Log;
import object.Bill;
import object.Category;
import object.Product;
import object.Target;
import object.User;

public class AddBillViewController implements Initializable,Runnable{
	
	private Target target;
	
    public AddBillViewController(Target target) {
		this.target = target;
	}

	@FXML
    private Button btnBill;

    @FXML
    private TextField txtSearch;

    @FXML
    private HBox pnTop;

    @FXML
    private VBox pnLeft;

    @FXML
    private FlowPane pnIndex;

    @FXML
    private ComboBox<User> cbWaiter;

    @FXML
    private Button btnAdd;

    @FXML
    void addBill(ActionEvent event) {
    	Bill bill = new BillDaoImpl().getByTarget(this.target.getId());
    	List<Product> products = DataSingleton.getInstance().getBillProducts();
		if(bill==null) {
			 new BillDaoImpl().insert(this.setBill());
			 bill = new BillDaoImpl().getByTarget(this.target.getId());
		}
		for(Product product : products) {
			
		}
		
    }
    
    private Bill setBill() {
    	//EXTRACCION DE INFORMACION
    	User waiter = cbWaiter.getSelectionModel().getSelectedItem();
    	Bill bill = new Bill();
    	bill.setTarget_id(target.getId());
    	bill.setWaiter_id(waiter.getId());
    	//1 ACTIVE 0 DESACTIVE 2 DESACTIVE ACTIVE TO COURT
    	bill.setActive(1);
    	//PRECIO
    	List<Product> products = DataSingleton.getInstance().getBillProducts();
    	Long price = Long.valueOf(0);
    	for(Product product : products) {
    		price+=product.getPrice();
    	}
    	bill.setTotal(price);
    	return bill;
    }
    
    private void setProductBill(Product product) {

    }

    @FXML
    void addObject(ActionEvent event) {

    }

    @FXML
    void searchObject(KeyEvent event) {
    	String search = this.txtSearch.getText();
    	this.pnIndex.getChildren().clear();
    	List<Product> products = new ProductDaoImpl().search(search);
    	for(Product product : products) {
    		addObject(product);
    	}
    }
    
    private void addObject(Product product){
    	if(product!=null) {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/components/BillProductComponent.fxml"));
    		fxmlLoader.setController(new BillProductComponentController(product));
    		Platform.runLater(() -> {
    			try {
    				pnIndex.getChildren().add(fxmlLoader.load());
    			} catch (IOException e) {
    				Log.getLogger(getClass()).error(e.getMessage());
    			}
    		});
    	}
    }
    
    private void loadProducts() {
    	List<Product> products = new ProductDaoImpl().getAll();
    	for(Product product : products) {
    		addObject(product);
    	}
    }
    
    
    private void loadCategories() {
    	List<Category> categories = new CategoryDaoImpl().getAll();
    	for(Category category : categories) {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/components/ButtonComponent.fxml"));
    		fxmlLoader.setController(new ButtonCategoryComponentController(category));
    		Platform.runLater(() -> {
    			try {
    				pnTop.getChildren().add(fxmlLoader.load());
    			} catch (IOException e) {
    				Log.getLogger(getClass()).error(e.getMessage());
    			}
    		});
        		
    		
    	}
    }
    
    private void loadWaiters() {
    	ObservableList<User> waiters = FXCollections.observableArrayList(new UserDaoImpl().getAll());
    	cbWaiter.setItems(waiters);
    	cbWaiter.getSelectionModel().select(0);
    }
     
    private void initView() {
    	new Thread(this).start();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.initView();
		DataSingleton.getInstance().setPnAuxiliar(pnLeft);
		DataSingleton.getInstance().setPnIndex(pnIndex);
		DataSingleton.getInstance().setTarget(target);
	}

	@Override
	public void run() {
		this.loadProducts();
		this.loadCategories();
		this.loadWaiters();
	}

}
