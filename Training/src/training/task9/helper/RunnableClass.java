package training.task9.helper;

import java.util.logging.Logger;

public class RunnableClass implements Runnable {

	Logger logger = Logger.getGlobal();
	private int time;
	Resource res ;
	private boolean flag = true;

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public RunnableClass(int time, Resource res) {
		logger.info("Runnable thread created");
		this.time = time * 1000;
		this.res = res;
	}



	@Override
	public void run() {

		while (flag) {
			logger.info(Thread.currentThread().getName() + " Going to sleep ..\n");

			res.addA("run");
			
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			logger.info(Thread.currentThread().getName() + "After sleep ..\n");

		}
	}

}
