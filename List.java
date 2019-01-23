package RGeneration;

public class List {
	
	private static int counter;
	private CityNode head;

	
	
	
	public String toString() {
		String output = "";
 
		if (head != null) {
			CityNode current = head.getNext();
			while (current != null) {
				output += "[" + current.getData() + "]";
				current = current.getNext();
			}
 
		}
		return output;
	}
	
	public String findZips() {
		
		
		
		
		
		return null;
	}
	
	
	
	// appends the specified element to the end of this list.
		public void add(Object zip, Object cityname, Object streetname, Object housenumber, boolean verticle, boolean horizontal ) {
	 
			// Initialize CityNode only incase of 1st element
			if (head == null) {
				head = new CityNode(zip, cityname, streetname, housenumber, verticle, horizontal);
			}
	 
			CityNode temp = new CityNode(zip, cityname, streetname, housenumber, verticle, horizontal);
			CityNode current = head;
	 
			// Let's check for NPE before iterate over current
			if (current != null) {
	 
				// starting at the head CityNode, crawl to the end of the list and then add element after last CityNode
				while (current.getNext() != null) {
					current = current.getNext();
				}
	 
				// the last CityNode's "next" reference set to our new CityNode
				current.setNext(temp);
			}
			incrementCounter();
		}
		
		
		
		private static int getCounter() {
			return counter;
		}
	 
		private static void incrementCounter() {
			counter++;
		}
	 
		private void decrementCounter() {
			counter--;
		}
		
		// returns the number of elements in this list.
		public int size() {
			return getCounter();
		}
		
		
		
		
		
		
		

}
