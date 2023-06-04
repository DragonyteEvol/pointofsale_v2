package object;

public class Product {

	public Long id;
	public String product;
	public Long price;
	public Long time;
	public Long categorie_id;
	public String categorie;
	public String created_at;
	
	public Product() {
		super();
	}
	
	
	public Product(Long id, String product, Long price, Long time, Long categorie_id, String categorie,
			String created_at) {
		super();
		this.id = id;
		this.product = product;
		this.price = price;
		this.time = time;
		this.categorie_id = categorie_id;
		this.categorie = categorie;
		this.created_at = created_at;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getProduct() {
		return product;
	}


	public void setProduct(String product) {
		this.product = product;
	}


	public Long getPrice() {
		return price;
	}


	public void setPrice(Long price) {
		this.price = price;
	}


	public Long getTime() {
		return time;
	}


	public void setTime(Long time) {
		this.time = time;
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


	public String getCreated_at() {
		return created_at;
	}


	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}


	@Override
	public String toString() {
		return product;
	}
	
	
	
}
