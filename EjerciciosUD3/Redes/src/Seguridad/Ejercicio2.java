package Seguridad;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Ejercicio2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchAlgorithmException {

        String fileSeparator = System.getProperty("file.separator");

        FileInputStream filein = new FileInputStream("src"+fileSeparator+"Seguridad"+fileSeparator+"Datos.dat");
        ObjectInputStream dataOS = new ObjectInputStream(filein);
        Object o = dataOS.readObject();

        String datos = (String) o;
        System.out.println("Datos: " + datos);

        o = dataOS.readObject();
        byte resumenOriginal[] = (byte[]) o;

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        md.update(datos.getBytes());
        byte resumenActual[] = md.digest();

        if (MessageDigest.isEqual(resumenActual, resumenOriginal))
            System.out.println("DATOS VÁLIDOS");
        else
            System.out.println("DATOS NO VÁLIDOS");
        dataOS.close();
        filein.close();

    }
}
