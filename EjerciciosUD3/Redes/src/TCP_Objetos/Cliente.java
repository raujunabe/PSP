package TCP_Objetos;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Cliente {

    static final String Host = "localhost";
    static final int Puerto=2000;

    public static void main(String[] args) {

        ArrayList<String> clientes = new ArrayList<>();
        clientes.add("Juan Pérez");
        clientes.add("María López");
        clientes.add("Carlos García");
        clientes.add("Ana Martínez");

        try{

            Socket sCliente = new Socket( Host, Puerto );

            OutputStream salida = sCliente.getOutputStream();

            ObjectOutputStream flujoSalida = new ObjectOutputStream(salida);

            flujoSalida.writeObject(clientes);

            InputStream entrada = sCliente.getInputStream();
            ObjectInputStream flujoEntrada = new ObjectInputStream(entrada);
            Object listaRecibida = flujoEntrada.readObject();
            System.out.println("Recibiendo del Servidor: \n\t"+listaRecibida);

            sCliente.close();
            } catch( Exception e ) {
                System.out.println( e.getMessage() );
            }
    }
}
