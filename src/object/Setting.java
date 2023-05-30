package object;

public class Setting {
	public Long id;
	public String nit;
	public String name;
	public String address;
	public String phone;
	public Long default_tip;
	public String cash_password;
	public String created_at;
	
	public Setting() {
		super();
	}

	public Setting(Long id, String nit, String name, String address, String phone, Long default_tip,
			String cash_password, String created_at) {
		super();
		this.id = id;
		this.nit = nit;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.default_tip = default_tip;
		this.cash_password = cash_password;
		this.created_at = created_at;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getDefault_tip() {
		return default_tip;
	}

	public void setDefault_tip(Long default_tip) {
		this.default_tip = default_tip;
	}

	public String getCash_password() {
		return cash_password;
	}

	public void setCash_password(String cash_password) {
		this.cash_password = cash_password;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
	
}
