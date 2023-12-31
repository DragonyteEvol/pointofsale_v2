package object;

public class Inventory {

	public Long id;
	public Long ingredient_id;
	public String ingredient;
	public Long quantity;
	public Long minimum;
	public String unit;
	public Long unit_id;
	public String created_at;
	
	public Inventory() {
		super();
	}

	public Inventory(Long id, Long ingredient_id, String ingredient, Long quantity, Long minimum, String created_at) {
		super();
		this.id = id;
		this.ingredient_id = ingredient_id;
		this.ingredient = ingredient;
		this.quantity = quantity;
		this.minimum = minimum;
		this.created_at = created_at;
	}
	
	public Inventory(String ingredient, Long quantity,String unit,String created_at) {
		this.ingredient = ingredient;
		this.quantity = quantity;
		this.created_at = created_at;
		this.unit = unit;
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

	public Long getMinimum() {
		return minimum;
	}

	public void setMinimum(Long minimum) {
		this.minimum = minimum;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Long getUnit_id() {
		return unit_id;
	}

	public void setUnit_id(Long unit_id) {
		this.unit_id = unit_id;
	}
}
