package point;

public class Point {
	private int x,y;
		public Point(int x,int y) {
		this.x=x;
		this.y=y;
		}
		public Point() {
		}
		public void setX(int x)
		{
			this.x=x;
		}
		public void setY(int y)
		{
			this.y=y;
		}
		public void setXY(int x,int y)
		{
			this.x=x;
			this.y=y;
		}
		public static void main(String args[])
		{
			Point p1=new Point();
			Point p2=new Point(12,9);
			p1.setX(123);
			p1.setY(456);
			System.out.println("the number is:");
			System.out.println(p1.x + p1.y);
			System.out.println(p2.x-p2.y);
		}
	}
	

