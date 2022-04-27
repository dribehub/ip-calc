package calculator;

import java.util.Objects;

public class NetworkClass {

    private final IpAddress startAddress;
    private final IpAddress endAddress;
    private final String subnetMask;

    public static NetworkClass A = get('A');
    public static NetworkClass B = get('B');
    public static NetworkClass C = get('C');
    public static NetworkClass D = get('D');
    public static NetworkClass E = get('E');

    private NetworkClass(IpAddress startAddress, IpAddress endAddress, Integer subnetMask) {
        this.startAddress = startAddress;
        this.endAddress = endAddress;
        this.subnetMask = subnetMask == null ? null
                : Integer.toBinaryString(subnetMask);
    }

    public static NetworkClass get(char name) {
        IpAddress startAddress, endAddress;
        switch (name) {
            case 'A':
                startAddress = new IpAddress("0", "0", "0", "0", 8);
                endAddress = new IpAddress("127", "255", "255", "255", 8);
                return new NetworkClass(startAddress, endAddress, 8);
            case 'B':
                startAddress = new IpAddress("128", "0", "0", "0", 16);
                endAddress = new IpAddress("191", "255", "255", "255", 16);
                return new NetworkClass(startAddress, endAddress, 16);
            case 'C':
                startAddress = new IpAddress("192", "0", "0", "0", 24);
                endAddress = new IpAddress("223", "255", "255", "255", 24);
                return new NetworkClass(startAddress, endAddress, 24);
            case 'D':
                startAddress = new IpAddress("224", "0", "0", "0", 0);
                endAddress = new IpAddress("239", "255", "255", "255", 0);
                return new NetworkClass(startAddress, endAddress, null);
            case 'E':
                startAddress = new IpAddress("240", "0", "0", "0", 0);
                endAddress = new IpAddress("255", "255", "255", "255", 0);
                return new NetworkClass(startAddress, endAddress, null);
            default:
                return null;
        }
    }

    public IpAddress getStartAddress() {
        return startAddress;
    }

    public IpAddress getEndAddress() {
        return endAddress;
    }

    public String getSubnetMask() {
        return subnetMask;
    }

    public boolean hasSubnetMask() {
        return subnetMask != null;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof NetworkClass)) return false;
        NetworkClass networkClass = (NetworkClass) other;
        return Objects.equals(this.startAddress, networkClass.startAddress)
                && Objects.equals(this.endAddress, networkClass.endAddress)
                && Objects.equals(this.subnetMask, networkClass.subnetMask);
    }
}