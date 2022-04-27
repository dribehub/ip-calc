package calculator;

public class IpAddress {

    private final String hostName;
    private final NetworkClass networkClass;
    private final int address;
    private final int mask;
    private final int network;
    private final int broadcast;
    private final int value;

    public IpAddress(String o1, String o2, String o3, String o4, int mask) {
        int[] ints = toInts(o1, o2, o3, o4);
        hostName = String.join(".", new String[]{o1, o2, o3, o4});
        networkClass = findNetworkClass(o1);
        address = (ints[0] << 24) | (ints[1] << 16) | (ints[2] << 8) | (ints[3]);
        this.mask = (int) (Math.pow(2, mask) - 1) << (32 - mask);
        network = address & this.mask;
        broadcast = network | ~this.mask;
        value = 32 - mask;
    }

    private NetworkClass findNetworkClass(String octet) {
        int classOctet = Integer.parseInt(octet);
        if (classOctet < 128) return NetworkClass.A;
        if (classOctet < 192) return NetworkClass.B;
        if (classOctet < 224) return NetworkClass.C;
        if (classOctet < 240) return NetworkClass.D;
        if (classOctet < 256) return NetworkClass.E;
        return null;
    }

    private int[] toInts(String... octets) {
        int value;
        int[] result = new int[octets.length];
        for (int i = 0; i < result.length; i++) {
            value = Integer.parseInt(octets[i]);
            if (value < 0 || value > 255)
                throw new NumberFormatException();
            result[i] = value;
        }
        return result;
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

    public String getMask() {
        return String.valueOf(mask);
    }

    public String getNetworkId() {
        return toOctets(network) + "/" + (32 - this.value);
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
}
