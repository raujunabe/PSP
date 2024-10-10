import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        File directorio = new File("/home/raujunabe/IdeaProjects/MayusculasPalindromo/src");
        ProcessBuilder pb = new ProcessBuilder("java","Mayusculas.java");
        pb.directory(directorio);
        Process p=pb.start();

        String cadena = "Esta es una cadena de ejemplo\n";
        String cadenaPalindromo = "Anita lava la tina\n";

        OutputStream os = p.getOutputStream();
        os.write(cadena.getBytes());
        os.flush();

        try {
            InputStream is = p.getInputStream();
            int c;
            while ((c = is.read()) != -1)
                System.out.print((char) c);
            is.close();
        }catch(Exception e) {
            e.getMessage();
        }
    }
}