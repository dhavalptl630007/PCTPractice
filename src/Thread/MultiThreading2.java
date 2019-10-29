package Thread;

//using runnable interface
//understanding of priority
class C implements Runnable {
	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println("in A " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class D implements Runnable{
	
	public void run() {
		for (int i = 6; i <= 10; i++) {
			System.out.println("in B " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class MultiThreading2 {

	public static void main(String[] args) throws InterruptedException {
    
	C t1 = new C();
	D t2 = new D();
	
    Thread t3 = new Thread(t1);
    Thread t4 = new Thread(t2);
	
    System.out.println("DD");
    t4.setPriority(Thread.MAX_PRIORITY);
    t3.setPriority(Thread.MIN_PRIORITY);
    t3.start();
    //Thread.sleep(1000);
    t4.start();
    
    t3.join();
    t4.join();
    System.out.println("Dhaval");
	}

}
