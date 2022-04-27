package calculator;

import java.net.UnknownHostException;

public class NetworkClass {

    private final IpAddress startAddress;
    private final IpAddress endAddress;
    private final Integer subnetMask;

    public static NetworkClass A = get('A');
    public static NetworkClass B = get('B');
    public static NetworkClass C = get('C');
    public static NetworkClass D = get('D');
    public static NetworkClass E = get('E');

    private NetworkClass(IpAddress startAddress, IpAddress endAddress, Integer subnetMask) {
        this.startAddress = startAddress;
        this.endAddress = endAddress;
        this.subnetMask = subnetMask;
    }

    public static NetworkClass get(char name) {
        IpAddress startAddress, endAddress;
        try {
            switch (name) {
                case 'A':
                    startAddress = new IpAddress(0, 0, 0, 0);
                    endAddress = new IpAddress(127, 255, 255, 255);
                    return new NetworkClass(startAddress, endAddress, 8);
                case 'B':
                    startAddress = new IpAddress(128, 0, 0, 0);
                    endAddress = new IpAddress(191, 255, 255, 255);
                    return new NetworkClass(startAddress, endAddress, 16);
                case 'C':
                    startAddress = new IpAddress(192, 0, 0, 0);
                    endAddress = new IpAddress(223, 255, 255, 255);
                    return new NetworkClass(startAddress, endAddress, 24);
                case 'D':
                    startAddress = new IpAddress(224, 0, 0, 0);
                    endAddress = new IpAddress(239, 255, 255, 255);
                    return new NetworkClass(startAddress, endAddress, null);
                case 'E':
                    startAddress = new IpAddress(240, 0, 0, 0);
                    endAddress = new IpAddress(255, 255, 255, 255);
                    return new NetworkClass(startAddress, endAddress, null);
                default:
                    return null;
            }
        } catch (UnknownHostException e) {
            return null;
        }
    }

    public IpAddress getStartAddress() {
        return startAddress;
    }

    public IpAddress getEndAddress() {
        return endAddress;
    }

    public Integer getSubnetMask() {
        return subnetMask;
    }

    public boolean hasSubnetMask() {
        return subnetMask != null;
    }
}