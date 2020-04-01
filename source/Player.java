// A class to represent a player in a game of Riccochet Robots

public class Player
{
	// name stores the player's name
	private String name;

	// targetChips stores how many target chips the player has accumulated
	private int targetChips;

	private int curBid;
	private boolean success;
	private int moveCount;

	Player(String name)
	{
		// name is initialised to the string passed in when declaring a new player
		this.name = name;
		// target chips is initialized to 0
		this.targetChips = 0;
		this.success = false;
		this.moveCount = 0;
		this.curBid = 0;
	}

	// getName returns the player's name stored in a string
	public String getName()
	{
		return this.name;
	}

	// getTargetChips returns the number of target chips a player has stored in a int
	public int getTargetChips()
	{
		return this.targetChips;
	}

	// addTargetChip increments the players target chip count
	public void addTargetChip()
	{
		this.targetChips += 1;
	}

	public void setBid(int newBid)
	{
		this.curBid = newBid;
	}

	public int getBid()
	{
		return this.curBid;
	}

	public void success()
	{
		this.success = true;
	}

	public Boolean isSuccessful()
	{
		return this.success;
	}

	public void move()
	{
		this.moveCount++;
	}

	public int getMoveCount()
	{
		return this.moveCount;
	}
}