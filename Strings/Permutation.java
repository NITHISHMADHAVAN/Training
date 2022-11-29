import java.util.Scanner;
public class Permutation {
	 void permut(String s,String per) {
        if (s.length() == 0) {
            System.out.print(per+ " ");
        }
 
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String str = s.substring(0, i) +s.substring(i + 1);
            permut(str,per+ ch);
        }
	}
	public static void main(String args[]) {
	Scanner sc=new Scanner(System.in);
	String s=sc.nextLine();
	Permutation p1=new Permutation();
	p1.permut(s,"");
	}	
}

