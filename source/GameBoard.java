import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class GameBoard
{
	private int row;
	private int col;
	private BoardTile[][] grid;
	private JPanel gameBoard;
	private ArrayList<Robot> robots;
	private Boolean complex;
	private ArrayList<TargetChip> chips;
	private TargetChip targetChip;
	private Robot curRobot;



	GameBoard()
	{
		this.robots = new ArrayList<Robot>();
		this.row = 16;
		this.col = 16;
		this.gameBoard = new JPanel();
		this.chips = new ArrayList<TargetChip>();
		createBoard();

	}

	public boolean isComplex()
	{
		return this.complex;
	}

	public void setSimple(ColorScheme theme)
	{
		this.complex = false;
		Robot blueRobot = new Robot(theme.getBlue(), 0, 0, "assets/default/Blue_Robot.png");
		Robot yellowRobot = new Robot(theme.getYellow(), 10, 3, "assets/default/Yellow_Robot.png");
		Robot lightGrayRobot = new Robot(theme.getLightGray(), 8, 4, "assets/default/Silver_Robot.png");
		Robot greenRobot = new Robot(theme.getGreen(), 13, 5, "assets/default/Green_Robot.png");
		Robot redRobot = new Robot(theme.getRed(), 3, 11, "assets/default/Red_Robot.png");

		this.robots = new ArrayList<>(Arrays.asList(greenRobot, blueRobot, yellowRobot, lightGrayRobot, greenRobot, redRobot));

		this.grid[0][0].add(blueRobot.getIcon());
		this.grid[10][3].add(yellowRobot.getIcon());
		this.grid[8][4].add(lightGrayRobot.getIcon());
		this.grid[13][5].add(greenRobot.getIcon());
		this.grid[3][11].add(redRobot.getIcon());

		this.grid[0][0].occupy(blueRobot);
		this.grid[10][3].occupy(yellowRobot);
		this.grid[8][4].occupy(lightGrayRobot);
		this.grid[13][5].occupy(greenRobot);
		this.grid[3][11].occupy(redRobot);

		this.grid[0][0].add(blueRobot.getIcon());
		blueRobot.getIcon().addActionListener(p -> setCurRobot(blueRobot));
		this.grid[10][3].add(yellowRobot.getIcon());
		yellowRobot.getIcon().addActionListener(p -> setCurRobot(yellowRobot));
		this.grid[8][4].add(lightGrayRobot.getIcon());
		lightGrayRobot.getIcon().addActionListener(p -> setCurRobot(lightGrayRobot));
		this.grid[13][5].add(greenRobot.getIcon());
		greenRobot.getIcon().addActionListener(p-> setCurRobot(greenRobot));
		this.grid[3][11].add(redRobot.getIcon());
		redRobot.getIcon().addActionListener(p -> setCurRobot(redRobot));

		TargetChip greenSun = new TargetChip(5, theme.getGreen(), "assets/default/Green_Sun_TC.png");
		TargetChip redMoon = new TargetChip(0, theme.getRed(), "assets/default/Red_Moon_TC.png");
		TargetChip yellowStar = new TargetChip(2, theme.getYellow(), "assets/default/Yellow_Star_TC.png");
		TargetChip blueSun = new TargetChip(3, theme.getBlue(), "assets/default/Blue_Sun_TC.png");
		TargetChip redPlanet = new TargetChip(1, theme.getRed(), "assets/default/Red_Planet_TC.png");
		TargetChip greenStar = new TargetChip(4, theme.getGreen(), "assets/default/Green_Star_TC.png");
		TargetChip bluePlanet = new TargetChip(6, theme.getBlue(), "assets/default/Blue_Planet_TC.png");
		TargetChip yellowMoon = new TargetChip(7, theme.getYellow(), "assets/default/Yellow_Moon_TC.png");
		TargetChip blueMoon = new TargetChip(13, theme.getBlue(), "assets/default/Blue_Moon_TC.png");
		TargetChip greenPlanet = new TargetChip(12, theme.getGreen(), "assets/default/Green_Planet_TC.png");
		TargetChip redSun = new TargetChip(8, theme.getRed(), "assets/default/Red_Sun_TC.png");
		TargetChip yellowPlanet = new TargetChip(9, theme.getYellow(), "assets/default/Yellow_Planet_TC.png");
		TargetChip greenMoon = new TargetChip(11, theme.getGreen(), "assets/default/Green_Moon_TC.png");
		TargetChip redStar = new TargetChip(15, theme.getRed(), "assets/default/Red_Star_TC.png");
		TargetChip blueStar = new TargetChip(14, theme.getBlue(), "assets/default/Blue_Star_TC.png");
		TargetChip yellowSun = new TargetChip(10, theme.getYellow(), "assets/default/Yellow_Sun_TC.png");
		TargetChip vortex = new TargetChip(16, theme.getLightGray(), "assets/default/Vortex.png");

		this.chips = new ArrayList<>(Arrays.asList(greenSun, redMoon, yellowStar, blueSun, redPlanet, greenStar,
		 bluePlanet, greenPlanet, redSun, yellowPlanet, greenMoon, redStar, blueStar, yellowSun, vortex));
		

		this.grid[1][2].setTargetChip(greenSun);
		this.grid[4][1].setTargetChip(redMoon);
		this.grid[6][3].setTargetChip(yellowStar);
		this.grid[9][2].setTargetChip(blueSun);
		this.grid[13][1].setTargetChip(redPlanet);
		this.grid[14][5].setTargetChip(greenStar);
		this.grid[3][6].setTargetChip(bluePlanet);
		this.grid[11][6].setTargetChip(yellowMoon);
		this.grid[1][9].setTargetChip(blueMoon);
		this.grid[4][10].setTargetChip(greenPlanet);
		this.grid[8][10].setTargetChip(redSun);
		this.grid[14][9].setTargetChip(yellowPlanet);
		this.grid[13][11].setTargetChip(greenMoon);
		this.grid[5][13].setTargetChip(redStar);
		this.grid[10][13].setTargetChip(blueStar);
		this.grid[3][14].setTargetChip(yellowSun);
		this.grid[5][8].setTargetChip(vortex);

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
		Robot greenRobot = new Robot(theme.getGreen(), 3, 4, "assets/default/Green_Robot.png");
		Robot blueRobot = new Robot(theme.getBlue(), 3, 11, "assets/default/Blue_Robot.png");
		Robot redRobot = new Robot(theme.getRed(), 9, 11, "assets/default/Red_Robot.png");
		Robot yellowRobot = new Robot(theme.getYellow(), 0, 14, "assets/default/Yellow_Robot.png");
		Robot lightGrayRobot = new Robot(theme.getLightGray(), 3, 14, "assets/default/Silver_Robot.png");

		this.robots.add(greenRobot);
		this.robots.add(blueRobot);
		this.robots.add(yellowRobot);
		this.robots.add(redRobot);

		this.grid[3][11].add(blueRobot.getIcon());
		blueRobot.getIcon().addActionListener(p -> setCurRobot(blueRobot));
		this.grid[0][14].add(yellowRobot.getIcon());
		yellowRobot.getIcon().addActionListener(p -> setCurRobot(yellowRobot));
		this.grid[3][14].add(lightGrayRobot.getIcon());
		lightGrayRobot.getIcon().addActionListener(p -> setCurRobot(lightGrayRobot));
		this.grid[3][4].add(greenRobot.getIcon());
		greenRobot.getIcon().addActionListener(p-> setCurRobot(greenRobot));
		this.grid[9][11].add(redRobot.getIcon());
		redRobot.getIcon().addActionListener(p -> setCurRobot(redRobot));


		TargetChip greenSun = new TargetChip(5, theme.getGreen(), "assets/default/Green_Sun_TC.png");
		TargetChip redMoon = new TargetChip(0, theme.getRed(), "assets/default/Red_Moon_TC.png");
		TargetChip yellowStar = new TargetChip(2, theme.getYellow(), "assets/default/Yellow_Star_TC.png");
		TargetChip blueSun = new TargetChip(3, theme.getBlue(), "assets/default/Blue_Sun_TC.png");
		TargetChip redPlanet = new TargetChip(1, theme.getRed(), "assets/default/Red_Planet_TC.png");
		TargetChip greenStar = new TargetChip(4, theme.getGreen(), "assets/default/Green_Star_TC.png");
		TargetChip bluePlanet = new TargetChip(6, theme.getBlue(), "assets/default/Blue_Planet_TC.png");
		TargetChip yellowMoon = new TargetChip(7, theme.getYellow(), "assets/default/Yellow_Moon_TC.png");
		TargetChip blueMoon = new TargetChip(13, theme.getBlue(), "assets/default/Blue_Moon_TC.png");
		TargetChip greenPlanet = new TargetChip(12, theme.getGreen(), "assets/default/Green_Planet_TC.png");
		TargetChip redSun = new TargetChip(10, theme.getRed(), "assets/default/Red_Sun_TC.png");
		TargetChip yellowPlanet = new TargetChip(9, theme.getYellow(), "assets/default/Yellow_Planet_TC.png");
		TargetChip greenMoon = new TargetChip(11, theme.getGreen(), "assets/default/Green_Moon_TC.png");
		TargetChip redStar = new TargetChip(15, theme.getRed(), "assets/default/Red_Star_TC.png");
		TargetChip blueStar = new TargetChip(14, theme.getBlue(), "assets/default/Blue_Star_TC.png");
		TargetChip yellowSun = new TargetChip(8, theme.getYellow(), "assets/default/Yellow_Sun_TC.png");
		TargetChip vortex = new TargetChip(16, theme.getLightGray(), "assets/default/Vortex.png");

		this.chips.add(greenSun);
		this.chips.add(redMoon);
		this.chips.add(yellowStar);
		this.chips.add(blueSun);
		this.chips.add(redPlanet);
		this.chips.add(greenStar);
		this.chips.add(bluePlanet);
		this.chips.add(yellowMoon);
		this.chips.add(blueMoon);
		this.chips.add(greenPlanet);
		this.chips.add(redSun);
		this.chips.add(yellowPlanet);
		this.chips.add(greenMoon);
		this.chips.add(redStar);
		this.chips.add(blueStar);
		this.chips.add(yellowSun);
	//	this.chips.add(vortex);
			
		this.grid[1][3].setTargetChip(redMoon);
		this.grid[10][1].setTargetChip(redPlanet);
		this.grid[6][4].setTargetChip(yellowStar);
		this.grid[8][4].setTargetChip(blueSun);
		this.grid[13][5].setTargetChip(greenStar);
		this.grid[2][6].setTargetChip(greenSun);
		this.grid[3][6].setTargetChip(bluePlanet);
		this.grid[13][6].setTargetChip(yellowMoon);
		this.grid[2][9].setTargetChip(yellowSun);
		this.grid[10][9].setTargetChip(yellowPlanet);
		this.grid[12][11].setTargetChip(redSun);
		this.grid[12][12].setTargetChip(greenMoon);
		this.grid[3][12].setTargetChip(greenPlanet);
		this.grid[3][13].setTargetChip(blueMoon);
		this.grid[9][13].setTargetChip(blueStar);
		this.grid[5][14].setTargetChip(redStar);
		

	
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
				panel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
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

	public ArrayList<Robot> getRobots()
	{
		return this.robots;
	}

	public void flipChip(ColorScheme theme)
	{
		Random rand = new Random();
		int chipInd = rand.nextInt(16) + 1;
		System.out.println(chipInd);
		switch (chipInd)
		{
			case 1:	 targetChip = new TargetChip(0, theme.getRed(), "assets/default/Red_Moon_TC.png");
				break;
			case 2:	targetChip = new TargetChip(1, theme.getRed(), "assets/default/Red_Planet_TC.png");
				break;
			case 3:	targetChip = new TargetChip(2, theme.getYellow(), "assets/default/Yellow_Star_TC.png");
				break;
			case 4:	targetChip = new TargetChip(3, theme.getBlue(), "assets/default/Blue_Sun_TC.png");
				break;
			case 5:	targetChip = new TargetChip(4, theme.getGreen(), "assets/default/Green_Star_TC.png");
				break;		
			case 6:	targetChip = new TargetChip(5, theme.getGreen(), "assets/default/Green_Sun_TC.png");
				break;	
			case 7:	targetChip = new TargetChip(6, theme.getBlue(), "assets/default/Blue_Planet_TC.png");
				break;
			case 8:	targetChip = new TargetChip(7, theme.getYellow(), "assets/default/Yellow_Moon_TC.png");
				break;
			case 9:	targetChip = new TargetChip(8, theme.getYellow(), "assets/default/Yellow_Sun_TC.png");
				break;
			case 10:	targetChip = new TargetChip(9, theme.getYellow(), "assets/default/Yellow_Planet_TC.png");
				break;
			case 11:	targetChip = new TargetChip(10, theme.getRed(), "assets/default/Red_Sun_TC.png");
				break;
			case 12:	targetChip = new TargetChip(11, theme.getGreen(), "assets/default/Green_Moon_TC.png");
				break;
			case 13:	targetChip = new TargetChip(12, theme.getGreen(), "assets/default/Green_Planet_TC.png");
				break;
			case 14:	targetChip = new TargetChip(13, theme.getBlue(), "assets/default/Blue_Moon_TC.png");
				break;
			case 15:	targetChip = new TargetChip(14, theme.getBlue(), "assets/default/Blue_Star_TC.png");
				break;
			case 16:	targetChip = new TargetChip(15, theme.getRed(), "assets/default/Red_Star_TC.png");
				break;
		}	

		this.grid[7][7].add(targetChip.getIcon());
		
	}

	public void makeMove(Player player, String dir)
	{
		player.move();
		Color targetColor = this.targetChip.getColor();
		if(this.curRobot == null)
		{
			this.curRobot = this.robots.get(0);
			for(int i = 0; i < 5; i++)
			{
				if(this.robots.get(i).getColor() == targetColor)
				{
					curRobot = this.robots.get(i);
				}
			}
		}
		switch (dir)
		{
			case "N":

			for(int i = curRobot.getCoordinates()[1] - 1; i > -1; i--)
			{	
					if((this.curRobot.getColor() == this.targetChip.getColor()) && (grid[curRobot.getCoordinates()[0]][i].getTargetChip() != null) && (grid[curRobot.getCoordinates()[0]][i].getWall() != "SB"))
					{
						System.out.println("cur target index: " + grid[curRobot.getCoordinates()[0]][i].getTargetChip().getIndex() +"\ntarget chip Index: " + this.targetChip.getIndex());
						if((grid[curRobot.getCoordinates()[0]][i].getTargetChip().getIndex() == this.targetChip.getIndex()) && (grid[curRobot.getCoordinates()[0]][i].getTargetChip() != this.targetChip))
						{
							curRobot = null;
							player.success();
							for(int k = 0; k < 16; k++)
							{
								for(int j = 0; j < 16; j++)
								{
									grid[j][k].removeAll();
									grid[j][k].removeTargetChip();
									grid[j][k].leave();

								}
							}
							grid[7][7].setTargetChip(this.targetChip);
							return;
						}
					}

					if(((grid[curRobot.getCoordinates()[0]][i].getWall() != "SB")) && (grid[curRobot.getCoordinates()[0]][i + 1].getWall() !="NB")
						&& (grid[curRobot.getCoordinates()[0]][i].isOccupied() == false) && (grid[curRobot.getCoordinates()[0]][i].getTargetChip() == null)
						&& (grid[curRobot.getCoordinates()[0]][i] != grid[7][7])
						&& (grid[curRobot.getCoordinates()[0]][i] != grid[7][8])
						&& (grid[curRobot.getCoordinates()[0]][i] != grid[8][8])
						&& (grid[curRobot.getCoordinates()[0]][i] != grid[8][7])
						&& (grid[curRobot.getCoordinates()[0]][i].getRobot() == null))
					{
						this.grid[curRobot.getCoordinates()[0]][i + 1].leave();
						curRobot.setCoordinates(curRobot.getCoordinates()[0], i);
						this.grid[curRobot.getCoordinates()[0]][i].add(curRobot.getIcon());
						this.grid[curRobot.getCoordinates()[0]][i].occupy(curRobot);
					}
					else
					{
						break;
					}
				
			}
			break;
			case "S":
			for(int i = curRobot.getCoordinates()[1] + 1; i < 16; i++)
			{
					if((this.curRobot.getColor() == this.targetChip.getColor()) && (grid[curRobot.getCoordinates()[0]][i].getTargetChip() != null) && (grid[curRobot.getCoordinates()[0]][i].getWall() != "NB"))
					{
						System.out.println("cur target index: " + grid[curRobot.getCoordinates()[0]][i].getTargetChip().getIndex() +"\ntarget chip Index: " + this.targetChip.getIndex());
						if((grid[curRobot.getCoordinates()[0]][i].getTargetChip().getIndex() == this.targetChip.getIndex()) && (grid[curRobot.getCoordinates()[0]][i].getTargetChip() != this.targetChip))
						{
							curRobot = null;
							player.success();
							for(int k = 0; k < 16; k++)
							{
								for(int j = 0; j < 16; j++)
								{
									grid[j][k].removeAll();
									grid[j][k].removeTargetChip();
									grid[j][k].leave();
								}
							}
							grid[7][7].setTargetChip(this.targetChip);
							return;
						}
					}
					if((grid[curRobot.getCoordinates()[0]][i - 1].getWall() != "SB") && (grid[curRobot.getCoordinates()[0]][i].getWall() !="NB")
						&& (grid[curRobot.getCoordinates()[0]][i].isOccupied() == false) && (grid[curRobot.getCoordinates()[0]][i].getTargetChip() == null)
						&& (grid[curRobot.getCoordinates()[0]][i] != grid[7][7])
						&& (grid[curRobot.getCoordinates()[0]][i] != grid[7][8])
						&& (grid[curRobot.getCoordinates()[0]][i] != grid[8][8])
						&& (grid[curRobot.getCoordinates()[0]][i] != grid[8][7])
						&& (grid[curRobot.getCoordinates()[0]][i].getRobot() == null))
					{
						this.grid[curRobot.getCoordinates()[0]][i - 1].leave();
						curRobot.setCoordinates(curRobot.getCoordinates()[0], i);
						this.grid[curRobot.getCoordinates()[0]][i].add(curRobot.getIcon());
						this.grid[curRobot.getCoordinates()[0]][i].occupy(curRobot);
					}
					else
					{
						break;
					}
			}
			break;	
			case "E":
			for(int i = curRobot.getCoordinates()[0] + 1; i < 16; i++)
			{
					if((this.curRobot.getColor() == this.targetChip.getColor()) && (grid[i][curRobot.getCoordinates()[1]].getTargetChip() != null) && (grid[i][curRobot.getCoordinates()[1]].getWall() != "WB"))
					{
						System.out.println("cur target index: " + grid[i][curRobot.getCoordinates()[1]].getTargetChip().getIndex() +"\ntarget chip Index: " + this.targetChip.getIndex());
						if((grid[i][curRobot.getCoordinates()[1]].getTargetChip().getIndex() == this.targetChip.getIndex()) && (grid[i][curRobot.getCoordinates()[1]].getTargetChip() != this.targetChip))
						{
							curRobot = null;
							player.success();
							for(int k = 0; k < 16; k++)
							{
								for(int j = 0; j < 16; j++)
								{
									grid[j][k].removeAll();
									grid[j][k].removeTargetChip();
									grid[j][k].leave();
								}
							}
							grid[7][7].setTargetChip(this.targetChip);
							return;
						}
					}
				
					if((grid[i - 1][curRobot.getCoordinates()[1]].getWall() != "EB") && (grid[i][curRobot.getCoordinates()[1]].getWall() !="WB")
						&& (grid[i][curRobot.getCoordinates()[1]].isOccupied() == false) && (grid[i][curRobot.getCoordinates()[1]].getTargetChip() == null)
						&& (grid[i][curRobot.getCoordinates()[1]] != grid[7][7])
						&& (grid[i][curRobot.getCoordinates()[1]] != grid[7][8])
						&& (grid[i][curRobot.getCoordinates()[1]] != grid[8][8])
						&& (grid[i][curRobot.getCoordinates()[1]] != grid[8][7])
						&& (grid[i][curRobot.getCoordinates()[1]].getRobot() == null))
					{
						this.grid[i - 1][curRobot.getCoordinates()[1]].leave();
						curRobot.setCoordinates(i, curRobot.getCoordinates()[1]);
						this.grid[i][curRobot.getCoordinates()[1]].add(curRobot.getIcon());
						this.grid[i][curRobot.getCoordinates()[1]].occupy(curRobot);
					}
					else
					{
						break;
					}
				
				
			}
			break;	
			case "W":
			for(int i = curRobot.getCoordinates()[0] - 1; i > -1; i--)
			{
				if((this.curRobot.getColor() == this.targetChip.getColor()) && (grid[i][curRobot.getCoordinates()[1]].getTargetChip() != null) && (grid[i][curRobot.getCoordinates()[1]].getWall() != "EB"))
					{
						if((grid[i][curRobot.getCoordinates()[1]].getTargetChip().getIndex() == this.targetChip.getIndex()) && (grid[i][curRobot.getCoordinates()[1]].getTargetChip() != this.targetChip))
						{
							curRobot = null;
							player.success();
							for(int k = 0; k < 16; k++)
							{
								for(int j = 0; j < 16; j++)
								{
									grid[j][k].removeAll();
									grid[j][k].removeTargetChip();
									grid[j][k].leave();
								}
							}
							grid[7][7].setTargetChip(this.targetChip);
							return;
						}
					}

				if(((grid[i][curRobot.getCoordinates()[1]].getWall() != "EB")) && (grid[i + 1][curRobot.getCoordinates()[1]].getWall() !="WB")
					&& (grid[i][curRobot.getCoordinates()[1]].isOccupied() == false) && (grid[i][curRobot.getCoordinates()[1]].getTargetChip() == null)
					&& (grid[i][curRobot.getCoordinates()[1]] != grid[7][7])
					&& (grid[i][curRobot.getCoordinates()[1]] != grid[7][8])
					&& (grid[i][curRobot.getCoordinates()[1]] != grid[8][8])
					&& (grid[i][curRobot.getCoordinates()[1]] != grid[8][7])
					&& (grid[i][curRobot.getCoordinates()[1]].getRobot() == null))
				{
					this.grid[i + 1][curRobot.getCoordinates()[1]].leave();
					curRobot.setCoordinates(i, curRobot.getCoordinates()[1]);
					this.grid[i][curRobot.getCoordinates()[1]].add(curRobot.getIcon());
					this.grid[i][curRobot.getCoordinates()[1]].occupy(curRobot);
				}
				else
				{
					break;
				}
			}
			break;	
		}
	}

	public boolean checkSuccess()
	{
		return false;
	}

	private void setCurRobot(Robot robot)
	{
		this.curRobot = robot;
	}

}
