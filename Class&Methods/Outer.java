package outer;

public class Outer
{
	void display()
	{
		System.out.println("Outer class");
	}
	public class Inner 
	{
			void display() 
			{
				System.out.println("Inner class");
			}
		}
	public class Main{
		public static void main(String args[])
		{
			Outer ou=new Outer();
			Outer.Inner in=ou.new Inner();
			ou.display();
			in.display();
	}
}
}
