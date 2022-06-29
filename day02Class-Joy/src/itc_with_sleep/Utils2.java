package itc_with_sleep;

public class Utils2 {
	private Emp e;
	private boolean dataReady;

	public synchronized void writeData(Emp ref) throws Exception {
		System.out.println("w entered --- " + Thread.currentThread().getName());
		while (dataReady) {
			Thread.sleep(30); // if data is ready: blocked
		}
		// produce data
		e = ref;
		System.out.println("Write Data " + e);
		System.out.println("w exited --- " + Thread.currentThread().getName());
		dataReady = true;
	}

	public synchronized Emp readData() throws Exception {
		System.out.println("r entered --- " + Thread.currentThread().getName());
		while (!dataReady) {
			Thread.sleep(100); // Till the time data is not ready : blocked
		}
		// consume data
		System.out.println("Read  Data " + e);
		System.out.println("r exited --- " + Thread.currentThread().getName());
		dataReady = false;
		return e;
	}

}
