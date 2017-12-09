import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 * This will allow the user to interact with the board
 * @author Vivian Hoang
 *
 */
public class View implements ChangeListener{
	private JButton undo;
	private JFrame frame;
	private JLabel label;
	private JButton changeStyle;
	private Mechanics rules;
	
	/**
	 * Initializes the view
	 */
	public View() {
		rules = new Mechanics(4);
		BoardIcon board = new BoardIcon(new BasicBoard(rules),1200,500); //This is the board implements the Strategy		
		
		frame = new JFrame("Mancala");
		Dimension window = new Dimension(1200,500);
		frame.setSize(window);
		label = new JLabel(board);
		undo = new JButton("Undo");
		changeStyle = new JButton("Change Style");
		
		JPanel buttonPlace = new JPanel();
		
		buttonPlace.setLayout(new GridLayout(0,2));
		buttonPlace.add(undo);
		buttonPlace.add(changeStyle);
		
		
		frame.add(buttonPlace,BorderLayout.SOUTH);
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	/**
	 * This will update the View every time the player clicks on the JButton
	 * @param arg0
	 */
	@Override
	public void stateChanged(ChangeEvent arg0) {
		label.repaint();
		if (rules.gameOver() == true) {
			JOptionPane.showMessageDialog(new JFrame(), "Game over!\n" + "Player One's score: " + rules.getBoardState()[6]
					+ "\n Player Two's score: " + rules.getBoardState()[13]);
		}

	}
	
	/**
	 * Passes the undo button to the Controller
	 * @return
	 */
	public JButton getUndoButton() {
		return undo;
	}
	
	/**
	 * Passes the frame to the Controller
	 * @return
	 */
	public JFrame getMainWindow() {
		return frame;
	}
	
	
	/**
	 * This returns the entire label containing painted board including the marbles
	 * @return
	 */
	public JLabel getBoard() {
		return label;
	}
	
	/**
	 * This will change the style of the board
	 * @return
	 */
	public JButton getChangeStyle() {
		return changeStyle;
	}
	
	/**
	 * Gets access to the data
	 * @return
	 */
	public Mechanics getMechanics() {
		return rules;
	}
	
}
