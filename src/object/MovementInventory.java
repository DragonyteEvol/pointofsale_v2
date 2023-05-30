package object;

public class MovementInventory {

	public Long id;
	public Long ingredient_id;
	public String ingredient;
	public Long quantity;
	public Long addition;
	public Long substraction;
	public Long unit_id;
	public String unit;
	public String created_at;
	
	public MovementInventory() {
		super();
	}
	
	public MovementInventory(Long id, Long ingredient_id, String ingredient, Long quantity, Long addition,
			Long substraction, Long unit_id, String unit, String created_at) {
		super();
		this.id = id;
		this.ingredient_id = ingredient_id;
		this.ingredient = ingredient;
		this.quantity = quantity;
		this.addition = addition;
		this.substraction = substraction;
		this.unit_id = unit_id;
		this.unit = unit;
		this.created_at = created_at;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIngredient_id() {
		return ingredient_id;
	}
	public void setIngredient_id(Long ingredient_id) {
		this.ingredient_id = ingredient_id;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getAddition() {
		return addition;
	}
	public void setAddition(Long addition) {
		this.addition = addition;
	}
	public Long getSubstraction() {
		return substraction;
	}
	public void setSubstraction(Long substraction) {
		this.substraction = substraction;
	}
	public Long getUnit_id() {
		return unit_id;
	}
	public void setUnit_id(Long unit_id) {
		this.unit_id = unit_id;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
	
	
}
