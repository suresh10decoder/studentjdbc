package student_det;
import java.sql.*;
import java.util.*;
public class Connection 
{ 
	public java.sql.Connection con;
public  Connection()
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students?useSSL=false","root","10@Decoders");
}catch(Exception e)
	{
	System.out.println(e);
	}
}
	public void add(Student stu)
	{
		try
		{
			String query = " insert into list (ID, Name, Cgpa)"
		  	        + " values (?, ?, ? )";
	         PreparedStatement pStmt = con.prepareStatement(query);
		  	      pStmt.setInt (1, stu.getId());
		  	      pStmt.setString (2, stu.getName());
		  	      pStmt.setFloat(3, stu.getCgpa());
		  	      pStmt.execute();
		      
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception!");
		      System.err.println(e.getMessage());
		    }
	}
	
	public void show(Student stu)
	{
		try
	    {
			
	      String query = "SELECT * FROM list";
	      PreparedStatement pStmt =con.prepareStatement(query);
	      ResultSet rs = pStmt.executeQuery();
	      while (rs.next())
	      {
	         rs.getInt(stu.getId());
	         rs.getString(stu.getName());
	        rs.getFloat((int) stu.getCgpa());
	        
	        System.out.format("%s, %s, %s, \n", 1, 2, 3);
	      }
	 
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
	  }
	public void modify(Student stu)
	{
		try
	    {
             PreparedStatement ps=con.prepareStatement("update list"+" set name=?"+" where Id=?");  
             ps.setString (2, stu.getName());
             ps.executeUpdate(); 
             System.out.println(" records updated");
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
	    }
		public void modify1(Student stu)
		{
			try
			{
	             PreparedStatement ps1=con.prepareStatement("update list"+" set Id=?"+" where Id=?"); 
	             ps1.setInt (1, stu.getId());
	             ps1.executeUpdate();
	             System.out.println(" records updated");
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }
		    }
			public void modify2(Student stu)
			{
				try
			    {
		             PreparedStatement ps=con.prepareStatement("update list "+"set cgpa=?"+" where Id=?");
		             ps.setFloat(3, stu.getCgpa());
		             ps.executeUpdate();
		    		  System.out.println(" records updated");
			    }
			    catch (Exception e)
			    {
			      System.err.println("Got an exception! ");
			      System.err.println(e.getMessage());
			    }
	}
	public void del(Student stu) {
		Scanner sc=new Scanner(System.in);
		try
	    {
		

				PreparedStatement ps=con.prepareStatement("delete from list"+" where id=?");  

				System.out.println("enter student id");
				ps.setInt(1,sc.nextInt());  
				  
				ps.executeUpdate();  
				con.close();
				sc.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
	}
	public static void main(String[] args)
	{
		
	}
	}