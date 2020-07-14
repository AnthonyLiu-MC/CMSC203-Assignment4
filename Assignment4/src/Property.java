
public class Property {

	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	
	
	public Property() {
		city = "";
		owner = "";
		propertyName = "";
		rentAmount = 0;
		plot = new Plot(0,0,1,1);
	}
	
	public Property(Property p) {	
		city = p.city;
		owner = p.owner;
		propertyName = p.propertyName;
		rentAmount = p.rentAmount;
		plot = p.plot;
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot();
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {	
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner; 
		plot = new Plot(x,y,width,depth);
	}
	
	public String getCity() {
		return city;
	}
	
	public String getOwner() {	
		return owner;
	}
	
	public String getPropertyName() {
		return propertyName;
	}
	
	public double getRentAmount() {	
		return rentAmount;
	}
	
	public Plot getPlot() {
		return plot;
	}
	
	public Plot setPlot(int x, int y, int width, int depth) {
		return new Plot(x,y,width,depth);
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public void setRentAMount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	
	public String toString() {
		
		String propertyName = " Property Name: " + this.propertyName + "\n";
		String city = " Located in " + this.city + "\n";
		String owner = " Belonging to: " + this.owner + "\n";
		String rentAmount = " Rent Amount: " + this.rentAmount + "\n";
		String propertyInfo = propertyName + city + owner + rentAmount;
		
		return propertyInfo;
	}
}
