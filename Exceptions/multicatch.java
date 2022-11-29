package multicatch;
import java.util.Scanner;
public class multicatch {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Give the elements you want");
		int n=sc.nextInt();
		try {
			int[] arr=new int[5];
			for(int i=0;i<n;i++)
			{
				arr[i]=sc.nextInt();
			}
			for (int i=0; i<n; i++)   
			{  
			System.out.println(arr[i]);  
			}  
		}catch(NegativeArraySizeException exception)
		{
			System.out.println("catch block handled ,negative size occurs" );
		}
		catch(ArrayIndexOutOfBoundsException exception)
		{
			System.out.println("catch block handled ,out of bounds occurs");
		}

}}
