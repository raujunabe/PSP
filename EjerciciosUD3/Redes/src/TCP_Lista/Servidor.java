package TCP_Lista;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Servidor {
    static final int Puerto = 2000;
    public static void main( String[] arg ) {
        try {

            ServerSocket skServidor = new ServerSocket(Puerto);
            Socket sCliente = skServidor.accept();
            InputStream entrada = sCliente.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);
            String producto = flujoEntrada.readUTF();
            System.out.println("Se ha recibido el producto: "+producto);
            OutputStream salida = sCliente.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);
            flujoSalida.writeUTF(producto);

            sCliente.close();
            skServidor.close();

            String fecha = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            String nombreArchivo = "src/TCP_Lista/"+fecha + ".txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
                writer.write(producto);
                writer.newLine();
            }
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
    }
}