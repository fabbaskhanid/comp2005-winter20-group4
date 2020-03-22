import javax.swing.*;
import java.awt.*;

public class GameBoard
{
	private int row;
	private int col;
	private JPanel[][] grid;
	private BoardTile[][] tiles;
	private JPanel gameBoard;
	private Robot blueRobot;
	private Robot yellowRobot;
	private Robot lightGrayRobot;
	private Robot greenRobot;
	private Robot redRobot;
	private Boolean complex;




	GameBoard()
	{
		this.row = 16;
		this.col = 16;
		this.gameBoard = new JPanel();
		createBoard();

	}

	public boolean isComplex()
	{
		return this.complex;
	}

	public void setSimple(ColorScheme theme)
	{
		this.complex = false;
		this.blueRobot = new Robot(0, 0, "assets/default/Blue_Robot.png");
		this.yellowRobot = new Robot(10, 3, "assets/default/Yellow_Robot.png");
		this.lightGrayRobot = new Robot(8, 4, "assets/default/Silver_Robot.png");
		this.greenRobot = new Robot(13, 5, "assets/default/Green_Robot.png");
		this.redRobot = new Robot(3, 11, "assets/default/Red_Robot.png");
		
		this.grid[0][0].removeAll();
		this.grid[10][3].removeAll();
		this.grid[8][4].removeAll();
		this.grid[13][5].removeAll();
		this.grid[3][11].removeAll();
		
		this.grid[0][0].add(this.blueRobot.getIcon());
		this.grid[10][3].add(this.yellowRobot.getIcon());
		this.grid[8][4].add(this.lightGrayRobot.getIcon());
		this.grid[13][5].add(this.greenRobot.getIcon());
		this.grid[3][11].add(this.redRobot.getIcon());

		this.tiles[1][2].setTargetChip(new TargetChip(theme.getGreen(), "assets/default/Green_Sun_TC.png"));
		this.tiles[4][1].setTargetChip(new TargetChip(theme.getRed(), "assets/default/Red_Moon_TC.png"));
		this.tiles[6][3].setTargetChip(new TargetChip(theme.getYellow(), "assets/default/Yellow_Star_TC.png"));
		this.tiles[9][2].setTargetChip(new TargetChip(theme.getBlue(), "assets/default/Blue_Sun_TC.png"));
		this.tiles[13][1].setTargetChip(new TargetChip(theme.getRed(), "assets/default/Red_Planet_TC.png"));
		this.tiles[14][5].setTargetChip(new TargetChip(theme.getGreen(), "assets/default/Green_Star_TC.png"));
		this.tiles[3][6].setTargetChip(new TargetChip(theme.getBlue(), "assets/default/Blue_Planet_TC.png"));
		this.tiles[11][6].setTargetChip(new TargetChip(theme.getYellow(), "assets/default/Yelloc_Moon_TC.png"));
		this.tiles[1][9].setTargetChip(new TargetChip(theme.getBlue(), "assets/default/Blue_Moon_TC.png"));
		this.tiles[4][10].setTargetChip(new TargetChip(theme.getGreen(), "assets/default/Green_Planet_TC.png"));
		this.tiles[8][10].setTargetChip(new TargetChip(theme.getRed(), "assets/default/Red_Sun_TC.png"));
		this.tiles[14][9].setTargetChip(new TargetChip(theme.getYellow(), "assets/default/Yellow_Planet_TC.png"));
		this.tiles[13][11].setTargetChip(new TargetChip(theme.getGreen(), "assets/default/Green_Moon_TC.png"));
		this.tiles[5][13].setTargetChip(new TargetChip(theme.getRed(), "assets/default/Red_Star_TC.png"));
		this.tiles[10][13].setTargetChip(new TargetChip(theme.getBlue(), "assets/default/Blue_Star_TC.png"));
		this.tiles[3][14].setTargetChip(new TargetChip(theme.getYellow(), "assets/default/Yellow_Sun_TC.png"));

	//	this.tiles[1][2].setBackground(theme.getGreen());
	//	this.tiles[4][1].setBackground(theme.getRed());
	//	this.tiles[6][3].setBackground(theme.getYellow());
//		this.tiles[9][2].setBackground(theme.getBlue());
//		this.tiles[13][1].setBackground(theme.getRed());
//		this.tiles[14][5].setBackground(theme.getGreen());
//		this.tiles[3][6].setBackground(theme.getBlue());
//		this.tiles[11][6].setBackground(theme.getYellow());
//		this.tiles[1][9].setBackground(theme.getBlue());
//		this.tiles[4][10].setBackground(theme.getGreen());
//		this.tiles[8][10].setBackground(theme.getRed());
//		this.tiles[14][9].setBackground(theme.getYellow());
//		this.tiles[13][11].setBackground(theme.getGreen());
//		this.tiles[5][13].setBackground(theme.getRed());
//		this.tiles[10][13].setBackground(theme.getBlue());
//		this.tiles[3][14].setBackground(theme.getYellow());
	



	}

