import javax.swing.*;

public class BoardTile extends JButton
{
	private int rowIndex;
	private int colIndex;
	private AdjacentTiles adjacentTiles;
	private TargetChip targetChip;
	private Wall wall;
	private Robot robot;

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
		this.setBackground(targetChip.getColor());
	}

	public TargetChip getTargetChip()
	{
		return this.targetChip;
	}

	public void setWall(Wall newWall)
	{
		this.wall = newWall;
	}

	public Wall getWall()
	{
		return this.wall;
	}
}