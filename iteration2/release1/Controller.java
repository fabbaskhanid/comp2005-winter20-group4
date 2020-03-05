import javax.swing.*;
import java.awt.*;

public class Controller
{
	private Settings gameSettings;
	private Window gameWindow;

	Controller()
	{
		this.gameWindow = new Window();
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
			gameSettings.setGameBoard(simpleBoard);
		});
		JButton hardButton = new JButton("HARD");
		hardButton.addActionListener(p -> 
		{
			GameBoard complexBoard = new GameBoard();
			complexBoard.setComplex();
			gameSettings.setGameBoard(complexBoard);
		});
		settingsWindow.add(easyButton, BorderLayout.WEST);
		settingsWindow.add(hardButton, BorderLayout.EAST);
		this.gameWindow.getContentPane().add(settingsWindow);
		this.gameWindow.getFrame().pack();
		this.gameWindow.getFrame().setVisible(true);
	}

}