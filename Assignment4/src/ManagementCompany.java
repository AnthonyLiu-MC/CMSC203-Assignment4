/***********************************************************************
 Class: CMSC203 CRN 46667
 Program: Assignment # 4
 Instructor: Dr.Grinberg
 Description: Management Company Class
 Due: 07/26/2020
 I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 Anthony Liu
************************************************************************/
/**
 * Represents management company object
 * 
 * @author Anthony Liu
 *
 */
public class ManagementCompany {

	/**
	 * Maximum number of properties that this management company handles is set to 5
	 */
	final private int MAX_PROPERTY = 5;
	/**
	 * Management fee percentage
	 */
	private double mgmFeePer;
	/**
	 * Name of the management company
	 */
	private String name;
	/**
	 * An array of properties
	 */
	private Property[] properties;
	/**
	 * Tax ID of the management company
	 */
	private String taxID;
	/**
	 * Width of management company set to 10
	 */
	final private int MGMT_WIDTH = 10;
	/**
	 * Depth of management company set to 10
	 */
	final private int MGMT_DEPTH = 10;
	/**
	 * Plot of the management company
	 */
	private Plot plot;

	/**
	 * No-Arg Constructor that creates a ManagementCompany object using empty
	 * strings and the plot set to a Plot with x, y set to 0 , width and depth set
	 * to 10. properties array is initialized here as well.
	 */
	public ManagementCompany() {
		taxID = "";
		name = "";
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}

	/**
	 * Constructor Creates a ManagementCompany object using the passed information.
	 * plot is set to a Plot with x, y set to 0 , width and depth set to 10
	 * properties array is initialized here as well
	 * 
	 * @param name   Management Company Name
	 * @param taxID  Tax ID
	 * @param mgmFee Management Fee Percentage
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];

	}

	/**
	 * Constructor Creates a ManagementCompany object using the passed information.
	 * 
	 * @param name   Management Company Name
	 * @param taxID  Tax ID
	 * @param mgmFee Management Fee Percentage
	 * @param x  x location of upper left corner of company plot
	 * @param y  y location of upper left corner of company plot
	 * @param width width of company plot
	 * @param depth depth of company plot
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		plot = new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY];
	}

	/**
	 * Copy Constructor that creates a ManagementCompany object from another
	 * ManagementCompany object
	 * 
	 * @param otherCompany Another Management Company
	 */
	public ManagementCompany(ManagementCompany otherCompany) {
		name = otherCompany.getName();
		taxID = otherCompany.getTaxID();
		mgmFeePer = otherCompany.getMgmfee();
		plot = new Plot(otherCompany.getPlot());
		properties = new Property[MAX_PROPERTY];
	}

	/**
	 * Creates a property object by copying from another property and adds it to the
	 * "properties" array.
	 * 
	 * @param p A property object
	 * @return Returns either -1 if the array is full, -2 if property is null, -3 if
	 *         the plot is not contained by the MgmtCo plot, -4 of the plot overlaps
	 *         any other property, or the index in the array where the property was
	 *         added successfully.
	 */
	public int addProperty(Property p) {

		Property property = new Property(p);

		if (!plot.encompasses(property.getPlot())) { //Checks if property is within plot 
			return -3;
		}
		;

		int i;
		for (i = 0; i < properties.length; i++) {
			if (properties[i] != null) {
				if (properties[i].getPlot().overlaps(property.getPlot())) { //Checks is property overlaps another property
					return -4;
				}
				if (i == properties.length - 1) { //Checks if property if full 
					return -1;
				}
			}
			if (properties[i] == null) {
				properties[i] = property;
				return i;
			}

		}

		return -2;

	}

	/**
	 * Creates a property object with a default plot and adds it to the "properties"
	 * array.
	 * 
	 * @param name      Property Name
	 * @param city      Location of the property
	 * @param rent      Monthly Rent
	 * @param ownerName Owner of the property
	 * @return Returns either -1 if the array is full, -2 if property is null, -3 if
	 *         the plot is not contained by the MgmtCo plot, -4 of the plot overlaps
	 *         any other property, or the index in the array where the property was
	 *         added successfully.
	 */
	public int addProperty(String name, String city, double rent, String ownerName) {

		Property property = new Property(name, city, rent, ownerName);
		
		if (!plot.encompasses(property.getPlot())) { //Checks if property is within plot 
			return -3;
		}
		;

		int i;
		for (i = 0; i < properties.length; i++) {
			if (properties[i] != null) {
				if (properties[i].getPlot().overlaps(property.getPlot())) { //Checks is property overlaps another property
					return -4;
				}
				if (i == properties.length - 1) { //Checks if property if full 
					return -1;
				}
			}
			if (properties[i] == null) {
				properties[i] = property;
				return i;
			}

		}

		return -2;

	}

	/**
	 * Creates a property object and adds it to the "properties" array. return -1 if
	 * the array is full , -2 if the Property object is null -3 if if management
	 * company does not encompass the property plot -4 if property plot overlaps ANY
	 * of properties in array otherwise return the index of the array where the
	 * property was added.
	 * 
	 * @param name  Property Name
	 * @param city  Location of property
	 * @param rent  Monthly rent
	 * @param owner Owner of property
	 * @param x     x location of upper left corner of property's plot
	 * @param y     y location of upper left corner of property's plot
	 * @param width width of the property's plot
	 * @param depth depth of the property's plot
	 * @return Returns either -1 if the array is full, -2 if property is null, -3 if
	 *         the plot is not contained by the MgmtCo plot, -4 of the plot overlaps
	 *         any other property, or the index in the array where the property was
	 *         added successfully.
	 */
	public int addProperty(String name, String city, double rent, String ownerName, int x, int y, int width, int depth) {

		Property property = new Property(name, city, rent, ownerName, x, y, width, depth);
		
		if (!plot.encompasses(property.getPlot())) { //Checks if property is within plot 
			return -3;
		}
		;

		int i;
		for (i = 0; i < properties.length; i++) {
			if (properties[i] != null) {
				if (properties[i].getPlot().overlaps(property.getPlot())) { //Checks is property overlaps another property
					return -4;
				}
				if (i == properties.length - 1) { //Checks if property if full 
					return -1;
				}
			}
			if (properties[i] == null) {
				properties[i] = property;
				return i;
			}

		}

		return -2;

	}

