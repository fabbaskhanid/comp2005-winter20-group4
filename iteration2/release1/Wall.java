import java.awt.Color;
import javax.swing.BorderFactory;

public class Wall extends BoardTile{
	
	private int rowIndex;
	private int colIndex;
	
	public Wall(int row, int col)
	{
		super(row, col);
	}
/*	
	public void setWallNorth()
	{
		tile.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, Color.BLACK));
	}
	
	public void setWallEast()
	{
		tile.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5, Color.BLACK));
	}
	
	public void setWallSouth()
	{
		tile.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.BLACK));
	}
	
	public void setWallWest()
	{
		tile.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.BLACK));
	}
	*/
}
