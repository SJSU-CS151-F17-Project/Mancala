import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
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
	private Mechanics model;
	private Pit[] pits;
	private JButton undo;
	private Board style;
	
	public View(Mechanics m, Board style) {
		BasicBoard defaults = new BasicBoard();
		this.model = m;
		this.style = defaults;
		BoardIcon board = new BoardIcon(style,1200,500); //This is the board implements the Strategy
		JFrame frame = new JFrame("Mancala");
		Dimension window = new Dimension(1200,500);
		frame.setSize(window);
		JLabel label = new JLabel(board);
		undo = new JButton("Undo");
		undo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				model.undo();
			}
		});
		final JPanel hGrid = new JPanel(new GridLayout(0,8));
		for(int i = 1; i < 7; i++){
			JPanel vGrid = new JPanel(new GridLayout(2,0));
			final Pit topside = new Pit(0,12-i);
			final Pit botside = new Pit(0,i);
			final int index = i;
			vGrid.add(topside);
			vGrid.add(botside);
			topside.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					super.mouseClicked(e);
					model.move(index);
				}
			});
			botside.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					super.mouseClicked(e);
					model.move(index);
				}
			});
			hGrid.add(vGrid);
		}
		
		JPanel buttonPlace = new JPanel();
		buttonPlace.add(undo);
		frame.add(buttonPlace,BorderLayout.SOUTH);
		frame.add(hGrid,  BorderLayout.CENTER);
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
		int[] board = model.getBoardData();
		for(int i = 0; i < board.length; i++){
			
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
 * Driver class
 * @param args
 */
	public static void main(String[] args) {
		Mechanics m = new Mechanics(3);
		Board b = new BasicBoard();
		View see = new View(m, b);
	}
}
