import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 * This will allow the user to interact with the board
 * @author Vivian Hoang
 *
 */
public class View implements ChangeListener{
	private JButton undo;
	private JTextArea moveList;
	private JFrame frame;
	private JLabel label;
	private Mechanics rules;
	private Board style;
	
	/**
	 * Initializes the view
	 */
	public View(int n, Board b) {
		style = b;
		createGameFrame(n);
	}
	
	private void createGameFrame(int marbles)
	{
		rules = new Mechanics(marbles);
		style.setMechanics(rules);
		BoardIcon board = new BoardIcon(style,1200,500); //This is the board implements the Strategy
		
		frame = new JFrame("Mancala");
		Dimension window = new Dimension(1200,500);
		Dimension moves = new Dimension(50, 50);
		frame.setSize(window);
		label = new JLabel(board);
		undo = new JButton("Undo");	
		JPanel buttonPlace = new JPanel();
		buttonPlace.add(undo);
		moveList = new JTextArea("");
		frame.add(moveList, BorderLayout.SOUTH);
		moveList.setPreferredSize(moves);
		frame.add(buttonPlace,BorderLayout.NORTH);
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
		moveList.setText(rules.toString());
		label.repaint();
		if (rules.gameOver() == true) {
			moveList.setText(rules.toString());
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
	 * Gets access to the data
	 * @return
	 */
	public Mechanics getMechanics() {
		return rules;
	}
	
}
