package room;
public class Room {
	int roomno;
	String roomtype;
	String roomarea;
	boolean Acmachine;
	 void setData(int rno,String rt,String ra,boolean ac)
	 {
		 roomno = rno;
		 roomtype=rt;
		 roomarea=ra;
		 Acmachine=ac;
	}
void displayData()
{
	System.out.println("The Room No is :" + roomno);
	System.out.println("The Room Type is:" + roomtype);
	System.out.println("The Room Area is:"+ roomarea);
	String s=(Acmachine)?"yes":"no";
	System.out.println("The Room is AC?: "+ s);
}
	 public static void main(String args[])
	 {
		 Room rooms =new Room();
		 rooms.setData(10, "2star", "chennai", false);
		 rooms.setData(223, "3star", "chennai", true);
		 rooms.displayData();
	 }
}
	
