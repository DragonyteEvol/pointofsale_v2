package object;

public class Category {

	public Long id;
	public String categorie;
	public int target;
	public String created_at;
	
	public Category() {
		super();
	}

	public Category(Long id, String categorie, int target, String created_at) {
		super();
		this.id = id;
		this.categorie = categorie;
		this.target = target;
		this.created_at = created_at;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
	
	
}
