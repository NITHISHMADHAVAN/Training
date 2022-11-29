
import java.util.HashSet;
public class hashset {
	public static void main(String[] args) {
		HashSet<String> hset1=new HashSet<String>();
		hset1.add("Chennai");
		hset1.add("Trichy");
		hset1.add("Madurai");
		hset1.add("Coimabatore");
		hset1.add("Tanjore");
		System.out.println("The first Hashset elements are:"+ hset1);

		HashSet<String> hset2=new HashSet<String>();
		hset2.add("Tanjore");
		hset2.add("Salem");
		hset2.add("Trichy");
		hset2.add("Chennai");
		hset2.add("Erode");
		System.out.println("The second Hashset elements are:"+ hset2);
		hset1.retainAll(hset2);
		System.out.print("The RETAIN HASHSET ELEMENTS :");
		System.out.print(hset1);
	}
}
