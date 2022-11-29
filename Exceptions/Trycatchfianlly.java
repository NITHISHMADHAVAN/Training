package trycatchfinally;

public class Trycatchfianlly {
	 public static void main(String args[]) {
		 int a= 450;
	     //try block 
	     try{  
	            System.out.println("Try block");
	            int num=a/0;  
	            System.out.println(num);  
	      }  
	      //catch block
	      catch(ArithmeticException e){
	          System.out.println("Catch block");
	         System.out.println("ArithmeticException Handled, because of the Number divided by zero");
	      }  
	      //finally block 
	     //this block is always executed
	      finally{
	          System.out.println("Finally block");
	      }  
	      System.out.println("The process is completed");  
	   }   
	}

