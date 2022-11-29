package models;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class Company {
	public static void main(String[] args)  throws IOException {
		int eId;
		Scanner sc = new Scanner(System.in);

		Hashtable<Integer, Employees> empHashTable = new Hashtable<Integer, Employees>();

		// Employees e=new Employees();

		Employees perm = null, parttime = null;
		int ce = 0;
		do {
			System.out.println(
					"Select any option: \n 1.Create Employee \n 2.Update Employee data \n 3.Delete Employee \n 4.Search Employees");
			int option = sc.nextInt();
			switch(option) {
			case 1:
				
				System.out.println("Enter Employee Name");
				String empname = sc.next();
				System.out.println("Enter Employee ID");
				int empid = sc.nextInt();
				System.out.println("Enter Employee Age");
				int age = sc.nextInt();
				System.out.println("Enter Employee Salary");
				double salary = sc.nextDouble();
				System.out.println("Enter the employee type:1.PermanentEmployee\n2.PartTimeEmployee:");
				int emp = sc.nextInt();
				//double incentives = 0.0;
				
			if (emp==1)
			{
				perm = new PermEmployee();
				perm.setName(empname);
				perm.setEmpid(empid);
				perm.setSalary(salary);
				perm.setAge(age);
				System.out.println("Enter Incentive : ");
				double incentives = sc.nextDouble();
				perm.setIncentives(incentives);

				empHashTable.put(perm.getEmpid(), perm);
			}
				else if(emp==2)
				{
				parttime = new PermEmployee();
				parttime.setName(empname);
				parttime.setEmpid(emp);
				parttime.setSalary(salary);
				parttime.setAge(age);
				System.out.println("Enter Working Hours : ");
				int workinghours=sc.nextInt();
				parttime.setWorkingHours(workinghours);
				
				empHashTable.put(parttime.getEmpid(), parttime);
			
				}
				else 
					System.out.println("Exit");
			break;
			case 2: 
				System.out.println("Enter the employee id to modify : ");
				eId=sc.nextInt();
				System.out.println("Enter you want to modify : 1.name\n 2.age\n 3.salary" );
				int select=sc.nextInt();
				
				if(select==1) {
					System.out.println("Enter name you want update");
					(empHashTable.get(eId)).empname=sc.next();
					System.out.println(" name is Succesfully Upadted");
				}else if(select ==2)
				{
					System.out.println("Enter age you want to update");
					(empHashTable.get(eId)).age=sc.nextInt();
					System.out.println("age is Succesfully Upadted");
				} else if(select==3)
				{
					System.out.println("Enter salary update");
					(empHashTable.get(eId)).salary=sc.nextDouble();
					System.out.println("salary is Succesfully Upadted");
				}
				break; 
				case 3:
					System.out.println("Enter the employee id ");
					int id = sc.nextInt();

					empHashTable.remove(id);

					System.out.println("Succesfully deleted the employee id " + id);
					break;
			case 4:
					System.out.println("Enter employee id to search and display: ");
					eId = sc.nextInt();
					Employees employees = empHashTable.get(eId);
					System.out.println("name::"+employees.getEmpName());
					System.out.println("age::"+employees.getAge());
					
					break;
				default:
					System.out.println("INVALID");
					
			}
					System.out.println("Employee  1.continue 2.exit");
					ce = sc.nextInt();
				}

		 while (ce == 1);
		sc.close();
	}
}
		
