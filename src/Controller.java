import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Vivian Hoang
 *
 */
public class Controller {
	private GameModel game;
	public Controller(GameModel game) {
		this.game = game;
	}
	
	
	public void attach(View v) {
		//This should get data from the GameModel which in turns gets the undo state
		v.getUndoButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}
