package ibu.edu.ba.binarysearch;

public class BinarySearch {


    public static String findNumber(IPAddress[] ipAddresses, long searchedIP)
    {
        int low = 0;
        int high = ipAddresses.length - 1;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            if (searchedIP >= ipAddresses[mid].ipFrom &&
                    searchedIP <= ipAddresses[mid].ipTo) {
                return ipAddresses[mid].toString();

            } else if (searchedIP < ipAddresses[mid].ipFrom) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }
        return ("IP entered is not found.");
    }




}
