package calculator;

import util.StringUtils;

import java.util.Objects;

public class IpCalculator {

    public static void compareClasses(IpAddress addr1, IpAddress addr2) {
        String onSuccess = "\t✔ Ndodhen në të njëjtën klasë!";
        String onFailure = "\t❌ Nuk ndodhen në të njëjtën klasë!";
        System.out.println(shareTheSameClass(addr1, addr2) ? onSuccess : onFailure);
    }

    private static boolean shareTheSameClass(IpAddress addr1, IpAddress addr2) {
        NetworkClass c1 = addr1.getNetworkClass();
        NetworkClass c2 = addr2.getNetworkClass();
        return Objects.equals(c1, c2);
    }

    public static void compareNetworkIds(IpAddress addr1, IpAddress addr2) {
        String onSuccess = "\t✔ Ndodhen në të njëjtin network!";
        String onFailure = "\t❌ Nuk ndodhen në të njëjtin network!";
        System.out.println(shareTheSameNetwork(addr1, addr2) ? onSuccess : onFailure);
    }

    private static boolean shareTheSameNetwork(IpAddress addr1, IpAddress addr2) {
        String networkId1 = addr1.getNetworkId();
        String networkId2 = addr2.getNetworkId();
        return Objects.equals(networkId1, networkId2);
    }

    public static void calculateNetworkId(IpAddress addr) {
        System.out.printf("\tNetwork ID: %s%n", addr.getNetworkId());
    }

    public static void calculateBroadcastId(IpAddress addr) {
        System.out.printf("\tBroadcast ID: %s%n", addr.getBroadcastId());
    }

    private static void calculateTotalHosts(IpAddress addr) {
        System.out.printf("\tNumri i hosteve: %s%n", addr.getTotalHosts());
    }

    public static void calculateSubnetId(String networkId) {
        String[] octets = getOctets(networkId);
        Integer mask = getMask(networkId);
        assert mask != null;
        String maskId = IpAddress.getMaskId(mask);
        String subnetId = StringUtils.purple(maskId);
        System.out.printf("\tSubnet ID: %s", subnetId);
    }

    private static String[] getOctets(String addr) {
        return addr.split("\\.");
    }

    private static Integer getMask(String addr) {
        if (!addr.contains("/")) return null;
        String mask = addr.split("/")[1];
        try {
            return Integer.parseInt(mask);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
