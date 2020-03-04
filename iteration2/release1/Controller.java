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
		settingsWindow.add(new JLabel("Welcome to Ricochet Robots \nPlease select the difficulty level:"), BorderLayout.NORTH);

	}

}