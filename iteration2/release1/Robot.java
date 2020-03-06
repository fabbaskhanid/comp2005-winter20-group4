import java.awt.*;
import javax.swing.*;

public class Robot
{
	private int[] coordinates;
	private Color color;
	private JPanel icon;
	Robot(int startX, int startY, Color robotColor)
	{
		this.coordinates = new int[]{startX, startY};
		this.color = robotColor;
		icon = new JPanel();
		
	}


}