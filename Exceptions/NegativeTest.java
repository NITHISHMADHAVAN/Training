package exception1;
import java.util.Scanner;
public class NegativeTest {
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Give the elements you want");
	int n=sc.nextInt();
	try {
		int[] arr=new int[-5];
		for(int i=1;i<=5;i++)
		{
			arr[i]=sc.nextInt();
		}
	}catch(NegativeArraySizeException exception)
	{
		System.out.println("negative size occurs" );
	}
	}
}
