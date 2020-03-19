public class AdjacentTiles
{
	private BoardTile north;
	private BoardTile south;
	private BoardTile east;
	private BoardTile west;

	AdjacentTiles()
	{
		this.north = null;
		this.south = null;
		this.east = null;
		this.west = null;
	}

	public void setNorth(BoardTile n)
	{
		this.north = n;
	}

	public void setSouth(BoardTile s)
	{
		this.south = s;
	}

	public void setEast(BoardTile e)
	{
		this.east = e;
	}

	public void setWest(BoardTile w)
	{
		this.west = w;
	}	

	public BoardTile getNorth()
	{
		return this.north;
	}	

	public BoardTile getSouth()
	{
		return this.south;
	}

	public BoardTile getEast()
	{
		return this.east;
	}

	public BoardTile getWest()
	{
		return this.west;
	}
}