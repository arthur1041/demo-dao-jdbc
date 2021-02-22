package model.entities;

import java.io.Serializable;

public class Department extends Entity implements Serializable{

	private static final long serialVersionUID = 1L;

    private String name;

    public Department(){

    }

    public Department(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


	@Override
	public String toString() {
		return "Department [id=" + super.getId() + ", name=" + name + "]";
	}
    
    
}
