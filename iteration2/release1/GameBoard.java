import javax.swing.*;
import java.awt.*;

public class GameBoard
{
	private int row;
	private int col;
	private BoardTile[][] tiles;
	private JPanel gameBoard;
	private Robot blueRobot;
	private Robot yellowRobot;
	private Robot lightGrayRobot;
	private Robot greenRobot;
	private Robot redRobot;




	GameBoard()
	{
		this.row = 16;
		this.col = 16;
		this.gameBoard = new JPanel();
		createBoard();

	}

	public void setSimple(ColorScheme theme)
	{
		this.blueRobot = new Robot(0, 0, theme.getBlue());
		this.yellowRobot = new Robot(10, 3, theme.getYellow());
		this.lightGrayRobot = new Robot(8, 4, theme.getLightGray());
		this.greenRobot = new Robot(13, 5, theme.getGreen());
		this.redRobot = new Robot(3, 11, theme.getRed());


	}

	public void setComplex(ColorScheme theme)
	{
		this.greenRobot = new Robot(3, 4, theme.getGreen());
		this.blueRobot = new Robot(3, 11, theme.getBlue());
		this.redRobot = new Robot(9, 11, theme.getRed());
		this.yellowRobot = new Robot(0, 14, theme.getYellow());
		this.lightGrayRobot = new Robot(3, 14, theme.getLightGray());
	}

	public void createBoard()
	{
		this.gameBoard.setLayout(new GridLayout(this.row, this.col));
		tiles = new BoardTile[16][16];
		int i = 0;
		int j = 0;

		while(i < this.row)
		{
			while(j < this.col)
			{
				JPanel panel = new JPanel();
				BoardTile tile = new BoardTile(i, j);
				tile.setPreferredSize(new Dimension(31, 31));
				tile.setBorder(BorderFactory.createLineBorder(Color.black));
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

	public void getRobots()
	{
		Robot[] robots = new Robot[]{this.yellowRobot, this.greenRobot, this.blueRobot, this.redRobot, this.lightGrayRobot};
	}

}