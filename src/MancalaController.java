import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MancalaController extends JFrame implements MouseListener, ChangeListener, ActionListener{
	
	private Mechanics model;
	private Board board;
	private Jlabel player;
	private JButton undo;
	
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 700;
	private static final int BOARD_WIDTH = 500;
	private static final int BOARD_HEIGHT = 300;
	
	public MancalaController(BoardSkin[] skins){
		
	}
	
	public void start(int marbles, BoardSkin skin){
		model = new Mechanics(marbles);
		board = new Board(skin);
		Mechanics.addChangeListener(this);
	}
}
