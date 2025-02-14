import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class Ej305 {
    public static void main(String[] args) {
        ArrayList<SuperHeroe> listaSuperheroes = new ArrayList<SuperHeroe>();

        try{
            BufferedReader br = new BufferedReader(new FileReader("src/superheroes.txt"));
            String linea;
            while ((linea=br.readLine())!= null){
                String[] datosSuperheroe = new String[4];
                int contador = 0;
                for (String s : linea.split(";")) {
                    datosSuperheroe[contador] = s;
                    contador++;
                }
                listaSuperheroes.add(new SuperHeroe(datosSuperheroe[0],datosSuperheroe[1],datosSuperheroe[2],datosSuperheroe[3]));
            }

        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new URL("http://mural.uv.es/franpevi/index.html").openStream()))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains("<img")) {
                    String[] partes = linea.split(" ");
                    String imagen = "";
                    String id = "";
                    for (String parte : partes) {
                        if (parte.startsWith("src=")) {
                            imagen = parte.split("\"")[1];
                        } else if (parte.startsWith("class=")) {
                            id = parte.split("\"")[1];
                        }
                    }
                    if (!imagen.isEmpty() && !id.isEmpty()) {
                        for (SuperHeroe superHeroe: listaSuperheroes){
                            if (superHeroe.getId().contentEquals(id)) superHeroe.setImagen(imagen);
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedWriter marvel = new BufferedWriter(new FileWriter("marvel.html"));
             BufferedWriter DC = new BufferedWriter(new FileWriter("dcweb.html"))) {

            inicializarHtml(marvel);
            inicializarHtml(DC);

           for (SuperHeroe superHeroe: listaSuperheroes){
                String id = superHeroe.getId();
                String nombre = superHeroe.getNombre_superheroe();
                String idSecreta = superHeroe.getIdentidad_secreta();
                String descripcion = superHeroe.getDescripcion();
                String imagen = superHeroe.getImagen();

                String fila = String.format(
                        "<tr><td>%s</td><td>%s</td><td>%s</td><td><img src=\"%s\" width=\"100\"></td></tr>\n",
                        nombre, idSecreta, descripcion, imagen
                );

                if (id.startsWith("M")) {
                    marvel.write(fila);
                } else if (id.startsWith("D")) {
                    DC.write(fila);
                }
            }
            finalizarHtml(marvel);
            finalizarHtml(DC);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void inicializarHtml(BufferedWriter bw) throws IOException {
        bw.write("<!DOCTYPE html>\n<html lang=\"es\">\n<head>\n<meta charset=\"UTF-8\">\n");
        bw.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        bw.write("<style>\n");
        bw.write("table { width: 100%; border-collapse: collapse; }\n");
        bw.write("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }\n");
        bw.write("th { background-color: #f2f2f2; }\n");
        bw.write("img { max-width: 100px; height: auto; }\n");
        bw.write("</style>\n</head>\n<body>\n");
        bw.write("<table>\n<tr><th>Nombre</th><th>ID Secreta</th><th>Descripción</th><th>Imagen</th></tr>\n");
    }

    private static void finalizarHtml(BufferedWriter bw) throws IOException {
        bw.write("</table>\n</body>\n</html>");
    }
}
class SuperHeroe {
    String id;
    String nombre_superheroe;
    String identidad_secreta;
    String descripcion;
    String imagen;

    SuperHeroe(String id, String nombre, String identidad, String descripcion){
        setId(id);
        setNombre_superheroe(nombre);
        setIdentidad_secreta(identidad);
        setDescripcion(descripcion);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre_superheroe() {
        return nombre_superheroe;
    }

    public void setNombre_superheroe(String nombre_superheroe) {
        this.nombre_superheroe = nombre_superheroe;
    }

    public String getIdentidad_secreta() {
        return identidad_secreta;
    }

    public void setIdentidad_secreta(String identidad_secreta) {
        this.identidad_secreta = identidad_secreta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}