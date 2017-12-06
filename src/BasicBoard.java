import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;

/**
 * This will have the basic board 
 * The Board has 1200 x 500 pixels
 * The Pit is 130 x 130 pixels
 * The Mancala is 130 x 350 pixels
 * 
 * @author Vivian Hoang
 *
 */
public class BasicBoard implements Board {

	private static ImageIcon basicBoard;
	private ImageIcon pit;
	private ImageIcon mancala;

	/**
	 * Initializes with the images
	 */
	public BasicBoard() {
		basicBoard = new ImageIcon("data/BasicBoard.jpg");
		pit = new ImageIcon("data/BasicPit.jpg");
		mancala = new ImageIcon("data/BasicMancala.jpg");
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
		AffineTransform o = new AffineTransform();
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
		
		g.drawImage(mancala.getImage(),o,null);
		o.translate(1070,0);
		g.drawImage(mancala.getImage(),o,null);
	}

	
}
