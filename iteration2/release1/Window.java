import java.awt.*;
import javax.swing.*;


public class Window
{

	private JFrame frame;
	private Container contentPane;

	Window()
	{
		this.frame = new JFrame("Ricochet Robots");
		this.contentPane = frame.getContentPane();
	}

	public JFrame getFrame()
	{
		return this.frame;
	}

	public Container getContentPane()
	{
		return this.contentPane;
	}

}