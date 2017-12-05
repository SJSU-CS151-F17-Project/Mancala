import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This will allow the user to interact with the board
 * @author Vivian Hoang
 *
 */
public class View implements ChangeListener {
	private ArrayList<JButton> pits;
	public View() {
		BasicBoard defaults = new BasicBoard();
		BoardIcon board = new BoardIcon(defaults,1200,500); //This is the board implements the Strategy
		JFrame frame = new JFrame("Mancala");
		Dimension window = new Dimension(1200,500);
		frame.setSize(window);
		
		
		
		JLabel label = new JLabel(board);
		JButton undo = new JButton("Undo");
		JPanel buttonPlace = new JPanel();
		buttonPlace.add(undo);
		frame.add(buttonPlace);
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * This will update the View every time the player clicks on the JButton
	 * @param arg0
	 */
	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * This will give the JButtons to the controller so it can decide what to do with the information
	 * @return
	 */
	public ArrayList<JButton> getPits(){
		return pits;
	}
	

	public static void main(String[] args) {
		View see = new View();
	}
}
