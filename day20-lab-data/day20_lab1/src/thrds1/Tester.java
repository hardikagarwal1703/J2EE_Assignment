package thrds1;

public class Tester {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread());// Thread : main , 5 ,main
		// create a runnable task instance
		RunnableTask task = new RunnableTask();
		// Attach a thrd to the runnable task
		// Thread(Runnable task , String name)
		Thread t1 = new Thread(task, "one");
		Thread t2 = new Thread(task, "two");
		Thread t3 = new Thread(task, "three");
		Thread t4 = new Thread(task, "four");// NEW : 4 , Runnable : 1
		t1.start();
		t2.start();
		t3.start();
		t4.start();//Runnable : 1 (parent : main ), 4 : child thrds

		System.out.println("main waiting for child thrds to finish exec..... ");
		System.out.println("t1 is alive "+t1.isAlive());//true
		t3.interrupt();//main sending interrupt signal to t3
		t1.join();//main waiting for t1 to complete exec
		System.out.println("t1 is alive "+t1.isAlive());//false
		t2.join();
		t3.join();
		t4.join();
		System.out.println("t4 is alive "+t4.isAlive());//false
		
		System.out.println("main over....");

	}

}
