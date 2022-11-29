package strings;

import java.util.Scanner;

public class Duplicate {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		char arr[]=str.toCharArray();
		System.out.println("The String is:"+ str);
		System.out.print("The Duplicates Strings are:");
		for(int i=0;i<str.length();i++)
		{
		for(int j=i+1;j<str.length();j++)
		{
			if(arr[i]==arr[j])
			{
		System.out.print(arr[i]+" ");
			}
		}
		}
	}
}
		
		

