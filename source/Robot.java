import java.awt.*;
import javax.swing.*;

public class Robot
{
	private int[] coordinates;
	private JPanel icon;
	Robot(int startX, int startY, String file)
	{
		this.coordinates = new int[]{startX, startY};
		icon = new JPanel();
		JLabel botLabel = new JLabel(new ImageIcon(file));
		this.icon.add(botLabel);
	}

	public JPanel getIcon()
	{
		return this.icon;
	}

}