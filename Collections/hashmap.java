import java.util.HashMap;

public class hashmap {
	public static void main(String[] args) {
		HashMap<String,Integer> HM= new HashMap<String,Integer>();
		System.out.println("The HashMap 1 key,values are:");
		HM.put("Nithish",95);
		HM.put("Maddy", 87);
		HM.put("Nanthini",91);
		HM.put("Nachu", 72);
		HM.put("Neeru", 82);
		System.out.println(HM);
	
		HashMap<String,Integer>HM1=new HashMap<String,Integer>();
		System.out.println("The HashMap 2 key,values are :");
		HM1.put("Maddy",87);
		HM1.put("Indhu",78);
		HM1.put("Deepak",79);
		HM1.put("Nachu",56);
		System.out.println(HM1);
		
		System.out.println("After Copying HashMap 1 to HashMap 2 ");
		HM1.putAll(HM);
		System.out.println(HM1);
	}

}
