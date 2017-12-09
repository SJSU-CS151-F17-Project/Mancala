import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This calls for the GameModel that the data is to be changed
 * @author Vivian Hoang
 *
 */
public class Controller {
	private GameModel game;
	public Controller(GameModel game) {
		this.game = game;
	}
	
	
	/**
	 * This will allow the data to be modified when the View is interacted with
	 * @param v
	 */
	public void attach(View v) {
		//This should get data from the GameModel which in turns gets the undo state
		v.getUndoButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				game.undoMove();
			}
		});
		
		v.getBoard().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				game.getPit(e.getX(),e.getY());
			}			
		});
	}
}