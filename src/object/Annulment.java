package object;

public class Annulment {

	public Long id;
	public String reason;
	public Long user_id;
	public String user;
	public Long product_id;
	public String product;
	public String quantity;
	public String created_at;
	
	public Annulment() {
		super();
	}
	public Annulment(Long id, String reason, Long user_id, String user, Long product_id, String product,
			String quantity, String created_at) {
		super();
		this.id = id;
		this.reason = reason;
		this.user_id = user_id;
		this.user = user;
		this.product_id = product_id;
		this.product = product;
		this.quantity = quantity;
		this.created_at = created_at;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
}
