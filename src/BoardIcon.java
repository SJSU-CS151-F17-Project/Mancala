import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Icon;

/**
 * This is the context to allow the use of drawing different Boards
 * @author Vivian Hoang
 *
 */
public class BoardIcon implements Icon{

	private Board mancala;
	private int width;
	private int height;
	public BoardIcon(Board mancala, int width, int height) {
		this.mancala = mancala;
		this.width = width;
		this.height = height;
	}
	@Override
	public int getIconHeight() {
		return height;
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		mancala.draw(g2);
	}

}
