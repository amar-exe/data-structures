package ibu.edu.ba.insertion;

import ibu.edu.ba.AbstractSort;
import ibu.edu.ba.IPAddress;


public class InsertionSort extends AbstractSort {

	public static void sort(IPAddress[] ipAddresses) {

		// Moving unsorted array boundary
	    for (int i = 0; i < ipAddresses.length; i++) {

			// Parsing through the unsorted part
	        for (int j = i; j > 0; j--) {

				// Swapping
	            if (less(ipAddresses[j].ipFrom, ipAddresses[j - 1].ipFrom)) {
	                swap(ipAddresses, j, j - 1);
	            } else {
	                break;
	            }
	        }
	    }
	}
	
}
