import java.util.LinkedList;

/**
 * The game logic for the entire system
 * This contains the current state, undo, and the move function
 * @author CriticalException
 *
 */

public class Mechanics {
	private static final int TOTAL = 14;
	private static final int MAX_UNDO = 3;
	
	class State{
		private int[] board;
		private boolean isPlayerOneTurn;
		
		public State(int marbles)
		{
			board = new int[TOTAL];
			for (int x = 0; x < TOTAL; x++) {
				if (x == 6 || x == 13) {
					board[x] = 0;
				} else {
					board[x] = marbles;
				}
			}
		}
		
		//deep copy a state
		public State(State other)
		{
			//copy the board
			this.board = new int[TOTAL];
			System.arraycopy( other.board, 0, this.board, 0, other.board.length );
			
			this.isPlayerOneTurn = other.isPlayerOneTurn;
		}
	}
	
	private State curState;
	private LinkedList<State> oldStates;
	private int curUndos;
	
	/**
	 * Initialize game with given number of marbles
	 * @param marbles are the total amount of marbles per pit
	 */
	public Mechanics(int marbles) {
		curUndos = MAX_UNDO;
		oldStates = new LinkedList<State>();
		curState = new State(marbles);
	}
	
	/**
	 * This will check if one of the sides is empty, if so the it will return true
	 * @return
	 */
	public boolean gameOver() {
		int total = 0;
		int otherTotal = 0;
		for(int x = 0; x < 6; x++) {
			total += curState.board[x];
		}
		for(int y = 7; y <13;y++) {
			otherTotal += curState.board[y];
		}
		if(total == 0 || otherTotal == 0) {
			//capture pieces and place them into mancala
			curState.board[6] += total;
			curState.board[13] += otherTotal;
			for(int i = 0; i < 14; i++) //clear the pits
			{
				if((i+1) % 7 != 0)
				{
					curState.board[i] = 0;
				}
			}
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
		int side = location / 7;
		
		//save to undo buffer
		//If new player made a move, clear the buffer. player 1's side is locations 0-6
		if(oldStates.peekLast() != null && oldStates.peekLast().isPlayerOneTurn != (side == 0 ? true : false))
		{
			curUndos = 3;
			oldStates.clear();
		}
		//System.out.println(oldStates.toString());
		oldStates.push(new State(curState));
		//System.out.println(oldStates.toString());
		
		
		int hand = curState.board[location];
		curState.board[location] = 0;
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
			curState.board[pivot++] += 1;
		}
		/*System.out.println(this.toString());*/
		if ((check == side && last == 6) || (check == side && last == 13))
			return true;
		else if ((curState.board[last] == 1) && ((pivot / 7) == side)) {
			if(curState.board[last] != curState.board[last] + curState.board[13-last-1])
				steal(last, side);
/*			System.out.println("Steal: ");
			System.out.println(this.toString());*/
			return false;
		}
		return false;
	}

	/**
	 * This undos the previous move 
	 */
	public void undo() {
		if(curUndos > 0 && oldStates.size() > 0)
		{
			curState = oldStates.removeLast();
			curUndos--;
		}
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
		curState.board[mancala] += curState.board[spot] + curState.board[13-spot-1];
		curState.board[spot] = 0;
		curState.board[13-spot-1] = 0;
	}

	/**
	 * Converts into string
	 */
	public String toString() {
		String first_row = "   ";
		String second_row = "";
		String playerTurn = "";
		for(int x =0 ; x < 7; x++){
			if(x ==6){
				first_row += " ";
			}
			first_row+=curState.board[x] + " ";
		}
		for(int x = 13; x > 6; x--){
			second_row += curState.board[x] + " ";
			if(x==13){
				second_row += " ";
			}
		}
		if(isPlayerOneTurn()){
			playerTurn = "It is Player 1's turn";
		}
		else{
			playerTurn = "It is Player 2's turn";
		}
		String together = second_row + "\n" + first_row + "\n" + playerTurn;
		return together;
	}
	
	/**
	 * This returns the array of marbles 
	 * @return
	 */
	public int[] getBoardState() {
		return curState.board;
	}
	
	/**
	 * This returns whether or not it is player one's turn
	 * @return isPlayerOneTurn
	 */
	public boolean isPlayerOneTurn() {
		return curState.isPlayerOneTurn;
	}

	/**
	 * This sets whether or not it is player one's turn
	 */
	public void setPlayerOneTurn(boolean isPlayerOneTurn) {
		curState.isPlayerOneTurn = isPlayerOneTurn;
	}
}