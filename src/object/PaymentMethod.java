package object;

public class PaymentMethod {

	public Long id;
	public String name;
	public Boolean phisical;
	public String created_at;
	
	public PaymentMethod() {
		super();
	}
	
	public PaymentMethod(Long id, String name, Boolean phisical, String created_at) {
		super();
		this.id = id;
		this.name = name;
		this.phisical = phisical;
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
	public Boolean getPhisical() {
		return phisical;
	}
	public void setPhisical(Boolean phisical) {
		this.phisical = phisical;
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
