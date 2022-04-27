package calculator;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class IpAddress {

    private final String[] octets;
    private final InetAddress inet;

    public IpAddress(int g1, int g2, int g3, int g4) throws UnknownHostException {
        octets = new String[] { // "%03d"
                String.valueOf(g1),
                String.valueOf(g2),
                String.valueOf(g3),
                String.valueOf(g4)
        };
        String host = String.join(".", octets);
        inet = InetAddress.getByName(host);
    }

    public long toLong() {
        long result = 0;
        for (byte octet : inet.getAddress()) {
            result <<= 8;
            result |= octet & 0xff;
        }
        return result;
    }

    public NetworkClass getNetworkClass() {
        long ip = toLong();
        if (ip < NetworkClass.B.getStartAddress().toLong())
            return NetworkClass.A;
        if (ip < NetworkClass.C.getStartAddress().toLong())
            return NetworkClass.B;
        if (ip < NetworkClass.D.getStartAddress().toLong())
            return NetworkClass.C;
        if (ip < NetworkClass.E.getStartAddress().toLong())
            return NetworkClass.D;
        if (ip <= NetworkClass.E.getEndAddress().toLong())
            return NetworkClass.E;
        return null;
    }

    public String[] getNetworkOctets() {
        if (NetworkClass.A.equals(getNetworkClass()))
            return new String[]{octets[0]};
        if (NetworkClass.B.equals(getNetworkClass()))
            return new String[]{octets[0], octets[1]};
        if (NetworkClass.C.equals(getNetworkClass()))
            return new String[]{octets[0], octets[1], octets[2]};
        return octets;
    }

    public String getNetworkId() {
        String[] networkOctets = getNetworkOctets();
        String joinedOctets = String.join(".", networkOctets);
        return joinedOctets + ".0".repeat(4 - networkOctets.length);
    }

    public String getBroadcastId() {
        return null;
    }

    public String getHostName() {
        String[] simpleOctets = new String[4];
        for (int i = 0; i < octets.length; i++)
            simpleOctets[i] = String.valueOf(Integer.parseInt(octets[i]));
        return String.join(".", simpleOctets);
    }

    public String[] getOctets() {
        return octets;
    }

    public InetAddress getInet() {
        return inet;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        IpAddress ipAddress = (IpAddress) other;
        return Arrays.equals(octets, ipAddress.octets);
    }
}
