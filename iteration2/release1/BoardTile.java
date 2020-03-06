import javax.swing.*;

public class BoardTile extends JButton
{
	private int rowIndex;
	private int colIndex;
	private boolean occupied;
	private AdjacentTiles adjacentTiles;
	private boolean targetLocation;
	private Wall wall;

	BoardTile(int row, int col)
	{
		super();
		this.rowIndex = row;
		this.colIndex = col;
		this.occupied = false;
		this.adjacentTiles = new AdjacentTiles();
		this.targetLocation = false;
		this.wall = null;
	}

	public void occupy()
	{
		this.occupied = true;
	}

	public void leave()
	{
		this.occupied = false;
	}

	public boolean isOccupied()
	{
		return this.occupied;
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

	public void setTargetLocation()
	{
		this.targetLocation = true;
	}

	public boolean getTargetLocation()
	{
		return this.targetLocation;
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