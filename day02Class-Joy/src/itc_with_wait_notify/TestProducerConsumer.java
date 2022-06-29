package itc_with_wait_notify;

public class TestProducerConsumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Utils2 u = new Utils2();
		String[] nms = { "Producer", "Consumer" };
		// produce task ---thrd --strt
		Producer p1 = new Producer(u);// thrd doesn't exist
		// Thread(Runnable inst,String nm)
		Thread t1 = new Thread(p1, nms[0]);// new
		t1.start();// rdy
		Thread.sleep(10);
		Consumer c1 = new Consumer(u);
		// Thread(Runnable inst,String nm)
		Thread t2 = new Thread(c1, nms[1]);// consumer thrd---new
		t2.start();// rdy pool
		// Thread.sleep(5);
		System.out.println("Press enter to exit");
		System.in.read();//main thrd Blocked on i/p
		p1.stop();
		c1.stop();
		System.out.println("Main is waiting for sometime for the threads to complete execution");
		t1.join(500);
		t2.join(400);
		System.out.println("Main is checking if some threads are alive--YES--sending interrupt");
		if(t1.isAlive()) {
			t1.interrupt(); // Waiting thread gets : IException
		}
		if(t2.isAlive()) {
			t2.interrupt(); // Waiting thread gets : IException
		}
		System.out.println("Main over...");
	}
}
