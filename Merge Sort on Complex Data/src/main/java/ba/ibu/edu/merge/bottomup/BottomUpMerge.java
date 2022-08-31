package ba.ibu.edu.merge.bottomup;

import ba.ibu.edu.AbstractSort;
import ba.ibu.edu.IPAddress;

public class BottomUpMerge extends AbstractSort {
    public static void sort(IPAddress[] ipAddresses) {
        IPAddress[] aux = new IPAddress[ipAddresses.length];                                       // 1
        for (int size = 1; size < ipAddresses.length; size *= 2) {                     // 2
            for (int low = 0; low < ipAddresses.length - size; low += 2 * size) {      // 3
                int mid = low + size - 1;                                           // 4
                int high = Math.min(low + 2 * size - 1, ipAddresses.length - 1);       // 4
                merge(ipAddresses, aux, low, mid, high);                               // 5
            }
        }
    }

    /* Merge the two sorted sub-arrays into a larger sorted (sub)array */
    private static void merge(IPAddress[] ipAddresses, IPAddress[] aux, int low, int mid, int high) {

        for (int k = low; k <= high; k++) {
            aux[k] = ipAddresses[k];
        }

        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                ipAddresses[k] = aux[j++];
            } else if (j > high) {
                ipAddresses[k] = aux[i++];
            } else if (less(aux[j].ipFrom, aux[i].ipFrom)) {
                ipAddresses[k] = aux[j++];
            } else {
                ipAddresses[k] = aux[i++];
            }
        }
    }
}
