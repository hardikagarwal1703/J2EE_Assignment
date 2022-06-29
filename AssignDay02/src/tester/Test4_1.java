package tester;

import utils.SynchroUtils;

public class Test4_1 {

	public static void main(String[] args) {

		SynchroUtils su = new SynchroUtils();
		Thread t1 = new Thread(() -> {
			while (true)
				SynchroUtils.test1();
		}, "t1");
		Thread t2 = new Thread(() -> {
			while (true)
				su.test();
		}, "t2");

		t1.start();
		t2.start();
	}
}

// RESULT : Threads t1 and t2 will run simultaneously as test() is non-static and test1()
//			is static.