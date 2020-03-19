import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Controller
{
	private Settings gameSettings;
	private Window gameWindow;
	private GameMenu menu;
	private ArrayList<Player> curPlayerOrder;

	Controller()
	{
		this.gameWindow = new Window();
		this.gameSettings = new Settings();
		this.menu = new GameMenu(this.gameSettings, this.gameWindow);
		start();
	}

	public void start()
	{ 
		this.gameWindow.getFrame().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JPanel settingsWindow = new JPanel(new BorderLayout());
		settingsWindow.add(new JLabel("<html>WELCOME TO RICOCHET ROBOTS!<br/>PLEASE SELECT THE DIFFICULTY LEVEL:</html>"), BorderLayout.NORTH);
		JButton easyButton = new JButton("EASY");
		easyButton.addActionListener(p -> 
		{
			GameBoard simpleBoard = new GameBoard();
			simpleBoard.setSimple(this.gameSettings.getTheme());
			this.gameSettings.setGameBoard(simpleBoard);
			enterNames();
		});
		JButton hardButton = new JButton("HARD");
		hardButton.addActionListener(p -> 
		{

			GameBoard complexBoard = new GameBoard();
			complexBoard.setComplex(this.gameSettings.getTheme());
			this.gameSettings.setGameBoard(complexBoard);
			enterNames();
		});
		settingsWindow.add(easyButton, BorderLayout.WEST);
		settingsWindow.add(hardButton, BorderLayout.EAST);
		this.gameWindow.getContentPane().add(settingsWindow);
		this.gameWindow.getFrame().pack();
		this.gameWindow.getFrame().setVisible(true);
	}

	public void enterNames()
	{
		
		this.gameWindow.getContentPane().removeAll();
		JPanel nameWindow = new JPanel(new BorderLayout());
		nameWindow.add(new JLabel("PLEASE ENTER EACH PLAYER'S NAME\n(up to 4 players)"), BorderLayout.NORTH);
		JPanel entries = new JPanel(new GridLayout(4, 2));
		String[] labels = {"Player 1: ", "Player 2: ", "Player 3: ", "Player 4: "};
		JTextField[] textFields = new JTextField[4];
		for(int i = 0; i < 4; i++)
		{
			JLabel line = new JLabel(labels[i], JLabel.TRAILING);
			entries.add(new JLabel(labels[i]));
			JTextField textField = new JTextField(10);
			entries.add(textField);
			textFields[i] = textField;
		}
		JButton done = new JButton("Done");
		
		done.addActionListener(p ->
		{
			int playerCount = 0;
			Player[] players = new Player[4];
			for(int i = 0; i < 4; i++)
			{
				if(textFields[i].getText().isEmpty() == false)
				{
					playerCount++;
					players[i] = new Player(textFields[i].getText());
				}
			}
			if(playerCount == 0)
			{
				return;
			}
			gameSettings.setPlayers(players[0], players[1], players[2], players[3]);
			if(playerCount != 4)
			{
				setDifficulty();
			}
			else if(0 < playerCount)
			{
				createGame();
			}
		});
		nameWindow.add(done, BorderLayout.SOUTH);
		nameWindow.add(entries, BorderLayout.CENTER);
		this.gameWindow.getContentPane().add(nameWindow);
		this.gameWindow.getFrame().revalidate();
		this.gameWindow.getFrame().repaint();
	}

	public void setDifficulty()
	{
		this.gameWindow.getContentPane().removeAll();
		JPanel difficultyPanel = new JPanel(new BorderLayout());
		JLabel label = new JLabel("Please enter the desired skill level of the CPU players");
		JButton novice = new JButton("Novice");
		novice.addActionListener(p ->
		{
			for(int i = 0; i < this.gameSettings.getPlayers().length; i++)
			{
				if(this.gameSettings.getPlayers()[i] == null)
				{
					 this.gameSettings.getPlayers()[i] = new SimpleAI("CPU" + i);
				}
			}
			createGame();
		});
	
		JButton pro = new JButton("Professional");
		pro.addActionListener(p ->
		{
			for(int i = 0; i < this.gameSettings.getPlayers().length; i++)
			{
				if(this.gameSettings.getPlayers()[i] == null)
				{
					this.gameSettings.getPlayers()[i] = new SmartAI("CPU" + i);
				}
			}
			createGame();
		});
		difficultyPanel.add(label, BorderLayout.NORTH);
		difficultyPanel.add(novice, BorderLayout.WEST);
		difficultyPanel.add(pro, BorderLayout.EAST);
		this.gameWindow.getContentPane().add(difficultyPanel);
		this.gameWindow.getFrame().revalidate();
		this.gameWindow.getFrame().repaint();
	}

	public void createGame()
	{
		this.gameWindow.getContentPane().removeAll();

		JPanel gameSpace = new JPanel(new BorderLayout());
		JPanel names = new JPanel(new GridLayout(5, 2));
		JPanel boardBase = new JPanel();
		names.add(new JLabel("Player Names  "));
		names.add(new JLabel("  Target Chips"));

		for(int i = 0; i < 4; i++)
		{
			names.add(new JLabel((this.gameSettings.getPlayers())[i].getName()));
			names.add(new JLabel(String.valueOf((this.gameSettings.getPlayers())[i].getTargetChips())));
		}
		
		JPanel bidSection = new JPanel(new GridLayout(5, 1));
		bidSection.add(new JPanel());
		
		for(int i = 0; i < 4; i++)
		{
			JButton bidButton = new JButton("Bid");
			bidSection.add(bidButton);
			bidButton.addActionListener(p ->
			{
				BidSetter bids = new BidSetter(this.gameWindow.getFrame(), this.gameSettings.getPlayers()[0], this.gameSettings.getPlayers()[1], this.gameSettings.getPlayers()[2], this.gameSettings.getPlayers()[3]);
		//here is where the program crashes
			
				this.curPlayerOrder = bids.getPlayerOrder();
				setBids(bidSection);
				this.gameWindow.getFrame().revalidate();
				this.gameWindow.getFrame().repaint();
				
				
				
			});
		}
		gameSpace.add(bidSection, BorderLayout.EAST);
		boardBase.add(this.gameSettings.getGameBoard().getBoardPanel());
		gameSpace.add(boardBase, BorderLayout.WEST);
		gameSpace.add(names, BorderLayout.CENTER);
		this.gameWindow.getContentPane().add(gameSpace);
		
		this.gameWindow.getFrame().setJMenuBar(this.menu.getMenuBar());

		this.gameWindow.getFrame().revalidate();
		this.gameWindow.getFrame().repaint();

	}

	private void setBids(JPanel panel)
	{
		panel.removeAll();
		System.out.println("flag");
		panel.setLayout(new GridLayout(5, 1));
		panel.add(new JPanel());
		for(int i = 0; i < 4; i++)
		{
			System.out.println("" + this.curPlayerOrder.get(i).getName());
			panel.add(new JLabel("" + this.curPlayerOrder.get(i).getBid()));
		}
	}
}
