import java.awt.Color;

import javax.swing.BorderFactory;

public class Wall {
	
	private Boolean passable;
	private BoardTile tile;
	
	public Wall(BoardTile tile)
	{
		this.tile = tile;
	}
	
	public Boolean getPassable() 
	{
		//see if passable
		return passable;
	}

	public void setPassable(Boolean passable) 
	{
		//set passable and unpassable
		this.passable = passable;
	}
	
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
}
