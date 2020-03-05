import javax.swing.*;
import java.awt.*;

public class Controller
{
	private Settings gameSettings;
	private Window gameWindow;

	Controller()
	{
		this.gameWindow = new Window();
		this.gameSettings = new Settings();
		start();
	}

	public void start()
	{ 
		JPanel settingsWindow = new JPanel(new BorderLayout());
		settingsWindow.add(new JLabel("WELCOME TO RICOCHET ROBOTS\nPLEASE SELECT THE DIFFICULTY LEVEL:"), BorderLayout.NORTH);
		JButton easyButton = new JButton("EASY");
		easyButton.addActionListener(p -> 
		{
			GameBoard simpleBoard = new GameBoard();
			simpleBoard.setSimple();
			this.gameSettings.setGameBoard(simpleBoard);
			
			enterNames();

		});
		JButton hardButton = new JButton("HARD");
		hardButton.addActionListener(p -> 
		{

			GameBoard complexBoard = new GameBoard();
			complexBoard.setComplex();

			this.gameSettings.setGameBoard(complexBoard);
			System.out.println("fs");
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
				if(textFields[i].getText() != null)
				{
					playerCount++;
					players[i] = new Player(textFields[i].getText());
				}
			}
			gameSettings.setPlayers(players[0], players[1], players[2], players[3]);
			if(playerCount != 4)
			{
				setDifficulty();
			}
			else
			{
				createGame();
			}
		});
		nameWindow.add(done, BorderLayout.SOUTH);
		nameWindow.add(entries, BorderLayout.CENTER);
		this.gameWindow.getContentPane().add(nameWindow);
		this.gameWindow.getFrame().revalidate();
		this.gameWindow.getFrame().repaint();
		//this.gameWindow.getFrame().setVisible(true);
	}

	public void setDifficulty()
	{

	}

	public void createGame()
	{
		
	}
}