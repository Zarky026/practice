package practice;

import javax.swing.JFrame;

public class gThread implements Runnable {
	
	public gThread() {
		
	}

	public void run() {
		gFrame frame1 = new gFrame("Sandbox");  //This will be the actual window
		frame1.setSize(136,123); //this will be the window size
		frame1.setVisible(true); //this will make it apparent on the screen
		frame1.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); //this will set the default operation upon closing the window
		frame1.setResizable(false); //this will set the ability to resize window to false.
	}

}
