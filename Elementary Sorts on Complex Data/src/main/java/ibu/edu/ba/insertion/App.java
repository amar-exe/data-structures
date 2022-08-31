package ibu.edu.ba.insertion;

import ibu.edu.ba.IPAddress;
import ibu.edu.ba.selection.SelectionSort;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        IPAddress[] IPAddresses = IPAddress.readIP("C:/Users/Amar/Downloads/IP-COUNTRY-REGION-CITY-SHUFFLED.csv", 1000);

        for (IPAddress ipaddr : IPAddresses) {
            System.out.println(ipaddr.toString());
        }

        System.out.println("Swapped: ");
        System.out.println();

        SelectionSort.sort(IPAddresses);

        for (IPAddress ipaddr : IPAddresses) {
            System.out.println(ipaddr.toString());
        }

        IPAddress.writeToFile("C:/Users/Amar/Downloads/INSERTION-SORT-ORGANIZED.csv", IPAddresses);
    }
}
