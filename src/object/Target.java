package object;

public class Target {
	public Long id;
	public String number;
	public Long capacity;
	public String description;
	public Long price;
	public Boolean room;
	public Boolean allocated;
	public String created_at;
	
	public Target() {
		super();
	}

	public Target(Long id, String number, Long capacity, String description, Long price, Boolean room,
			Boolean allocated, String created_at) {
		super();
		this.id = id;
		this.number = number;
		this.capacity = capacity;
		this.description = description;
		this.price = price;
		this.room = room;
		this.allocated = allocated;
		this.created_at = created_at;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCapacity() {
		return capacity;
	}

	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Boolean getRoom() {
		return room;
	}

	public void setRoom(Boolean room) {
		this.room = room;
	}

	public Boolean getAllocated() {
		return allocated;
	}

	public void setAllocated(Boolean allocated) {
		this.allocated = allocated;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Target [number=" + number + "]";
	}
	
	
	
}
