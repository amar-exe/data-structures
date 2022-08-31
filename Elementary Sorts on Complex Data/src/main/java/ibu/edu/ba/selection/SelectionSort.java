package ibu.edu.ba.selection;

import ibu.edu.ba.AbstractSort;
import ibu.edu.ba.IPAddress;


public class SelectionSort extends AbstractSort {
	
	public static void sort(IPAddress[] ipAddresses) {
		int arr_length = ipAddresses.length;

		// Moving unsorted array boundary
		for (int i = 0; i < arr_length-1; i++)
		{
			// Finding minimum
			int min_index = i;
			for (int j = i+1; j < arr_length; j++)
				if (ipAddresses[j].ipFrom < ipAddresses[min_index].ipFrom)
					min_index = j;

			// Swap min and current
			swap(ipAddresses, i, min_index);
		}
	}
}
