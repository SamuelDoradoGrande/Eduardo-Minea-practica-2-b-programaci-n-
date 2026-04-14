import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        // Comprobamos los argumentos
        if (args.length != 2) {
            System.out.println("Uso correcto:");
            System.out.println("java Main init fichero.json");
            System.out.println("java Main show fichero.json");
            return;
        }

        String operacion = args[0];
        String fichero = args[1];

        if (operacion.equals("init")) {
            Alumno alumno = new Alumno("Juan Perez", 20, "Matematicas y Computacion", 7.5);
            guardarAlumno(fichero, alumno);
            System.out.println("Fichero creado correctamente: " + fichero);

        } else if (operacion.equals("show")) {
            Alumno alumno = cargarAlumno(fichero);

            if (alumno != null) {
                System.out.println("Datos del alumno leidos desde el fichero:");
                System.out.println("Nombre: " + alumno.getNombre());
                System.out.println("Edad: " + alumno.getEdad());
                System.out.println("Titulacion: " + alumno.getTitulacion());
                System.out.println("Nota media: " + alumno.getNotaMedia());
            } else {
                System.out.println("No se ha podido leer el fichero.");
            }

        } else {
            System.out.println("Operacion no valida.");
            System.out.println("Usa: init o show");
        }
    }

    public static void guardarAlumno(String nombreFichero, Alumno alumno) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(nombreFichero)) {
            gson.toJson(alumno, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar el fichero.");
            e.printStackTrace();
        }
    }

    public static Alumno cargarAlumno(String nombreFichero) {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(nombreFichero)) {
            return gson.fromJson(reader, Alumno.class);
        } catch (IOException e) {
            System.out.println("Error al leer el fichero.");
            e.printStackTrace();
            return null;
        }
    }

    static class Alumno {
        private String nombre;
        private int edad;
        private String titulacion;
        private double notaMedia;

        public Alumno() {
        }

        public Alumno(String nombre, int edad, String titulacion, double notaMedia) {
            this.nombre = nombre;
            this.edad = edad;
            this.titulacion = titulacion;
            this.notaMedia = notaMedia;
        }

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

        public String getTitulacion() {
            return titulacion;
        }

        public void setTitulacion(String titulacion) {
            this.titulacion = titulacion;
        }

        public double getNotaMedia() {
            return notaMedia;
        }

        public void setNotaMedia(double notaMedia) {
            this.notaMedia = notaMedia;
        }
    }
}
