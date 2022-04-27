package test;

import calculator.IpAddress;
import calculator.IpCalculator;
import util.PrintUtils;

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
        PrintUtils.printHeader("\nKrahasimi i klasave dhe networkut:");
        IpAddress addr1 = new IpAddress("0", "12", "53", "2", 8);
        IpAddress addr2 = new IpAddress("0", "194", "92", "220", 8);
        System.out.printf("\tPër %s dhe %s:%n", PrintUtils.purple(addr1), PrintUtils.purple(addr2));
        IpCalculator.compareClasses(addr1, addr2);
        IpCalculator.compareNetworkIds(addr1, addr2);
        addr1 = new IpAddress("15", "203", "198", "132", 8);
        addr2 = new IpAddress("127", "255", "30", "85", 8);
        System.out.printf("\tPër %s dhe %s:%n", PrintUtils.purple(addr1), PrintUtils.purple(addr2));
        IpCalculator.compareClasses(addr1, addr2);
        IpCalculator.compareNetworkIds(addr1, addr2);
        addr1 = new IpAddress("40", "24", "93", "111", 8);
        addr2 = new IpAddress("128", "0", "0", "0", 8);
        System.out.printf("\tPër %s dhe %s:%n", PrintUtils.purple(addr1), PrintUtils.purple(addr2));
        IpCalculator.compareClasses(addr1, addr2);
        IpCalculator.compareNetworkIds(addr1, addr2);
    }

    /**
     * Teston funksionalitetin e llogaritjes së <b>Network ID</b> dhe <b>Broadcast ID</b> për një IP të dhënë
     */
    private static void calculateNetworkIdAndBroadcastId() {
        PrintUtils.printHeader("\nLlogaritja e Network ID dhe Broadcast ID:");
        IpAddress addr = new IpAddress("123", "234", "0", "1", 8);
        System.out.printf("\tPër %s:%n", PrintUtils.purple(addr));
        IpCalculator.calculateNetworkId(addr);
        IpCalculator.calculateBroadcastId(addr);
        addr = new IpAddress("150", "122", "42", "34", 16);
        System.out.printf("\tPër %s:%n", PrintUtils.purple(addr));
        IpCalculator.calculateNetworkId(addr);
        IpCalculator.calculateBroadcastId(addr);
        addr = new IpAddress("200", "45", "54", "7", 24);
        System.out.printf("\tPër %s:%n", PrintUtils.purple(addr));
        IpCalculator.calculateNetworkId(addr);
        IpCalculator.calculateBroadcastId(addr);
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
        PrintUtils.printHeader("\nGjenerimi i Subnet ID, Broadcast ID, # të hosteve dhe IP së parë dhe të fundit:");
        IpAddress addr = new IpAddress("123", "234", "0", "1", 8);
        String networkId = addr.getNetworkId();
    }
}
