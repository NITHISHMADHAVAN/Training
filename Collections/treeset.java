import java.util.TreeSet;

public class treeset {
	public static void main(String[] args) {
		TreeSet<Integer>TS=new TreeSet<Integer>();
		TS.add(50);
		TS.add(14);
		TS.add(05);
		TS.add(11);
		TS.add(40);
		TS.add(31);
		TS.add(02);
		TS.add(14);
		System.out.println("The TreeSet Elements are:"+TS);
		
		System.out.println("The less than 20 number is:");
		for(Integer n:TS)
		{
			if(n<20)
				System.out.println(n);
		}
	}

}
