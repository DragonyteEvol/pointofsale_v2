package controller.modal;

import java.net.URL;
import java.util.ResourceBundle;

import controller.DataSingleton;
import controller.Utils;
import dao.CategoryDaoImpl;
import dao.IngredientDao;
import dao.IngredientDaoImpl;
import dao.InventoryDao;
import dao.InventoryDaoImpl;
import dao.MovementInventoryDao;
import dao.MovementInventoryDaoImpl;
import dao.UnitDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import log.Log;
import object.Category;
import object.Ingredient;
import object.Inventory;
import object.MovementInventory;
import object.Unit;

public class AddIngredientViewController implements Initializable{
	
	private Ingredient ingredient;
	private Inventory inventory;
	private MovementInventory movementInventory;
	
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClean;

    @FXML
    private ComboBox<Category> cbCategory;
    
    @FXML
    private ComboBox<Unit> cbUnit;

    @FXML
    private CheckBox chAmenitie;

    @FXML
    private Spinner<Integer> spPrice;

    @FXML
    private Spinner<Double> spQuantity;
    
    @FXML
    private Spinner<Double> spQuantityMin;

    @FXML
    private TextField txtIngredient;

    @FXML
    void addObject(ActionEvent event) {
    	IngredientDao ingredientDao = new IngredientDaoImpl();
    	this.validateInsert(ingredientDao.insert(this.setObject()));
    	Utils.getUtils().closeView(btnAdd);
    }

    @FXML
    void cleanForm(ActionEvent event) {
    	this.txtIngredient.setText(null);
    }
    
  //ASIGNA EL OBJECTO CREADO EN UNA VARIABLE EN MEMORIA
  	private void validateInsert(Long id) {
  		if(id>0) {
  			Log.getLogger(getClass()).info("Ingrediente: " + this.ingredient.getIngredient() + " registrado correctamente en la base de datos");
  			this.ingredient.setId(id);
  			setRelations(id);
  			DataSingleton.getInstance().setIngredient(ingredient);
  		}
  	}
  	
  	//INSERTA LAS DEPENCIAS NECESARIAS DEL OBJECTO A BASE DE DATOS
  	private void setRelations(Long id) {
  		long quantity_min = spQuantityMin.getValue().longValue();
  		long quantity = spQuantity.getValue().longValue();
  		long unit_id = cbUnit.getSelectionModel().getSelectedItem().getId();
  		this.inventory = new Inventory();
  		this.inventory.setIngredient_id(id);
  		this.inventory.setMinimum(quantity_min);
  		this.inventory.setQuantity(quantity);
  		
  		//CREACION DE OBJECTOS
  		this.movementInventory = new MovementInventory();
  		this.movementInventory.setIngredient_id(id);
  		this.movementInventory.setAddition(quantity);
  		this.movementInventory.setQuantity(quantity);
  		this.movementInventory.setSubstraction(Long.valueOf(0));
  		this.movementInventory.setUnit_id(unit_id);
  		
  		InventoryDao inventoryDao = new InventoryDaoImpl();
  		MovementInventoryDao movementInventoryDao = new MovementInventoryDaoImpl();
  		//VALIDAR INSERCION DE DEPENDENCIAS
  		if(inventoryDao.insert(inventory)> 0 & movementInventoryDao.insert(movementInventory)>0) {
  			Log.getLogger(getClass()).info("Dependencias del ingrediente: " + this.ingredient.getIngredient() + " registradas correctamente en la base de datos");
  		}
  	}
  	
  	private boolean validateForm(Long unit_id,Long category_id, String ingredient,Long quantity, Long quantity_min) {
  		if(unit_id <= 0) {
  			return false;
  		}
  		if(category_id <=0) {
  			return false;
  		}
  		if(ingredient.isBlank()) {
  			return false;
  		}
  		if(quantity < 0) {
  			return false;
  		}
  		if(quantity < quantity_min) {
  			return false;
  		}
  		return true;
  	}
  	
  	//CREA UNA INSTANCIA DEL OBJECTO TARGET ASIGNA SUS RESPECTIVAS VARIABLES
      private Ingredient setObject() {
      	//EXTRACCION DE INFORMACION
      	long quantity = spQuantity.getValue().longValue();
      	long quantity_min = spQuantityMin.getValue().longValue();
      	long price = Long.parseLong(spPrice.getValue().toString());
      	String ingredient = this.txtIngredient.getText();
      	long unit_id = this.cbUnit.getSelectionModel().getSelectedItem().getId();
      	String unit = this.cbUnit.getSelectionModel().getSelectedItem().getUnit();
      	long category_id = this.cbCategory.getSelectionModel().getSelectedItem().getId();
      	String category = this.cbCategory.getSelectionModel().getSelectedItem().getCategorie();
      	boolean amenitie = this.chAmenitie.isSelected();
      	if(validateForm(unit_id, category_id, ingredient, quantity, quantity_min)) {
      		//ASIGNACION INGREDIENTE
      		this.ingredient = new Ingredient();
          	this.ingredient.setIngredient(ingredient);
          	this.ingredient.setCategorie_id(category_id);
          	this.ingredient.setUnit_id(unit_id);
          	this.ingredient.setPrice(price);
          	this.ingredient.setAmenitie(amenitie);
          	this.ingredient.setUnit(unit);
          	this.ingredient.setCategorie(category);
      	}
      	return this.ingredient;
      }
      
      private void initView() {
    	    //MODELOS
    	    SpinnerValueFactory<Double> spinnerFactoryQuantity = new SpinnerValueFactory.DoubleSpinnerValueFactory(0,Double.MAX_VALUE,0);
    	    SpinnerValueFactory<Double> spinnerFactoryQuantityMin = new SpinnerValueFactory.DoubleSpinnerValueFactory(0,Double.MAX_VALUE,0);
    	    SpinnerValueFactory<Integer> spinnerFactoryPrice = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,Integer.MAX_VALUE,0);
    	    ObservableList<Unit> listUnit = FXCollections.observableArrayList(new UnitDaoImpl().getAll());
    	    ObservableList<Category> listCategory = FXCollections.observableArrayList(new CategoryDaoImpl().getAll());
    	    //ASIGNACION DE MODELOS
    	    this.spQuantity.setValueFactory(spinnerFactoryQuantity);
    	    this.spPrice.setValueFactory(spinnerFactoryPrice);
    	    this.spQuantityMin.setValueFactory(spinnerFactoryQuantityMin);
    	    this.cbUnit.setItems(listUnit);
    	    this.cbCategory.setItems(listCategory);
      }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.initView();
	}
}

