package UDP;

import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {

        final int puerto = 12345;

        byte[] buffer = new byte[1024];
        InetAddress destino = null;
        try (DatagramSocket socketUDP = new DatagramSocket();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Introduce un mensaje: ");
            String message = scanner.nextLine();
            byte[] data = message.getBytes();

            InetAddress serverAddress = InetAddress.getByName("localhost");
            DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, 12345);
            socketUDP.send(packet);

            System.out.println("Esperando datagrama...");

            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(responsePacket);

            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Recibiendo el número de caracteres 'a' que son: " + response);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
