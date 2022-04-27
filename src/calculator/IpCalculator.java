package calculator;

import util.PrintUtils;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Objects;

public class IpCalculator {

    public static IpAddress safeCreateIpAddress(int g1, int g2, int g3, int g4) {
        try {
            return new IpAddress(g1, g2, g3, g4);
        } catch (UnknownHostException e) {
            System.out.println("Ip e vendosur nuk është e saktë");
            return null;
        }
    }

    public static void compareClasses(IpAddress addr1, IpAddress addr2) {
        String onSuccess = "%s dhe %s ndodhen në të njëjtën klasë%n";
        String onFailure = "%s dhe %s NUK ndodhen në të njëjtën klasë%n";
        String format = IpCalculator.shareTheSameClass(addr1, addr2) ? onSuccess : onFailure;
        System.out.printf(format, PrintUtils.purple(addr1), PrintUtils.purple(addr2));
    }

    public static void compareNetworkIds(IpAddress addr1, IpAddress addr2) {
        String onSuccess = "%s dhe %s ndodhen në të njëjtin network%n";
        String onFailure = "%s dhe %s NUK ndodhen në të njëjtin network%n";
        String format = IpCalculator.shareTheSameNetwork(addr1, addr2) ? onSuccess : onFailure;
        System.out.printf(format, PrintUtils.purple(addr1), PrintUtils.purple(addr2));
    }

    public static void calculateNetworkId(IpAddress addr) {
        String ip = PrintUtils.purple(addr);
        String network = PrintUtils.purple(addr.getNetworkId());
        System.out.printf("Network ID e %s është %s%n", ip, network);
    }

    public static void calculateBroadcastId(IpAddress addr) {
        String ip = PrintUtils.purple(addr);
        String broadcast = PrintUtils.purple(addr.getBroadcastId());
        System.out.printf("Broadcast ID e %s është %s%n", ip, broadcast);
    }

    private static boolean shareTheSameClass(IpAddress addr1, IpAddress addr2) {
        NetworkClass c1 = addr1.getNetworkClass();
        NetworkClass c2 = addr2.getNetworkClass();
        return Objects.equals(c1, c2);
    }

    private static boolean shareTheSameNetwork(IpAddress addr1, IpAddress addr2) {
        String networkId1 = addr1.getNetworkId();
        String networkId2 = addr2.getNetworkId();
        return Objects.equals(networkId1, networkId2);
    }
}
