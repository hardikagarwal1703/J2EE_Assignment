package runnable_tasks;

import static java.lang.Thread.currentThread;

import com.app.banking.JointBankAccount;

public class CheckBalanceTask implements Runnable {

	private JointBankAccount joinAccount;

	public CheckBalanceTask(JointBankAccount joinAccount) {
		super();
		this.joinAccount = joinAccount;
	}

	@Override
	public void run() {
		System.out.println(currentThread() + " Started ");
		try {
			while (true) {
				double balance = joinAccount.checkBalance();
				if (balance != 10000) {
					System.out.println("***ERROR INVALID BALANCE***");
					System.exit(-1);// JVM Terminated over the err condition
				}
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			System.out.println(currentThread() + " got error " + e);
		}
		System.out.println(currentThread() + " ended ");

	}

}
