package TCP_mensajes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
public class Cliente {
    static final String Host = "localhost";
    static final int Puerto=2000;
    public static void main( String[] arg ) {
        try{

            Socket sCliente = new Socket( Host, Puerto );

            OutputStream salida = sCliente.getOutputStream();

            DataOutputStream flujoSalida = new DataOutputStream(salida);

           flujoSalida.writeUTF("Saludos al SERVIDOR desde el CLIENTE");

           InputStream entrada = sCliente.getInputStream();
           DataInputStream flujoEntrada = new DataInputStream(entrada);
           System.out.println("Recibiendo del Servidor: \n\t"+flujoEntrada.readUTF());

            sCliente.close();
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
    }
}