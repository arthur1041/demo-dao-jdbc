package model.entities;

import java.io.Serializable;
import java.util.Date;

public class Seller extends Entity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private Date birthDate;
	private Double baseSalary;
	
	private Department department;
	
	public Seller() {
		
	}

	public Seller(Integer id, String name, String email, Date birthDate, Double baseSalary, Department department) {
		super(id);
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}


	@Override
	public String toString() {
		return "Seller [id=" + super.getId() + ", name=" + name + ", email=" + email + ", birthDate=" + birthDate + ", baseSalary="
				+ baseSalary + ", department=" + department + "]";
	}
	
}
