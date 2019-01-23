package RGeneration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public interface Route {
	
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
