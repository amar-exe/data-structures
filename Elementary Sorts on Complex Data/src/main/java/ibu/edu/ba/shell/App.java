package ibu.edu.ba.shell;

import ibu.edu.ba.IPAddress;

import java.io.IOException;

public class App {
  public static void main(String[] args) throws IOException {

    IPAddress[] IPAddresses = IPAddress.readIP("C:/Users/Amar/Downloads/IP-COUNTRY-REGION-CITY-SHUFFLED.csv", 1000);

    for (IPAddress ipaddr : IPAddresses) {
      System.out.println(ipaddr.toString());
    }

    System.out.println("Swapped: ");
    System.out.println();

    ShellSort.sort(IPAddresses);

    for (IPAddress ipaddr : IPAddresses) {
      System.out.println(ipaddr.toString());
    }

    IPAddress.writeToFile("C:/Users/Amar/Downloads/SHELL-SORT-ORGANIZED.csv", IPAddresses);

  }
}