	public void setComplex(ColorScheme theme)
	{
		this.complex = true;
		this.greenRobot = new Robot(3, 4, "assets/default/Green_Robot.png");
		this.blueRobot = new Robot(3, 11, "assets/default/Blue_Robot.png");
		this.redRobot = new Robot(9, 11, "assets/default/Red_Robot.png");
		this.yellowRobot = new Robot(0, 14, "assets/default/Yellow_Robot.png");
		this.lightGrayRobot = new Robot(3, 14, "assets/default/Silver_Robot.png");

		this.grid[3][4].removeAll();
		this.grid[3][11].removeAll();
		this.grid[9][11].removeAll();
		this.grid[0][14].removeAll();
		this.grid[3][14].removeAll();
		
		this.grid[3][11].add(this.blueRobot.getIcon();
		this.grid[0][14].add(this.yellowRobot.getIcon());
		this.grid[3][14].add(this.lightGrayRobot.getIcon());
		this.grid[3][4].add(this.greenRobot.getIcon());
		this.grid[9][11].add(this.redRobot.getIcon());

		this.tiles[1][3].setTargetChip(new TargetChip(theme.getRed(), "assets/default/Red_Moon_TC.png"));
		this.tiles[10][1].setTargetChip(new TargetChip(theme.getRed(), "assets/default/Red_Planet_TC.png"));
		this.tiles[6][4].setTargetChip(new TargetChip(theme.getYellow(), "assets/default/Yellow_Star_TC.png"));
		this.tiles[8][4].setTargetChip(new TargetChip(theme.getBlue(), "assets/default/Blue_Sun_TC.png"));
		this.tiles[13][5].setTargetChip(new TargetChip(theme.getGreen(), "assets/default/Green_Star_TC.png"));
		this.tiles[2][6].setTargetChip(new TargetChip(theme.getGreen(), "assets/default/Green_Sun_TC.png"));
		this.tiles[3][6].setTargetChip(new TargetChip(theme.getBlue(), "assets/default/Blue_Planet_TC.png"));
		this.tiles[13][6].setTargetChip(new TargetChip(theme.getYellow(), "assets/default/Yelloc_Moon_TC.png"));
		this.tiles[2][9].setTargetChip(new TargetChip(theme.getYellow(), "assets/default/Yellow_Sun_TC.png"));
		this.tiles[10][9].setTargetChip(new TargetChip(theme.getYellow(), "assets/default/Yellow_Planet_TC.png"));
		this.tiles[12][11].setTargetChip(new TargetChip(theme.getRed(), "assets/default/Red_Sun_TC.png"));
		this.tiles[3][12].setTargetChip(new TargetChip(theme.getGreen(), "assets/default/Green_Moon_TC.png"));
		this.tiles[3][13].setTargetChip(new TargetChip(theme.getBlue(), "assets/default/Blue_Moon_TC.png"));
		this.tiles[9][13].setTargetChip(new TargetChip(theme.getBlue(), "assets/default/Blue_Star_TC.png"));
		this.tiles[5][14].setTargetChip(new TargetChip(theme.getRed(), "assets/default/Red_Star_TC.png"));
		


	}

	public void createBoard()
	{
		this.gameBoard.setLayout(new GridLayout(this.row, this.col));
		this.grid = new JPanel[16][16];
		this.tiles = new BoardTile[16][16];
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
				this.grid[j][i] = panel; 
				this.tiles[j][i] = tile;
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