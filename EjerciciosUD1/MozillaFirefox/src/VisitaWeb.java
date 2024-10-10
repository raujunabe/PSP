import java.io.*;

public class VisitaWeb {
    public static void main(String[] args) throws IOException {

        String[] cadenasTotales = args[0].split("@");
        for (int i = 0; i < cadenasTotales.length; i++){

        ProcessBuilder pb2 = new ProcessBuilder("firefox",cadenasTotales[i]);
        Process p= pb2.start();

        }

    }
}
