package UDP_Entradas;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Servidor {
    static String[] entradas = new String[4];
    static Queue<String> listaEspera = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        byte[] buffer = new byte[1024];
        boolean servidorAbierto = true;
        System.out.println("Servidor Arrancado...");

        while (servidorAbierto){
            try(DatagramSocket socketUDP = new DatagramSocket(12345)){
                DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
                socketUDP.receive(recibo);
                String mensaje = new String(recibo.getData(), 0, recibo.getLength());
                InetAddress direccionCliente = recibo.getAddress();
                int puertoCliente = recibo.getPort();
                String cad = "";
                switch (mensaje){
                    case "1":
                        for (int i = 0; i<entradas.length; i++){
                            cad += ""+(i+1)+": "+(entradas[i] != null ? entradas[i] : "LIBRE!")+"\n";
                        }
                        byte[] datos = cad.getBytes();
                        DatagramPacket envio = new DatagramPacket(datos, datos.length, direccionCliente, puertoCliente);
                        socketUDP.send(envio);
                        break;
                    case "2":
                        recibo = new DatagramPacket(buffer, buffer.length);
                        socketUDP.receive(recibo);
                        String usuarioReserva = new String(recibo.getData(), 0, recibo.getLength());
                        reservarEntrada(usuarioReserva);
                        break;
                    case "3":
                        recibo = new DatagramPacket(buffer, buffer.length);
                        socketUDP.receive(recibo);
                        String usuarioEliminar = new String(recibo.getData(), 0, recibo.getLength());
                        System.out.println(usuarioEliminar);
                        cancelarEntrada(usuarioEliminar);
                        break;
                    case "4":
                        System.out.println("El cliente se ha desconectado... ");
                        break;
                    case "123":
                        System.out.println("Cerrando Servidor...");
                        servidorAbierto = false;
                        break;
                    default:
                        cad = "Opción Incorrecta";
                        break;

                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    static void reservarEntrada(String mensaje){
        for (int i = 0; i<entradas.length;i++){
            if (entradas[i] == null){
                System.out.println(mensaje+" tiene asignada la butaca "+(i+1));
                entradas[i] = mensaje;
                return;
            }
        }
        System.out.println("Lo siento, ya no quedan butacas libres, pasas a la lista de reservas.");
        listaEspera.add(mensaje);
        System.out.println("Lista de espera:");
        int contador = 0;
        for (String usuario : listaEspera) {
            contador++;
            System.out.println(contador+": " + usuario);
        }
    }

    static void cancelarEntrada(String mensaje){
        for (int i = 0; i<entradas.length;i++){
            if (entradas[i].toLowerCase().contentEquals(mensaje.toLowerCase())){
                if (listaEspera.isEmpty()) entradas[i] = null;
                else entradas[i] = listaEspera.poll();
            }
        }
    }
}
