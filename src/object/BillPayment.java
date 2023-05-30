package object;

public class BillPayment {

	public Long id;
	public Long bill_id;
	public Long payment_method_id;
	public String payment_method;
	public Long price;
	public String created_at;
	
	public BillPayment() {
		super();
	}
	
	public BillPayment(Long id, Long bill_id, Long payment_method_id, String payment_method, Long price,
			String created_at) {
		super();
		this.id = id;
		this.bill_id = bill_id;
		this.payment_method_id = payment_method_id;
		this.payment_method = payment_method;
		this.price = price;
		this.created_at = created_at;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getBill_id() {
		return bill_id;
	}
	public void setBill_id(Long bill_id) {
		this.bill_id = bill_id;
	}
	public Long getPayment_method_id() {
		return payment_method_id;
	}
	public void setPayment_method_id(Long payment_method_id) {
		this.payment_method_id = payment_method_id;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
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
