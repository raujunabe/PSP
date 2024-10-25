package Menu;

import java.io.*;
import java.util.ArrayList;

public class Menu {
    public static void main(String[] args) throws FileNotFoundException {

        Plato[] platos = new Plato[3];

        File[] ficheros = new File[3];
        ficheros[0] = new File("src/Menu/primeros.txt");
        ficheros[1] = new File("src/Menu/segundos.txt");
        ficheros[2] = new File("src/Menu/postres.txt");

        for (int i = 0; i<platos.length; i++){
            platos[i] = new Plato((i+1)+"-",(i+1)+" hilo", ficheros[i]);
            platos[i].start();
        }

    }
}




class Plato extends Thread {
    String prefijo;
    File ficheroPlatos;

    Plato(String prefijo, String name, File ruta){
        super(name);
        this.prefijo = prefijo;
        this.ficheroPlatos = ruta;
    }

    @Override
    public void run() {
        File ficheroMenu = new File("src/Menu/menu.txt");

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroMenu)));
             BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroPlatos));){

            String linea;
            while ((linea = bf.readLine()) != null) {
                if (linea.startsWith(prefijo)
                        && !linea.substring(2).contentEquals("PRIMEROS")
                        && !linea.substring(2).contentEquals("SEGUNDOS")
                        && !linea.substring(2).contentEquals("POSTRES"))
                {
                    bw.write(linea.substring(2));
                    bw.newLine();
                    System.out.println("El "+getName()+" escribre..."+linea.substring(2));
                }
            }
        }catch(Exception e) {
            e.getMessage();
        }


    }
}