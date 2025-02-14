package TCP_Lista;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    static final String Host = "localhost";
    static final int Puerto=2000;
    public static void main( String[] arg ) {
        Scanner sc = new Scanner(System.in);
        System.out.println("PROGRAMA CLIENTE INICIADO...");

        try{
            Socket sCliente = new Socket( Host, Puerto );

            OutputStream salida = sCliente.getOutputStream();

            DataOutputStream flujoSalida = new DataOutputStream(salida);

            System.out.println("Introduce un producto para insertarlo en la lista de la compra: ");
            String producto = sc.next();
            flujoSalida.writeUTF(producto);

            InputStream entrada = sCliente.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);
            System.out.println("Se ha volcado el producto "+flujoEntrada.readUTF()+" a la lista de la compra.");

            sCliente.close();
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
    }
}