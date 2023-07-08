package controller.modal;

import controller.DataSingleton;
import controller.Utils;
import dao.CategoryDao;
import dao.CategoryDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import object.Category;

public class AddCategoryViewController {
	
	private Category category;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClean;

    @FXML
    private TextField txtCategory;

    @FXML
    void addObject(ActionEvent event) {
    	CategoryDao categoryDao = new CategoryDaoImpl();
    	this.validateInsert(categoryDao.insert(this.setObject()));
    	Utils.getUtils().closeView(btnAdd);
    }

    @FXML
    void cleanForm(ActionEvent event) {
    	this.txtCategory.setText(null);
    }
    
    private void validateInsert(Long id) {
    	if(id > 0) {
    		this.category.setId(id);
    		DataSingleton.getInstance().setCategory(category);
    	}
    }
    
    private boolean validateForm(String category) {
    	if(category.isBlank()) {
    		return false;
    	}
    	return true;
    }

    private Category setObject() {
    	String category = this.txtCategory.getText();
    	if(validateForm(category)) {
    		this.category = new Category();
    		this.category.setCategorie(category);
    	}
    	return this.category;
    }

}
