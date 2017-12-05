import java.util.ArrayList;

import javax.swing.JButton;

/**
 * This is the GameModel
 * @author Vivian Hoang
 *
 */
public class GameModel {
	private ArrayList<JButton> pits; 
	public GameModel(View v) {
		pits = v.getPits();
	}
}
