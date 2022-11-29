
 class Emp
{
	void display() {
	 String str="BASE";
		System.out.println("The EMPLOYEE: "+ str);
	}
}
	class Permanentemployee extends Emp {
		void display(){
			String str1="CHILD 1 ";
				System.out.println("The permanentEmployee :"+ str1);
			}
		}
		class Parttimeemployee extends Emp{
			void display()
			{
				String str2="CHILD 2 ";
					System.out.println("The Parttimeemployee :"+str2);
				}
			}
			class Contractemployee extends Emp
			{
				void display() {
					String str3="CHILD 3 ";			
						System.out.println("The Contractemployee S:"+str3);
					}
						
					}
			class Employee
			{
				public static void main(String[] args) {
					Emp E;
					E=new Emp();
					E.display();
					E=new Permanentemployee();      //RUN TIME POLY
					E.display();
					E=new Parttimeemployee();
					E.display();
					E=new Contractemployee();
					E.display();
				}
			}
		// Compile time poly	
			/*
			Emp E=new Emp();
			E.display();
			Permanentemployee p=new Permanentemployee();
			p.display();
			Parttimeemployee p1=new Parttimeemployee();
			p1.display();
			Contractemployee c=new Contractemployee();
			c.display();
			*/
			
			
		

	
	
