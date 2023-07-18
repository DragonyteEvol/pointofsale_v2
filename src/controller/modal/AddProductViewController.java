package controller.modal;

import java.net.URL;
import java.util.ResourceBundle;

import controller.DataSingleton;
import controller.Utils;
import dao.CategoryDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import object.Category;
import object.Product;

public class AddProductViewController implements Initializable{
	
	private Product product;

    @FXML
    private Button btnClean;

    @FXML
    private Button btnAdd;

    @FXML
    private ComboBox<Category> cbCategory;

    @FXML
    private Spinner<Double> spPrice;

    @FXML
    private Spinner<Integer> spTime;

    @FXML
    private TextField txtProduct;

    @FXML
    void cleanForm(ActionEvent event) {
    	this.txtProduct.setText(null);
    }

    //DEPLIEGA EL FORMULARIO
    @FXML
    void addObject(ActionEvent event) {
    	DataSingleton.getInstance().setProduct(this.setObject());
    	Utils.getUtils().changeView("/view/modal/AddProductIngredientView.fxml", true);
    	Utils.getUtils().closeView(btnAdd);
    }
    
    private boolean validateForm(String product,Long price,Long categorie_id) {
  		if(product.isBlank()) {
  			return false;
  		}
  		if(price <= 0) {
  			return false;
  		}
  		if(categorie_id==null) {
  			return false;
  		}
  		return true;
  	}
    
  //CREA UNA INSTANCIA DEL OBJECTO TARGET ASIGNA SUS RESPECTIVAS VARIABLES
    private Product setObject() {
    	//EXTRACCION DE INFORMACION
    	String product = this.txtProduct.getText();
    	Long time = this.spTime.getValue().longValue();
    	Long price = this.spPrice.getValue().longValue();
    	Long categorie_id = this.cbCategory.getSelectionModel().getSelectedItem().getId();
    	String categorie = this.cbCategory.getSelectionModel().getSelectedItem().getCategorie();
    	if(validateForm(product, price, categorie_id)) {
    		//ASIGNACION
    		this.product = new Product();
    		this.product.setCategorie(categorie);
    		this.product.setCategorie_id(categorie_id);
    		this.product.setPrice(price);
    		this.product.setProduct(product);
    		this.product.setTime(time);
    	}
    	return this.product;
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.initView();
	}
	
	private void initView() {
		SpinnerValueFactory<Double> spinnerValueFactoryPrice = new SpinnerValueFactory.DoubleSpinnerValueFactory(0, Double.MAX_VALUE,0);
		SpinnerValueFactory<Integer> spinnerValueFactoryTime = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE,0);
		ObservableList<Category> listCategory = FXCollections.observableArrayList(new CategoryDaoImpl().getAll());
		
		this.spPrice.setValueFactory(spinnerValueFactoryPrice);
		this.spTime.setValueFactory(spinnerValueFactoryTime);
		this.cbCategory.setItems(listCategory);
	}

}