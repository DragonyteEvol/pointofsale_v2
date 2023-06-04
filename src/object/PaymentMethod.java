package object;

public class PaymentMethod {

	public Long id;
	public String payment_method;
	public Boolean phisical;
	public String created_at;
	
	public PaymentMethod() {
		super();
	}
	
	
	public PaymentMethod(Long id, String payment_method, Boolean phisical, String created_at) {
		super();
		this.id = id;
		this.payment_method = payment_method;
		this.phisical = phisical;
		this.created_at = created_at;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPayment_method() {
		return payment_method;
	}


	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
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
		return payment_method;
	}
	
	
	
}
