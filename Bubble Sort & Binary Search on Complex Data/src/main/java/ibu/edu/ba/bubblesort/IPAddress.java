package ibu.edu.ba.bubblesort;

import java.io.*;
import java.util.Scanner;

public class IPAddress implements Comparable<IPAddress> {

    long ipFrom;
    long ipTo;
    String countryCode;
    String countryName;
    String regionName;
    String cityName;

    public IPAddress(long ipFrom, long ipTo, String countryCode, String countryName, String regionName, String cityName) {
        this.ipFrom = ipFrom;
        this.ipTo = ipTo;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.regionName = regionName;
        this.cityName = cityName;
    }

    @Override
    public int compareTo(IPAddress that) {
        return Long.compare(this.ipFrom, that.ipFrom);
    }

    /* Read the IPAddress list from a file in the given path */
    public static IPAddress[] readIP(String path, int numOfRows) throws FileNotFoundException {
        IPAddress[] IPAddresses = new IPAddress[numOfRows];
        String line;
        Scanner scanner = new Scanner(new File(path));
        int i = 0; // counter
        while (i<numOfRows) {
            line = scanner.nextLine();
            IPAddresses[i] = convertToIPAddress(line);
            i++;
        }
        scanner.close();
        return IPAddresses;
    }

    /*Converts the .csv file addresses into ones usable by our class*/
    public static IPAddress convertToIPAddress(String raw) {
        String[] splitted = raw.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); //splitting the string by commas surrounded by quotation marks in both sides
        String ipFrom = splitted[0].replace("\"", ""); //removing quotation marks
        long tempIPFrom = Long.parseLong(ipFrom);
        String ipTo = splitted[1].replace("\"", "");
        long tempIPTo = Long.parseLong(ipTo);
        String tempCountryCode = splitted[2].replaceAll("\"", "");
        String tempCountryName = splitted[3].replaceAll("\"", "");
        String tempRegionName = splitted[4].replaceAll("\"", "");
        String tempCityName = splitted[5].replaceAll("\"", "");

        return new IPAddress(tempIPFrom, tempIPTo, tempCountryCode,
                tempCountryName, tempRegionName, tempCityName);
    }

    @Override
    public String toString(){
        return ("\"" + this.ipFrom + "\",\"" + this.ipTo + "\",\"" + this.countryCode +
                "\",\"" + this.countryName + "\",\"" + this.regionName + "\",\"" + this.cityName + "\"\n");
    }

    public static void writeToFile(String path, IPAddress[] ipAddresses) throws IOException {
        BufferedWriter fileWriter = null;
        fileWriter = new BufferedWriter(new FileWriter(path));
        for (IPAddress ipaddr : ipAddresses) {
            fileWriter.write(ipaddr.toString()); //writing the formatted IP Address into the file
        }
        fileWriter.flush();
        fileWriter.close();

        System.out.println("Successfully written to path: " + path);
    }

}
