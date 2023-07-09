package object;

public class Ingredient {

	public Long id;
	public String ingredient;
	public Long price;
	public Long unit_id;
	public String unit;
	public Long categorie_id;
	public String categorie;
	public Boolean amenitie;
	public String created_at;
	
	public Ingredient() {
		super();
	}
	
	public Ingredient(Long id, String ingredient, Long price, Long unit_id, String unit, Long categorie_id,
			String categorie, Boolean amenitie, String creted_at) {
		super();
		this.id = id;
		this.ingredient = ingredient;
		this.price = price;
		this.unit_id = unit_id;
		this.unit = unit;
		this.categorie_id = categorie_id;
		this.categorie = categorie;
		this.amenitie = amenitie;
		this.created_at = creted_at;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
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

	public Long getCategorie_id() {
		return categorie_id;
	}

	public void setCategorie_id(Long categorie_id) {
		this.categorie_id = categorie_id;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Boolean getAmenitie() {
		return amenitie;
	}

	public void setAmenitie(Boolean amenitie) {
		this.amenitie = amenitie;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String creted_at) {
		this.created_at = creted_at;
	}

	@Override
	public String toString() {
		return ingredient;
	}
	
	
	
}
