package itc_with_wait_notify;

public class Utils2 {
	private Emp e;
	private boolean dataReady;

	public synchronized void writeData(Emp ref) throws Exception {
		System.out.println("w entered --- " + Thread.currentThread().getName());
		while (dataReady) {
			wait(); // blocked on wait outside monitor
		}
		// produce data
		e = ref;
		System.out.println("Write Data " + e);
		System.out.println("w exited --- " + Thread.currentThread().getName());
		dataReady = true;
		notify(); // Unblocking trigger for the consumer thread which is blocked on wait(), on the same objects monitor
	}

	public synchronized Emp readData() throws Exception {
		System.out.println("r entered --- " + Thread.currentThread().getName());
		while (!dataReady) {
			wait(); // blocked on wait outside monitor
		}
		// consume data
		System.out.println("Read  Data " + e);
		System.out.println("r exited --- " + Thread.currentThread().getName());
		dataReady = false;
		notify();
		return e;
	}

}
