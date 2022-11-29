package Crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudTable
{

	public static void main(String[] args) throws SQLException, ClassNotFoundException 
	{

		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
			String Url= "jdbc:mysql://localhost:3306/emp"; 
			 String username = "root"; 
			 String password = "Nithish@123";
			 Connection con = DriverManager.getConnection(Url, username, password);
			 System.out.println("Connected");
			 Statement st = con.createStatement();
			 int id = 0;
			 String name = null;
			 int age = 0;
			 String gender = null;
			 String department = null;
			 int c=0;
			 int studentId=0;
			 do
			 {
			 System.out.println("Enter any option: \n1.Insert student \n2.Modify student data \n3.Delete student ");
			 int option=sc.nextInt();
			 switch(option)
			 {
			 case 1: 
				 	System.out.println("Enter Student StudID");//unique
					 id = sc.nextInt();
					System.out.println("Enter Student Name");
					 name = sc.next();
					System.out.println("Enter Student Age");
					 age=sc.nextInt();
					 System.out.println("Enter Gender");
					 gender=sc.next();
					 System.out.println("Enter Dept");
					 department=sc.next();
			 
					 String sql="INSERT INTO students( id,name, age, gender,department)" + "VALUES(?,?,?,?,?)";
					    PreparedStatement pst = con.prepareStatement(sql);
					    pst.setInt(1,id);
					    pst.setString(2, name);
					    pst.setInt(3, age);
					    pst.setString(4, gender);
					    pst.setString(5, department);
					    pst.executeUpdate();
					    System.out.println("successfully inserted");
					    break;
			 case 2:
				 
					System.out.println("Enter the student id ");
					studentId=sc.nextInt();
					String s = "SELECT * FROM students where id=?";
					PreparedStatement p=con.prepareStatement(s);
					p.setInt(1, studentId);
					ResultSet rs=p.executeQuery();
					while(rs.next())
					{
						System.out.println("1.StudID :"+rs.getInt("id"));
						System.out.println("2.Name :"+rs.getString("name"));
						System.out.println("3.Age :"+rs.getInt("age"));
						System.out.println("4.Gender:"+rs.getString("gender"));
						System.out.println("5.Dept:"+rs.getString("department"));
					}
					
					System.out.println("Enter all Update fileds ");
					String str= "Update  students SET name=?,age=?,gender=?,department=? where id=? ";
					PreparedStatement stat = con.prepareStatement(str);
		
					System.out.println("update Student Name");
					 name = sc.next();
					 
					System.out.println("update Student Age");
					 age=sc.nextInt();
					 System.out.println("update Gender");
					 gender=sc.next();
					 System.out.println("update Dept");
					 department=sc.next();
					    stat.setString(1, name);
					    stat.setInt(2, age);
					    stat.setString(3, gender);
					    stat.setString(4, department);
					    stat.setInt(5, 5);
					    stat.executeUpdate();
					    System.out.println("Successfully updated id "+ id);
				 
					    break;
				 
					
					
					/*System.out.println("Enter choice which one you want to Update");
					System.out.println("\n1.name \n2.age \n3.gender \n4.department");
					int select=sc.nextInt();
					if(select==1) 
					{	
					String s1="UPDATE students SET name='?' where id=?";
				    PreparedStatement ps = con.prepareStatement(s1);
				    ps.setString(1, name);
				    ps.setInt(2, studentId);
				    ps.executeUpdate();
					}
					else if(select==2)
					{
						String s2="UPDATE students SET age='?' where id=?";
						PreparedStatement ps = con.prepareStatement(s2);
						ps.setInt(1, age);
						ps.setInt(2, studentId);
						ps.executeUpdate();
					}
					else if(select==3)
					{
						String s3="Update students SET gender='?' where id=?";
						PreparedStatement ps = con.prepareStatement(s3);
						ps.setString(1, gender);
						ps.setInt(2, studentId);
						ps.executeUpdate();
					}
					else
					{
						String s4="UPDATE students SET department='?' where id=?";
						PreparedStatement ps = con.prepareStatement(s4);
						ps.setString(1, department);
						ps.setInt(2, studentId);
						ps.executeUpdate();
					}
					break;
					*/
			 case 3:
				 System.out.println("Enter the employee id ");
				 studentId=sc.nextInt();
					PreparedStatement ps=con.prepareStatement("delete from students where id=?");
					ps.setInt(1, studentId);
				ps.executeUpdate();
				System.out.println("Succesfully Deleted "+studentId);
			 
			 break;
	
			 default:
				 System.out.println("Invalid");
			 }
	System.out.println("1.continue 2.exit ");
	c=sc.nextInt();
			 }
			 while (c == 1);
			 }
}

			 

						
		
						
	
						
			
				 
			
		



	

	

