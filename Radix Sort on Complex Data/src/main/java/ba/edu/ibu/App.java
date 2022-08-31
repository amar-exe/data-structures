package ba.edu.ibu;

import java.io.IOException;

public class App {
  public static void main(String[] args) throws IOException {
    IPAddress[] IPAddresses = IPAddress.readIP("C:/Users/Amar/Downloads/IP-COUNTRY-REGION-CITY-SHUFFLED.csv", 4637053);

    RadixSort.sort(IPAddresses);

    //Radix Sort is so far the fastest sorting algorithm by a mile for me

    IPAddress.writeToFile("C:/Users/Amar/Downloads/RADIX-SORT-ORGANIZED.csv", IPAddresses);

  }
}
