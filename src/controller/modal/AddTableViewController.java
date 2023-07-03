package controller.modal;

import java.net.URL;
import java.util.ResourceBundle;

import controller.DataSingleton;
import controller.Utils;
import dao.TargetDao;
import dao.TargetDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import object.Target;

public class AddTableViewController implements Initializable{
	
	public Target target;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClean;
    
    //FACTORY
    SpinnerValueFactory<Integer> spinnerFactoryCapacity = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,20,0);

    SpinnerValueFactory<Integer> spinnerFactoryPrice = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,Integer.MAX_VALUE,0);

    @FXML
    private Spinner<Integer> spCapacity;

    @FXML
    private Spinner<Integer> spPrice;

    @FXML
    private TextArea txtDescription;

    @FXML
    private TextField txtTarget;
   

    @FXML
    void addObject(ActionEvent event) {
    	Object source = event.getSource();
    	//INSERTA EL TARGET EN BASE DE DATOS
    	if(source==this.btnAdd) {
    		this.setObject();
    		TargetDao targetDao = new TargetDaoImpl();
    		targetDao.insert(this.target);
    		Utils.getUtils().closeView(btnAdd);
    	}
    }

    @FXML
    void cleanForm(ActionEvent event) {
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.spCapacity.setValueFactory(spinnerFactoryCapacity);
		this.spPrice.setValueFactory(spinnerFactoryPrice);
	}
	
	//CREA UNA INSTANCIA DEL OBJECTO TARGET ASIGNA SUS RESPECTIVAS VARIABLES
    private void setObject() {
    	//EXTRACCION DE INFORMACION
    	long capacity = Long.parseLong(spCapacity.getValue().toString());
    	long price = Long.parseLong(spPrice.getValue().toString());
    	String description = this.txtDescription.getText();
    	Integer targetName =Integer.valueOf(this.txtTarget.getText());
    	//ASIGNACION
    	target = new Target();
    	target.setCapacity(capacity);
    	target.setPrice(price);
    	target.setTarget(targetName);
    	target.setDescription(description);
    	target.setRoom(false);
    	target.setAllocated(false);
    	DataSingleton.getInstance().setTarget(target);
    }

}