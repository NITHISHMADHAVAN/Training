
	public class TwoThreads extends Thread{

			public void run()
			{ for(int i=1;i<=2;i++)
			{
				System.out.println("The Thread is running ");
				try {
		        		Thread.sleep(1500);
		    		}
		    	catch(Exception exception) 
		    	{ 
		    		// do something
		    	}
		       	System.out.println("the Thread is exit ");
		  	}
			}
			public static void main(String[] args)
			{
				TwoThreads t1=new TwoThreads();
				TwoThreads t2=new TwoThreads();
				t1.start();
				t2.start();
				System.out.println(t1.isAlive());
				System.out.println(t2.isAlive());
			}
		}