import java.awt.*;
import javax.swing.*;


public class Window
{

	private JFrame frame;
	private Container contentPane;
	private Dimension frameSize;

	Window()
	{
		this.frame = new JFrame("Ricochet Robots");
		this.contentPane = frame.getContentPane();
		size();
	}

	private void size()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.frameSize = new Dimension((int) (screenSize.width * 7/8), (int) screenSize.height * 15/16);
		this.frame.setPreferredSize(frameSize);
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
