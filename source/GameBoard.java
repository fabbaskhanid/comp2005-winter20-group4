import javax.swing.*;
import java.awt.*;

public class GameBoard
{
	private int row;
	private int col;
	private BoardTile[][] grid;

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

		this.grid[0][0].add(this.blueRobot.getIcon());
		this.grid[10][3].add(this.yellowRobot.getIcon());
		this.grid[8][4].add(this.lightGrayRobot.getIcon());
		this.grid[13][5].add(this.greenRobot.getIcon());
		this.grid[3][11].add(this.redRobot.getIcon());

		this.grid[1][2].setTargetChip(new TargetChip(theme.getGreen(), "assets/default/Green_Sun_TC.png"));
		this.grid[4][1].setTargetChip(new TargetChip(theme.getRed(), "assets/default/Red_Moon_TC.png"));
		this.grid[6][3].setTargetChip(new TargetChip(theme.getYellow(), "assets/default/Yellow_Star_TC.png"));
		this.grid[9][2].setTargetChip(new TargetChip(theme.getBlue(), "assets/default/Blue_Sun_TC.png"));
		this.grid[13][1].setTargetChip(new TargetChip(theme.getRed(), "assets/default/Red_Planet_TC.png"));
		this.grid[14][5].setTargetChip(new TargetChip(theme.getGreen(), "assets/default/Green_Star_TC.png"));
		this.grid[3][6].setTargetChip(new TargetChip(theme.getBlue(), "assets/default/Blue_Planet_TC.png"));
		this.grid[11][6].setTargetChip(new TargetChip(theme.getYellow(), "assets/default/Yellow_Moon_TC.png"));
		this.grid[1][9].setTargetChip(new TargetChip(theme.getBlue(), "assets/default/Blue_Moon_TC.png"));
		this.grid[4][10].setTargetChip(new TargetChip(theme.getGreen(), "assets/default/Green_Planet_TC.png"));
		this.grid[8][10].setTargetChip(new TargetChip(theme.getRed(), "assets/default/Red_Sun_TC.png"));
		this.grid[14][9].setTargetChip(new TargetChip(theme.getYellow(), "assets/default/Yellow_Planet_TC.png"));
		this.grid[13][11].setTargetChip(new TargetChip(theme.getGreen(), "assets/default/Green_Moon_TC.png"));
		this.grid[5][13].setTargetChip(new TargetChip(theme.getRed(), "assets/default/Red_Star_TC.png"));
		this.grid[10][13].setTargetChip(new TargetChip(theme.getBlue(), "assets/default/Blue_Star_TC.png"));
		this.grid[3][14].setTargetChip(new TargetChip(theme.getYellow(), "assets/default/Yellow_Sun_TC.png"));
		this.grid[5][8].setTargetChip(new TargetChip(theme.getLightGray(), "assets/default/Vortex.png"));

		this.grid[7][7].setBackground(Color.black);
		this.grid[7][8].setBackground(Color.black);
		this.grid[8][7].setBackground(Color.black);
		this.grid[8][8].setBackground(Color.black);

