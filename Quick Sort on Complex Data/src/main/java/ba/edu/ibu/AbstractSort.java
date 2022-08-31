package ba.edu.ibu;

public abstract class AbstractSort {
	
    /* Returns whether the first element is less than the second one */
    public static boolean less(long v, long w) {
        return v < w;
    }
    
    /* Swaps the two elements in an array */
    public static void swap (IPAddress[] ipAddresses, int a, int b) {
        IPAddress tmp = ipAddresses[a];
        ipAddresses[a] = ipAddresses[b];
        ipAddresses[b] = tmp;
    }
}
