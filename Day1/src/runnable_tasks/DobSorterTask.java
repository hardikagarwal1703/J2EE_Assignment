package runnable_tasks;

import static utils.IOUtils.storeStudentDetails;
import static utils.StudentCollectionUtils.sortStudentsByDoB;

import java.util.Map;

import com.app.core.Student;

public class DobSorterTask implements Runnable {
	// state
	private Map<String, Student> studentMap;
	private String fileName;

	public DobSorterTask(Map<String, Student> studentMap, String fileName) {
		super();
		this.studentMap = studentMap;
		this.fileName = fileName;
		System.out.println("in ctor of " + getClass() + " invoked by " + Thread.currentThread());
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread() + "sorted");
		try {
			storeStudentDetails(fileName, sortStudentsByDoB(studentMap));
			System.out.println("**** sorting and saving complete! *****");
		} catch (Exception e) {
			System.out.println(Thread.currentThread() + " got err " + e);
		}
		System.out.println(Thread.currentThread() + " over!");
	}
}
