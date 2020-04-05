import javax.swing.*;
import java.awt.*;

public class GameMenu
{
	private JMenuBar menuBar;
	private JMenu settingsTab;
	private JMenu Theme;
	private Settings settings;
	private Window gameWindow;
	private JMenu helpMenu;

	GameMenu(Settings gameSettings, Window gameWindow)
	{
		this.menuBar = new JMenuBar();
		this.settings = gameSettings;
		this.gameWindow = gameWindow;
		init(gameWindow);
	}

	public void init(Window gameWindow)
	{
		this.settingsTab = new JMenu("Settings");
		this.helpMenu = new JMenu("Help");
		this.menuBar.add(settingsTab);
		this.menuBar.add(helpMenu);
		JMenuItem showHelp = new JMenuItem("Show Help");
		helpMenu.add(showHelp);
		showHelp.addActionListener(p ->
		{
			JDialog helpDialog = new JDialog(gameWindow.getFrame());
			JLabel helpText = new JLabel("<html>To start a round, first decide how many times robots most move to collect the target chip corresponding to the chip displayed in the"
				+ " center of the board.  then press the \"bid\" button to place your bid. All other players will have one minute to place their bids.<br><br>After the minute is up, "
				+ " the round can now begin. The player with the lowest bid plays first.<br><br>Select the robot you wish to move by clicking on it, and then use the arrow keys near the "
				+ "bottom of the screen to select the direction for the move. If the player does not collect the target chip with a move count of less than or equal to their bid,"
				+ " the turn moves to the player with the next lowest bid.</html>");
			helpDialog.setPreferredSize(new Dimension(600, 400));
			helpDialog.add(helpText);
			helpDialog.pack();
			helpDialog.setVisible(true);


		});
		JMenuItem save = new JMenuItem("Save Game");
		JMenuItem load = new JMenuItem("Load Game");
		JMenu theme = new JMenu("Change Theme");
		JMenuItem t0 = new JMenuItem("Classic");
		t0.addActionListener(p ->
		{
			this.settings.getTheme().setColorScheme(0);
			if(this.settings.getGameBoard().isComplex())
			{
				this.settings.getGameBoard().setComplex(this.settings.getTheme());
			}
			else
			{
				this.settings.getGameBoard().setSimple(this.settings.getTheme());
			}
			this.gameWindow.getFrame().getContentPane().revalidate();
			this.gameWindow.getFrame().getContentPane().repaint();
		});
		JMenuItem t1 = new JMenuItem("Retro");
		t1.addActionListener(p -> 
		{
			this.settings.getTheme().setColorScheme(1);
			if(this.settings.getGameBoard().isComplex())
			{
				this.settings.getGameBoard().setComplex(this.settings.getTheme());
			}
			else
			{
				this.settings.getGameBoard().setSimple(this.settings.getTheme());
			}
			this.gameWindow.getFrame().getContentPane().revalidate();
			this.gameWindow.getFrame().getContentPane().repaint();
		});
		JMenuItem t2 = new JMenuItem("Cosmic");
		t2.addActionListener(p -> 
		{
			this.settings.getTheme().setColorScheme(2);
			if(this.settings.getGameBoard().isComplex())
			{
				this.settings.getGameBoard().setComplex(this.settings.getTheme());
			}
			else
			{
				this.settings.getGameBoard().setSimple(this.settings.getTheme());
			}
			this.gameWindow.getFrame().revalidate();
			this.gameWindow.getFrame().repaint();
		});
		JMenuItem t3 = new JMenuItem("Hi-Contrast");
		t3.addActionListener(p -> 
		{
			this.settings.getTheme().setColorScheme(3);
			if(this.settings.getGameBoard().isComplex())
			{
				this.settings.getGameBoard().setComplex(this.settings.getTheme());
			}
			else
			{
				this.settings.getGameBoard().setSimple(this.settings.getTheme());
			}
			this.gameWindow.getFrame().revalidate();
			this.gameWindow.getFrame().repaint();
		});

		theme.add(t0);
		theme.add(t1);
		theme.add(t2);
		theme.add(t3);
		this.settingsTab.add(save);
		this.settingsTab.add(load);
		this.settingsTab.add(theme);

	}

	public JMenuBar getMenuBar()
	{
		return this.menuBar;
	}
}