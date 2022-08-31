package ibu.edu.ba.binarysearch;

import java.io.File;
import java.io.FileNotFoundException;
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

    public static IPAddress convertToIPAddress(String raw) {
        String[] splitted = raw.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        String ipFrom = splitted[0].replace("\"", "");
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
                "\",\"" + this.countryName + "\",\"" + this.regionName + "\",\"" + this.cityName + "\"");
    }

    public static long convertIP(String ip) throws IllegalArgumentException {

        /*Reading the input IP Address and converting it to an IP number*/
        for (int i = 0; i < ip.length(); i++) {
            char c = ip.charAt(i);
            if (!Character.isDigit(c) && !(c == '.')) {
                throw new IllegalArgumentException("Invalid input, check your IP address again.");
            }
        }

        String[] original_ip = ip.split("\\.");

        long w = Long.parseLong(original_ip[0]) * 16777216L;
        long x = Long.parseLong(original_ip[1]) * 65536L;
        long y = Long.parseLong(original_ip[2]) * 256L;
        long z = Long.parseLong(original_ip[3]);

        return(w + x + y + z);
    }
}
