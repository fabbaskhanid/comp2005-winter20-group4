import javax.swing.*;
import java.awt.*;

public class GameMenu
{
	private JMenuBar menuBar;
	private JMenu settingsTab;
	private JMenu Theme;
	private Settings settings;
	private Window gameWindow;

	GameMenu(Settings gameSettings, Window gameWindow)
	{
		this.menuBar = new JMenuBar();
		this.settings = gameSettings;
		this.gameWindow = gameWindow;
		init();
	}

	public void init()
	{
		this.settingsTab = new JMenu("Settings");

		this.menuBar.add(settingsTab);
		JMenuItem save = new JMenuItem("Save Game");
		JMenuItem load = new JMenuItem("Load Game");
		JMenu theme = new JMenu("Change Theme");
		JMenuItem t0 = new JMenuItem("Classic");
		t0.addActionListener(p ->
		{
			this.settings.getTheme().setColorScheme(0);
		});
		JMenuItem t1 = new JMenuItem("Retro");
		t1.addActionListener(p -> 
		{
			this.settings.getTheme().setColorScheme(1);
			this.gameWindow.getFrame().revalidate();
			this.gameWindow.getFrame().repaint();
		});
		JMenuItem t2 = new JMenuItem("Cosmic");
		t2.addActionListener(p -> 
		{
			this.settings.getTheme().setColorScheme(2);
			this.gameWindow.getFrame().revalidate();
			this.gameWindow.getFrame().repaint();
		});
		JMenuItem t3 = new JMenuItem("Hi-Contrast");
		t3.addActionListener(p -> 
		{
			this.settings.getTheme().setColorScheme(3);
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