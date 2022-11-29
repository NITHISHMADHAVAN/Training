class HotException extends Exception {
}
public class userdefined {
	public static void main(String[] args) {
	try{ 
		throw new  HotException();
	}
	catch(HotException exception){
		System.out.println(exception);}
		{
		System.out.println("the user defined exception is created");
	}
	}

}
