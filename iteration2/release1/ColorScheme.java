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
		Color red = new Color(255,0,0);
		Color blue = new Color(0,0,255);
		Color yellow = new Color(255,255,0);
		Color green = new Color(0,255,0);
		applyColor(red, blue, yellow, green);
	}
	
	public void protanopiaScheme()
	{
		Color red = new Color(134,161,87);
		Color blue = new Color(1,77,165);
		Color yellow = new Color(243,243,19);
		Color green = new Color(255,255,129);
		applyColor(red, blue, yellow, green);
	}
	
	public void deuteranopiaScheme()
	{
		Color red = new Color(220,151,13);
		Color blue = new Color(0,51,102);
		Color yellow = new Color(255,232,183);
		Color green = new Color(255,229,204);
		applyColor(red, blue, yellow, green);
	}
	
	public void tritanopiaScheme()
	{
		Color red = new Color(255,36,36);
		Color blue = new Color(0,102,102);
		Color yellow = new Color(51,255,255);
		Color green = new Color(255,204,255);
		applyColor(red, blue, yellow, green);
	}
	
	public void applyColor(Color r, Color b, Color y, Color g)
	{
		//applies the colors to the game
		//nothing to really apply to atm
		Color red = r;
		Color blue = b;
		Color yellow = y;
		Color green = g;
		Color white = new Color(255,255,255);
		Color black = new Color(0,0,0);
		Color lightGray = new Color(220,220,220);
		Color darkGray = new Color(107,107,107);
	}
	
}
