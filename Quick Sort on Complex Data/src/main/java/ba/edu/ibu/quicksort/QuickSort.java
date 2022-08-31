package ba.edu.ibu.sort;

import ba.edu.ibu.AbstractSort;
import ba.edu.ibu.IPAddress;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class QuickSort extends AbstractSort {

    private static void shuffle(IPAddress[] ipAddresses) {
        Random rand = ThreadLocalRandom.current();
        for (int i = ipAddresses.length - 1; i > 0; i--)
        {
            int index = rand.nextInt(i + 1);

            IPAddress a = ipAddresses[index];
            ipAddresses[index] = ipAddresses[i];
            ipAddresses[i] = a;
        }
    }

    private static void sort(IPAddress[] ipAddresses, int low, int high) {

        if (low < high) {
            int p = partition(ipAddresses, low, high);
            sort(ipAddresses, low, p - 1);
            sort(ipAddresses, p + 1, high);


        }
    }

    public static void sort(IPAddress[] ipAddresses) {
        long start = System.currentTimeMillis();
        shuffle(ipAddresses);
        sort(ipAddresses, 0, ipAddresses.length-1);
        System.out.println("Successfully Sorted");
        long end = System.currentTimeMillis();
        System.out.println("Elapsed Time for Quick sort: " + (end-start) + "ms");

    }

    private static int partition(IPAddress[] ipAddresses, int low, int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (less(ipAddresses[++i].ipFrom, ipAddresses[low].ipFrom)) {
                if (i == high) {
                    break;
                }
            }
            while (less(ipAddresses[low].ipFrom, ipAddresses[--j].ipFrom)) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(ipAddresses, i, j);
        }
        swap(ipAddresses, low, j);
        return j;
    }
}
