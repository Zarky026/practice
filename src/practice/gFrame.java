package practice;

import java.awt.*;    //awt stands for "Abstract Window Toolkit"
import java.awt.event.*;

import javax.swing.*; //swing gives more modern GUI options
import javax.swing.event.*;

public class gFrame extends JFrame implements ActionListener, ChangeListener, MouseListener{

	private static boolean[] lock = new boolean[5];
	private static int[][] random = new int[5][5];
	private JLabel[][] wheels = new JLabel[5][5];
	private JButton[] locker = new JButton[5];
	private JButton roll;
	private JPanel board;
	private JPanel buttons;

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
				random[i][j] = (int) (Math.random()*6);
				wheels[i][j] = new JLabel(random[i][j] + "|");
				board.add(wheels[i][j]);
			}
			lock[i] = false;
			locker[i] = new JButton();
			locker[i].addActionListener(this);
			locker[i].setActionCommand("lock" + i);
			locker[i].setBounds(0 + (15*i), 0, 15, 15);
			buttons.add(locker[i]);
		}
		
		roll = new JButton("Roll");
		roll.addActionListener(this);
		roll.setActionCommand("roll");
		roll.setBounds(75, 0, 55, 95);
		
		add(roll);
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
					if(lock[j] == false){
						random[i][j] = (int) (Math.random()*6);
						wheels[i][j].setText(random[i][j] + "|");
					}
				}
			}
		}
		for(int i = 0; i < 5; i++){
			if(event.getActionCommand().equals("lock" + i)){
				if(lock[i]==false){
					lock[i] = true;
					locker[i].setBackground((Color) Color.red);
				}else{
					lock[i] = false;
					locker[i].setBackground((Color) Color.gray);
				}
			}
		}
		
	}

}
