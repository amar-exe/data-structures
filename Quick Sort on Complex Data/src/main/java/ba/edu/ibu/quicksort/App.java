package ba.edu.ibu.quicksort;

import ba.edu.ibu.IPAddress;

import java.io.IOException;

import static ba.edu.ibu.sort.QuickSort.sort;

public class App {
  public static void main(String[] args) throws IOException {
    IPAddress[] IPAddresses = IPAddress.readIP("C:/Users/Amar/Downloads/IP-COUNTRY-REGION-CITY-SHUFFLED.csv", 4637053);

    sort(IPAddresses);

    IPAddress.writeToFile("C:/Users/Amar/Downloads/QUICK-SORT-ORGANIZED.csv", IPAddresses);

    /*
    On my PC:
      -Elapsed Time for file reading: 42104ms
      -Elapsed Time for Quick sort: 3879ms
      -Elapsed Time for file writing: 3469ms

      ------------------------------------------

      Elapsed Time for Recursive Merge sort: 4335ms

     */

  }
}
