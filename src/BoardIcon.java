import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Icon;

/**
 * This is the context to allow the use of drawing different Boards
 * @author CriticalException
 *
 */
public class BoardIcon implements Icon{

	private Board mancala;
	private int width;
	private int height;
	
	/**
	 * Creates board icon that implements the Strategy pattern
	 * @param mancala
	 * @param width
	 * @param height
	 */
	public BoardIcon(Board mancala, int width, int height) {
		this.mancala = mancala;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * This returns the board's height
	 */
	@Override
	public int getIconHeight() {
		return height;
	}

	/**
	 * This returns the board's width
	 */
	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	/**
	 * This paints the board when called to repaint
	 */
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		mancala.draw(g2);
	}

}
