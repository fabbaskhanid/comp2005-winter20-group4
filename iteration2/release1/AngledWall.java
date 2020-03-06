import java.awt.Color;

public class AngledWall extends Wall{

        private int col;
        private int row;
	private Color color;
	
	public AngledWall(int col, int row, Color color) {
		super();	
		this.color = color;
	}

        public void setBack(Color color)
        {
                this.tile.setText(“\”).setForeground(color);
        }

        public void setFore(Color color)
        {
                this.tile.setText(“/”).setForeground(color);
        }
	
}
