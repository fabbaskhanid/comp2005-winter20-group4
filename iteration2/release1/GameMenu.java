import javax.swing.*;
import java.awt.*;

public class GameMenu
{
	private JMenuBar menuBar;
	private JMenu settingsTab;
	private Settings settings;

	GameMenu(Settings gameSettings)
	{
		this.menuBar = new JMenuBar();
		this.settings = gameSettings;
		init();
	}

	public void init()
	{
		this.settingsTab = new JMenu("Settings");
		this.menuBar.add(settingsTab);
		JMenuItem save = new JMenuItem("Save Game");
		JMenuItem load = new JMenuItem("Load Game");
		JMenuItem theme = new JMenuItem("Change Theme");
		this.settingsTab.add(save);
		this.settingsTab.add(load);
		this.settingsTab.add(theme);

	}

	public JMenuBar getMenuBar()
	{
		return this.menuBar;
	}
}