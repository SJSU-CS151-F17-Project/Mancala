import java.util.LinkedList;

/**
 * 
 * @author CriticalException
 *
 */

public class Mechanics {
	private static final int TOTAL = 14;
	private int[] board;
	private LinkedList<int[]> old_state;
	private int undo;

	public Mechanics(int marbles) {
		undo = 3;
		old_state = new LinkedList<int[]>();
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
	 * This will check if one of the sides is empty, if so the it will return true
	 * @return
	 */
	public boolean gameOver() {
		int total = 0;
		int otherTotal = 0;
		for(int x = 0; x < 6; x++) {
			total +=board[x];
		}
		for(int y = 7; y <13;y++) {
			otherTotal += board[y];
		}
		if(total == 0 || otherTotal == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Player will choose a slot from above and will move
	 * board[6] and board[13] are the MANCALAS
	 * @return This will return true if the player can go again and false if not
	 * 
	 */
	public boolean move(int location) {
		old_state.push(board);
		int hand = board[location];
		int side = location / 7;
		board[location] = 0;
		int pivot = location;
		pivot++;
		int last = 0;
		int check = pivot/7;
		while (hand > 0) {
			if (((pivot / 7) != side && pivot == 6) || ((pivot / 7) != side && pivot == 13)) {
				pivot++;
			}
			if (pivot == 14)
				pivot = 0;
			hand--;
			last = pivot;
			check = pivot/7;
			board[pivot++] += 1;
		}
		System.out.println(this.toString());
		if ((check == side && last == 6) || (check == side && last == 13))
			return true;
		else if ((board[last] == 1) && ((pivot / 7) == side)) {
			if(board[last] != board[last] + board[13-last-1])
				steal(last, side);
			System.out.println("Steal: ");
			System.out.println(this.toString());
			return false;
		}
		return false;
	}

	/**
	 * This undos the previous move 
	 */
	public void undo() {
		undo--;
		board = old_state.pop();
	}

	/**
	 * Stealing all the points
	 * @param spot
	 * @param side
	 */
	public void steal(int spot, int side) {
		int mancala = 6;
		if (side == 1) {
			mancala = 13;
		}
		board[mancala] += board[spot] + board[13-spot-1];
		board[spot] = 0;
		board[13-spot-1] = 0;
	}

	/**
	 * Converts into string to see for the test
	 */
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
			if(x==13){
				second_row += " ";
			}
		}
		String together = second_row + "\n" + first_row ;
		return together;
	}
	
	/**
	 * This returns the array of marbles 
	 * @return
	 */
	public int[] getBoardState() {
		return board;
	}

}