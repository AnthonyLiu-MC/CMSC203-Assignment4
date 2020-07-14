import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	
	ManagementCompany m;
	Property p1,p2,p3,p4,p5,p6;
	
	@Before
	public void setUp() throws Exception {
		//student create a management company
		m = new ManagementCompany("Fake Company", "12345", 7);
		//student add three properties, with plots, to mgmt co
		p1 = new Property("Apartment", "Rockville", 4000.0, "Anthony Liu",2,1,2,3);
		p2 = new Property("Hotel", "Gaithersburg", 6450.0, "Jenny Ha", 3,4,1,1);
		p3 = new Property("Condo", "Germantown", 5462.0, "Nathan Smith", 7,8,2,1);
	
		m.addProperty(p1);
		m.addProperty(p2);
		m.addProperty(p3);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null  
		p1=p2=p3=null;
		m=null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		
		p4 = new Property("House", "Manhatten", 9000.0, "Jason Smith");
		p5 = new Property("Shack", "Swamplands", 50.0, "Hobo Jim", 9,9,1,1);
		p6 = new Property("Mall", "Montgomery", 15000.0, "John White", 4,5,1,1);
		
		//student should add property with 4 args & default plot (0,0,1,1)
		assertEquals(m.addProperty(p4),3,0);
		//student should add property with 8 args
		assertEquals(m.addProperty(p5),4,0);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
		assertEquals(m.addProperty(p6),-1,0);
		
	}
 
	@Test
	public void testMaxRentProp() {
		
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(m.maxRentProp(),6450.0,0);
	}

	@Test
	public void testTotalRent() {
		
		//student should test if totalRent returns the total rent of properties
		assertEquals(m.totalRent(),15912.0,0);
	}

 }