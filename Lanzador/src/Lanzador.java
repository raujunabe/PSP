import java.io.*;

public class Lanzador {
    public static void main(String[] args) throws IOException {
         //int numero01 = 10;
         //int numero02 = 20;

        File directorio = new File("/home/raujunabe/IdeaProjects/Lanzador/src");
        ProcessBuilder pb = new ProcessBuilder("java","Sumador.java","2","3");
        pb.directory(directorio);
        Process p=pb.start();


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
