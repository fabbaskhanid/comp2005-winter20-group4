import java.awt.Color;

public class AngledWall extends Wall{

	private Color color;
	
	public AngledWall(BoardTile tile, Color color) {
		super(tile);	
		this.color = color;
	}
	
}
