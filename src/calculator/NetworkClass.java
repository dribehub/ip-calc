package calculator;

import java.util.Objects;

public class NetworkClass {

    private final IpAddress startAddress;
    private final IpAddress endAddress;
    private final String defaultSubnetMask;
    private final char name;

    public static NetworkClass A = get('A', 8);
    public static NetworkClass B = get('B', 16);
    public static NetworkClass C = get('C', 24);
    public static NetworkClass D = get('D', null);
    public static NetworkClass E = get('E', null);

    private NetworkClass(IpAddress from, IpAddress to, Integer defaultSubnetMask, char name) {
        this.startAddress = from;
        this.endAddress = to;
        this.defaultSubnetMask = defaultSubnetMask == null ? null
                : Integer.toBinaryString(defaultSubnetMask);
        this.name = name;
    }

    private static NetworkClass get(char name, Integer mask) {
        IpAddress from, to;
        int safeMask = mask == null ? 0 : mask;
        switch (name) {
            case 'A':
                from = new IpAddress(0, 0, 0, 0, safeMask);
                to = new IpAddress(126, 255, 255, 255, safeMask);
                return new NetworkClass(from, to, mask, name);
            case 'B':
                from = new IpAddress(127, 0, 0, 0, safeMask);
                to = new IpAddress(190, 255, 255, 255, safeMask);
                return new NetworkClass(from, to, mask, name);
            case 'C':
                from = new IpAddress(191, 0, 0, 0, safeMask);
                to = new IpAddress(222, 255, 255, 255, safeMask);
                return new NetworkClass(from, to, mask, name);
            case 'D':
                from = new IpAddress(223, 0, 0, 0, safeMask);
                to = new IpAddress(238, 255, 255, 255, safeMask);
                return new NetworkClass(from, to, mask, name);
            case 'E':
                from = new IpAddress(239, 0, 0, 0, safeMask);
                to = new IpAddress(254, 255, 255, 255, safeMask);
                return new NetworkClass(from, to, mask, name);
            default:
                return null;
        }
    }

    public NetworkClass applyMask(int mask) {
        return get(name, mask);
    }

    public char getName() {
        return name;
    }

    public IpAddress getStartAddress() {
        return startAddress;
    }

    public IpAddress getEndAddress() {
        return endAddress;
    }

    public String getDefaultSubnetMask() {
        return defaultSubnetMask;
    }

    public boolean hasSubnetMask() {
        return defaultSubnetMask != null;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof NetworkClass)) return false;
        NetworkClass networkClass = (NetworkClass) other;
        return Objects.equals(this.startAddress, networkClass.startAddress)
                && Objects.equals(this.endAddress, networkClass.endAddress)
                && Objects.equals(this.defaultSubnetMask, networkClass.defaultSubnetMask);
    }
}