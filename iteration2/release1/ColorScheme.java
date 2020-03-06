import java.awt.Color;

public class ColorScheme{
	private Color red;
	private Color blue;
	private Color yellow;
	private Color green;
	private Color white;
	private Color black;
	private Color lightGray;
	private Color darkGray;
	private int colorPalette;
	
	public ColorScheme(int colorPalette)
	{
		super();
		this.colorPalette = colorPalette;
		setColorScheme(colorPalette);		
	}
	
	public void setColorScheme(int colorPalette)
	{
		//identifies selected color set from game board
		if (colorPalette == 1)
		{
			protanopiaScheme();
		}
		else if (colorPalette == 2)
		{
			deuteranopiaScheme();
		}
		else if (colorPalette == 3)
		{
			tritanopiaScheme();
		}
		else {
			defaultScheme();
		}
	}
	
	public void defaultScheme()
	{
		//default colors for people without color blindness
		this.red = new Color(255,0,0);
		this.blue = new Color(0,0,255);
		this.yellow = new Color(255,255,0);
		this.green = new Color(0,255,0);
		this.lightGray = new Color(192,192,192);
		setColor(red, blue, yellow, green);
	}
	
	public void protanopiaScheme()
	{
		//replacement colors for people with red color blindness
		this.red = new Color(134,161,87);
		this.blue = new Color(1,77,165);
		this.yellow = new Color(243,243,19);
		this.green = new Color(255,255,129);
		this.lightGray = new Color(192,192,192);
		setColor(red, blue, yellow, green);
	}
	
	public void deuteranopiaScheme()
	{
		//replacement colors for people with red-green color blindness
		this.red = new Color(220,151,13);
		this.blue = new Color(0,51,102);
		this.yellow = new Color(255,232,183);
		this.green = new Color(255,229,204);
		this.lightGray = new Color(192,192,192);
		setColor(red, blue, yellow, green);
	}
	
	public void tritanopiaScheme()
	{
		//replacement colors for people with blue-yellow color blindness
		Color red = new Color(255,36,36);
		Color blue = new Color(0,102,102);
		Color yellow = new Color(51,255,255);
		Color green = new Color(255,204,255);
		setColor(red, blue, yellow, green);
	}
	
	public void setColor(Color r, Color b, Color y, Color g)
	{
		//sets which colors are to be used
		//nothing to really apply to atm
		Color red = r;
		Color blue = b;
		Color yellow = y;
		Color green = g;
	}
	
	public Color getRed()
	{
		return this.red;
	}
	
	public Color getBlue()
	{
		return this.blue;
	}
	
	public Color getYellow()
	{
		return this.yellow;
	}
	
	public Color getGreen()
	{
		return this.green;
	}

	public Color getLightGray()
	{
		return this.lightGray;
	}
}
