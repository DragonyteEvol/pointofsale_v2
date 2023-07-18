package controller;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import object.Category;
import object.Ingredient;
import object.Product;
import object.Target;
import object.Unit;

public class DataSingleton {
	
	private static DataSingleton instance;
	
	//DATA
	private Target target;
	private String string;
	private Unit unit;
	private Ingredient ingredient;
	private Category category;
	private Product product;
	private VBox pnAuxiliar;
	private FlowPane pnIndex;
	private List<Ingredient> productIngredients = new ArrayList<>();
	
	private DataSingleton() {
		super();
	}

	public static DataSingleton getInstance() {
		if(instance==null) {
			instance=new DataSingleton();
		}
		return instance;
	}

	public static void setInstance(DataSingleton instance) {
		DataSingleton.instance = instance;
	}

	public Target getTarget() {
		return target;
	}

	public void setTarget(Target target) {
		this.target = target;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public VBox getPnAuxiliar() {
		return pnAuxiliar;
	}

	public void setPnAuxiliar(VBox pnAuxiliar) {
		this.pnAuxiliar = pnAuxiliar;
	}

	public List<Ingredient> getProductIngredients() {
		return productIngredients;
	}

	public void setProductIngredients(List<Ingredient> productIngredients) {
		this.productIngredients = productIngredients;
	}

	public FlowPane getPnIndex() {
		return pnIndex;
	}

	public void setPnIndex(FlowPane pnIndex) {
		this.pnIndex = pnIndex;
	}
	
}
