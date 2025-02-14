package TCP_Lista;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Servidor_Pro {
    static final int Puerto = 2000;

    public static void main( String[] arg ) {
        String fecha = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        String nombreArchivo = "src/TCP_Lista/"+fecha + ".txt";
        String producto="";
        try {
            ServerSocket skServidor = new ServerSocket(Puerto);
            while (!producto.toLowerCase().contentEquals("salir")){
                Socket sCliente = skServidor.accept();
                InputStream entrada = sCliente.getInputStream();
                DataInputStream flujoEntrada = new DataInputStream(entrada);
                producto = flujoEntrada.readUTF();
                System.out.println("Se ha recibido el producto: "+producto);
                OutputStream salida = sCliente.getOutputStream();
                DataOutputStream flujoSalida = new DataOutputStream(salida);
                flujoSalida.writeUTF(producto);

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
                    writer.write(producto);
                    writer.newLine();
                }

                sCliente.close();
            }
            skServidor.close();

        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
    }
}
