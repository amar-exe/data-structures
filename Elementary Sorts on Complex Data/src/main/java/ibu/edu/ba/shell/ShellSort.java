package ibu.edu.ba.shell;

import ibu.edu.ba.AbstractSort;
import ibu.edu.ba.IPAddress;


public class ShellSort extends AbstractSort {
	
	public static void sort(IPAddress[] ipAddresses) {
		int arr_length = ipAddresses.length;

		// Calculating the maximum h
		int h = 1;
		while (h < arr_length / 3) h = 3 * h + 1;

		// Performing shell sort
		while (h >= 1) {
			for (int i = h; i < arr_length; i++) {
				for (int j = i; j >= h && less(ipAddresses[j].ipFrom, ipAddresses[j - h].ipFrom); j -= h) {
					swap(ipAddresses, j, j - h);
				}
			}
			h /= 3;
		}
	}
}
