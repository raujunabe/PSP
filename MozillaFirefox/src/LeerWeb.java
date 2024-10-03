import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Scanner;

public class LeerWeb {

    Scanner sc= new Scanner(System.in);
    String introducirWebs(){
        System.out.println("Introduzca la pagina web (3 como maximo separadas por @): ");
        return sc.nextLine();
    }

    void comprobarWebs(String cad) throws IOException {
        File directorio = new File("/home/raujunabe/IdeaProjects/MozillaFirefox/src");

        String[] cadenasTotales = cad.split("@");

        if (cadenasTotales.length >= 4){
            System.out.println("ERROR");
            return;
        }
        ProcessBuilder pb = new ProcessBuilder("java","VisitaWeb.java",cad);
        pb.directory(directorio);
        Process p =pb.start();



    }

    public static void main(String[] args) throws IOException {
        LeerWeb leerWeb = new LeerWeb();

        String webs = leerWeb.introducirWebs();
        leerWeb.comprobarWebs(webs);

    }
}
