package ba.ibu.edu.merge.recursive;

import ba.ibu.edu.AbstractSort;
import ba.ibu.edu.ByName;
import ba.ibu.edu.IPAddress;

public class RecursiveMerge extends AbstractSort {

    public static void sort(IPAddress[] ipAddresses) {
        IPAddress[] aux = new IPAddress[ipAddresses.length];
        sort(ipAddresses, aux, 0, ipAddresses.length - 1);
    }

    private static void sort(IPAddress[] ipAddresses, IPAddress[] aux, int low, int high) {
        if (high <= low) {
            return;
        }

        int mid = low + (high - low) / 2;
        sort(ipAddresses, aux, low, mid);
        sort(ipAddresses, aux, mid + 1, high);
        merge(ipAddresses, aux, low, mid, high);
    }

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

    public static void sortByName(IPAddress[] ipAddresses, ByName byName) {
        IPAddress[] aux = new IPAddress[ipAddresses.length];
        sortByName(ipAddresses, aux, 0, ipAddresses.length - 1, byName);
    }

    private static void sortByName(IPAddress[] ipAddresses, IPAddress[] aux, int low, int high, ByName byName) {
        if (high <= low) {
            return;
        }

        int mid = low + (high - low) / 2;
        sortByName(ipAddresses, aux, low, mid, byName);
        sortByName(ipAddresses, aux, mid + 1, high, byName);
        mergeByName(ipAddresses, aux, low, mid, high, byName);
    }

    private static void mergeByName(IPAddress[] ipAddresses, IPAddress[] aux, int low, int mid, int high, ByName byName) {

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
            } else if (byName.compare(aux[j], aux[i]) < 0) {
                ipAddresses[k] = aux[j++];
            } else {
                ipAddresses[k] = aux[i++];
            }
        }
    }
}
