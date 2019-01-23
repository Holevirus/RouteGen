package RGeneration;
/*
 * Class to instantiate a CityNode for keeping the Zip of the city, street, house number ectßß
 */




public class CityNode {

	CityNode next;
	 
	// Zip carried by this CityNode. could be of any type you need.
	Object zip;
	Object cityName;
	Object streetName;
	Object houseNumber;
	boolean vert;
	boolean horiz;

	// CityNode constructor
	public CityNode(Object Zip, Object CityName, Object StreetName, Object HouseNumber, boolean Verticle, boolean Horizontal) {
		next = null;
		zip = Zip;
		cityName = CityName;
		streetName = StreetName;
		houseNumber = HouseNumber; 
		vert = Verticle;
		horiz = Horizontal;
		
	}

	// another CityNode constructor if we want to specify the CityNode to point to.
	public CityNode(Object Zip, CityNode nextValue) {
		next = nextValue;
		zip = Zip;
	}

	// these methods should be self-explanatory
	public Object getData() {
		String data;
		
		data = "" + zip + ", "  +cityName+ ", " + streetName+ ", " + houseNumber+ " ";
		if(vert == true) {
			data += ", Verticle ";
		}
		if(horiz == true) {
			data+= ", Horizontal ";
		}
		
		return data;
	}

	public void setData(Object Zip) {
		zip = Zip;
	}

	public CityNode getNext() {
		return next;
	}

	public void setNext(CityNode nextValue) {
		next = nextValue;
	}
	


}
