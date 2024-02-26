package training.task8.helper;

class Resource {
    // Some resource representation
}

class Thread1 extends Thread {
    private Resource resource1;
    private Resource resource2;

    public Thread1(Resource r1, Resource r2) {
        this.resource1 = r1;
        this.resource2 = r2;
    }

    public void run() {
        synchronized (resource1) {
            System.out.println("Thread1 holds resource1");

            try {
                // Simulate some processing
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            resource1.notify();
            synchronized (resource2) {
                System.out.println("Thread1 holds resource2");
            }
        }
    }
}

class Thread2 extends Thread {
    private Resource resource1;
    private Resource resource2;

    public Thread2(Resource r1, Resource r2) {
        this.resource1 = r1;
        this.resource2 = r2;
    }

    public void run() {
        synchronized (resource2) {
            System.out.println("Thread2 holds resource2");

            try {
                // Simulate some processing
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            resource2.notify();
            synchronized (resource1) {
                System.out.println("Thread2 holds resource1");
            }
        }
    }
}

public class DeadlockExample {
    public static void main(String[] args) {
        Resource resource1 = new Resource();
        Resource resource2 = new Resource();

        Thread1 thread1 = new Thread1(resource1, resource2);
        Thread2 thread2 = new Thread2(resource1, resource2);

        thread1.start();
        thread2.start();
    }
}
