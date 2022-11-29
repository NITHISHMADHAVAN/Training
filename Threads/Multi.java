package multithreading;
class MyThread extends Thread
{
	public void run()
	{
String str[] ={ "Java,", "is,", "hot,", "aromatic,", "and", "invigorating."};
        for (int i=0;i<str.length;i++) {
        try {
        	System.out.println( str[i]);
           sleep(1500);

        } catch (Exception exception) { 
           System.out.println("some exception occurs");
        }   
    }
    }

public class  Multi {
	public static  void main(String[] args) {
		MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start();
        thread2.start();
	}
}
}

