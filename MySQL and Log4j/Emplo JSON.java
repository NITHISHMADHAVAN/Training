package Json;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

class Employee {
	private int empID;
	private String empName;
	private Double salary;
	private String type;

	public Employee() {
	}

	public Employee(int empID, String empName, double salary, String type) {
		this.empName = empName;
		this.empID = empID;
		this.salary = salary;
		this.type = type;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

class ContractEmployee extends Employee {
	private Double contperiod;

	public Double getContperiod() {
		return contperiod;
	}

	public void setContperiod(Double contperiod) {
		this.contperiod = contperiod;
	}

	public ContractEmployee() {
	}

	public ContractEmployee(int empid, String empName, double salary, String type, double contperiod) {
		this.contperiod = contperiod;
	}
}

class permanentEmployee extends Employee {
	private Double incentives;

	public Double getIncentives() {
		return incentives;
	}

	public void setIncentives(Double incentives) {
		this.incentives = incentives;
	}

	public permanentEmployee() {
	}

	public permanentEmployee(int empid, String empName, double salary, String type, double incentives) {
		this.incentives = incentives;
	}
}

public class Emplo {


	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		String Url = "jdbc:mysql://localhost:3306/emp";
		String username = "root";
		String password = "Nithish@123";
		// Connection con = DriverManager.getConnection(Url, username, password);
		Connection con = null;
		
		int empid = 0;
		String empName = "";
		double salary = 0;
		int ce = 0;
		do {
			System.out.println(
					"Enter any option: \n1.Create Employee \n2.Modify Employee data \n3.Delete Employee \n4.List Employees");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				PreparedStatement insertStatement = null;
				try {
					con = DriverManager.getConnection(Url, username, password);
					
					System.out.println("Enter Employee ID");// unique
					empid = sc.nextInt();
					System.out.println("Enter Employee Name");
					empName = sc.next();
					System.out.println("Enter Employee salary");
					salary = sc.nextDouble(); //type

					String sql = "INSERT INTO emplo( empID,empname,salary,type )" + "VALUES(?,?,?,?)";
					try {
						insertStatement = con.prepareStatement(sql);
						insertStatement.setInt(1, empid);
						insertStatement.setString(2, empName);
						insertStatement.setDouble(3, salary);
						insertStatement.setString(4, "");
						insertStatement.executeUpdate();
						insertStatement.close();
						System.out.println("successfully inserted");
					} catch (Exception exception) {
						System.out.println("failed to insert due to::" + exception);
					}

					System.out.println("Select Employee any option:\n1.Contract Employee \n2.Permanent Employee ");
					int emp = sc.nextInt();
					if (emp == 1) {
						String str1 = "UPDATE emplo SET Type='contract employee' where empID=?";
						
						try {
							insertStatement = con.prepareStatement(str1);
							insertStatement.setDouble(1, empid);
							insertStatement.executeUpdate();
							insertStatement.close();
						} catch (Exception exception) {
							System.out.println(exception);
						}

						String str2 = "INSERT INTO contract_employee " + "VALUES(?,?)";// ID & period
						System.out.println("Enter Contract period : ");
						Double contperiod = sc.nextDouble();
						try {
							
							insertStatement = con.prepareStatement(str2);
							insertStatement.setInt(1, empid);
							insertStatement.setDouble(2, contperiod);
							insertStatement.executeUpdate();
						} catch (Exception exception) {
							System.out.println(exception);
						}
					} else if (emp == 2) {
						
						String str1 = "UPDATE emplo SET Type='Permanent employee' where empID=?";
						try {
							insertStatement = con.prepareStatement(str1);
							insertStatement.setDouble(1, empid);
							insertStatement.executeUpdate();
							insertStatement.close();
						} catch (Exception exception) {
							System.out.println(exception);
						}

						String str2 = "INSERT INTO permanent_employee " + "VALUES(?,?)";// ID & incentives
						System.out.println("Enter Incentives : ");
						Double incent = sc.nextDouble();
						try {
							insertStatement = con.prepareStatement(str2);
							insertStatement.setInt(1, empid);
							insertStatement.setDouble(2, incent);
							insertStatement.executeUpdate();
						}

						catch (Exception exception) {
							System.out.println(exception);
						}
					}
				} catch (Exception e) {
					System.out.println(e);
				} 
				finally {
					
					insertStatement.close();
					con.close();
				}
				break;

			case 2:
				PreparedStatement updateStatement = null;
				ResultSet res=null;
				try {
					con = DriverManager.getConnection(Url, username, password);
					System.out.println("Enter Emp ID you want to update");
					int id = sc.nextInt();
					String str1 = "SELECT * FROM emplo where empID=?";
					updateStatement = con.prepareStatement(str1);
					updateStatement.setInt(1, id);
					res = updateStatement.executeQuery();
					
					while (res.next()) {
						System.out.println("1.EmpID :" + res.getInt("empID"));
						System.out.println("2.EmpName :" + res.getString("empName"));
						System.out.println("3.Empsalary :" + res.getInt("salary"));

						String Type = res.getString("type");

						if (Type.equals("contract employee")) {
							String s1 = "select * from contract_employee where cempId=?";
							try {
							updateStatement = con.prepareStatement(s1);
							updateStatement.setInt(1, id);
							res = updateStatement.executeQuery();
							

							while (res.next()) {
								System.out.println("4.Contract period :" + res.getDouble("period"));
							}
							//res.close();

						}
						catch(Exception exception)
							{
							System.out.println(exception);
							}
						}

						else if (Type.equals("permanent employee")) {
							String s1 = "select * from permanent_employee Where pempId=?";
							//int pid = sc.nextInt();
							try {
							updateStatement = con.prepareStatement(s1);
							updateStatement.setInt(1, id);

							res = updateStatement.executeQuery();
							while (res.next()) {
								System.out.println("4. Incentives :" + res.getDouble("incentives"));
							}
							}
							catch(Exception exception) {
								System.out.println(exception);
							}
						}

						System.out.println("Enter choice which one you want to Update");
						System.out.println("\n1.name \n2.Salary \n3.Type");
						int select = sc.nextInt();
						if (select == 1) {
							System.out.println("Enter update name");
							String updName = sc.next();
							String st1 = "UPDATE emplo SET empName=? where empID=?";
							try {
							updateStatement = con.prepareStatement(st1);
							updateStatement.setString(1, updName);
							updateStatement.setInt(2, id);
							updateStatement.executeUpdate();
							}
						
							catch(Exception exception)
							{
								System.out.println(exception);
							}
						}
						else if (select == 2) {
							System.out.println("Enter update salary");
							double Sal = sc.nextDouble();
							String s2 = "UPDATE emplo SET salary=? where empID=?";
							try {
							updateStatement = con.prepareStatement(s2);
							updateStatement.setDouble(1, Sal);
							updateStatement.setInt(2, id);
							updateStatement.executeUpdate();
							updateStatement.close();
							}
							catch(Exception exception)
							{
								System.out.println(exception);
							}
						}
						 else if ((select == 3)) {
							System.out.println("Enter the employee type contract_employee ,permanent_employee");
							String emptype = sc.next();
							String type = emptype;
							if (type.equals("contract_employee")) {
								{
									System.out.println("Enter Contract Period");
									double conttarctperiod = sc.nextDouble();
								 	String s3 = "Update contract_employee SET period=? where cempId=?";
									try {
									updateStatement = con.prepareStatement(s3);
									updateStatement.setDouble(1, conttarctperiod);
									updateStatement.setInt(2, id);
									updateStatement.executeUpdate();
									updateStatement.close();
									System.out.println("sucessfully updated");
									}
									catch(Exception exception) {
										System.out.println();
								}
								}
							}
						
							 else {
								System.out.println("Enter Incentives");
								double Incentives = sc.nextDouble();
								String s4 = "Update permanent_employee SET incentives=? where pempId=?";

								updateStatement = con.prepareStatement(s4);
								updateStatement.setDouble(1, Incentives);
								updateStatement.setInt(2, id);
								updateStatement.executeUpdate();
								updateStatement.close();
								System.out.println("sucessfully updated");
							}
						}
						
					}
					
			
					//res.close();
					}
				
				
				catch (Exception exception) {
					System.out.println(exception);
				} finally {
					
					updateStatement.close();
					con.close();
				}

				break;
			case 3:
				PreparedStatement deleteStatement = null;
				
				try {
					con = DriverManager.getConnection(Url, username, password);
					

					System.out.println("Enter the employee id to delete : ");
					int empi = sc.nextInt();
					/*
					 * String type=""; String s5="select type from emplo where empID=?";
					 * PreparedStatement p1=con.prepareStatement(s5); p1.setInt(1, empID); ResultSet
					 * rs1=p1.executeQuery(); while(rs1.next()) { String Type=rs1.getString("type");
					 * } if(type.equals("contract_employee")) { PreparedStatement
					 * p11=con.prepareStatement("delete from contract_employee where cempId=?");
					 * p11.setInt(1, empID); p11.executeUpdate(); }
					 * 
					 * else { PreparedStatement
					 * p2=con.prepareStatement("delete from permanent_employee where pempId=?");
					 * p2.setInt(1, empID); p2.executeUpdate(); }
					 */
					String s="delete  from emplo where empID=?";
					deleteStatement = con.prepareStatement(s);
					deleteStatement.setInt(1, empi);
					deleteStatement.executeUpdate();
					System.out.println("Succesfully deleted the employ id ");
				} catch (Exception exception) {
					System.out.println(exception);
				} finally {
					deleteStatement.close();
					con.close();
				}
				break;
				
			case 4:
				Statement statement =null;
				try {
					
					con = DriverManager.getConnection(Url, username, password);
					  statement = con.createStatement();
					 ResultSet resultset = statement.executeQuery("Select * from emplo");
					JSONArray arr = new JSONArray();
					
					while (resultset.next()) {
						// System.out.println(rs.getString("Name"),....);
						JSONObject record = new JSONObject();
						int emp = resultset.getInt("empID");
						String Name = resultset.getString("empName");
						double Salary = resultset.getDouble("salary");
						String Type = resultset.getString("type");

						record.put("empID", emp);
						record.put("Name", Name);
						record.put("Salary", Salary);
						record.put("emptype", Type);
						arr.put(record);

					}
					System.out.println(arr);
				} catch (Exception exception) {
					System.out.println(exception);
				} finally {
					statement.close();
					con.close();
				}
				break;

			default:
				System.out.println("Invalid");
			}
			
			System.out.println("1.continue 2.exit ");
			ce = sc.nextInt();
		} while (ce == 1);
		sc.close();
	}
}

