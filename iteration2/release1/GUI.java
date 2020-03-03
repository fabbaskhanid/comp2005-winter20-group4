import java.awt.*;
import javax.swing.*;

public class GUI
{
	private JFrame frame;
	private Container contentPane;

	GUI()
	{
		init();
	}

	public void init()
	{
		this.frame = new JFrame("Ricochet Robots");
		this.contentPane = frame.getContentPane();

	}

}