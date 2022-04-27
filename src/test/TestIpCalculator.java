package test;

import calculator.IpAddress;
import calculator.IpCalculator;
import util.PrintUtils;

public class TestIpCalculator {

    public static void compareClassesAndNetworkIds() {
        PrintUtils.printTitle("\nKrahasimi i klasave dhe networkut");
        IpAddress addr1 = IpCalculator.safeCreateIpAddress(0, 0, 0, 0);
        IpAddress addr2 = IpCalculator.safeCreateIpAddress(0, 255, 255, 255);
        IpCalculator.compareClasses(addr1, addr2);
        IpCalculator.compareNetworkIds(addr1, addr2);
        addr2 = IpCalculator.safeCreateIpAddress(127, 255, 255, 255);
        IpCalculator.compareClasses(addr1, addr2);
        IpCalculator.compareNetworkIds(addr1, addr2);
        addr2 = IpCalculator.safeCreateIpAddress(128, 0, 0, 0);
        IpCalculator.compareClasses(addr1, addr2);
        IpCalculator.compareNetworkIds(addr1, addr2);
    }

    public static void calculateNetworkIdAndBroadcastId() {
        PrintUtils.printTitle("\nLlogaritja e Network ID dhe Broadcast ID");
        IpAddress addr = IpCalculator.safeCreateIpAddress(123, 234, 0, 1);
        IpCalculator.calculateNetworkId(addr);
        IpCalculator.calculateBroadcastId(addr);
        addr = IpCalculator.safeCreateIpAddress(150, 122, 42, 34);
        IpCalculator.calculateNetworkId(addr);
        IpCalculator.calculateBroadcastId(addr);
    }
}
