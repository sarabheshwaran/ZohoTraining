package training.task9.helper;

import java.util.logging.Logger;

public class CustomThread extends Thread {
	Logger logger = Logger.getGlobal();
	Resource res;
	private int time;
	private boolean flag = true;

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public CustomThread(int time, Resource res) {
		System.out.println("Runnable thread created");
		this.time = time * 1000;
		this.res = res;
	}

	@Override
	public void run() {

		while (flag) {
			logger.info(Thread.currentThread().getName() + " Going to sleep ..\n");

			res.delA("run");
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			logger.info(Thread.currentThread().getName() + " After sleep ..\n");
		}
	}

}
