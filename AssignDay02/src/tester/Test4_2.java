package tester;

import utils.SynchroUtils;

public class Test4_2 {

	public static boolean exit;
	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {
			while (!exit)
				SynchroUtils.test1();
		}, "t1");
		Thread t2 = new Thread(() -> {
			while (!exit)
				SynchroUtils.test2();
		}, "t2");

		t1.start();
		t2.start();
	}
}

// RESULT : Threads t1 and t2 will run one at a time. But will never run simultaneously. 