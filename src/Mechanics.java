import java.util.*;
import javax.swing.event.*;
/**
 * 
 * @author CriticalException
 *
 */

public class Mechanics {
	private static final int TOTAL = 14;
	private static final int MAX_UNDOS = 3;
	private int[][] board;
	private int[] mancala;
	private boolean undo;
	private ArrayList<ChangeListener> listeners;
	private boolean isGameOver;

	public Mechanics(int marbles) {

		board = new int[TOTAL];
		for (int x = 0; x < TOTAL; x++) {
			if (x == 6 || x == 13) {
				board[x] = 0;
			} else {
				board[x] = marbles;
			}
		}
	}

	/**
	 * Player will choose a slot from above and will move
	 * 
	 * @return This will return true if the player can go again and false if not
	 * 
	 */
	public boolean move(int location) {
		int hand = board[location];
		int side = location / 7;
		board[location] = 0;
		int pivot = location;
		pivot++;
		int last = 0;
		while (hand > 0) {
			if (((pivot / 7) != side && pivot == 6) || ((pivot / 7) != side && pivot == 13)) {
				pivot++;
			}
			if (pivot == 14)
				pivot = 0;
			hand--;
			last = pivot;
			board[pivot++] += 1;
		}
		int check = pivot % 7;
		if ((check == side && last == 6) && (check == side && last == 13))
			return true;
		else if ((board[pivot] == 1) && ((pivot % 7) == side)) {
			steal(last, side);
			return false;
		}
		return false;
	}

	/**
	 * This undos the previous move and the current player will only have a
	 * maximum of 3 undos
	 */
	public void undo() {
		undo++;
	}

	/**
	 * 
	 * @param spot
	 * @param side
	 */
	public void steal(int spot, int side) {
		int mancala = 6;
		if (side == 1) {
			mancala = 13;
		}
		switch (spot) {
		case 0:
		case 12:
			board[mancala] = board[0] + board[12];
			board[0] = 0;
			board[12] = 0;
			break;
		case 1:
		case 11:
			board[mancala] = board[1] + board[11];
			board[1] = 0;
			board[11] = 0;
			break;
		case 2:
		case 10:
			board[mancala] = board[2] + board[10];
			board[2] = 0;
			board[10] = 0;
			break;
		case 3:
		case 9:
			board[mancala] = board[3] + board[9];
			board[3] = 0;
			board[9] = 0;
			break;
		case 4:
		case 8:
			board[mancala] = board[4] + board[8];
			board[4] = 0;
			board[8] = 0;
			break;
		case 5:
		case 7:
			board[mancala] = board[5] + board[7];
			board[5] = 0;
			board[7] = 0;
			break;
		}
	}
	
	public void addChangeListener(ChangeListener l){
		listeners.add(l);
		somethingChanged();
	}
	
	public void somethingChanged(){
		for(ChangeListener l: listeners){
			l.stateChanged(new ChangeEvent(this));
		}
	}

	public String toString() {
		String first_row = "   ";
		String second_row = "";
		for(int x =0 ; x < 7; x++){
			if(x ==6){
				first_row += " ";
			}
			first_row+=board[x] + " ";
		}
		for(int x = 13; x > 6; x--){
			second_row += board[x] + " ";
			if(x ==13){
				second_row += " ";
			}
		}
		String together = second_row + "\n" + first_row ;
		return together;
	}

	public static void main(String[] args) {
		Mechanics board = new Mechanics(4);
		System.out.println(board.toString());
		System.out.println(board.move(2));
		System.out.println("Results: ");
		System.out.println(board.toString());
	}
}
