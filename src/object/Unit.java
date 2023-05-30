package object;

public class Unit {

	public Long id;
	public String name;
	public String prefix;
	public String created_at;
	
	public Unit() {
		super();
	}
	
	public Unit(Long id, String name, String prefix, String created_at) {
		super();
		this.id = id;
		this.name = name;
		this.prefix = prefix;
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
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	@Override
	public String toString() {
		return prefix;
	}
	
	
	
}
