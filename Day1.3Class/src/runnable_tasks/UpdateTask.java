package runnable_tasks;

import static java.lang.Thread.currentThread;

import com.app.banking.JointBankAccount;

public class UpdateTask implements Runnable {

	private JointBankAccount joinAccount;

	public UpdateTask(JointBankAccount joinAccount) {
		super();
		this.joinAccount = joinAccount;
	}

	@Override
	public void run() {
		System.out.println(currentThread() + " Started ");
		try {
			while (true) {
				synchronized (joinAccount) {
					joinAccount.updateBalance(5000);
				}
				Thread.sleep(234);
			}
		} catch (Exception e) {
			System.out.println(currentThread() + " got error " + e);
		}
		System.out.println(currentThread() + " ended ");

	}

}
