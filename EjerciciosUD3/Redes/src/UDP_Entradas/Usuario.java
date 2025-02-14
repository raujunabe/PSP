package UDP_Entradas;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Usuario {

    public static void main(String[] args) throws IOException {
        final int puerto = 12345;
        byte[] buffer = new byte[1024];
        Scanner sc = new Scanner(System.in);

        int numOpcion = 0;

        while (numOpcion != 4 && numOpcion != 123){
            System.out.println("==TICKETSERVER==");
            System.out.println("Introduzca opción: ");
            System.out.println("1-Listar Butacas ");
            System.out.println("2-Reservar Butacas ");
            System.out.println("3-Anular Butacas ");
            System.out.println("4-Salir ");
            numOpcion = sc.nextInt();

            try(DatagramSocket socketUDP = new DatagramSocket()){
                InetAddress destino = InetAddress.getByName("localhost");
                byte[] data = String.valueOf(numOpcion).getBytes();
                DatagramPacket envio = new DatagramPacket(data, data.length,destino,puerto);
                socketUDP.send(envio);

                String nombre = "";
                switch (numOpcion){
                    case 1:
                        DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
                        socketUDP.receive(responsePacket);
                        String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
                        System.out.println(response);
                        break;
                    case 2:
                        System.out.println("Introduzca su nombre para la reserva: ");
                        nombre = sc.next();
                        data = nombre.getBytes();
                        envio = new DatagramPacket(data, data.length,destino,puerto);
                        socketUDP.send(envio);
                        break;

                    case 3:
                        System.out.println("Introduzca su nombre para la cancelación: ");
                        nombre = sc.next();
                        data = nombre.getBytes();
                        envio = new DatagramPacket(data, data.length,destino,puerto);
                        socketUDP.send(envio);
                        break;
                    case 4:
                        System.out.println("Terminando la conexion... ");
                        break;

                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }


    }

}
