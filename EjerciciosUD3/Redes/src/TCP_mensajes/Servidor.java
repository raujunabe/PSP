package TCP_mensajes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
public class Servidor {
    static final int Puerto = 2000;
    public static void main( String[] arg ) {
        try {

            ServerSocket skServidor = new ServerSocket(Puerto);
            System.out.println("Escuchando en el puerto "+Puerto);
            System.out.println("Escuchando al Cliente: ");
            Socket sCliente = skServidor.accept();
            InputStream entrada = sCliente.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);
            System.out.println("Recibiendo del cliente: \n\t"+flujoEntrada.readUTF());
            OutputStream salida = sCliente.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);
            flujoSalida.writeUTF("Saludos al cliente del servidor");

            sCliente.close();
            skServidor.close();
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
        System.out.println("Servidor cerrado. ");
    }
}