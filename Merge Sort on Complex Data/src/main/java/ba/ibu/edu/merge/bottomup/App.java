package ba.ibu.edu.merge.bottomup;

import ba.ibu.edu.IPAddress;

import java.io.IOException;

public class App {
  public static void main(String[] args) throws IOException {
    IPAddress[] IPAddresses = IPAddress.readIP("C:/Users/Amar/Downloads/IP-COUNTRY-REGION-CITY-SHUFFLED.csv", 500);

    for (IPAddress ipaddr : IPAddresses) {
      System.out.println(ipaddr.toString());
    }

    System.out.println("Swapped: ");
    System.out.println();

    BottomUpMerge.sort(IPAddresses);

    for (IPAddress ipaddr : IPAddresses) {
      System.out.println(ipaddr.toString());
    }

    IPAddress.writeToFile("C:/Users/Amar/Downloads/BOTTOMUP-MERGE-SORT-ORGANIZED.csv", IPAddresses);
  }
}
