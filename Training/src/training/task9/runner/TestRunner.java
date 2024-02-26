package training.task9.runner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import training.exceptions.CustomException;
import training.task6.helper.ArrayListHelper;
import training.task8.helper.FileHelper;
import training.task9.helper.CustomThread;
import training.task9.helper.Resource;
import training.task9.helper.RunnableClass;
import training.task9.helper.RunnableClass1;
import training.utilities.HelperUtils;

public class TestRunner {

	public static void main(String[] args) {
		Logger logger = Logger.getGlobal();
		try {
			HelperUtils.formatLogger("7");
		} catch (SecurityException | IOException | CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Resource resource = new Resource();

		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			try {
				logger.info("Enter Option : (0 for Exit )");

				int choice = scanner.nextInt();

				scanner.nextLine();

				logger.info("-------------------------------------------------");

				switch (choice) {
				case 1: {

					logger.info("1. Write a class(ExtendedThread) which extends Thread. Inside the run methods print\n"
							+ "the current thread name, priority & its state. In the runner class Spawn a new thread\n"
							+ "using the ExtendedThread class. Print the current thread name, priority & its state in\n"
							+ "the runner class before & after calling the thread.start() method.");

					CustomThread extThread = new CustomThread(20, resource);

					extThread.setName("Extended Thread");

					logger.info(
							"1" + extThread.getName() + " : " + extThread.getPriority() + " : " + extThread.getState());
					extThread.start();
					logger.info(
							"2" + extThread.getName() + " : " + extThread.getPriority() + " : " + extThread.getState());

					break;
				}
				case 2: {

					logger.info(
							"1.Write a class (RunnableThread) which implements Runnable. Inside the run methods print\n"
									+ "the current thread name, priority & its state. In the runner class Spawn a new thread\n"
									+ "using the ExtendedThread class. Print the current thread name, priority & its state in\n"
									+ "the runner class before & after calling the thread.start() method.");

					Thread myRunThread = new Thread(new RunnableClass1());

					myRunThread.setName("ggg");

					logger.info(
							myRunThread.getName() + " : " + myRunThread.getPriority() + " : " + myRunThread.getState());

					myRunThread.start();
//					Thread.sleep(1000);
					logger.info(myRunThread.getState() + "");
					logger.info(myRunThread.getName() + " : " + myRunThread.getPriority() + " : ");
					logger.info(myRunThread.getPriority() + "");
					logger.info(myRunThread.getState() + "");
					break;
				}
				case 3: {
					logger.info("Spawn a new Thread using the ExtendedThread and provide the name for that\n"
							+ "thread as ExtendedThread. Spawn a new Thread using the RunnableThread & set\n"
							+ "the name as RunnableThread. Print the current thread name, priority & its state in the\n"
							+ "runner class before & after calling the thread.start() method of each thread.");

					RunnableClass runClassObject = new RunnableClass(1, resource);

					Thread runThread = new Thread(runClassObject);
					runThread.setName("Runnable implemented thread");

					CustomThread extThread = new CustomThread(1, resource);
					extThread.setName("Thread extended thread");

//					logger.info(extThread.getName()+" : "+extThread.getPriority()+" : "+extThread.getState());
					extThread.start();
//					logger.info(extThread.getName()+" : "+extThread.getPriority()+" : "+extThread.getState());

//					logger.info(runThread.getName()+" : "+runThread.getPriority()+" : "+runThread.getState());
					runThread.start();

					int i = 0;

					ArrayListHelper listHelper = new ArrayListHelper();

					List<String> dumpList = listHelper.getList();

					while (i < 5) {

						Thread.sleep(2000);

						ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

						long[] threadIds = threadMXBean.getAllThreadIds();

						ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadIds);

						for (ThreadInfo threadInfo : threadInfos) {
							dumpList.add(threadInfo.getThreadName());
						}
						dumpList.add(
								"--------------------------------------------------------------------------------------------------\n");
						dumpList.add(
								"--------------------------------------------------------------------------------------------------\n\n");
						i++;
					}

					FileHelper fileHelper = new FileHelper();

					fileHelper.fileCreation("dumpList.txt", "", dumpList);

//					Thread.sleep(10000);
//					
//					extThread.setFlag(false);
//					runClassObject.setFlag(false);
//					System.out.println("All threds done !");
//					logger.info(runThread.getName()+" : "+runThread.getPriority()+" : "+runThread.getState());
				}
				case 4: {
					logger.info("In the run method of ExtendedThread, print a message “Going to Sleep:\n"
							+ "“+threadName. After that sleep for 60 secs. Then print After sleeping:\n"
							+ "“+threadName.In the run method of RunnableThread,print a message “Going to\n"
							+ "Sleep: “+threadName. After that sleep for45 secs. Then print After sleeping:\n"
							+ "“+threadName.From the runner class spawn 5 ExtendedThreads with your custom\n"
							+ "Thread name for each thread & 5 more RunnableThreads with your custom name for\n"
							+ "each Thread. Observe what happens by analysing the output prints.");

					ArrayList<Thread> threadList = new ArrayList<Thread>();

					for (int i = 0; i < 5; i++) {

						Thread thread = new CustomThread(i, resource);
						thread.setName("extThread - " + i);
						threadList.add(thread);

					}
					for (int i = 0; i < 5; i++) {

						Thread thread = new Thread(new RunnableClass(i, resource));
						thread.setName("runThread - " + i);
						threadList.add(thread);

					}

					for (Thread t : threadList) {

						t.start();

					}

					int i = 0;

					ArrayListHelper listHelper = new ArrayListHelper();

					List<String> dumpList = listHelper.getList();

					while (i < 5) {

						Thread.sleep(2000);

						ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

						long[] threadIds = threadMXBean.getAllThreadIds();

						ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadIds);

						for (ThreadInfo threadInfo : threadInfos) {
							dumpList.add(threadInfo.getThreadName()+" "+threadInfo.getThreadState()+ " Lock Owned by : "+ threadInfo.getLockOwnerName()+"\n\n");
						}
						dumpList.add(
								"--------------------------------------------------------------------------------------------------\n");
						dumpList.add(
								"--------------------------------------------------------------------------------------------------\n\n");
						i++;
					}

					FileHelper fileHelper = new FileHelper();

					fileHelper.fileCreation("dumpList.txt", "", dumpList);

					break;
				}
				case 6: {
					logger.info("In the run method of ExtendedThread, print a message “Going to Sleep:\n"
							+ "“+threadName. After that sleep for 60 secs. Then print After sleeping:\n"
							+ "“+threadName.In the run method of RunnableThread,print a message “Going to\n"
							+ "Sleep: “+threadName. After that sleep for45 secs. Then print After sleeping:\n"
							+ "“+threadName.From the runner class spawn 5 ExtendedThreads with your custom\n"
							+ "Thread name for each thread & 5 more RunnableThreads with your custom name for\n"
							+ "each Thread. Observe what happens by analysing the output prints.");

				}
				case 0: {
					loop = false;
					scanner.close();

					break;
				}

				default: {
					logger.info("Invalid case number.");

					break;
				}
				}

				logger.info("--------------------------------------------------");
			}

//			catch (CustomException e) {
//				logger.severe(e.getMessage() + "\n");

//			} 
			catch (Exception e) {
				logger.warning("Enter Correct Input : ");
				e.printStackTrace();
				scanner.nextLine();

			}
		}

	}

}
