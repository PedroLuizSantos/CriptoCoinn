package api;

public class ThreadAPI extends Thread {

	public ThreadAPI() {

		start();
	}

	public void run() {
		
	

	}

	public static void main(String[] args) {

		Thread ada = Thread.currentThread();
		System.out.println(ada.getName());
		
		Thread thread1 = new Thread(new ClasseRunnable());
		thread1.run();
		
	}

}
