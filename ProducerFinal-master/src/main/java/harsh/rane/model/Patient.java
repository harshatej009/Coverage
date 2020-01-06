package harsh.rane.model;

public class Patient {

	private String id;
	private String name;
	private String surname;

	
	
	public Patient(String id, String name, String surname) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}
	
	
}
