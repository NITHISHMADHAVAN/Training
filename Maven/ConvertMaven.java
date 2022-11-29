package sam;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;


class Employee {
	private int ID;
	private String name;
	private Double salary;
	private String type;

	public Employee() {
	}

	public Employee(int ID, String name, double salary, String type) {
		this.name = name;
		this.ID = ID;
		this.salary = salary;
		this.type = type;
	}

	public int getEmpID() {
		return ID;
	}

	public void setEmpID(int ID) {
		this.ID = ID;
	}

	public String getempname() {
		return name;
	}

	public void setempname(String name) {
		this.name = name;
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

	public ContractEmployee(int ID, String name, double salary, String type, double contperiod) {
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

	public permanentEmployee(int ID, String name, double salary, String type, double incentives) {
		this.incentives = incentives;
	}
}


public class ConvertMaven {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		String Url = "jdbc:mysql://localhost:3306/emp";
		String username = "root";
		String password = "Nithish@123";
		Logger log=Logger.getLogger(ConvertMaven.class);
		BasicConfigurator.configure();
        log.info("Connection is successfull");
        log.debug("Debug message");  
        log.error("Error message");  
	        
		// Connection con = DriverManager.getConnection(Url, username, password);
		Connection con = null;
		
		int empid = 0;
		String empName = "";
		double salary = 0;
		int ce = 0;
		String type="";
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
					salary = sc.nextDouble(); 
					System.out.println("Enter Employee Type");
					System.out.println(" contract  or permanent ");
					type=sc.next();	
					
					String sql = "INSERT INTO workers( ID,name,salary,type )" + "VALUES(?,?,?,?)";
					try {
						insertStatement = con.prepareStatement(sql);
						insertStatement.setInt(1, empid);
						insertStatement.setString(2, empName);
						insertStatement.setDouble(3, salary);
						insertStatement.setString(4,type);
						insertStatement.executeUpdate();
						insertStatement.close();
						System.out.println("successfully inserted");
					} catch (Exception exception) {
						System.out.println("failed to insert due to::" + exception);
					}

					System.out.println("Select Employee any option:\n1.Contract Employee \n2.Permanent Employee ");
					int emp = sc.nextInt();
					if (emp == 1) {
						//String str1 = "UPDATE wokers SET Type='contract employee' where empID=?";
						
						//try {
						//	insertStatement = con.prepareStatement(str1);
						//	insertStatement.setDouble(1, empid);
						//	insertStatement.executeUpdate();
							///insertStatement.close();
						//} catch (Exception exception) {
						//	System.out.println(exception);
						//}

						String str2 = "INSERT INTO contract_employee " + "VALUES(?,?)";// ID & period
						System.out.println("Enter Contract period : ");
						Double contperiod = sc.nextDouble();
						try {
							
							insertStatement = con.prepareStatement(str2);
							insertStatement.setInt(1, empid);
						insertStatement.setDouble(2, contperiod);
							insertStatement.executeUpdate();
					} catch (Exception exception) {
							//System.out.println(exception);
						}
					} else if (emp == 2) {
						
						//String str1 = "UPDATE workers SET Type='Permanent employee' where empID=?";
						//try {
							//insertStatement = con.prepareStatement(str1);
							//insertStatement.setDouble(1, empid);
							//insertStatement.executeUpdate();
						//}
						// catch (Exception exception) {
							//System.out.println(exception);
						//}

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
					String str1 = "SELECT * FROM workers where ID=?";
					
					updateStatement = con.prepareStatement(str1);
					updateStatement.setInt(1, id);
					res = updateStatement.executeQuery();
					
					while (res.next()) {
						System.out.println("1.EmpID :" + res.getInt("ID"));
						System.out.println("2.EmpName :" + res.getString("name"));
						System.out.println("3.Empsalary :" + res.getInt("salary"));
						System.out.println("3.Emptype :" + res.getString("type"));

						//String Type = res.getString("type");

						if (type.equals("contract")) {
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

						else if (type.equals("permanent")) {
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
							String st1 = "UPDATE workers SET name=? where ID=?";
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
							String s2 = "UPDATE workers SET salary=? where ID=?";
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
							System.out.println("Enter the employee type 1.contract_employee ,2.permanent_employee");
							int t=sc.nextInt();
							if(t==1)
								
							//String emptype = sc.next();
							//String etype = emptype;
							//if (etype.equals("contract_employee")) {
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
					String s="delete  from workers where ID=?";
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
					 ResultSet resultset = statement.executeQuery("Select * from workers");
					JSONArray arr = new JSONArray();
					
					while (resultset.next()) {
						// System.out.println(rs.getString("Name"),....);
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
