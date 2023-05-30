package object;

public class Event {
	public Long id;
	public String name;
	public Long price;
	public Boolean active;
	public String start_date;
	public String end_date;
	public String created_at;
	
	public Event() {
		super();
	}
	
	

	public Event(Long id, String name, Long price, Boolean active, String start_date, String end_date,
			String created_at) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.start_date = start_date;
		this.end_date = end_date;
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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}



	@Override
	public String toString() {
		return "Event [name=" + name + "]";
	}
	
	
	
}
