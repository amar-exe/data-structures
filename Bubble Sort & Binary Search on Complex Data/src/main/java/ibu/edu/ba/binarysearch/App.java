package ibu.edu.ba.binarysearch;

import java.io.IOException;
import java.util.Scanner;

import static ibu.edu.ba.binarysearch.IPAddress.convertIP;

public class App {
  public static void main(String[] args) throws IOException {

    IPAddress[] IPAddresses = IPAddress.readIP("C:/Users/Amar/Downloads/ORGANIZED.csv", 1000);

    Scanner reader = new Scanner(System.in);

    System.out.println("Input an IP address: ");
    String inputIP = reader.nextLine();

    System.out.println(BinarySearch.findNumber(IPAddresses, convertIP(inputIP)));

  }
}