package calculator;

import util.StringUtils;

import java.util.Objects;

public class IpCalculator {

    public static void compareClasses(IpAddress addr1, IpAddress addr2) {
        NetworkClass c1 = addr1.getNetworkClass();
        NetworkClass c2 = addr2.getNetworkClass();
        System.out.println(Objects.equals(c1, c2)
                ? "\t✔ Ndodhen në të njëjtën klasë!"
                : "\t❌ Nuk ndodhen në të njëjtën klasë!");
    }

    public static void compareNetworkIds(IpAddress addr1, IpAddress addr2) {
        String networkId1 = addr1.getNetworkId();
        String networkId2 = addr2.getNetworkId();
        System.out.println(Objects.equals(networkId1, networkId2)
                ? "\t✔ Ndodhen në të njëjtin network!"
                : "\t❌ Nuk ndodhen në të njëjtin network!");
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
        String[] octets = networkId.split("\\.");
        Integer mask = getMask(networkId);
        assert mask != null;
        String maskId = IpAddress.getMaskId(mask);
        String subnetId = StringUtils.purple(maskId);
        System.out.printf("\tSubnet ID: %s", subnetId);
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
