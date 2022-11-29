package mythreads;


	class base extends Thread{
	public base() {
		System.out.println("main");
	}
}
class child extends base implements Runnable{
	public child() {
		System.out.println("sub");
	
	}
	public void run() {
				 try {
					 Thread.sleep(1000);
					 System.out.println("its working");
			}catch(Exception exception) {
				System.out.println(exception);
			
			}
	}
}
public class MyThread extends Thread {
	public static void main(String args[]) {
		 Thread t=new Thread(new MyThread());
		 t.start();
		 child c=new child();
		 c.start();
	}
}
