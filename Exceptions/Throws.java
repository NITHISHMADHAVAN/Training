
public class Throws {
	public static  void divide(int a,int b) throws ArithmeticException,ArrayIndexOutOfBoundsException{
		int c=a/b;
		System.out.println("C value is "+c);
	}
	public class throwscall {
		public static void main(String[] args) {
			try {
				Throws.divide(5,0);
			}
			catch(ArithmeticException ecxeption)
			{
				System.out.println("check your inputs");
			}
			catch(ArrayIndexOutOfBoundsException exception)
			{
				System.out.println("give only 2 inputs");
			}
		}
		
		}


}
