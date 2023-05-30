package object;

public class Ingredient {

	public Long id;
	public String name;
	public Long price;
	public Long unit_id;
	public String unit;
	public Long categorie_id;
	public String categorie;
	public Boolean amenitie;
	public String creted_at;
	
	public Ingredient() {
		super();
	}
	
	public Ingredient(Long id, String name, Long price, Long unit_id, String unit, Long categorie_id, String categorie,
			Boolean amenitie, String creted_at) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.unit_id = unit_id;
		this.unit = unit;
		this.categorie_id = categorie_id;
		this.categorie = categorie;
		this.amenitie = amenitie;
		this.creted_at = creted_at;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getCreted_at() {
		return creted_at;
	}
	public void setCreted_at(String creted_at) {
		this.creted_at = creted_at;
	}
	@Override
	public String toString() {
		return name;
	}
	
	
	
}
