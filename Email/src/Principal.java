import java.io.*;
import java.util.Scanner;

public class Principal {

     int numeroIntentos = 3;

     boolean correoValido = false;

     Scanner sc = new Scanner(System.in);
     String introducirEmail(){
        System.out.println("Introduce tu email: ");
        return sc.nextLine();
    }


    void comprobarEmail() throws IOException {
        numeroIntentos--;
        String email = introducirEmail();

        File directorio = new File("/home/raujunabe/IdeaProjects/Email/src");

        ProcessBuilder pb = new ProcessBuilder("java","ValidaMail.java",email);

        try {
            pb.directory(directorio);
            Process p = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if (line.contentEquals("El email es valido")) correoValido = true;
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }

    }

    public static void main(String[] args) throws IOException {
        Principal principal = new Principal();
        while (principal.numeroIntentos > 0 && !principal.correoValido) principal.comprobarEmail();

    }
}
