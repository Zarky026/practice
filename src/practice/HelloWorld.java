package practice;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		Thread guiThread = new Thread(new gThread());
		guiThread.start();

	}

}
