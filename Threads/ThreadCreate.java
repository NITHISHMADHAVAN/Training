package threadcreate;
public class ThreadCreate implements Runnable 
{
 public static void main(String args[])
 {
	 ThreadCreate tc=new ThreadCreate();
	 Thread t1=new Thread(tc);
	 t1.start();
 }
@Override
public void run() {
	for(int i=1;i<=4;i++)
	 {
	 try {
		 Thread.sleep(500);
		 System.out.println("Its Working");
		 }
			 catch(Exception exception) {}
		 }
	
}
 
