package object;

public class MovementCash {

	public Long id;
	public Long entry;
	public Long out;
	public Long required;
	public Long user_id;
	public String user;
	public String created_at;
	
	public MovementCash() {
		super();
	}
	
	public MovementCash(Long id, Long entry, Long out, Long required, Long user_id, String user, String created_at) {
		super();
		this.id = id;
		this.entry = entry;
		this.out = out;
		this.required = required;
		this.user_id = user_id;
		this.user = user;
		this.created_at = created_at;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEntry() {
		return entry;
	}
	public void setEntry(Long entry) {
		this.entry = entry;
	}
	public Long getOut() {
		return out;
	}
	public void setOut(Long out) {
		this.out = out;
	}
	public Long getRequired() {
		return required;
	}
	public void setRequired(Long required) {
		this.required = required;
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
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
	
	
}
