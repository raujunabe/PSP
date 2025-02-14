package TCP_Objetos.ejercicio2;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

    static final int Puerto = 2000;

    public static void main(String[] args) {
        Persona persona = new Persona("Raul",22);
        try {

            ServerSocket skServidor = new ServerSocket(Puerto);
            System.out.println("Escuchando al Cliente: ");
            Socket sCliente = skServidor.accept();


            OutputStream salida = sCliente.getOutputStream();
            ObjectOutputStream flujoSalida = new ObjectOutputStream(salida);
            flujoSalida.writeObject(persona);

            InputStream entrada = sCliente.getInputStream();
            ObjectInputStream flujoEntrada = new ObjectInputStream(entrada);
            Object personaRecibida = flujoEntrada.readObject();
            System.out.println("Recibiendo del cliente: \n\t"+personaRecibida);


            sCliente.close();
            skServidor.close();
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
        System.out.println("Servidor cerrado. ");
    }
}
