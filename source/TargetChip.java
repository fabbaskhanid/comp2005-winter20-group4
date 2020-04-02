import java.awt.*;
import javax.swing.*;

public class TargetChip
{
	private Color color;
	private JPanel iconPanel;
	private String fileName;
	private int index;

	TargetChip(int ind, Color chipColor, String file)
	{
		this.index = ind;
		this.color = chipColor;
		this.fileName = file;
		setIcon(file);
	}

	public int getIndex()
	{
		return this.index;
	}

	public Color getColor()
	{
		return this.color;
	}

	private void setIcon(String file)
	{
		this.iconPanel = new JPanel();
		
		this.iconPanel.add(new JLabel(new ImageIcon(file)));
	}

	public JPanel getIcon()
	{
		return this.iconPanel;
	}

	public String getFileName()
	{
		return this.fileName;
	}
}