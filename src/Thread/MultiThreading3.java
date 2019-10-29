/*
 * package Thread;
 * 
 * //understanding of wait and notify
 * 
 * class Q { static int num; boolean setValue = false; public synchronized void
 * setNum() {
 * 
 * while (setValue) { try { wait(); } catch (InterruptedException e) {
 * e.printStackTrace(); } } num++; System.out.println("put  " +num); setValue =
 * true; notify(); }
 * 
 * public synchronized void getNum() throws InterruptedException {
 * 
 * Thread.sleep(2000); while (!setValue) { try { wait(); } catch
 * (InterruptedException e) { e.printStackTrace(); } } System.out.println("get "
 * + num); setValue = false; notify();
 * 
 * }
 * 
 * 
 * }
 * 
 * class Producer implements Runnable {
 * 
 * Q q = new Q();
 * 
 * @Override public void run() {
 * 
 * for(int i = 0; i<5;i++) {
 * 
 * q.setNum(); try { Thread.sleep(1000); } catch (InterruptedException e) { //
 * TODO Auto-generated catch block e.printStackTrace(); }
 * 
 * }
 * 
 * }
 * 
 * }
 * 
 * class Consumer implements Runnable {
 * 
 * Producer p; Q q = new Q();
 * 
 * Consumer(Producer p) { this.p = p; }
 * 
 * @Override public synchronized void run() {
 * 
 * for (int i = 0; i < 5; i++) { try { q.getNum(); } catch (InterruptedException
 * e1) { // TODO Auto-generated catch block e1.printStackTrace(); } try {
 * Thread.sleep(2000); } catch (InterruptedException e) { // TODO Auto-generated
 * catch block e.printStackTrace(); } }
 * 
 * } }
 * 
 * public class MultiThreading3 {
 * 
 * public static void main(String[] args) throws InterruptedException {
 * 
 * Producer p = new Producer(); Consumer q = new Consumer(p);
 * 
 * Thread t1 = new Thread(p); Thread t2 = new Thread(q);
 * 
 * t1.setPriority(Thread.MAX_PRIORITY); t2.setPriority(Thread.MIN_PRIORITY);
 * t1.start(); t2.start();
 * 
 * }
 * 
 * 
 * }
 */