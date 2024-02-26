package training.task9.helper;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Resource {

	Logger logger = Logger.getGlobal();
	private ArrayList<String> arrList = new ArrayList();
	boolean a = true;
	public void addA(String element) {
		
		synchronized (this) {
			while(a) {
				
			}
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			arrList.add(element);
			logger.info(arrList.toString());
		}
		
	}

	public void delA(String element) {
		
		synchronized (this) {
			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			arrList.remove(element);
			logger.info(arrList.toString());
		}
		
	}
	
	
	
}
