import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del archivo: ");
        String ruta = sc.next();
        String[] cmd = {"ls",ruta};
        Process proceso = new ProcessBuilder(cmd).start();

        BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
        String linea;

        while ((linea = br.readLine()) != null) if (linea.toLowerCase().endsWith(".png")) System.out.println(linea);
    }
}