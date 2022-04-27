import test.TestIpCalculator;

public class Main {

    public static void main(String[] args) {
        // Realizoni nje kalkulator IP per skemen e adresimit te protokollit TCP/IP V4
        // Kalkulatori duhet:
        // a) Te llogarise nese dy adresa jane pjese e te njejtit network ID ose jo,
        // b) Te llogarise Network ID dhe Broadcast ID per nje adrese IP te dhene,
        // c) Te gjeneroje:
        //      1) Subnet ID,
        //      2) Broadcast ID,
        //      3) IP e pare,
        //      4) IP e fundit,
        //      5) # i hosteve (te vlefshme per subnetin)
        //    per nje Network ID dhe # e subneteve te dhene

        TestIpCalculator.compareClassesAndNetworkIds();
        TestIpCalculator.calculateNetworkIdAndBroadcastId();
    }
}
