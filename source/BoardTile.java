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
	private boolean angledWall;
	

	BoardTile(int row, int col)
	{
		super();
		this.rowIndex = row;
		this.colIndex = col;
		this.adjacentTiles = new AdjacentTiles();
		this.wall = null;
		this.robot = null;
		this.targetChip = null;

	}

	public Robot getRobot()
	{
		return this.robot;
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

	public void removeTargetChip()
	{
		this.targetChip = null;
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
			this.setBorder(BorderFactory.createMatteBorder(8, 1, 1, 1, Color.BLACK));
			border = true;
		}
		else if (wall == "EB") //east border
		{
			this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 8, Color.BLACK));
			border = true;
		}
		else if (wall == "SB") //south border
		{
			this.setBorder(BorderFactory.createMatteBorder(1, 1, 8, 1, Color.BLACK));
			border = true;
		}
		else if (wall == "WB") //east border
		{
			this.setBorder(BorderFactory.createMatteBorder(1, 8, 1, 1, Color.BLACK));
			border = true;
		}
		else if (wall == "NE") //north east wall
		{
			this.setBorder(BorderFactory.createMatteBorder(8, 1, 1, 8, Color.BLACK));
			normalWall = true;
		}
		else if (wall == "NW") //north west wall
		{
			this.setBorder(BorderFactory.createMatteBorder(8, 8, 1, 1, Color.BLACK));
			normalWall = true;
		}
		else if (wall == "SE") //south east wall
		{
			this.setBorder(BorderFactory.createMatteBorder(1, 1, 8, 8, Color.BLACK));
			normalWall = true;
		}
		else if (wall == "SW") //south west wall
		{
			this.setBorder(BorderFactory.createMatteBorder(1, 8, 8, 1, Color.BLACK));
			normalWall = true;
		}
		else {
			return;
		}
	}

	public String setAngledWall(String wallColor)
	{
		if (wallColor == "red") 
		{
			angledWall = true;
			return "assets/default/Red_Angled_Wall.png";
		}
		else if (wallColor == "blue") 
		{
			angledWall = true;
			return "assets/default/Blue_Angled_Wall.png";
		}
		else if (wallColor == "green") 
		{
			angledWall = true;
			return "assets/default/Green_Angled_Wall.png";
		}
		else if (wallColor == "yellow") 
		{
			angledWall = true;
			return "assets/default/Yellow_Angled_Wall.png";
		}
		else {
			return "invalid";
		}
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
		else if (angledWall == true)
		{
			return "Angled Wall";
		}
		else {
			return "None";
		}
	}
}
