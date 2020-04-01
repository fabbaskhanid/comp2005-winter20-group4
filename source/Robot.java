import java.awt.*;
import javax.swing.*;

public class Robot
{
	private int[] coordinates;
	private JButton icon;
	private Color color;

	Robot(Color color, int startX, int startY, String file)
	{
		this.color = color;
		this.coordinates = new int[]{startX, startY};
		icon = new JButton();
		JLabel botLabel = new JLabel(new ImageIcon(file));
		this.icon.add(botLabel);
	}

	public JButton getIcon()
	{
		return this.icon;
	}

	public Color getColor()
	{
		return this.color;
	}

	public int[] getCoordinates()
	{
		return this.coordinates;
	}

	public void setCoordinates(int x, int y)
	{
		this.coordinates = new int[]{x, y};
	}

}