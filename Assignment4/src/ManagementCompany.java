
public class ManagementCompany {

	final private int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name; 
	private Property[] properties;
	private String taxID;
	final private int MGMT_WIDTH = 10;
	final private int MGMT_DEPTH = 10;
	private Plot plot; 
	
	public ManagementCompany() {
		taxID = "";
		name = "";
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee) {	
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
		
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		plot = new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(ManagementCompany otherCompany) {
		name = otherCompany.getName();
		taxID = otherCompany.getTaxID();
		mgmFeePer = otherCompany.getMgmfee();
		plot = new Plot(otherCompany.getPlot());
		properties = new Property[MAX_PROPERTY];
	}
	
	public int addProperty(Property p) {
		
		Property property = new Property(p);
		
		if (!plot.encompasses(property.getPlot())) {
			return -3;
		};
		
		int i;
		for (i = 0; i < properties.length; i++) {
			if (properties[i] != null) {	
				if (properties[i].getPlot().overlaps(property.getPlot())) {
					return -4;
			}
				if( i == properties.length - 1) {
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
	
	public int addProperty(String propertyName, String city, double rent, String ownerName) {
		
		Property property = new Property(propertyName, city, rent, ownerName);
		int i;
		for (i = 0; i < properties.length; i++) {
			if (properties[i] == null) {
				properties[i] = property;
				break;
			}
		}
		
		return i;
		
		
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		int i;
		for (i = 0; i < properties.length; i++) {
			if (properties[i] == null) {
				properties[i] = property;
				break;
			}
		}
		
		return i;

		
	}
	
	public String displayPropertyAtIndex(int i) {
	
		return properties[i].toString();
	}
	
	public int getMAX_PROPERTY() {
		
		return MAX_PROPERTY;
	}
	
	public double totalRent() {
		double totalRent = 0;
		
		for (int i = 0; i < properties.length; i++) {
			if (properties[i] != null) {
				totalRent += properties[i].getRentAmount();
			}
		}
		
		return totalRent;
		
	}
	
	public int maxRentPropertyIndex() {
		int maxRentProperty = 0;
		
		for(int i = 0; i < properties.length; i++) {
			if (properties[i] != null) {
				if (properties[i].getRentAmount() > properties[maxRentProperty].getRentAmount()) {
					maxRentProperty = i;
				}
			}
		}
		
		return maxRentProperty;
	}
	
	public double maxRentProp() {
		
		double maxRent = properties[maxRentPropertyIndex()].getRentAmount();
		
		return maxRent;
	}
	
	
	public void setName(String name) {
		
		this.name = name; 
	}
	
	public String getName() {
		
		return name;
	}
	
	public void setTaxID(String taxID) {
		
		this.taxID = taxID;
	}
	public String getTaxID() {
		
		return taxID;
	}
	
	public void setMgmfee(double mgmFeePer) {
		
		this.mgmFeePer = mgmFeePer;
	}
	public double getMgmfee() {
		
		return mgmFeePer;
	}
	
	public Plot getPlot() {
		return plot;
	}
	
	public void setPlot(int x, int y, int width, int depth) {
		plot.setX(x);
		plot.setY(y);
		plot.setWidth(width);
		plot.setDepth(depth);
	}
	
	public void setPlot(Plot p) {
		plot.setX(p.getX());
		plot.setY(p.getY());
		plot.setWidth(p.getWidth());
		plot.setDepth(p.getDepth());
	}
	
	public String toString() {
		
		String allProperties = "List of the properties for " + getName() + ", taxID: " + getTaxID()
				+ "\n ______________________________________________________\n";
		
		for (int i =0 ; i< properties.length; i++) {
			if (properties[i] != null) {
				allProperties += properties[i].toString();
			}
		}
		double mgmFee = totalRent() * (getMgmfee() / 100);
		
		allProperties += " ______________________________________________________\n total management Fee: " + mgmFee;
		
		return allProperties;
	}
}
