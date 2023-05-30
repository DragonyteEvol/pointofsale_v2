package object;

public class Category {

	public Long id;
	public String name;
	public int target;
	public String created_at;
	
	public Category() {
		super();
	}
	public Category(Long id, String name, int target, String created_at) {
		super();
		this.id = id;
		this.name = name;
		this.target = target;
		this.created_at = created_at;
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
	@Override
	public String toString() {
		return name;
	}
	
	
	
}
