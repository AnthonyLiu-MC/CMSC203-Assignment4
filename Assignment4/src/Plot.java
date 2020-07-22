/***********************************************************************
 Class: CMSC203 CRN 46667
 Program: Assignment # 4
 Instructor: Dr.Grinberg
 Description: Plot class
 Due: 07/26/2020
 I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 Anthony Liu
************************************************************************/
/**
 * Represents a Plot object
 * 
 * @author Anthony Liu
 *
 */
public class Plot {

	/**
	 * The x-value of the upper-left corner of the Plot
	 */
	private int x;
	/**
	 * The y-value of the upper-left corner of the Plot
	 */
	private int y;
	/**
	 * The horizontal extent of the Plot
	 */
	private int width;
	/**
	 * The vertical extent of the Plot
	 */
	private int depth;

	/**
	 * No-arg Constructor, creates a Plot with x=0, y=0, width=1, depth=1
	 */
	public Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}

	/**
	 * Copy Constructor, creates a new Plot using the information of the Plot passed
	 * to it.
	 * 
	 * @param p A plot object
	 */
	public Plot(Plot p) {
		x = p.x;
		y = p.y;
		width = p.width;
		depth = p.depth;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param x     horizontal coordinate of upper left corner
	 * @param y     vertical coordinate of upper left corner
	 * @param width horizontal size
	 * @param depth vertical size
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}

	/**
	 * Determines if this plot overlaps the parameter
	 * 
	 * @param plot Plot to be checked
	 * @return Returns true if this plot overlaps the parameter, false otherwise
	 */
	public boolean overlaps(Plot plot) {
		if (getX() + getWidth() <= plot.getX() || plot.getX() + plot.getWidth() <= getX()) { //Checks if plot is on left/right side of other plot
			return false;
		}
		if (getY() + getDepth() <= plot.getY() || plot.getY() + plot.getDepth() <= getY()) { //Checks if plot is above or below other plot 
			return false;
		}
		return true;
	}

	/**
	 * Determines if this plot encompasses the parameter
	 * 
	 * @param plot Plot that is checked
	 * @return Returns true if this plot encompasses the parameter, false otherwise
	 */
	public boolean encompasses(Plot plot) {
		if (getX() <= plot.getX() && getY() <= plot.getY() && (getX() + getWidth()) >= (plot.getX() + plot.getWidth())
				&& (getY() + getDepth()) >= (plot.getY() + plot.getDepth())) {
			return true;
		}
		return false;
	}

	/**
	 * Set the x value
	 * 
	 * @param x x - the x value to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Return the x value
	 * 
	 * @return the x value
	 * 
	 */
	public int getX() {
		return x;
	}

	/**
	 * Set the y value
	 * 
	 * @param y y - the y value to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Return the y value
	 * 
	 * @return the y value
	 * 
	 */
	public int getY() {
		return y;
	}

	/**
	 * Set the width value
	 * 
	 * @param width the width value to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Return the width value
	 * 
	 * @return The width value
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Set the depth value
	 * 
	 * @param depth Depth value to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * Return the depth value
	 * 
	 * @return the depth value to set
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * Prints out the name, city, owner and rent amount for a property
	 * 
	 * @return the string representation of a Plot object in the following format:
	 *         Upper left: (1,1); Width: 3 Depth: 3
	 */
	public String toString() {
		String s = "Upper left: (" + getX() + "," + getY() + "); Width: " + getWidth() + " Depth: " + getDepth();
		return s;
	}

}
