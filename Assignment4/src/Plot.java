
public class Plot {

	private int x;
	private int y;
	private int width;
	private int depth;

	public Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}

	public Plot(Plot p) {
		x = p.x;
		y = p.y;
		width = p.width;
		depth = p.depth;
	}

	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}

	public boolean overlaps(Plot plot) {
		if (getX() + getWidth() <= plot.getX() || plot.getX() + plot.getWidth() <= getX()) {
			return false;
		}
		if (getY() + getDepth() <= plot.getY() || plot.getY() + plot.getDepth() <= getY()) {
			return false;
		}	
		return true;
	}

	public boolean encompasses(Plot plot) {
		if ( getX() <= plot.getX() &&
			 getY() <= plot.getY() &&
			 (getX() + getWidth()) >= (plot.getX() + plot.getWidth()) &&
			 (getY() + getDepth()) >= (plot.getY()+ plot.getDepth()))
		{
			return true;
		}
		return false;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getDepth() {
		return depth;
	}

	public String toString() {
		String s = "Upper left: (" + x + "," + y + "); Width: " 
						+ width + " Depth: " + depth;
		return s;
	}

}
