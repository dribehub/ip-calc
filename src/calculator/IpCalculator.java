package calculator;

import util.PrintUtils;

import java.util.Objects;

public class IpCalculator {

    public static void compareClasses(IpAddress addr1, IpAddress addr2) {
        String onSuccess = "\t\tNdodhen në të njëjtën klasë!";
        String onFailure = "\t\tNuk ndodhen në të njëjtën klasë!";
        System.out.println(shareTheSameClass(addr1, addr2) ? onSuccess : onFailure);
    }

    private static boolean shareTheSameClass(IpAddress addr1, IpAddress addr2) {
        NetworkClass c1 = addr1.getNetworkClass();
        NetworkClass c2 = addr2.getNetworkClass();
        return Objects.equals(c1, c2);
    }

    public static void compareNetworkIds(IpAddress addr1, IpAddress addr2) {
        String onSuccess = "\t\tNdodhen në të njëjtin network!";
        String onFailure = "\t\tNuk ndodhen në të njëjtin network!";
        System.out.println(shareTheSameNetwork(addr1, addr2) ? onSuccess : onFailure);
    }

    private static boolean shareTheSameNetwork(IpAddress addr1, IpAddress addr2) {
        String networkId1 = addr1.getNetworkId();
        String networkId2 = addr2.getNetworkId();
        return Objects.equals(networkId1, networkId2);
    }

    public static void calculateNetworkId(IpAddress addr) {
        String network = PrintUtils.purple(addr.getNetworkId());
        System.out.printf("\t\tNetwork ID: %s%n", network);
    }

    public static void calculateBroadcastId(IpAddress addr) {
        String broadcast = PrintUtils.purple(addr.getBroadcastId());
        System.out.printf("\t\tBroadcast ID: %s%n", broadcast);
    }

    public static void calculateTotalHosts(IpAddress addr) {
        System.out.printf("\t\tNumri i hosteve: %s%n", addr.getTotalHosts());
    }
}
