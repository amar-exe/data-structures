package ba.ibu.edu.merge.recursive;

import ba.ibu.edu.ByName;
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

    RecursiveMerge.sort(IPAddresses);

    for (IPAddress ipaddr : IPAddresses) {
      System.out.println(ipaddr.toString());
    }

    IPAddress.writeToFile("C:/Users/Amar/Downloads/RECURSIVE-MERGE-SORT-ORGANIZED.csv", IPAddresses);

    RecursiveMerge.sortByName(IPAddresses, new ByName());

    IPAddress.writeToFile("C:/Users/Amar/Downloads/SORT-BY-NAME-ORGANIZED.csv", IPAddresses);

  }
}
