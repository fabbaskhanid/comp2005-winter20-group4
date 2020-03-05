public class Settings
{
	private Player[] players;
	private GameBoard gameBoard;
	private ColorScheme theme;

	Settings()
	{
		this.players = new Player[4];
		this.gameBoard = new GameBoard();
		this.theme = new ColorScheme(0);
	}

	public void setPlayers(Player a, Player b, Player c, Player d)
	{
		this.players = new Player[]{a, b, c, d};
	}

	public void setGameBoard(GameBoard newGameBoard)
	{
		this.gameBoard = newGameBoard;
	}

	public void setTheme(ColorScheme newColorScheme)
	{
		this.theme = newColorScheme;	
	}
}