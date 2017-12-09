import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;

/**
 * This is the GameModel
 * 
 * @author Vivian Hoang
 *
 */
public class GameModel {
	private View mancala;
	private Mechanics rules;
	private ArrayList<Rectangle> playerOne;
	private ArrayList<Rectangle> playerTwo;
	public GameModel(View v) {
		mancala = v;
		rules = v.getMechanics();
		rules.setPlayerOneTurn(true);
		playerOne = new ArrayList<Rectangle>(6);
		playerTwo = new ArrayList<Rectangle>(6);
		for (int x = 0; x < 6; x++) {
			playerTwo.add(new Rectangle(150 * (x + 1), 50, 130, 130));
		}
		for (int x = 0; x < 6; x++) {
			playerOne.add(new Rectangle(150 * (x + 1), 200, 130, 130));
		}

	}

	/**
	 * This will get the pit
	 * Player one are the bottom pits
	 * Player two are the top pits
	 * The pits are labeled 0 - 13 starting from the left pit and ending to the left mancala
	 * 13 12 11 10 9 8 7
	 * 0 1 2 3 4 5 6
	 * @param mouseXpos
	 * @param mouseYpos
	 */
	public void getPit(int mouseXpos, int mouseYpos) {
		boolean goAgain = false;
		Point mouseClickLocation = new Point(mouseXpos, mouseYpos);
		if (rules.isPlayerOneTurn()) {
			for (int counter = 0; counter < 6; counter++) {
				if (playerOne.get(counter).contains(mouseClickLocation)) {
					if (rules.getBoardState()[counter] == 0)
						return;
					System.out.println("Index: " + counter);
					goAgain = rules.move(counter);
					if (goAgain == false) {
						rules.setPlayerOneTurn(false);
						rules.toString();
						System.out.println("It is now Player Two's turn");
						mancala.stateChanged(new ChangeEvent(this));
						break;
					} else {
						System.out.println("Player One can go again");
						mancala.stateChanged(new ChangeEvent(this));
					}
				}
			}
		} else {
			for (int counter = 0, index = 12; counter < 6; counter++, index--) {
				if (playerTwo.get(counter).contains(mouseClickLocation)) {
					if (rules.getBoardState()[index] == 0)
						return;
					System.out.println("Index: " + index);
					goAgain = rules.move(index);
					if (goAgain == false) {
						rules.setPlayerOneTurn(true);
						rules.toString();
						System.out.println("It is now Player One's turn");
						mancala.stateChanged(new ChangeEvent(this));
						break;
					} else {
						System.out.println("Player Two can go again");
						mancala.stateChanged(new ChangeEvent(this));
					}
				}

			}
		}
	}

	/**
	 *  This should let the board undo a move
	 */
	public void undoMove() {
		rules.undo();
		mancala.stateChanged(new ChangeEvent(this));
	}

}
