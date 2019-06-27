
package student_det;
public class Student {
	
	public int id;
    public String name;
    public float cgpa;
    

    public Student(int id,String name,float cgpa){
        this.id=id;
        this.name=name;
        this.cgpa=cgpa;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCgpa() {
		return cgpa;
	}

	public void setCgpa(float cgpa) {
		this.cgpa = cgpa;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", cgpa=" + cgpa + "]";
	}
    
    
}