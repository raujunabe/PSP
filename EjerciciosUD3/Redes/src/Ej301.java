import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ej301 {
    public static void main(String[] args) throws UnknownHostException {

        String googleUrl = "www.google.es";
        byte[] localAddress = {127,0,0,1};

        InetAddress ipGoogle = InetAddress.getByName(googleUrl);
        InetAddress[] direccionesGoogle = InetAddress.getAllByName(googleUrl);

        InetAddress ipLocalHost = InetAddress.getByAddress(localAddress);

        System.out.println("SALIDA PARA LOCALHOST: ");
        showAddressDetails(ipLocalHost);
        System.out.println("==================================================");

        System.out.println("SALIDA PARA UNA URL: ");
        showAddressDetails(ipGoogle);
        System.out.println("DIRECCIONES IP PARA: "+googleUrl);
        for (int i = 0; i< direccionesGoogle.length;i++) System.out.println(direccionesGoogle[i]);
        System.out.println("==================================================");
    }

    private static void showAddressDetails(InetAddress ip) throws UnknownHostException {
        System.out.println("Metodo getByName(): "+ip);
        System.out.println("Metodo getLocalHost(): "+InetAddress.getLocalHost());
        System.out.println("Metodo getHostName(): "+ip.getHostName());
        System.out.println("Metodo getHostAddress(): "+ip.getHostAddress());
        System.out.println("Metodo toString(): "+ip.toString());
        System.out.println("Metodo getCannonicalHostName(): "+ip.getCanonicalHostName());
    }
}
