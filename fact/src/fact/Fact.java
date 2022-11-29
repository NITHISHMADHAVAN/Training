package fact;
import java.util.Scanner;
public class Fact {
	Scanner sc=new Scanner(System.in);
	
	int num = sc.nextInt();
	int fact=1;
	int i;
	for(i=1;i<=num;i++)
	{
		fact=fact*i;
	}
	System.out.println(num +"is"+fact);
	}
}
