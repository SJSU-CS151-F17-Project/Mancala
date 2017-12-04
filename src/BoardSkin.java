import java.awt.*;
import java.awt.geom.*;

public abstract class BoardSkin {
	
	protected Rectangle2D.Double[] pitBounds;
	protected int width;
	protected int height;
	
	public BoardSkin(int boardLength){
		pitBounds = new Rectangle2D.Double[boardLength];
	}
	
	public abstract void redraw(Graphics g, Board b, int[][]pits, int[] mancalas);
	
	public abstract String getName();
	
	public Rectangle2D.Double[] getPitBounds(){
		return pitBounds;
	}
	
	public void setSize(int width, int height){
		this.width = width;
		this.height = height;
	}
}
