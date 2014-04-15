package practice;

import javax.swing.JFrame;

public class gThread implements Runnable {
	
	public gThread() {
		
	}

	public void run() {
		gFrame frame1 = new gFrame("Sandbox");  //This will be the actual window
		frame1.setSize(136,123);
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame1.setResizable(false);
	}

}
