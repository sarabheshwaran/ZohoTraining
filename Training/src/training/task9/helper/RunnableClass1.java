package training.task9.helper;

import java.util.Iterator;

public class RunnableClass1 implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<50; i++)
		System.out.println(Thread.currentThread().getName()+" - "+Thread.currentThread().getPriority()+" - "+Thread.currentThread().getState());
		
		
	}

}
