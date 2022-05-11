package calculator;

import util.StringUtils;

import java.util.stream.Stream;

public class IpAddress {

    private String hostName;
    private NetworkClass networkClass;
    private int address;
    private int mask;
    private int network;
    private int broadcast;
    private int value;

    public IpAddress(int o1, int o2, int o3, int o4, int mask) {
        validateOctets(o1, o2, o3, o4);
        validateMask(mask);
        hostName = toAddress(o1, o2, o3, o4);
        networkClass = findNetworkClass(o1);
        address = (o1 << 24) | (o2 << 16) | (o3 << 8) | (o4);
        this.mask = (int) (Math.pow(2, mask) - 1) << (32 - mask);
        network = address & this.mask;
        broadcast = network | ~this.mask;
        value = 32 - mask;
    }

    public IpAddress(int o1, int o2, int o3, int o4) {

    }

    private void validateOctets(int... octets) {
        for (int octet : octets) {
            if (octet < 0)
                throw new IllegalArgumentException("Octets must be >= 0");
            if (octet >= 256)
                throw new IllegalArgumentException("Octets must be < 256");
        }
    }

    private void validateMask(int mask) {
        if (Stream.of(0, 8, 16, 24).noneMatch(i -> i == mask))
            throw new IllegalArgumentException("Mask arg should equal 0, 8, 16 or 24");
    }

    private NetworkClass findNetworkClass(int octet) {
        return octet < 128 ? NetworkClass.A
             : octet < 192 ? NetworkClass.B
             : octet < 224 ? NetworkClass.C
             : octet < 240 ? NetworkClass.D
             : octet < 256 ? NetworkClass.E
             : null;
    }

    private String toAddress(int o1, int o2, int o3, int o4) {
       return String.format("%d.%d.%d.%d", o1, o2, o3, o4);
    }

    private int[] toInts(String ip) {
        String[] octets = ip.split("\\.");
        int[] intOctets = new int[octets.length];
        for (int i = 0; i < octets.length; i++)
            intOctets[i] = Integer.parseInt(octets[i]);
        return intOctets;
    }

    private String toOctets(int ip) {
        return String.format("%d.%d.%d.%d",
                ip >> 24 & 0xff,
                ip >> 16 & 0xff,
                ip >> 8 & 0xff,
                ip & 0xff
        );
    }

    public String getHostName() {
        return hostName;
    }

    public NetworkClass getNetworkClass() {
        return networkClass;
    }

    public String getAddress() {
        return String.valueOf(address);
    }

    public int getMask() {
        return mask;
    }

    public String getMaskId() {
        return getMaskId(mask);
    }

    public static String getMaskId(int mask) {
        return switch (mask) {
            case 0 -> "0.0.0.0/0";
            case 8 -> "255.0.0.0/8";
            case 16 -> "255.255.0.0/16";
            case 24 -> "255.255.255.0/24";
            default -> throw new IllegalStateException();
        };
    }

    public String getNetworkId() {
        String networkId = toOctets(network) + "/" + (32 - this.value);
        return StringUtils.purple(networkId);
    }

    public String getBroadcastId() {
        return toOctets(broadcast);
    }

    public int getTotalHosts() {
        return (int) (Math.pow(2, this.value) - 2);
    }

    public String getFirstAddress() {
        return toOctets(network + 1);
    }

    public String getLastAddress() {
        return toOctets(broadcast - 1);
    }

    @Override
    public String toString() {
        return StringUtils.purple(this);
    }
}
