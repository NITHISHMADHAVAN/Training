
public interface Test1 {
void square(int x);
}
class arithmetic implements Test1
{
	int x;
	public void square(int y,int z) {
	x=y*z;
	System.out.println(x);	
	}
}
	public class ToTestInt extends arithmetic
	{
		public static void main(String[] args)
		{
			arithmetic arith=new arithmetic();
			arith.square(10,20);
			
		}
	}
	
	