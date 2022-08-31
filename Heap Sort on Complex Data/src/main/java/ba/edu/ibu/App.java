package ba.edu.ibu;

import java.io.FileNotFoundException;
import java.io.IOException;

public class App {
  public static void main(String[] args) throws IOException {

    IPAddress[] IPAddresses = IPAddress.readIP("C:/Users/Amar/Downloads/IP-COUNTRY-REGION-CITY-SHUFFLED.csv", 4637053);

    HeapSort.sort(IPAddresses);

    IPAddress.writeToFile("C:/Users/Amar/Downloads/HEAP-SORT-TEST.csv", IPAddresses);


  }
}
