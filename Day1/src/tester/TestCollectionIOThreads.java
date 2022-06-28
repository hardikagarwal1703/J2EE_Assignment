package tester;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.Map;
import java.util.Scanner;

import com.app.core.Student;

import runnable_tasks.DobSorterTask;
import runnable_tasks.GpaSorterTask;

public class TestCollectionIOThreads {
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {

			Map<String, Student> map = populateMap(populateList());

			System.out.println("Enter file name to store students details asorted in DOB");
			String file1 = scan.nextLine();

			System.out.println("Enter file name to store students details asorted in GPA");
			String file2 = scan.nextLine();

			Thread t1 = new Thread(new DobSorterTask(map, file1), "dob_sorter");
			Thread t2 = new Thread(new GpaSorterTask(map, file2), "gpa_sorter");

			// making threads runnable
			t1.start();
			t2.start();

			System.out.println("main waiting for child threads to complete exec");
			//t1.join();
			//t2.join();

			System.out.println("Child Threads over");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Main Over");
	}
}
