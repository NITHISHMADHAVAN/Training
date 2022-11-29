package linkedlist;
import java.util.LinkedList;
import java.util.Scanner;
public class Linkedlist {
	public static void main(String[] args) {
		LinkedList<String> trees=new LinkedList<String>();
		trees.add("COCONUT");
		trees.add("TAMARIND");
		trees.add("NEEM");
		trees.add("BANYAN");
		System.out.println("Before ADD");
		for(String str:trees) {
		System.out.println(str);
		}
		Scanner sc=new Scanner(System.in);
		int index=sc.nextInt();
		trees.add(index,"PAPAYA");
		System.out.println("After ADD");
		for(String str:trees) {
			System.out.println(str);
		}
	}

}