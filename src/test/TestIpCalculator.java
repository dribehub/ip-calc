package test;

import calculator.IpAddress;
import calculator.IpCalculator;

import util.StringUtils;

public class TestIpCalculator {

    public static void runTests() {
        compareClassesAndNetworkIds();
        calculateNetworkIdAndBroadcastId();
        generateIpDetails();
    }

    /**
     * Teston funksionalitetin e krahasimit të <b>klasës</b> dhe <b>networkut</b> midis dy IP të dhëna
     */
    private static void compareClassesAndNetworkIds() {

        StringUtils.printHeader("\nKrahasimi i klasave dhe networkut:");

        IpAddress[] ips = {
                new IpAddress(0, 12, 53, 2, 8),
                new IpAddress(0, 194, 92, 220, 8),

                new IpAddress(15, 203, 198, 132, 8),
                new IpAddress(127, 255, 30, 85, 8),

                new IpAddress(40, 24, 93, 111, 8),
                new IpAddress(128, 0, 0, 0, 8)
        };

        for (int i = 0; i < ips.length; i += 2) {
            IpAddress ip1 = ips[i];
            IpAddress ip2 = ips[i + 1];
            System.out.printf("Për %s dhe %s:%n", ip1, ip2);
            IpCalculator.compareClasses(ip1, ip2);
            IpCalculator.compareNetworkIds(ip1, ip2);
        }
    }

    /**
     * Teston funksionalitetin e llogaritjes së <b>Network ID</b> dhe <b>Broadcast ID</b> për një IP të dhënë
     */
    private static void calculateNetworkIdAndBroadcastId() {

        StringUtils.printHeader("\nLlogaritja e Network ID dhe Broadcast ID:");

        IpAddress[] ips = {
                new IpAddress(123, 234, 0, 1, 8),
                new IpAddress(150, 122, 42, 34, 16),
                new IpAddress(200, 45, 54, 7, 24)
        };

        for (IpAddress ip : ips) {
            System.out.printf("Për %s:%n", ip);
            IpCalculator.calculateNetworkId(ip);
            IpCalculator.calculateBroadcastId(ip);
        }
    }

    /**
     * Teston funksionalitetin e gjenerimit të:
     * <ul>
     *     <li>Subnet ID</li>
     *     <li>Broadcast ID</li>
     *     <li># të hosteve</li>
     *     <li>IP së parë</li>
     *     <li>IP së fundit</li>
     * </ul>
     * për një Network ID dhe # e subneteve të dhënë
     */
    private static void generateIpDetails() {
        StringUtils.printHeader("\nGjenerimi i Subnet ID, Broadcast ID, # të hosteve dhe IP së parë dhe të fundit:");
        String networkId = "123.0.0.0/8";
        System.out.printf("Për %s:%n", StringUtils.purple(networkId));
        IpCalculator.calculateSubnetId(networkId);
//        IpCalculator.calculateBroadcastId(networkId);
//        IpCalculator.calculateTotalHosts(networkId);
//        IpCalculator.calculateFirstIp(networkId);
//        IpCalculator.calculateLastIp(networkId);
    }
}
