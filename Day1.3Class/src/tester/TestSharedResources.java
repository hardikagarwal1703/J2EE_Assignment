package tester;

import com.app.banking.JointBankAccount;

import runnable_tasks.CheckBalanceTask;
import runnable_tasks.UpdateTask;

public class TestSharedResources {

	public static void main(String[] args) {
		JointBankAccount acct = new JointBankAccount(10000);

		Thread t1 = new Thread(new UpdateTask(acct), "cust1");
		Thread t2 = new Thread(new CheckBalanceTask(acct), "cust2");

		t1.start();
		t2.start();
		
		System.out.println("Main waiting for child threads to complete");
		System.out.println("Main Over");
	}

}
