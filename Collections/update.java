package updatecollec;
import java.util.*;

public class update {
	public static void main(String[] args) {
	ArrayList <String>games=new ArrayList<String>();
	games.add("Cricket");
	games.add("Football");
	games.add("Hockey");
	games.add("Volleyball");
	System.out.println("Before update");
	System.out.println(games);
	games.set(3,"Carrom");
	System.out.println("After update");
	System.out.println(games);
	}
}
	
	