	/**
	 * Displays the information of the property at index i
	 * 
	 * @param i Index of property in an array
	 * @return Information of the property at index i
	 */
	public String displayPropertyAtIndex(int i) {

		return properties[i].toString();
	}

	/**
	 * Return the MAX_PROPERTY constant that represents the size of the "properties"
	 * array.
	 * 
	 * @return int, the MAX_PROPERTY a constant attribute for this class that is set
	 *         5
	 */
	public int getMAX_PROPERTY() {

		return MAX_PROPERTY;
	}

	/**
	 * This method accesses each "Property" object within the array "properties" and
	 * sums up the property rent and returns the total amount.
	 * 
	 * @return double, Total rent of properties
	 */
	public double totalRent() {
		double totalRent = 0;

		for (int i = 0; i < properties.length; i++) {
			if (properties[i] != null) {
				totalRent += properties[i].getRentAmount();	//Adds property rent to total property rent 
			}
		}

		return totalRent;

	}

	/**
	 * This method finds the index of the property with the maximum rent amount.
	 * NOTE: For simplicity assume that each "Property" object's rent amount is
	 * different.
	 * 
	 * @return int , the index of the property with the maximum rent amount
	 */
	private int maxRentPropertyIndex() {
		int maxRentProperty = 0;

		for (int i = 0; i < properties.length; i++) {
			if (properties[i] != null) {
				//Checks if the property rent is greater than the current greatest rent
				if (properties[i].getRentAmount() > properties[maxRentProperty].getRentAmount()) { 
					maxRentProperty = i;
				}
			}
		}

		return maxRentProperty;
	}

	/**
	 * This method finds a property within the properties array that has the maximum
	 * rent amount and returns the rent amount.
	 * 
	 * @return Highest rent 
	 */
	public double maxRentProp() {
		
		double maxRent = properties[maxRentPropertyIndex()].getRentAmount();

		return maxRent;
	}

	/**
	 * Sets Management Company's name
	 * 
	 * @param name Management Company Name
	 */
	public void setName(String name) {

		this.name = name;
	}

	/**
	 * Returns Management Company's name
	 * 
	 * @return name
	 */
	public String getName() {

		return name;
	}

	/**
	 * Sets company Tax ID
	 * 
	 * @param taxID Company Tax ID
	 */
	public void setTaxID(String taxID) {

		this.taxID = taxID;
	}

	/**
	 * Returns company Tax ID
	 * 
	 * @return Company Tax ID
	 */
	public String getTaxID() {

		return taxID;
	}

	/**
	 * Sets Management Company Fee Percentage
	 * 
	 * @param mgmFeePer Company Fee Percentage
	 */
	public void setMgmfee(double mgmFeePer) {

		this.mgmFeePer = mgmFeePer;
	}

	/**
	 * Returns the management company fee Percentage
	 * 
	 * @return management company fee percentage
	 */
	public double getMgmfee() {

		return mgmFeePer;
	}

	/**
	 * Returns a copy of the management company Plot object
	 * 
	 * @return Copy of company plot
	 */
	public Plot getPlot() {
		return new Plot(plot);
	}

	/**
	 * Sets the plot size of management company
	 * 
	 * @param x     x location of upper left corner of company plot
	 * @param y     y location of upper left corner of company plot
	 * @param width width of company plot
	 * @param depth depth of company plot
	 */
	public void setPlot(int x, int y, int width, int depth) {
		plot.setX(x);
		plot.setY(y);
		plot.setWidth(width);
		plot.setDepth(depth);
	}

	/**
	 * Sets the plot size of management company
	 * 
	 * @param p Plot that is copied
	 */
	public void setPlot(Plot p) {
		plot.setX(p.getX());
		plot.setY(p.getY());
		plot.setWidth(p.getWidth());
		plot.setDepth(p.getDepth());
	}

	/**
	 * Displays the information of all the properties in the "properties" array.
	 * 
	 * @return information of ALL the properties within this management company by
	 *         accessing the "Properties" array. The format is as following example:
	 *         
	 *         List of the properties for Alliance, taxID: 1235
	 *         ______________________________________________________ 
	 *          Property Name: Belmar
	 *          Located in Silver Spring 
	 *          Belonging to: John Smith 
	 *          Rent Amount: 1200.0
	 *          Property Name: Camden Lakeway 
	 *          Located in Rockville 
	 *          Belonging to: Ann Taylor
	 *          Rent Amount: 2450.0
	 *          Property Name: Hamptons
	 *          Located in Rockville
	 *          Belonging to: Rick Steves 
	 *          Rent Amount: 1250.0
	 *         ______________________________________________________ 
	 *         total management Fee: 294.0
	 *         
	 * 
	 */
	public String toString() {

		String allProperties = "List of the properties for " + getName() + ", taxID: " + getTaxID()
				+ "\n ______________________________________________________\n";

		for (int i = 0; i < properties.length; i++) {
			if (properties[i] != null) {		//Adds property to string if not null 
				allProperties += properties[i].toString();
			}
		}
		double mgmFee = totalRent() * (getMgmfee() / 100); //Calculate management fee 

		allProperties += " ______________________________________________________\n total management Fee: " + mgmFee;

		return allProperties;
	}
}
