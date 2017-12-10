import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

/**
 * This will have the basic board 
 * The Board has 1200 x 500 pixels 
 * The Pit is 130
 * x 130 pixels 
 * The Mancala is 130 x 350 pixels
 * 
 * @author CriticalException
 *
 */
public class BlackBoard implements Board {

	private static ImageIcon basicBoard;
	private ImageIcon pit;
	private ImageIcon mancala;
	private Mechanics data;
	private ArrayList<Rectangle> playerOne;
	private ArrayList<Rectangle> playerTwo;

	/**
	 * This initializes the board
	 * @param rules
	 */
	public BlackBoard(Mechanics rules) {
		data = rules;
		basicBoard = new ImageIcon("data/BlackBoard.jpg");
		pit = new ImageIcon("data/MarblePit.jpg");
		mancala = new ImageIcon("data/MarbleMancala.jpg");
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
	 * This sets the mechanics
	 * @param m the mechanics
	 */
	 public void setMechanics(Mechanics m){
		 data=m;
	 }

	/**
	 * This should allow to draw a the board including the marbles
	 */
	@Override
	public void draw(Graphics2D g) {
		Random rand = new Random();
		int[] boardValues = data.getBoardState();
		AffineTransform tx = new AffineTransform();
		AffineTransform x = new AffineTransform();
		AffineTransform o = new AffineTransform();
		g.drawImage(basicBoard.getImage(), null, null);
		tx.translate(0, 50);

		for (int i = 0; i < 6; i++) {
			tx.translate(150, 0);
			g.drawImage(pit.getImage(), tx, null);
		}
		x.translate(0, 200);
		for (int i = 0; i < 6; i++) {
			x.translate(150, 0);
			g.drawImage(pit.getImage(), x, null);
		}

		g.drawImage(mancala.getImage(), o, null);
		o.translate(1070, 0);
		g.drawImage(mancala.getImage(), o, null);

		for (int counter = 0; counter < 6; counter++) {
			for (int count = 0; count < boardValues[counter]; count++) {
				int rectX = (int) playerOne.get(counter).getX();
				int rectY = (int) playerOne.get(counter).getY();
				int xvalue = rand.nextInt((rectX + 80) - rectX - 1) + rectX;
				int yvalue = rand.nextInt((rectY + 80) - rectY - 1) + rectY;
				Ellipse2D marble = new Ellipse2D.Double(xvalue, yvalue, 50, 50);
				g.setColor(Color.WHITE);
				g.draw(marble);
				g.setColor(Color.BLACK);
				g.fill(marble);
			}
		}
		for (int counter = 0,index = 12; counter < 6; counter++,index--) {
			for (int count = 0; count < boardValues[index]; count++) {
				int rectX = (int) playerTwo.get(counter).getX();
				int rectY = (int) playerTwo.get(counter).getY();
				int xvalue = rand.nextInt((rectX + 80) - rectX - 1) + rectX;
				int yvalue = rand.nextInt((rectY + 80) - rectY - 1) + rectY;
				Ellipse2D marble = new Ellipse2D.Double(xvalue, yvalue, 50, 50);
				g.setColor(Color.WHITE);
				g.draw(marble);
				g.setColor(Color.BLACK);
				g.fill(marble);
			}
		}
		for (int count = 0; count < boardValues[6]; count++) {
			int rectX = 1070;
			int rectY = 0;
			int xvalue = rand.nextInt((rectX + 80) - rectX - 1) + rectX;
			int yvalue = rand.nextInt((rectY + 320) - rectY - 1) + rectY;
			Ellipse2D marble = new Ellipse2D.Double(xvalue, yvalue, 50, 50);
			g.setColor(Color.WHITE);
			g.draw(marble);
			g.setColor(Color.BLACK);
			g.fill(marble);
		}
		for (int count = 0; count < boardValues[13]; count++) {
			int rectX = 0;
			int rectY = 0;
			int xvalue = rand.nextInt((rectX + 80) - rectX - 1) + rectX;
			int yvalue = rand.nextInt((rectY + 320) - rectY - 1) + rectY;
			Ellipse2D marble = new Ellipse2D.Double(xvalue, yvalue, 50, 50);
			g.setColor(Color.WHITE);
			g.draw(marble);
			g.setColor(Color.BLACK);
			g.fill(marble);
		}
		

	}

}
