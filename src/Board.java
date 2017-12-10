import java.awt.Graphics2D;

/**
 * The interface for different styles of boards
 * @author CriticalException
 *
 */
public interface Board{
	/**
	 * This will allow each a different style of the board
	 * @param g the Graphics
	 */
	void draw(Graphics2D g);
	void setMechanics(Mechanics m);
}

