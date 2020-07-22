/***********************************************************************
 Class: CMSC203 CRN 46667
 Program: Assignment # 4
 Instructor: Dr.Grinberg
 Description: Property class
 Due: 07/26/2020
 I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 Anthony Liu
************************************************************************/
/**
 * Represents a Property object
 * 
 * @author Anthony Liu
 *
 */
public class Property {
	/**
	 * City location of property
	 */
	private String city;
	/**
	 * Name of property owner
	 */
	private String owner;
	/**
	 * Name of property
	 */
	private String propertyName;
	/**
	 * Monthly rent of property
	 */
	private double rentAmount;
	/**
	 * Property plot object
	 */
	private Plot plot;

	/**
	 * No-arg Constructor, creates a new object with default values of empty
	 * strings, 0 for rent amount, and default Plot
	 */
	public Property() {
		city = "";
		owner = "";
		propertyName = "";
		rentAmount = 0;
		plot = new Plot(0, 0, 1, 1);
	}

	/**
	 * Copy Constructor, creates a new object using the information of the object
	 * passed to it.
	 * 
	 * @param p a Property object
	 */
	public Property(Property p) {
		city = p.city;
		owner = p.owner;
		propertyName = p.propertyName;
		rentAmount = p.rentAmount;
		plot = p.plot;
	}

	/**
	 * Constructor, Parameterized constructor with no Plot information (uses default
	 * Plot where x,y are set to 0, width and depth set to 1)
	 * 
	 * @param propertyName property name
	 * @param city         city where the property is located
	 * @param rentAmount   rent amount
	 * @param owner        the owner's name
	 */
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot();
	}

	/**
	 * Constructor, Parameterized constructor
	 * 
	 * @param propertyName property name
	 * @param city         city where the property is located
	 * @param rentAmount   rent amount
	 * @param owner        the owner's name
	 * @param x            the x-value of the property's plot
	 * @param y            the y-value of the property's plot
	 * @param width        the horizontal size of the property's plot
	 * @param depth        the vertical size of the property's plot
	 * 
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width,
			int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot(x, y, width, depth);
	}

	/**
	 * Return city
	 * 
	 * @return City of property
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Return owner name
	 * 
	 * @return Name of property owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Return the property name
	 * 
	 * @return Name of property
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * Return rent
	 * 
	 * @return Monthly Rent amount
	 */
	public double getRentAmount() {
		return rentAmount;
	}

	/**
	 * Return a plot object
	 * 
	 * @return A plot object
	 */
	public Plot getPlot() {
		return new Plot(plot);
	}

	/**
	 * Set the plot values
	 * 
	 * @param x     the x-value of the property's plot
	 * @param y     the y-value of the property's plot
	 * @param width the horizontal size of the property's plot
	 * @param depth the vertical size of the property's plot
	 * @return the Plot for the property
	 * 
	 */
	public Plot setPlot(int x, int y, int width, int depth) {
		return plot = new Plot(x, y, width, depth);
	}

	/**
	 * Set location/city of property name
	 * 
	 * @param city Location of property name to be set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Set the property owner's name
	 * 
	 * @param owner Property owner name to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * Set the property name
	 * 
	 * @param propertyName the property name to set
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * Set the rent amount
	 * 
	 * @param rentAmount the rentAmount to set
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	/**
	 * Prints out the name, city, owner and rent amount for a property
	 * 
	 * @return the string representation of a Property object in the following format:
               Property Name: propertyName
               Located in city
               Belonging to: owner
               Rent Amount: rentAmount
               Be sure the last item is the rent amount, preceded by a space.
	 */
	public String toString() {

		String propertyName = " Property Name: " + this.propertyName + "\n";
		String city = " Located in " + this.city + "\n";
		String owner = " Belonging to: " + this.owner + "\n";
		String rentAmount = " Rent Amount: " + this.rentAmount + "\n";
		String propertyInfo = propertyName + city + owner + rentAmount;

		return propertyInfo;
	}
}
