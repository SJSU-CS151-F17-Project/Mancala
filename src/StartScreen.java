import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
/**
 * Screen that prompts for game settings
 *
 */
public class StartScreen {
	
	private int marbles;
	private Board style;
	
	/**
	 * Prompts the user for the number of marbles per slot and which style to use at the beginning of the game
	 */
	public void start(){
		//Style select-----
		JFrame styleFrame = new JFrame();
		styleFrame.setLayout(new BorderLayout());

		styleFrame.add(new JLabel("Select style of board.", SwingConstants.CENTER), BorderLayout.CENTER);
				
		JButton basicButton = new JButton("BasicBoard");
		basicButton.addActionListener(event ->
			{
				Mechanics m = new Mechanics(marbles);
				style = new BasicBoard(m);
				View mancala = new View(marbles, style);
				GameModel data = new GameModel(mancala);
				Controller manager = new Controller(data);
				manager.attach(mancala);
				styleFrame.dispose();
			}
		);
		styleFrame.add(basicButton, BorderLayout.WEST);
				
		JButton blackButton = new JButton("BlackBoard");
		blackButton.addActionListener(event ->
			{
				Mechanics m = new Mechanics(marbles);
				style = new BlackBoard(m);
				View mancala = new View(marbles, style);
				GameModel data = new GameModel(mancala);
				Controller manager = new Controller(data);
				manager.attach(mancala);
				styleFrame.dispose();
			}
		);
		styleFrame.add(blackButton, BorderLayout.EAST);
		
		//marble number select-----
		JFrame selectFrame = new JFrame();
		selectFrame.setLayout(new BorderLayout());

		selectFrame.add(new JLabel("Select number of marbles.", SwingConstants.CENTER), BorderLayout.CENTER);

		JButton threeButton = new JButton("3");
		threeButton.addActionListener(event ->
			{
				marbles = 3;
				selectFrame.dispose();
				
				styleFrame.setTitle("Select style of board");
				styleFrame.setSize(300,85);
				styleFrame.setVisible(true);
			}
		);
		selectFrame.add(threeButton, BorderLayout.WEST);

		JButton fourButton = new JButton("4");
		fourButton.addActionListener(event ->
			{
				marbles = 4;
				selectFrame.dispose();
				
				styleFrame.setTitle("Select style of board");
				styleFrame.setSize(300,85);
				styleFrame.setVisible(true);
			}
		);
		selectFrame.add(fourButton, BorderLayout.EAST);

		//finalize frame
		selectFrame.setTitle("Select number of marbles.");
		selectFrame.setSize(300,85);
		selectFrame.setVisible(true);
				

	}
}