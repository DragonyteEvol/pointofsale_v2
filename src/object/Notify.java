package object;

public class Notify {

	public Long id;
	public Long ingredient_id;
	public String ingredient;
	public Boolean notify;
	public String create_at;
	
	public Notify() {
		super();
	}
	
	public Notify(Long id, Long ingredient_id, String ingredient, Boolean notify, String create_at) {
		super();
		this.id = id;
		this.ingredient_id = ingredient_id;
		this.ingredient = ingredient;
		this.notify = notify;
		this.create_at = create_at;
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
	public Boolean getNotify() {
		return notify;
	}
	public void setNotify(Boolean notify) {
		this.notify = notify;
	}
	public String getCreate_at() {
		return create_at;
	}
	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}
	@Override
	public String toString() {
		return ingredient;
	}
	
	
	
	
}
