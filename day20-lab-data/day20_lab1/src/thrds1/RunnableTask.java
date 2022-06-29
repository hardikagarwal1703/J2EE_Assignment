package thrds1;

public class RunnableTask implements Runnable {
	

	@Override
	public void run() // throws InterruptedException
	{
		System.out.println("started " + Thread.currentThread().getName());
		// B.L
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("executed by " + Thread.currentThread().getName() + " exec count " + i);
				if(Thread.currentThread().getName().equals("three"))
				{
					System.out.println("Enter data");
					System.in.read();//blocked on i/p
				}
				Thread.sleep(200);
			}
		} catch (Exception e) {
			System.out.println("err in thrd " + Thread.currentThread().getName() + " err " + e);
		}
		System.out.println(Thread.currentThread().getName() + " over ...");

	}//state : DEAD

}
