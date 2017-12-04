import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;

public class Board extends JComponent{
	
	private int [][] pits;
	private int[] mancalas;
	private BoardSkin skin;

	public Board(BoardSkin skin){
		this.skin = skin;
	}
	
	public Rectangle2D.Double[] getPitShape(){
		return skin.getPitBounds();
	}
	
	public void setBoardSize(int width, int height){
		setSize(new Dimension(width, height));
		skin.setSize(width, height);
	}
	
	public void paintComponent(Graphics g){
		skin.redraw(g, this, pits, mancalas);
	}
	
	public void setStones(int[][] pits, int[]mancalas){
		this.pits = pits;
		this.mancalas = mancalas;
	}
}
