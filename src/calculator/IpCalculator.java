package calculator;

import util.PrintUtils;

import java.net.UnknownHostException;
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

    public static boolean shareTheSameClass(IpAddress addr1, IpAddress addr2) {
        NetworkClass c1 = IpAddress.getNetworkClass(addr1);
        NetworkClass c2 = IpAddress.getNetworkClass(addr2);
        return Objects.equals(c1, c2);
    }

    public static boolean shareTheSameNetworkId(IpAddress addr1, IpAddress addr2) {
        String networkId1 = IpAddress.getNetworkId(addr1);
        String networkId2 = IpAddress.getNetworkId(addr2);
        return Objects.equals(networkId1, networkId2);
    }

    public static void compareClasses(IpAddress addr1, IpAddress addr2) {
        String onSuccess = "%s ndodhet në të njëjtën klasë me %s%n";
        String onFailure = "%s NUK ndodhet në të njëjtën klasë me %s%n";
        String format = IpCalculator.shareTheSameClass(addr1, addr2) ? onSuccess : onFailure;
        System.out.printf(format, PrintUtils.paint(addr1), PrintUtils.paint(addr2));
    }

    public static void compareNetworkIds(IpAddress addr1, IpAddress addr2) {
        String onSuccess = "%s ka të njëjtin network ID me %s%n";
        String onFailure = "%s NUK ka të njëjtin network me %s%n";
        String format = IpCalculator.shareTheSameNetworkId(addr1, addr2) ? onSuccess : onFailure;
        System.out.printf(format, PrintUtils.paint(addr1), PrintUtils.paint(addr2));
    }
}
