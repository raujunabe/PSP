package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Servidor {

    public static void main(String[] args) throws IOException {
        byte[] buffer = new byte[1024];
        DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
        DatagramSocket socketUDP = new DatagramSocket(12345);
        System.out.println("Servidor esperando datagrama...");
        socketUDP.receive(recibo);

        String mensaje = new String(recibo.getData(), 0, recibo.getLength());
        System.out.println("Servidor recibe: " + mensaje);

        long numero = mensaje.chars().filter(c -> c == 'a' || c == 'A').count();
        System.out.println("Enviando número de apariciones de la letra 'a': " + numero);

        String respuesta = "La letra 'a' aparece " + numero + " veces";
        byte[] datosRespuesta = respuesta.getBytes();

        InetAddress direccionCliente = recibo.getAddress();
        int puertoCliente = recibo.getPort();

        DatagramPacket envio = new DatagramPacket(datosRespuesta, datosRespuesta.length, direccionCliente, puertoCliente);
        socketUDP.send(envio);

        System.out.println("Cerrando la conexión...");

        socketUDP.close();
    }
}
