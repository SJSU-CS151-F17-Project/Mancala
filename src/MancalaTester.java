import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * This will run the application as well
 * @author Vivian Hoang
 *
 */
public class MancalaTester {
	public static void main(String[] args) {
		
		//marble number select-----
		JFrame selectFrame = new JFrame();
		selectFrame.setLayout(new BorderLayout());

		selectFrame.add(new JLabel("Select number of marbles.", SwingConstants.CENTER), BorderLayout.CENTER);

		JButton threeButton = new JButton("3");
		threeButton.addActionListener(event ->
			{
				View mancala = new View(3);
				GameModel data = new GameModel(mancala);
				Controller manager = new Controller(data);
				manager.attach(mancala);
				selectFrame.dispose();
			}
		);
		selectFrame.add(threeButton, BorderLayout.WEST);

		JButton fourButton = new JButton("4");
		fourButton.addActionListener(event ->
			{
				View mancala = new View(4);
				GameModel data = new GameModel(mancala);
				Controller manager = new Controller(data);
				manager.attach(mancala);
				selectFrame.dispose();
			}
		);
		selectFrame.add(fourButton, BorderLayout.EAST);

		//finalize frame
		selectFrame.setTitle("Select number of marbles.");
		selectFrame.setSize(300,85);
		selectFrame.setVisible(true);
		//-------------------------		
		
		/*
		View mancala = new View();
		GameModel data = new GameModel(mancala);
		Controller manager = new Controller(data);
		manager.attach(mancala);
		*/
	}
}
