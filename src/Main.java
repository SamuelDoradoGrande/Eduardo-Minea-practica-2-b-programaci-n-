import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Ejercicio Alumno
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

        //Ejercicio 1
        switch (args[0]) {
            case "initCircle" -> guardarObjetoEnArchivo(args[1], new Circle());
            case "showCircle" -> {
                Circle datoCargado = cargarObjetoDesdeArchivo(args[1], Circle.class);
                if (datoCargado != null) System.out.println(datoCargado);
            }
            //Clase Rectangle
            case "initRectangle" -> guardarObjetoEnArchivo(args[1], new Rectangle());
            case "showRectangle" -> {
                Rectangle datoCargado = cargarObjetoDesdeArchivo(args[1], Rectangle.class);
                if (datoCargado != null) System.out.println(datoCargado);
            }
            //Clase MyCircle
            case "initMyCircle" -> guardarObjetoEnArchivo(args[1], new MyCircle());
            case "showMyCircle" -> {
                MyCircle datoCargado = cargarObjetoDesdeArchivo(args[1], MyCircle.class);
                if (datoCargado != null) System.out.println(datoCargado);
            }
            //Clase MyPoint
            case "initMyPoint" -> guardarObjetoEnArchivo(args[1], new MyPoint());
            case "showMyPoint" -> {
                MyPoint datoCargado = cargarObjetoDesdeArchivo(args[1], MyPoint.class);
                if (datoCargado != null) System.out.println(datoCargado);
            }
        // Ejercicio 2
            case "initAlumnoEnAlumno" -> {
                Alumno nuevoAlumno = new Alumno("Paco", 18, "1º Año 1º Cuatrimestre", 15);
                guardarObjetoEnArchivo(args[1], new Alumno(nuevoAlumno));
            }
            // Ejercicio 3
            case "initArray" -> guardarObjetoEnArchivo(args[1], new int[]{1, 2, 3, 4});
            case "showArray" -> {
                int[] datoCargado = cargarObjetoDesdeArchivo(args[1], int[].class);
                if (datoCargado != null) System.out.println(Arrays.toString(datoCargado));
            }
            // Ejercicio 4
            case "initAsignatura" -> {
                Estudiante alumno1 = new Estudiante("Manolo", 6, "1º Primaria");
                Estudiante alumno2 = new Estudiante("Manola", 6, "1º Primaria");
                guardarObjetoEnArchivo(args[1], new Asignatura("Física Cuántica", "Pepe", "AulaE360", new Estudiante[]{alumno1, alumno2}));
            }
            case "" -> System.out.println(" ");
            default -> System.out.println("Comando no válido");
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

        public Alumno(Alumno alumno) {
            this.nombre = alumno.nombre;
            this.edad = alumno.edad;
            this.titulacion = alumno.titulacion;
            this.notaMedia = alumno.notaMedia;
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

    public static <T> void guardarObjetoEnArchivo(String rutaArchivo, T objeto) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(objeto, writer);
        } catch (IOException e) {
            System.out.println("Se ha producido un error; inténtelo de nuevo en otro momento");
        }
    }

    public static <T> T cargarObjetoDesdeArchivo(String rutaArchivo, Class<T> clase) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(rutaArchivo)) {
            return gson.fromJson(reader, clase);
        } catch (IOException e) {
            System.out.println("Se ha producido un error; inténtelo de nuevo en otro momento");
            return null;
        }
    }

    static class Circle{
        private double radius;

        private String color;

        public Circle(){
            radius = 1.0;
            color = "red";
        }

        public Circle(double radius){
            this.radius = radius;
            color = "red";
        }

        public Circle(double radius, String color){
            this.radius = radius;
            this.color = color;
        }

        public double getRadius() {
            return radius;
        }

        public String getColor(){
            return color;
        }

        public double getArea() {
            return radius*radius*Math.PI;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString(){
            return "Circle[radius = " + radius + " color = " + color + "]";
        }
    }

    static class Rectangle{
        private float length;

        private float width;

        public Rectangle(){
            length = 1.0f;
            width = 1.0f;
        }

        public Rectangle(float length, float width){
            this.length = length;
            this.width = width;
        }

        public float getLength() {
            return length;
        }

        public void setLength(float length) {
            this.length = length;
        }

        public float getWidth() {
            return width;
        }

        public void setWidth(float width) {
            this.width = width;
        }

        public double getArea(){
            return length*width;
        }

        public double getPerimeter(){
            return 2*(length+width);
        }

        @Override
        public String toString() {
            return "Rectangle[length = " + length + "; width = " + width + "]";
        }
    }

    static class MyCircle{
        private MyPoint center;
        private int radius;

        public MyCircle(){
            this.center = new MyPoint(0, 0);
            this.radius = 1;
        }

        public MyCircle(int x, int y, int radius){
            this.center = new MyPoint(x, y);
            this.radius = radius;
        }

        public MyCircle(MyPoint center, int radius){
            this.center = center;
            this.radius = radius;
        }

        public int getRadius() {
            return radius;
        }

        public void setRadius(int radius) {
            this.radius = radius;
        }

        public MyPoint getCenter() {
            return center;
        }

        public void setCenter(MyPoint center) {
            this.center = center;
        }

        public int getCenterX(){
            return center.getX();
        }

        public void setCenterX(int x){
            this.center.setX(x);
        }

        public int getCenterY(){
            return center.getY();
        }

        public void setCenterY(int y){
            this.center.setY(y);
        }

        public int[] getCenterXY(){
            return center.getXY();
        }

        public void setCenterXY(int x, int y){
            this.center.setX(x);
            this.center.setY(y);
        }

        public String toString(){
            return  "MyCircle[radius = " + radius + ", center = " + center + "]";
        }

        public double getArea(){
            return Math.PI*radius*radius;
        }

        public double getCircumference(){
            return 2*Math.PI*radius;
        }

        public double distance(MyCircle another){
            return center.distance(another.center);
        }
    }

    static class MyPoint{
        private int x;
        private int y;

        public MyPoint(){
            x = 0;
            y = 0;
        }

        public MyPoint(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int[] getXY(){
            return new int[]{x, y};
        }

        public void setXY(int x, int y){
            this.x = x;
            this.y = y;
        }

        public String toString(){
            return "(" + x + ", " + y + ")";
        }

        public double distance(int x, int y){
            return Math.sqrt(Math.pow(getX() - x, 2) + Math.pow(getY() - y, 2));
        }

        public double distance(MyPoint another){
            return Math.sqrt(Math.pow(getX() - another.getX(), 2) + Math.pow(getY() - another.getY(), 2));
        }

        public double distance(){
            return Math.sqrt(Math.pow(getX(), 2) + Math.pow(getY(), 2));
        }
    }

    static class Asignatura{
        private String nombre;
        private String docente;
        private String aula;
        private Estudiante[] estudiantes;

        public Asignatura(String nombre, String docente, String aula, Estudiante[] estudiantes) {
            this.nombre = nombre;
            this.docente = docente;
            this.aula = aula;
            this.estudiantes = estudiantes;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDocente() {
            return docente;
        }

        public void setDocente(String docente) {
            this.docente = docente;
        }

        public String getAula() {
            return aula;
        }

        public void setAula(String aula) {
            this.aula = aula;
        }

        public Estudiante[] getEstudiantes() {
            return estudiantes;
        }

        public void setEstudiantes(Estudiante[] estudiantes) {
            this.estudiantes = estudiantes;
        }
    }

    static class Estudiante{
        private String nombre;
        private int edad;
        private String curso;

        public Estudiante(String nombre, int edad, String curso) {
            this.nombre = nombre;
            this.edad = edad;
            this.curso = curso;
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

        public String getCurso() {
            return curso;
        }

        public void setCurso(String curso) {
            this.curso = curso;
        }
    }
}

        public void setNotaMedia(double notaMedia) {
            this.notaMedia = notaMedia;
        }
    }
}
