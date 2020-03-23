import javax.swing.*;
import java.awt.Color;
import java.util.*;

public class BoardTile extends JPanel
{
	private int rowIndex;
	private int colIndex;
	private AdjacentTiles adjacentTiles;
	private TargetChip targetChip;
	private String wall;
	private Robot robot;
	private boolean normalWall;
	private boolean border;
	

	BoardTile(int row, int col)
	{
		super();
		this.rowIndex = row;
		this.colIndex = col;
		this.adjacentTiles = new AdjacentTiles();
		this.wall = null;
		this.robot = null;

	}

	public void occupy(Robot robot)
	{
		this.robot = robot;
	}

	public void leave()
	{
		this.robot = null;
	}

	public boolean isOccupied()
	{
		if(this.robot != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void setAdjacent(BoardTile north, BoardTile south, BoardTile east, BoardTile west)
	{
		this.adjacentTiles.setNorth(north);
		this.adjacentTiles.setSouth(south);
		this.adjacentTiles.setEast(east);
		this.adjacentTiles.setWest(west);
	}

	public AdjacentTiles getAdjacent()
	{
		return this.adjacentTiles;
	}

	public void setTargetChip(TargetChip targetChip)
	{
		this.targetChip = targetChip;
		this.add(targetChip.getIcon());
	}

	public TargetChip getTargetChip()
	{
		return this.targetChip;
	}



	public String getWall()
	{
		return this.wall;
	}

		public void drawWall(String wall)
	{
		this.wall = wall;

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