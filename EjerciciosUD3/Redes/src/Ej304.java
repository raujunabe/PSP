import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Ej304 {
    public static void main(String[] args) throws MalformedURLException {
        String periodico = "https://elpais.com/";
        URL url_periodico = new URL(periodico);

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(url_periodico.openStream()));
            StringBuilder contenido = new StringBuilder();
            String linea;

            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
            br.close();

            String html = contenido.toString();

            int index = 0;
            while ((index = html.indexOf("<h2", index)) != -1) {
                int start = html.indexOf(">", index) + 1;

                int end = html.indexOf("</h2>", start);

                if (start != -1 && end != -1) {
                    String titular = html.substring(start, end).trim();
                    if (!titular.isEmpty()) {
                        System.out.println(titular);
                    }
                    index = end + 5;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
