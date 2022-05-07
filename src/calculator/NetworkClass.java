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

    private NetworkClass(IpAddress from, IpAddress to, Integer mask, char name) {
        this.startAddress = from;
        this.endAddress = to;
        this.defaultSubnetMask = mask == null ? null
                : Integer.toBinaryString(mask);
        this.name = name;
    }

    private static NetworkClass get(char name, Integer mask) {

        int minVal = 0;
        int maxVal = 255;
        int maxA = 126;
        int maxB = 190;
        int maxC = 222;
        int maxD = 238;
        int maxE = 254;

        int classMin = switch (name) {
            case 'A' -> minVal;
            case 'B' -> maxA + 1;
            case 'C' -> maxB + 1;
            case 'D' -> maxC + 1;
            case 'E' -> maxD + 1;
            default -> -1;
        };

        int classMax = switch (name) {
            case 'A' -> maxA;
            case 'B' -> maxB;
            case 'C' -> maxC;
            case 'D' -> maxD;
            case 'E' -> maxE;
            default -> -1;
        };

        if (classMin == classMax)
            return null;

        int safeMask = mask == null ? minVal : mask;
        IpAddress from = new IpAddress(classMin, minVal, minVal, minVal, safeMask);
        IpAddress to = new IpAddress(classMax, maxVal, maxVal, maxVal, safeMask);
        return new NetworkClass(from, to, mask, name);
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