import java.awt.Color;
import javax.swing.BorderFactory;

public class Wall extends BoardTile{
	
	private boolean normalWall;
	private boolean border;
	
	public Wall(int row, int col, String wall)
	{
		super(row, col);
		drawWall(wall);
	}
	
	public void drawWall(String wall)
	{
		if (wall == "NB") //north border
		{
			setWallNorth();
		}
		else if (wall == "EB") //east border
		{
			setWallEast();
		}
		else if (wall == "SB") //south border
		{
			setWallSouth();
		}
		else if (wall == "WB") //east border
		{
			setWallWest();
		}
		else if (wall == "NE") //north east wall
		{
			setWallNorthEast();
		}
		else if (wall == "NW") //north west wall
		{
			setWallNorthWest();
		}
		else if (wall == "SE") //south east wall
		{
			setWallSouthEast();
		}
		else if (wall == "SW") //south west wall
		{
			setWallSouthWest();
		}
		else {
			return;
		}
	}
	
	public void setWallNorth()
	{
		this.setBorder(BorderFactory.createMatteBorder(8, 0, 0, 0, Color.BLACK));
		border = true;
	}
	
	public void setWallEast()
	{
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 8, Color.BLACK));
		border = true;
	}
	
	public void setWallSouth()
	{
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 8, 0, Color.BLACK));
		border = true;
	}
	
	public void setWallWest()
	{
		this.setBorder(BorderFactory.createMatteBorder(0, 8, 0, 0, Color.BLACK));
		border = true;
	}
	
	public void setWallNorthEast()
	{
		this.setBorder(BorderFactory.createMatteBorder(8, 0, 0, 8, Color.BLACK));
		normalWall = true;
	}
	
	public void setWallNorthWest()
	{
		this.setBorder(BorderFactory.createMatteBorder(8, 8, 0, 0, Color.BLACK));
		normalWall = true;
	}
	
	public void setWallSouthEast()
	{
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 8, 8, Color.BLACK));
		normalWall = true;
	}
	
	public void setWallSouthWest()
	{
		this.setBorder(BorderFactory.createMatteBorder(0, 8, 8, 0, Color.BLACK));
		normalWall = true;
	}
	
	public String returnWall()
	{
		if(normalWall == true)
		{
			return "Normal Wall";
		}
		else if (border == true)
		{
			return "Border";
		}
		else {
			return "None";
		}
	}
}
