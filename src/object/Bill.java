package object;

public class Bill {
	public Long id;
	public Long target_id;
	public String target;
	public Long waiter_id;
	public String waiter;
	public Long user_id;
	public String user;
	public Long discount;
	public Long tip;
	public Long total;
	public Long event_id;
	public String event;
	public Boolean courtesy;
	public Integer active;
	public Boolean restock;
	public String created_at;
	
	//CAMPOS DE UNION
	public String product;
	public Long quantity;
	public Long subvalue;
	public String ingredient;
	
	public Bill() {
		super();
	}
	
	public Bill(Long id, Long target_id, String target, Long waiter_id, String waiter, Long user_id, String user,
			Long discount, Long tip, Long total, Long event_id, String event, Boolean courtesy, Integer active,
			Boolean restock, String created_at) {
		super();
		this.id = id;
		this.target_id = target_id;
		this.target = target;
		this.waiter_id = waiter_id;
		this.waiter = waiter;
		this.user_id = user_id;
		this.user = user;
		this.discount = discount;
		this.tip = tip;
		this.total = total;
		this.event_id = event_id;
		this.event = event;
		this.courtesy = courtesy;
		this.active = active;
		this.restock = restock;
		this.created_at = created_at;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTarget_id() {
		return target_id;
	}
	public void setTarget_id(Long target_id) {
		this.target_id = target_id;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public Long getWaiter_id() {
		return waiter_id;
	}
	public void setWaiter_id(Long waiter_id) {
		this.waiter_id = waiter_id;
	}
	public String getWaiter() {
		return waiter;
	}
	public void setWaiter(String waiter) {
		this.waiter = waiter;
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
	public Long getDiscount() {
		return discount;
	}
	public void setDiscount(Long discount) {
		this.discount = discount;
	}
	public Long getTip() {
		return tip;
	}
	public void setTip(Long tip) {
		this.tip = tip;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Long getEvent_id() {
		return event_id;
	}
	public void setEvent_id(Long event_id) {
		this.event_id = event_id;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public Boolean getCourtesy() {
		return courtesy;
	}
	public void setCourtesy(Boolean courtesy) {
		this.courtesy = courtesy;
	}
	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Boolean getRestock() {
		return restock;
	}
	public void setRestock(Boolean restock) {
		this.restock = restock;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getSubvalue() {
		return subvalue;
	}
	public void setSubvalue(Long subvalue) {
		this.subvalue = subvalue;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	
	
}
