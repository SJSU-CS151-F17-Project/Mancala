
/**
 * This will run the application as well
 * @author Vivian Hoang
 *
 */
public class MancalaTester {
	public static void main(String[] args) {
		View mancala = new View();
		GameModel data = new GameModel(mancala);
		Controller manager = new Controller(data);
		manager.attach(mancala);
	}
}
