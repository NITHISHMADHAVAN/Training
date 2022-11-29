
public class Current implements Runnable {
	public static void main(String[] args) { 
		Current ct1=new Current();
		Thread thread1=new Thread(ct1,"1 st work");
		thread1.start();
		Thread thread2=new Thread(ct1,"2 nd work");
		thread2.start();
	}
	@Override
	public void run() {
		for(int i=1;i<4;i++) {
			System.out.println("The running thread is "+Thread.currentThread()+":"+i);
			try {
				Thread.sleep(500);
			} catch (Exception exception) {}
	}
		
	}
}
