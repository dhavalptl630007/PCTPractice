package Thread;

//using Thread class
class A extends Thread
{
	public void run()
	{
		for(int i = 0; i<=5 ; i++) {
		 System.out.println("in A " +i);
		 try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
}

class B extends Thread
{
	public void run()
	{
		for(int i = 6; i<=10 ; i++) {
		 System.out.println("in B "+i);
		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
public class MultiThreading1 {

	public static void main(String[] args) throws InterruptedException {
		
     A t1 = new A();
     B t2 = new B();
     
     t1.start();
     Thread.sleep(1000);
     t2.start();
     t1.join();
     t2.join();
     System.out.println("Dhaval");
     
	}

}
