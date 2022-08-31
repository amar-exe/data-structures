package ibu.edu.ba.bubblesort;

import java.io.IOException;

public class App {
  public static void main(String[] args) throws IOException {

    IPAddress[] IPAddresses = IPAddress.readIP("C:/Users/Amar/Downloads/IP-COUNTRY-REGION-CITY-SHUFFLED.csv", 1000);

    for (IPAddress ipaddr : IPAddresses) {
      System.out.println(ipaddr.toString());
    }

    System.out.println("Swapped: ");
    System.out.println();

    BubbleSort.sort(IPAddresses);

    for (IPAddress ipaddr : IPAddresses) {
      System.out.println(ipaddr.toString());
    }

    IPAddress.writeToFile("C:/Users/Amar/Downloads/ORGANIZED.csv", IPAddresses);
  }
}
