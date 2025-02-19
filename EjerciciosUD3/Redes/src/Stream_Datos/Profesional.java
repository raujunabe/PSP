package Stream_Datos;

public class Profesional {
    String nombre;
    int edad;
    char genero;
    int tipo_profesional;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getTipo_profesional() {
        return tipo_profesional;
    }

    public void setTipo_profesional(int tipo_profesional) {
        this.tipo_profesional = tipo_profesional;
    }

    public Profesional(String nombre, int edad, char genero, int tipo_profesional) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.tipo_profesional = tipo_profesional;
    }

    @Override
    public String toString() {
        return "Profesional{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", genero=" + genero +
                ", tipo_profesional=" + tipo_profesional +
                '}';
    }
}
