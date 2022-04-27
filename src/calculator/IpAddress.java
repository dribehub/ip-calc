package calculator;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpAddress {

    private final String[] octets;
    private final InetAddress inet;

    public IpAddress(int g1, int g2, int g3, int g4) throws UnknownHostException {
        octets = new String[] {
                String.format("%03d", g1),
                String.format("%03d", g2),
                String.format("%03d", g3),
                String.format("%03d", g4)
        };
        String host = String.join(".", octets);
        inet = InetAddress.getByName(host);
    }

    public static long toLong(IpAddress ipAddress) {
        long result = 0;
        for (byte octet : ipAddress.inet.getAddress()) {
            result <<= 8;
            result |= octet & 0xff;
        }
        return result;
    }

    public static NetworkClass getNetworkClass(IpAddress ipAddress) {
        long ip = toLong(ipAddress);
        if (ip < toLong(NetworkClass.B.getStartAddress()))
            return NetworkClass.A;
        if (ip < toLong(NetworkClass.C.getStartAddress()))
            return NetworkClass.B;
        if (ip < toLong(NetworkClass.D.getStartAddress()))
            return NetworkClass.C;
        if (ip < toLong(NetworkClass.E.getStartAddress()))
            return NetworkClass.D;
        if (ip <= toLong(NetworkClass.E.getEndAddress()))
            return NetworkClass.E;
        return null;
    }

    public static String getNetworkId(IpAddress ipAddress) {
        return ipAddress.inet.getHostName().split("\\.")[0];
    }

    public String getHostName() {
        String[] simpleOctet = new String[4];
        for (int i = 0; i < octets.length; i++)
            simpleOctet[i] = String.valueOf(Integer.parseInt(octets[i]));
        return String.join(".", simpleOctet);
    }

    public String[] getOctets() {
        return octets;
    }

    public InetAddress getInet() {
        return inet;
    }
}
