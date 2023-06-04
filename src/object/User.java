package object;

public class User {
	
	public Long id;
	public String user;
	public String mail;
	public String password;
	public Boolean admin;
	public String created_at;
	
	public User() {
		super();
	}
	
	
	public User(Long id, String user, String mail, String password, Boolean admin, String created_at) {
		super();
		this.id = id;
		this.user = user;
		this.mail = mail;
		this.password = password;
		this.admin = admin;
		this.created_at = created_at;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Boolean getAdmin() {
		return admin;
	}


	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}


	public String getCreated_at() {
		return created_at;
	}


	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}


	@Override
	public String toString() {
		return user;
	}
	
	
	
}
