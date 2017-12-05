import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This will have the basic board
 * 
 * @author Vivian Hoang
 *
 */
public class BasicBoard implements Board {

	private static ImageIcon basicBoard;
	private ImageIcon pit;
	private ArrayList<JButton> pits;

	/**
	 * Initializes with the images
	 */
	public BasicBoard() {
		basicBoard = new ImageIcon("data/BasicBoard.jpg");
		pit = new ImageIcon("data/BasicPit.jpg");
	}

	/**
	 * This will override the paint so it will call the other functions
	 */
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		draw(g2);
	}

	/**
	 * This should allow to draw a the board including the buttons
	 */
	@Override
	public void draw(Graphics2D g) {
		AffineTransform tx = new AffineTransform();
		AffineTransform x = new AffineTransform();
		g.drawImage(basicBoard.getImage(), null, null);
		tx.translate(0, 50);
		for (int i = 0; i < 6; i++) {
			tx.translate(150, 0);
			g.drawImage(pit.getImage(), tx, null);
		}

		x.translate(0, 200);
		for (int i = 0; i < 6; i++) {
			x.translate(150, 0);
			g.drawImage(pit.getImage(), x, null);
		}
	}

	/**
	 * This will return the button of the pits for the View
	 * @return
	 */
	public ArrayList<JButton> getPits(){
		return pits;
	}
}
