import javax.swing.*;
import java.awt.*;

public class GameBoard
{
	private int row;
	private int col;
	JPanel gameBoard;

	GameBoard()
	{
		this.row = 16;
		this.col = 16;
		this.gameBoard = new JPanel();
		createBoard();
	}

	public void setSimple()
	{

	}

	public void setComplex()
	{

	}

	public void createBoard()
	{
		this.gameBoard.setLayout(new GridLayout(this.row, this.col));
		int i = 0;
		int j = 0;
		while(i < this.row)
		{
			while(j < this.col)
			{
				JPanel panel = new JPanel();
				panel.setBorder(BorderFactory.createLineBorder(Color.black));
				BoardTile tile = new BoardTile(i, j);
				tile.setPreferredSize(new Dimension(100, 100));
				panel.add(tile);
				this.gameBoard.add(panel);
				j++;
			}
			j = 0;
			i++;
		}
		
	}

}