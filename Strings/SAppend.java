import java.util.Scanner;
public class SAppend {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str1=sc.next();
		String str2=sc.next();
		int n1=str1.length();
		int n2=str2.length();
		String result="";
		int s;
		if(n1==n2) 
		{

			result=str1.concat(str2);
		}
		else if(n1>n2) {
		     s= n1-n2;
		        str1=str1.substring(s);
			result=str1.concat(str2);
		}
		else {
		    s=n2-n1;
			str2=str2.substring(s);
			result=str1.concat(str2);
		}
		System.out.println(result);
		}
}
