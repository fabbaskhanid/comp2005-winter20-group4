import javax.swing.*;
import java.awt.*;

public class GameBoard
{
	private int row;
	private int col;
	private JPanel gameBoard;

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
				BoardTile tile = new BoardTile(i, j);
				tile.setBorder(BorderFactory.createLineBorder(Color.black));
				tile.setPreferredSize(new Dimension(30, 30));
				panel.add(tile);
				this.gameBoard.add(panel);
				j++;
			}
			j = 0;
			i++;
		}
		
	}

	public JPanel getBoardPanel()
	{
		return this.gameBoard;
	}

}