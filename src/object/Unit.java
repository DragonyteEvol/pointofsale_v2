package object;

public class Unit {

	public Long id;
	public String unit;
	public String prefix;
	public String created_at;
	
	public Unit() {
		super();
	}
	
	
	public Unit(Long id, String unit, String prefix, String created_at) {
		super();
		this.id = id;
		this.unit = unit;
		this.prefix = prefix;
		this.created_at = created_at;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUnit() {
		return unit;
	}


	public void setUnit(String unit) {
		this.unit = unit;
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
