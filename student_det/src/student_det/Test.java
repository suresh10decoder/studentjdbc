package student_det;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Test t=new Test();
		Connection c=new Connection();
		ArrayList<Student> someStudent = new ArrayList<Student>();
		char quit = 'Y';
	     int id;
	     String name;
	     float cgpa;
	     Scanner scan = new Scanner(System.in);

	     while(quit == 'Y'){
	         System.out.print("\n ID: ");
	         id=scan.nextInt();

	         System.out.print("\n Name: ");
	         name=scan.next();

	         System.out.print("\n CGPA: ");
	         cgpa=scan.nextFloat();
	         c.add(new Student(id,name,cgpa));//connection.
             someStudent.add (new Student(id, name, cgpa));
	         System.out.print(" Enter Another Record? (Y/N)");
	         String word = scan.next();
	         word = word.toUpperCase();
	         quit= word.charAt(0);
	     }
	     for(Student student:someStudent){
	         System.out.println(student.id);
	         System.out.println(student.name);
	         System.out.println(student.cgpa);
	         c.show(student);//connection
	     }
System.out.println("If you want any upadte student detail(Y/N)");
String wo = scan.next();
wo = wo.toUpperCase();
quit= wo.charAt(0);
while(quit == 'Y'){
			System.out.print("Select student by ID: ");
		int pickID = scan.nextInt();
		boolean found = false;
		for(Student s : someStudent) {
		    if(s.id == pickID && !found){
		        t.update(s);
		        System.out.println("If you want any upadte student detail(Y/N)");
		        String wol = scan.next();
		        wol = wol.toUpperCase();
		        quit= wol.charAt(0);
		        for(Student st:someStudent){
		        	c.show(st);
			         System.out.println(st.getId());
			         System.out.println(st.getName());
			         System.out.println(st.getCgpa());
			   
			     }
		     
		    
		    }
		
		    else {
		    System.out.println("No student with that ID.");
		}
		    
		}
		scan.close();
}
}
		
		public void update(Student s)
		{Connection c=new Connection();
			Scanner scan = new Scanner(System.in);
			ArrayList<Student> someStudent = new ArrayList<Student>();
			boolean edit = true;
		    while(edit){
		        System.out.println(String.format("Select operation:\n1. Change name\n2. Change ID\n3. Change CGPA\n4. Delete\n5. Done"));
		        int opt = scan.nextInt();
		        switch(opt){
		            case 1:
		                String newName = scan.next();
		                s.setName(newName);
		                c.modify(s);
		                break;
		            case 2:
		                int newID = scan.nextInt();
		                s.setId(newID);
		                c.modify1(s);
		                break;
		            case 3:
		                float newCGPA = scan.nextFloat();
		                s.setCgpa(newCGPA);
		                c.modify2(s);
		                break;
		            case 4:
		                for(int i=0;i<someStudent.size();i++){
		                    if(someStudent.get(i)==s){
		                        someStudent.remove(s);
		                        c.del(s);
		                    }
		                }
		                break;
		            case 5:
		                edit = false;
		                break;
		            default:
		                break;
		        }
		        
		    }
		    scan.close();
		}
	
}
		
    
