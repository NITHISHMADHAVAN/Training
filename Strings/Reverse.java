package recrev;
import java.util.Scanner;
public class Reverse {
	   public String reverseString(String str){
	   
	      if(str.isEmpty()){
	         return str;
	      } else {
	         return reverseString(str.substring(1))+str.charAt(0);
	      }
	      
	   }
	   public static void main(String[] args)
	   {
		   Scanner sc=new Scanner(System.in);
		     Reverse rev = new Reverse();
		     System.out.print("The given string is: ");
		     String str=sc.next();
		     System.out.print("The Reverse String is: ");
		     System.out.println(rev.reverseString(str));
	   }
}