
package Lib;
import java.util.Scanner;


import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Javalib {
	
	Scanner sc = new Scanner(System.in);
	//Class.forName("com.mysql.cj.jdbc.Driver");
	String Url = "jdbc:mysql://localhost:3306/emp";
	String username = "root";
	String password = "Nithish@123";
	Logger log=Logger.getLogger(Javalib.class);
	
	Connection con = null;
	
	int empid = 0;
   	String empName = "";
	double salary = 0;
	static int ce = 0;
	String Type="";
	
	public  void createemp() throws SQLException
	{
	
		PreparedStatement insertStatement=null;
		System.out.println("Enter Employee ID");// unique
		empid = sc.nextInt();
		System.out.println("Enter Employee Name");
		empName = sc.next();
		System.out.println("Enter Employee salary");
		salary = sc.nextDouble(); 
		System.out.println("Enter Employee Type");
		System.out.println(" contract  or permanent ");
		Type=sc.next();	
		
		    String sql = "INSERT INTO workers( ID,name,salary,type )" + "VALUES(?,?,?,?)";
		    insertStatement = con.prepareStatement(sql);
			insertStatement.setInt(1, empid);
			insertStatement.setString(2, empName);
			insertStatement.setDouble(3, salary);
			insertStatement.setString(4,Type);
			insertStatement.executeUpdate();
			insertStatement.close();
			System.out.println("successfully inserted");
			
			System.out.println("Select Employee any option:\n1.Contract Employee \n2.Permanent Employee ");
			int emp = sc.nextInt();
			if (emp == 1) {
				String str1 = "INSERT INTO contract_employee " + "VALUES(?,?)";// ID & period
				System.out.println("Enter Contract period : ");
				Double contperiod = sc.nextDouble();
				insertStatement = con.prepareStatement(str1);
				insertStatement.setInt(1, empid);
				insertStatement.setDouble(2, contperiod);
				insertStatement.executeUpdate();
			}
			 else if (emp == 2) {
			
				String str1 = "INSERT INTO permanent_employee " + "VALUES(?,?)";// ID & incentives
				System.out.println("Enter Incentives : ");
				Double incent = sc.nextDouble();
				insertStatement = con.prepareStatement(str1);
				insertStatement.setInt(1, empid);
				insertStatement.setDouble(2,incent);
				insertStatement.executeUpdate();
			 }
			 }
	

//	public void listemp() throws SQLException
//	{
//		PreparedStatement list = null;
//		ResultSet res=null;
//			con = DriverManager.getConnection(Url, username, password);
//		String st="select *from workers where ID";
//		list = con.prepareStatement(st);
//		res = list.executeQuery();
//		
//		while (res.next()) {
//			System.out.println("EmpID :" + res.getInt("ID"));
//		}
//		
//	}
	public void updateemp() throws SQLException
	{
		PreparedStatement updatestatement = null;
		ResultSet res=null;
		con = DriverManager.getConnection(Url, username, password);

		System.out.println("Enter Emp ID you want to update");
		int id = sc.nextInt();
		String str1 = "SELECT * FROM workers where ID=?";
		
		updatestatement = con.prepareStatement(str1);
		updatestatement.setInt(1, id);
		res = updatestatement.executeQuery();
		
		while (res.next()) 
		{
			System.out.println("1.EmpID :" + res.getInt("ID"));
			System.out.println("2.EmpName :" + res.getString("name"));
			System.out.println("3.Empsalary :" + res.getInt("salary"));
			System.out.println("3.Emptype :" + res.getString("type"));

			//String Type = res.getString("type");

			if (Type.equals("contract"))
			{
				String s1 = "select * from contract_employee where cempId=?";
				updatestatement = con.prepareStatement(s1);
				updatestatement.setInt(1, id);
				res = updatestatement.executeQuery();
				

				while (res.next()) {
					System.out.println("4.Contract period :" + res.getDouble("period"));
				}
			}
			
		else if (Type.equals("permanent")) 
		{
				String s1 = "select * from permanent_employee Where pempId=?";
				updatestatement = con.prepareStatement(s1);
				updatestatement.setInt(1, id);
				res = updatestatement.executeQuery();
				while (res.next()) {
					System.out.println("4. Incentives :" + res.getDouble("incentives"));
				}
		}
			}

			System.out.println("Enter choice which one you want to Update");
			System.out.println("\n1.name \n2.Salary \n3.Type");
			int select = sc.nextInt();
			if (select == 1) {
				System.out.println("Enter update name");
				String updName = sc.next();
				String st1 = "UPDATE workers SET name=? where ID=?";

				updatestatement = con.prepareStatement(st1);
				updatestatement.setString(1, updName);
				updatestatement.setInt(2, id);
				updatestatement.executeUpdate();
			
			}
			else if (select == 2) {
				System.out.println("Enter update salary");
				double Sal = sc.nextDouble();
				String s2 = "UPDATE workers SET salary=? where ID=?";
			
				updatestatement = con.prepareStatement(s2);
				updatestatement.setDouble(1, Sal);
				updatestatement.setInt(2, id);
				updatestatement.executeUpdate();
				updatestatement.close();
			}
			
			  else if ((select == 3)) {
				System.out.println("Enter the employee type 1. contract_employee ,2.permanent_employee");
				int t=sc.nextInt();
				if(t==1)
					{
						System.out.println("Enter Contract Period");
						double conttarctperiod = sc.nextDouble();
					 	String s3 = "Update contract_employee SET period=? where cempId=?";
						
						updatestatement = con.prepareStatement(s3);
						updatestatement.setDouble(1, conttarctperiod);
						updatestatement.setInt(2, id);
						updatestatement.executeUpdate();
						updatestatement.close();
						System.out.println("sucessfully updated");
						
				}
			 }
				 else {
					System.out.println("Enter Incentives");
					double Incentives = sc.nextDouble();
					String s4 = "Update permanent_employee SET incentives=? where pempId=?";
					updatestatement = con.prepareStatement(s4);
					updatestatement.setDouble(1, Incentives);
					updatestatement.setInt(2, id);
					updatestatement.executeUpdate();
					updatestatement.close();
					System.out.println("sucessfully updated");
				 }
			
			 }
			 
	public void deleteemp() throws SQLException
	{
		con = DriverManager.getConnection(Url, username, password);
			

			System.out.println("Enter the employee id to delete : ");
			int empi = sc.nextInt();
			String s="delete  from workers where ID=?";
			deleteStatement = con.prepareStatement(s);
			deleteStatement.setInt(1, empi);
			deleteStatement.executeUpdate();
			System.out.println("Succesfully deleted the employ id ");
	}
		
public void listemp() throws SQLException {
Statement statement =null;
	con = DriverManager.getConnection(Url, username, password);
	  statement = con.createStatement();
	 ResultSet resultset = statement.executeQuery("Select * from workers");
	JSONArray arr = new JSONArray();
	
	while (resultset.next()) {
		JSONObject record = new JSONObject();
		int emp = resultset.getInt("ID");
		String Name = resultset.getString("name");
		double Salary = resultset.getDouble("salary");
		String Type = resultset.getString("type");

		record.put("ID", emp);
		record.put("name", Name);
		record.put("salary", Salary);
		record.put("type", Type);
		arr.put(record);

	}
}
public static void main(String[] args) throws ClassNotFoundException, SQLException { 
	Javalib java=new Javalib();
	Scanner sc = new Scanner(System.in);
	String Url = "jdbc:mysql://localhost:3306/emp";
	String username = "root";
	String password = "Nithish@123";
	Class.forName("com.mysql.cj.jdbc.Driver");
     Connection	con = DriverManager.getConnection(Url, username, password); 
	System.out.println("Connection Established successfully");
    Logger log=Logger.getLogger(Javalib.class);
   
   System.out.println("Enter your choice : 1.Create 2.Modify 3.Delete 4.display: ");
	int c=sc.nextInt();
do {
	switch(c) {
	case 1:
		java.createemp();
		break;
	case 2:
		java.updateemp();
		break;
	case 3:
		java.deleteemp();
		break;
	case 4:
		java.listemp();
		break;
	}
	
System.out.println("1.continue 2.exit ");
int ce =sc.nextInt();
} while (ce == 1);
}
}

