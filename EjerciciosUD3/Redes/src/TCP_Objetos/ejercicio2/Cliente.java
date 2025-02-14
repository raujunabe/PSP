package TCP_Objetos.ejercicio2;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Cliente {
    static final String Host = "localhost";
    static final int Puerto=2000;

    public static void main(String[] args) {

        try{

            Socket sCliente = new Socket( Host, Puerto );

            InputStream entrada = sCliente.getInputStream();
            ObjectInputStream flujoEntrada = new ObjectInputStream(entrada);
            Object personaRecibida = flujoEntrada.readObject();
            System.out.println("Recibiendo del Servidor: \n"+personaRecibida);


            if (personaRecibida instanceof Persona){
                Persona persona = (Persona) personaRecibida;

                persona.setNombre("Jaime");
                persona.setEdad(40);

                OutputStream salida = sCliente.getOutputStream();
                ObjectOutputStream flujoSalida = new ObjectOutputStream(salida);

                flujoSalida.writeObject(persona);
                flujoSalida.flush();
            }

            sCliente.close();
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
    }
}
