package RGeneration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileTran {
	
	
	
	
	public String AddressPath = "src/RGeneration/Address.dat";
	public String LayoutPath = "src/RGeneration/Layout.dat";
	//public List list;
	public List list;
	
	public FileTran() {
		list = new List();
		AddressInfo();
	}
	
	
	
	public void AddressInfo() {
		
		List list = new List();
		
		
		//String path = "src/RGeneration/Layout.dat";
		ArrayList<String> temps = new ArrayList<String>();
		ArrayList<String> vert = new ArrayList<String>();
		ArrayList<String> horz = new ArrayList<String>();
		String token1 = "";
	    // for-each loop for calculating heat index of May - October

	    // create Scanner inFile1
	    Scanner inFile1;
		try {
			inFile1 = new Scanner(new File(LayoutPath));
			 // while loop
		    while (inFile1.hasNext()) {
		      // find next line
		      token1 = inFile1.nextLine();
		      temps.add(token1);
		    }
		    inFile1.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}
		System.out.println(temps.toString());
		
		Iterator it = temps.listIterator();
		Iterator it2 = temps.listIterator();
		while(it.hasNext()) {
			String thing = it.next().toString();
			
			if(thing.contains("Vertical")) {
				
				while(it.hasNext()) {
					
					String thing2 = it.next().toString();
					//System.out.println("SHIT: " + thing2);
					
					if(thing2.contains("Horizontal")) {
						break;
					}else {
						vert.add(thing2);
						vert.remove("");
					}
					
				}
			}
		}
		while(it2.hasNext()) {
			String thing = it2.next().toString();
			
			if(thing.contains("Horizontal")) {
				
				while(it2.hasNext()) {
					
					String thing2 = it2.next().toString();
					//System.out.println("SHIT: " + thing2);
					
					if(thing2.contains("Vertical")) {
						break;
					}else {
						horz.add(thing2);
						horz.remove("");
					}
					
				}			
			}
		}
		System.out.println("Verts:::::");
		System.out.println(vert.toString());
		System.out.println("Horz::::::::");
		System.out.println(horz.toString());
		
		
		BufferedReader br = null;
		String line;
		int r = FileT(AddressPath).length;
		System.out.println(r);
		
		for (String s: FileT(AddressPath)) {
			// want to use string stringTokenizer in order to get the data separated to add
			// to the linked list in the List class
			

				 StringTokenizer stringTokenizer = new StringTokenizer(s, ",");
				   
				  
				 while (stringTokenizer.hasMoreElements()) {

					   // Integer id = Integer.parseInt(stringTokenizer.nextElement().toString());
					    String streetH = stringTokenizer.nextElement().toString();
					    String city = stringTokenizer.nextElement().toString().replaceAll("\\s+","");
					    String zip = stringTokenizer.nextElement().toString().replaceAll("\\s+","");
					    
						StringBuilder sb = new StringBuilder();
						
						
						//Need to seperate street name and house number with another stringTokenizer the variable street
						//System.out.println(streetH);
						String arr[] = streetH.split(" ", 2);
						String houseNum = arr[0];
						String streetName = arr[1];
						
						
						Iterator iterator = vert.iterator();
						Iterator itH = horz.iterator();
						
						while(iterator.hasNext()) {
							String thing = iterator.next().toString();
							
							if(thing.equals(streetName)) {
								list.add(zip, city, streetName, houseNum, true, false);
								//System.out.println(list.toString());
								break;
							}
						}
						while(itH.hasNext()) {
							String thing1 = itH.next().toString();
							//System.out.println(streetName);
							if(thing1.equals(streetName)) {
								list.add(zip, city, streetName, houseNum, false, true);
								//System.out.println(list.toString());
								break;
							}
							
						}
					
				 }
			
			
		}
		//return list;
		
		
		
		
		
		
		//return list;
		
	}
	
	
	
	
	
	
	

	public static String[] FileT(String AddressPath) {
		ArrayList<String> temps = new ArrayList<String>();
		// TODO code application logic here

	    // // read KeyWestTemp.txt
		//String fpath = path;
	    // create token1
	    String token1 = "";

	    // for-each loop for calculating heat index of May - October

	    // create Scanner inFile1
	    Scanner inFile1;
		try {
			inFile1 = new Scanner(new File(AddressPath));
			 // while loop
		    while (inFile1.hasNext()) {
		      // find next line
		      token1 = inFile1.nextLine();
		      temps.add(token1);
		    }
		    inFile1.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}

	    // Original answer used LinkedList, but probably preferable to use ArrayList in most cases
	    // List<String> temps = new LinkedList<String>();

	    String[] tempsArray = temps.toArray(new String[0]);

	   // for (String s : tempsArray) {
	      //System.out.println(s);
	  //  }
		
		
		return tempsArray;
	}


}
