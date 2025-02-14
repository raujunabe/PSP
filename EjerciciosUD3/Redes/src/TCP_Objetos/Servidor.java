package TCP_Objetos;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
    static final int Puerto = 2000;

    public static void main(String[] args) {
        ArrayList<String> clientes = new ArrayList<>();
        clientes.add("Juan Pérez");
        clientes.add("María López");
        clientes.add("Carlos García");
        clientes.add("Ana Martínez");

            try {

                ServerSocket skServidor = new ServerSocket(Puerto);
                System.out.println("Escuchando al Cliente: ");
                Socket sCliente = skServidor.accept();

                InputStream entrada = sCliente.getInputStream();
                ObjectInputStream flujoEntrada = new ObjectInputStream(entrada);
                Object listaRecibida = flujoEntrada.readObject();
                System.out.println("Recibiendo del cliente: \n\t"+listaRecibida.toString());

                OutputStream salida = sCliente.getOutputStream();
                ObjectOutputStream flujoSalida = new ObjectOutputStream(salida);
                flujoSalida.writeObject(clientes);

                sCliente.close();
                skServidor.close();
            } catch( Exception e ) {
                System.out.println( e.getMessage() );
            }
            System.out.println("Servidor cerrado. ");
    }
}
