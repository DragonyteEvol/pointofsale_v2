package object;

public class Inventory {

	public Long id;
	public Long ingredient_id;
	public String ingredient;
	public Long quanity;
	public Long minimum;
	public String created_at;
	
	public Inventory() {
		super();
	}
	
	public Inventory(Long id, Long ingredient_id, String ingredient, Long quanity, Long minimum, String created_at) {
		super();
		this.id = id;
		this.ingredient_id = ingredient_id;
		this.ingredient = ingredient;
		this.quanity = quanity;
		this.minimum = minimum;
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
	public Long getQuanity() {
		return quanity;
	}
	public void setQuanity(Long quanity) {
		this.quanity = quanity;
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
	
	
	
}