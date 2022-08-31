package ba.edu.ibu;

public class RadixSort {
	
    /* Radix sort algorithm (public invocation) */
    public static void sort(IPAddress[] ipAddresses) {
        long start = System.currentTimeMillis();
        IPAddress max = getMax(ipAddresses);
        long maxIP = max.ipFrom;
        for (int exp = 1; (maxIP / exp) > 0; exp *= 10) {
            sort(ipAddresses, exp);
        }
        long end = System.currentTimeMillis();
        System.out.println("Elapsed Time for Radix sort: " + (end-start) + "ms");
    }
 
    /* Digit-wise radix sort logic */
    private static void sort(IPAddress[] ipAddresses, int exp) {
    	IPAddress[] aux = new IPAddress[ipAddresses.length];
        int[] frequency = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (IPAddress ipAddress : ipAddresses) {
            int digit = (int)((ipAddress.ipFrom / exp) % 10);
            frequency[digit]++;
        }
        
        for (int i = 1; i < 10; i++) {
            frequency[i] += frequency[i - 1];
        }

        for (int i = ipAddresses.length - 1; i >= 0; i--) {
            long digit = (ipAddresses[i].ipFrom / exp) % 10; // 1
            aux[frequency[(int) digit] - 1] = ipAddresses[i];
            frequency[(int) digit]--;
        }

        for (int i= 0; i < ipAddresses.length; i++) {
            ipAddresses[i] = aux[i];
        }
    }
    
    /* Find the maximum element in the array */
    private static IPAddress getMax(IPAddress[] ipAddresses) {
        IPAddress maxIPAddress = ipAddresses[0];
        for (int i = 1; i < ipAddresses.length; i++) {
            if (ipAddresses[i].ipFrom > maxIPAddress.ipFrom) {
                maxIPAddress = ipAddresses[i];
            }
        }
        return maxIPAddress;
    }
}
