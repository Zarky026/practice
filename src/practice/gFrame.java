package practice;

import java.awt.*;    //awt stands for "Abstract Window Toolkit"
import java.awt.event.*;

import javax.swing.*; //swing gives more modern GUI options
import javax.swing.event.*;

public class gFrame extends JFrame implements ActionListener, ChangeListener, MouseListener{

	private static boolean[] lock = new boolean[5]; //boolean variable to decide if column [1-5] is stagnant.
	private static int[][] random = new int[5][5]; //2-D int array to hold all the randomly generated values.
	private JLabel[][] wheels = new JLabel[5][5]; //2-D JLabel array to display values on the screen.
	private JButton[] locker = new JButton[5]; //Jbutton array to hold the buttons to lock each given column.
	private JButton roll; //the roll button.
	private JPanel board; //the panel holding the 'wheel' values.
	private JPanel buttons; //the panel holding the 'lock/unlock/ buttons.

	/**
	 * 
	 */
	private static final long serialVersionUID = -3076624019548915515L;

	public gFrame(String title) {
		super(title);
		
		setLayout(null);
		
		board = new JPanel();
		board.setVisible(true);
		board.setBounds(0, 0, 75, 80);
		board.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		
		buttons = new JPanel();
		buttons.setVisible(true);
		buttons.setBounds(0, 80, 75, 15);
		buttons.setLayout(null);
		
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				random[i][j] = (int) (Math.random()*6); //generate the random numbers
				wheels[i][j] = new JLabel(random[i][j] + "|"); //set values to JLabel([i][j]) array.
				board.add(wheels[i][j]); //add 'wheels[][]' JLabel([i][j]) to 'board' JPanel.
			}
			lock[i] = false;
			locker[i] = new JButton();
			locker[i].addActionListener(this);
			locker[i].setActionCommand("lock" + i);
			locker[i].setBounds(0 + (15*i), 0, 15, 15);
			buttons.add(locker[i]); //add 'locker[]' JButton([i]) to 'buttons' JPanel.
		}
		
		roll = new JButton("Roll");
		roll.addActionListener(this);
		roll.setActionCommand("roll");
		roll.setBounds(75, 0, 55, 95);
		
		add(roll); //add components to window.
		add(board);
		add(buttons);
		
		validate();
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("roll")){
			for(int i = 0; i < 5; i++){
				for(int j = 0; j < 5; j++){
					if(lock[j] == false){ //if [boolean] lock([j]) is not True, execute the RNG for the current value.
						random[i][j] = (int) (Math.random()*6); //generate value...
						wheels[i][j].setText(random[i][j] + "|"); //set to JLabel([i][j])...
					}
				}
			}
		}
		for(int i = 0; i < 5; i++){
			if(event.getActionCommand().equals("lock" + i)){
				if(lock[i]==false){ //if button is pressed, and [boolean] lock([i]) is false, set value to True.
					lock[i] = true;
					locker[i].setBackground((Color) Color.red); //set button colour to red to signify that this column is locked.
				}else{ //else (if lock([i]) is NOT false [aka == True]) set value to false.
					lock[i] = false;
					locker[i].setBackground((Color) Color.gray); //set button colour to grey to signify that this column is unlocked (formerly locked).
				}
			}
		}
		
	}

}
