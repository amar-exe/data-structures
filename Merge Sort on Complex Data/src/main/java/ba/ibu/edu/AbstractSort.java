package ba.ibu.edu;

public abstract class AbstractSort {
	
    /* Returns whether the first element is less than the second one */
    public static boolean less(long v, long w) {
        return v < w;
    }
    
    /* Swaps the two elements in an array */
    public static void swap (IPAddress[] elements, int a, int b) {
        IPAddress tmp = elements[a];
        elements[a] = elements[b];
        elements[b] = tmp;
    }
}