		this.grid[1][0].drawWall("EB");
		this.grid[11][0].drawWall("EB");
		this.grid[4][0].drawWall("SB");
		this.grid[13][0].drawWall("SB");
		this.grid[4][1].drawWall("WB");
		this.grid[13][1].drawWall("WB");
		this.grid[1][1].drawWall("SB");
		this.grid[1][2].drawWall("EB");
		this.grid[10][2].drawWall("WB");
		this.grid[9][3].drawWall("NB");
		this.grid[7][3].drawWall("WB");
		this.grid[6][4].drawWall("NB");
		this.grid[15][3].drawWall("SB");
		this.grid[0][6].drawWall("NB");
		this.grid[13][5].drawWall("EB");
		this.grid[14][6].drawWall("NB");
		this.grid[2][6].drawWall("EB");
		this.grid[3][7].drawWall("NB");
		this.grid[11][5].drawWall("SB");
		this.grid[12][6].drawWall("WB");
		this.grid[5][7].drawWall("SB");
		this.grid[6][8].drawWall("WB");
		this.grid[7][7].drawWall("WB");
		this.grid[7][8].drawWall("SB");
		this.grid[8][7].drawWall("NB");
		this.grid[1][10].drawWall("NB");
		this.grid[2][9].drawWall("WB");
		this.grid[15][9].drawWall("WB");
		this.grid[14][10].drawWall("NB");
		this.grid[3][10].drawWall("EB");
		this.grid[4][11].drawWall("NB");
		this.grid[8][9].drawWall("SB");
		this.grid[9][10].drawWall("WB");
		this.grid[15][10].drawWall("SB");
		this.grid[0][11].drawWall("SB");
		this.grid[5][12].drawWall("SB");
		this.grid[6][13].drawWall("WB");
		this.grid[10][12].drawWall("SB");
		this.grid[9][13].drawWall("EB");
		this.grid[3][14].drawWall("NB");
		this.grid[2][14].drawWall("EB");
		this.grid[6][15].drawWall("EB");
		this.grid[11][15].drawWall("WB");


	}

	public void setComplex(ColorScheme theme)
	{
		this.complex = true;
		this.greenRobot = new Robot(3, 4, "assets/default/Green_Robot.png");
		this.blueRobot = new Robot(3, 11, "assets/default/Blue_Robot.png");
		this.redRobot = new Robot(9, 11, "assets/default/Red_Robot.png");
		this.yellowRobot = new Robot(0, 14, "assets/default/Yellow_Robot.png");
		this.lightGrayRobot = new Robot(3, 14, "assets/default/Silver_Robot.png");

		this.grid[3][11].add(this.blueRobot.getIcon());
		this.grid[0][14].add(this.yellowRobot.getIcon());
		this.grid[3][14].add(this.lightGrayRobot.getIcon());
		this.grid[3][4].add(this.greenRobot.getIcon());
		this.grid[9][11].add(this.redRobot.getIcon());

		this.grid[1][3].setTargetChip(new TargetChip(theme.getRed(), "assets/default/Red_Moon_TC.png"));
		this.grid[10][1].setTargetChip(new TargetChip(theme.getRed(), "assets/default/Red_Planet_TC.png"));
		this.grid[6][4].setTargetChip(new TargetChip(theme.getYellow(), "assets/default/Yellow_Star_TC.png"));
		this.grid[8][4].setTargetChip(new TargetChip(theme.getBlue(), "assets/default/Blue_Sun_TC.png"));
		this.grid[13][5].setTargetChip(new TargetChip(theme.getGreen(), "assets/default/Green_Star_TC.png"));
		this.grid[2][6].setTargetChip(new TargetChip(theme.getGreen(), "assets/default/Green_Sun_TC.png"));
		this.grid[3][6].setTargetChip(new TargetChip(theme.getBlue(), "assets/default/Blue_Planet_TC.png"));
		this.grid[13][6].setTargetChip(new TargetChip(theme.getYellow(), "assets/default/Yellow_Moon_TC.png"));
		this.grid[2][9].setTargetChip(new TargetChip(theme.getYellow(), "assets/default/Yellow_Sun_TC.png"));
		this.grid[10][9].setTargetChip(new TargetChip(theme.getYellow(), "assets/default/Yellow_Planet_TC.png"));
		this.grid[12][11].setTargetChip(new TargetChip(theme.getRed(), "assets/default/Red_Sun_TC.png"));
		this.grid[3][12].setTargetChip(new TargetChip(theme.getGreen(), "assets/default/Green_Moon_TC.png"));
		this.grid[3][13].setTargetChip(new TargetChip(theme.getBlue(), "assets/default/Blue_Moon_TC.png"));
		this.grid[9][13].setTargetChip(new TargetChip(theme.getBlue(), "assets/default/Blue_Star_TC.png"));
		this.grid[5][14].setTargetChip(new TargetChip(theme.getRed(), "assets/default/Red_Star_TC.png"));
		

	
		this.grid[7][7].setBackground(Color.black);
		this.grid[7][8].setBackground(Color.black);
		this.grid[8][7].setBackground(Color.black);
		this.grid[8][8].setBackground(Color.black);




	}

	public void createBoard()
	{
		this.gameBoard.setLayout(new GridLayout(this.row, this.col));
		this.grid = new BoardTile[16][16];

		int i = 0;
		int j = 0;

		while(i < this.row)
		{
			while(j < this.col)
			{
				BoardTile panel = new BoardTile(j, i);
				panel.setPreferredSize(new Dimension(40, 40));
				panel.setBorder(BorderFactory.createLineBorder(Color.black));
				this.gameBoard.add(panel);
				this.grid[j][i] = panel; 
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