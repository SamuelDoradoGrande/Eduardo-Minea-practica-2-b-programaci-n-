import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Ejercicio Util_Modificar.
        if (args[0].equals("utilModificado")){
            // Ruta del archivo donde se guardará el objeto.
            String rutaArchivo = "usuario.json";

            // Crear una instancia del objeto Usuario.
            Usuario usuario = new Usuario ("Juan", 30, "juan@example.com");

            // Guardar el objeto Usuario al archivo JSON.
            guardarObjetoEnArchivo(rutaArchivo, usuario);

            // Cargar el objeto Usuario desde el archivo JSON.
            Usuario usuarioCargado = cargarObjetoDesdeArchivo(rutaArchivo, Usuario.class);

            if (usuarioCargado != null) { // Si el usuario no es vacío se imprime su nombre.
                System.out.println("Usuario cargado :" + usuarioCargado.nombre);
            }
        }
        // Ejercicio Alumno
        // Comprobamos los argumentos
        if (args.length != 2) {
            System.out.println("Uso correcto:");
            System.out.println("java Main init fichero.json");
            System.out.println("java Main show fichero.json");
            return; // Si no hay dos, nos salimos.
        }

        String operacion = args[0]; // Se asignan operación y fichero a los argumentos.
        String fichero = args[1];

        if (operacion.equals("init")) { // Si es init.
            Alumno alumno = new Alumno("Juan Perez", 20, "Matemáticas y Computación", 7.5);
            guardarAlumno(fichero, alumno); // Se guarda la información del alumno en el fichero.
            System.out.println("Fichero creado correctamente: " + fichero);

        } else if (operacion.equals("show")) { // Si es show.
            Alumno alumno = cargarAlumno(fichero); // Se carga en "alumno" la información guardada en el fichero anteriormente.
            if (alumno != null) { // Si el alumno no es vacío.
                System.out.println("Datos del alumno leídos desde el fichero:");
                System.out.println("Nombre: " + alumno.getNombre());
                System.out.println("Edad: " + alumno.getEdad());
                System.out.println("Titulación: " + alumno.getTitulacion());
                System.out.println("Nota media: " + alumno.getNotaMedia());
            } else { // Si está vacío.
                System.out.println("No se ha podido leer el fichero.");
            }
        } else { // Si no es ni init ni show.
            System.out.println("Operación no valida.");
            System.out.println("Usa: init o show");
        }

        switch (args[0]) {
            // Ejercicio 1. Cuaderno 1.1: Clase Circle.
            case "initCircle" -> guardarObjetoEnArchivo(args[1], new Circle());
            case "showCircle" -> {
                Circle datoCargado = cargarObjetoDesdeArchivo(args[1], Circle.class);
                if (datoCargado != null) System.out.println(datoCargado);
            }
            // Ejercicio 1. Cuaderno 1.2: Clase Rectangle.
            case "initRectangle" -> guardarObjetoEnArchivo(args[1], new Rectangle());
            case "showRectangle" -> {
                Rectangle datoCargado = cargarObjetoDesdeArchivo(args[1], Rectangle.class);
                if (datoCargado != null) System.out.println(datoCargado);
            }
            // Ejercicio 1. Cuaderno 2.1: Clase MyCircle.
            case "initMyCircle" -> guardarObjetoEnArchivo(args[1], new MyCircle());
            case "showMyCircle" -> {
                MyCircle datoCargado = cargarObjetoDesdeArchivo(args[1], MyCircle.class);
                if (datoCargado != null) System.out.println(datoCargado);
            }
            // Ejercicio 1. Cuaderno 2.2: Clase MyPoint.
            case "initMyPoint" -> guardarObjetoEnArchivo(args[1], new MyPoint());
            case "showMyPoint" -> {
                MyPoint datoCargado = cargarObjetoDesdeArchivo(args[1], MyPoint.class);
                if (datoCargado != null) System.out.println(datoCargado);
            }
            case "" -> System.out.println(" ");
            default -> System.out.println("Comando no válido");
        }

        // Ejercicio 1. Cuaderno 3.1: Clase Cylinder.
        String rutaArchivo = args[1];

        if (operacion.equals("initCylinder")) { // Si es init.
            Cylinder c = new Cylinder(2.0, 5.0, "blue"); // Se crea un cilindro.
            guardarObjetoEnArchivo(rutaArchivo, c); // Se guarda el cilindro en rutaArchivo.
            System.out.println("Fichero creado con cilindro por defecto.");

        } else if (operacion.equals("showCylinder")) { // Si es show.
            Cylinder c = cargarObjetoDesdeArchivo(rutaArchivo, Cylinder.class); // Se carga en "c" el cilindro guardado antes en rutaArchivo.
            if (c != null) { // Si el cilindro existe.
                System.out.println("Datos del cilindro:");
                System.out.println(c);
                System.out.println("Área: " + c.getArea());
                System.out.println("Volumen: " + c.getVolume());
            } else { // Si está vacío.
                System.out.println("No se pudo leer el fichero.");
            }

        } else { // Si no es init o show.
            System.out.println("Operación no válida. Usa 'init' o 'show'.");
        }

        // Ejercicio 1. Cuaderno 3.2: Clase Point3D.
        if (operacion.equals("initPoint3D")) { // Si es init.
            Point3D p = new Point3D(1.0f, 2.0f, 3.0f); // Se crea el punto.
            guardarObjetoEnArchivo(rutaArchivo, p); // Se guarda en rutaArchivo.
            System.out.println("Fichero creado con punto 3D por defecto.");

        } else if (operacion.equals("showPoint3D")) { // Si es show.
            Point3D p = cargarObjetoDesdeArchivo(rutaArchivo, Point3D.class); // Se carga en p el punto en 3D guardado antes.
            if (p != null) { // Si p existe.
                System.out.println("Datos del punto:");
                System.out.println(p);
                float[] coords = p.getXYZ();
                System.out.println("Coordenadas: x=" + coords[0] + ", y=" + coords[1] + ", z=" + coords[2]);
            } else { // Si está vacío.
                System.out.println("No se pudo leer el fichero.");
            }

        } else { // Si no es init o show.
            System.out.println("Operación no válida. Usa 'init' o 'show'.");
        }

        // Ejercicio 1. Cuaderno 4.1: Clase MovableCircle.
        if (operacion.equals("initMovableCircle")) { // Si es init.
            MovableCircle c = new MovableCircle(0, 0, 2, 2, 5); // Se crea el círculo.
            guardarObjetoEnArchivo(rutaArchivo, c); // Se guarda el círculo en rutaArchivo.
            System.out.println("Fichero creado con círculo móvil por defecto.");

        } else if (operacion.equals("showMovableCircle")) { // Si es show.
            MovableCircle c = cargarObjetoDesdeArchivo(rutaArchivo, MovableCircle.class); // Se carga en "c" lo que se ha guardado antes en rutaArchivo.
            if (c != null) { // Si existe.
                System.out.println("Estado inicial:");
                System.out.println(c);
                // Probamos cómo se mueve.
                c.moveUp();
                c.moveRight();
                System.out.println("Después de mover:");
                System.out.println(c);
            } else { // Si está vacío.
                System.out.println("No se pudo leer el fichero.");
            }
        } else { // Si no es ni init ni show.
            System.out.println("Operación no válida. Usa 'init' o 'show'.");
        }

        // Ejercicio 1. Cuaderno 4.2: Clase BigDog.
        if (operacion.equals("initBigDog")) { // Si es init.
            Dog dog = new BigDog(); // Se crea BigDog.
            guardarObjetoEnArchivo(rutaArchivo, dog); // Se guarda en rutaArchivo.
            System.out.println("Fichero creado con perro por defecto.");

        } else if (operacion.equals("showBigDog")) { // Si es show.
            Dog dog = cargarObjetoDesdeArchivo(rutaArchivo, Dog.class); // Se carga en dog lo que se ha guardado antes en rutaArchivo.
            if (dog != null) { // Si existe.
                System.out.println("Tipo: " + dog);
                System.out.print("Saludo básico: ");
                dog.greeting();
                System.out.print("Saludo con otro perro: ");
                dog.greeting(new Dog());
            } else { // Si está vacío.
                System.out.println("No se pudo leer el fichero.");
            }

        } else { // Si no es ni init ni show.
            System.out.println("Operación no válida. Usa 'init' o 'show'.");
        }

        switch (args[0]) {
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
                Estudiante alumno1 = new Estudiante("Manolo", 8, "3º Primaria");
                Estudiante alumno2 = new Estudiante("Manola", 8, "3º Primaria");
                guardarObjetoEnArchivo(args[1], new Asignatura("Física Cuántica", "Pepe", "AulaE360", new Estudiante[]{alumno1, alumno2}));
            }
            case "" -> System.out.println(" ");
            default -> System.out.println("Comando no válido");
        }
    }

    // Clase Usuario. Corresponde con el Ejercicio Util_Modificado
    public static class Usuario { // Se crea la clase Usuario.
        String nombre;
        int edad;
        String correo;

        public Usuario(String nombre, int edad, String correo) { // Se crea el constructor con los atributos nombre, edad, y correo.
            this.nombre = nombre;
            this.edad = edad;
            this.correo = correo;
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

        public String getCorreo() {
            return correo;
        }
        public void setCorreo(String correo) {
            this.correo = correo;
        }
    }

    public static void guardarAlumno(String nombreFichero, Alumno alumno) { // Metodo para guardar los alumnos en el fichero.
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Se crea un Gson "gson".

        try (FileWriter writer = new FileWriter(nombreFichero)) { // Se crea un escritor de archivos "writer" que escribe el nombreFichero.
            gson.toJson(alumno, writer); // Se pasa la información del GSON gson a JSON.
        } catch (IOException e) { // Se atrapa la excepción de netrada/salida.
            System.out.println("Error al guardar el fichero.");
            e.printStackTrace();
        }
    }

    public static Alumno cargarAlumno(String nombreFichero) { // Metodo para cargar los alumnos del fichero.
        Gson gson = new Gson(); // Se crea un Gson "gson".

        try (FileReader reader = new FileReader(nombreFichero)) { // Se crea un lector de archivos "reader" que lee la información de nombreFichero.
            return gson.fromJson(reader, Alumno.class); // Se asa el archivo de JSON al Gson gson y se retorna.
        } catch (IOException e) { // Se atrapa la excepción de entrada/salida.
            System.out.println("Error al leer el fichero.");
            e.printStackTrace();
            return null;
        }
    }


    public static <T> void guardarObjetoEnArchivo(String rutaArchivo, T objeto) { // Es el metodo para guardar los archivos.
        Gson gson = new Gson(); // Se crea el Gson "gson".
        try (FileWriter writer = new FileWriter(rutaArchivo)) { // Se crea el escritor de archivos "writer" que escribe en rutaArchivo.
            gson.toJson(objeto, writer); // Pasa el objeto que quieres pasar a JSON en la ruta que se le ha dado a "writer".
        } catch (IOException e) { // Se atrapan las excepciones de salida y entrada.
            System.out.println("Error al entrar o al salir del archivo.");
        }
    }

    public static <T> T cargarObjetoDesdeArchivo(String rutaArchivo, Class<T> clase) { // Es el metodo para leer los archivos.
        Gson gson = new Gson(); // Se crea el Gson "gson".
        try (FileReader reader = new FileReader(rutaArchivo)) { // Se crea el lector de archivos "reader" que lee lo que hay escrito en rutaArchivo.
            return gson.fromJson(reader, clase); // Retorna lo que pone en la rutaArchivo dada a reader.
        } catch (FileNotFoundException e) { // Se atrapa la excepción de que el archivo no esté. Como pertenece a "IOException" se pone antes porque es específico.
            System.out.println("El fichero no existe.");
            return null;
        } catch (IOException e) { // Se atrapan las excepciones de salida y entrada.
            e.printStackTrace();
            return null;
        }
    }

    // Corresponde con el Ejercicio Alumno y Ejercicio 2.
    static class Alumno {
        private String nombre;
        private int edad;
        private String titulacion;
        private double notaMedia;


        public Alumno(String nombre, int edad, String titulacion, double notaMedia) { // Constructor Alumno con los atributos de la clase.
            this.nombre = nombre;
            this.edad = edad;
            this.titulacion = titulacion;
            this.notaMedia = notaMedia;
        }

        public Alumno(Alumno alumno) { // Constructor Alumno con los atributos de un alumno determinado.
            this.nombre = alumno.nombre;
            this.edad = alumno.edad;
            this.titulacion = alumno.titulacion;
            this.notaMedia = alumno.notaMedia;
        }
        // Getter y setter de nombre, edad, titulación, y nota media.
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

    static class Circle11{ // Corresponde con el Ejercicio 1. Cuaderno 1.1.
        private double radius;
        private String color;

        public Circle11(){ // Se crea un constructor predefinido.
            radius = 1.0;
            color = "red";
        }
        public Circle11(double radius){ // Se crea un constructor con el parámetro color predefinido.
            this.radius = radius;
            color = "red";
        }
        public Circle11(double radius, String color){ // Se crea el constructor de Circle.
            this.radius = radius;
            this.color = color;
        }
        // Getter y setter de radius y de color.
        public double getRadius() { return radius;}
        public String getColor(){ return color;}
        public void setRadius(double radius) { this.radius = radius;}
        public void setColor(String color) { this.color = color;}

        public double getArea() { // Se retorna el área del círculo.
            return radius*radius*Math.PI;
        }
        public String toString(){
            return "Circle[radius = " + radius + " color = " + color + "]";
        }
    }

    static class Rectangle{ // Corresponde con el Ejercicio 1. Cuaderno 1.2.
        private float length;
        private float width;

        public Rectangle(){ // Se crea un constructor predefinido.
            length = 1.0f;
            width = 1.0f;
        }
        public Rectangle(float length, float width){ // Se crea el constructor Rectangle.
            this.length = length;
            this.width = width;
        }
        // Getter y setter de length y width.
        public float getLength() { return length;}
        public void setLength(float length) { this.length = length;}
        public float getWidth() { return width;}
        public void setWidth(float width) { this.width = width;}

        public double getArea(){
            return length*width; // Se retorna el área del rectángulo.
        }
        public double getPerimeter(){
            return 2*(length+width); // Se retorna el perímetro del rectángulo.
        }
        @Override
        public String toString() {
            return "Rectangle[length = " + length + "; width = " + width + "]";
        }
    }

    static class MyCircle{ // Corresponde con el Ejercicio 1. Cuaderno 2.1.
        private MyPoint center;
        private int radius;

        public MyCircle(){ // Constructor predefinido.
            this.center = new MyPoint(0, 0);
            this.radius = 1;
        }

        public MyCircle(int x, int y, int radius){ // Constructor MyCircle con coordenadas.
            this.center = new MyPoint(x, y);
            this.radius = radius;
        }

        public MyCircle(MyPoint center, int radius){ // Constructor MyCircle con punto.
            this.center = center;
            this.radius = radius;
        }

        // Getter y setter de radius, center, CenterX(solo la coordenada X), CenterY(solo la coordenada Y), Center XY (Coordenada X e Y).
        public int getRadius() { return radius;}
        public void setRadius(int radius) { this.radius = radius;}
        public MyPoint getCenter() { return center;}
        public void setCenter(MyPoint center) { this.center = center;}
        public int getCenterX(){ return center.getX();}
        public void setCenterX(int x){ this.center.setX(x);}
        public int getCenterY(){ return center.getY();}
        public void setCenterY(int y){ this.center.setY(y);}
        public int[] getCenterXY(){ return center.getXY();}
        public void setCenterXY(int x, int y){
            this.center.setX(x);
            this.center.setY(y);
        }

        public String toString(){
            return  "MyCircle[radius = " + radius + ", center = " + center + "]";
        }

        public double getArea(){
            return Math.PI*radius*radius; // Se retorna el área del círculo.
        }

        public double getCircumference(){
            return 2*Math.PI*radius; // Se retorna la circunferencia (perímetro) del círculo.
        }

        public double distance(MyCircle another){ // Distancia entre los centros de dos círculos.
            return center.distance(another.center);
        }
    }


    static class MyPoint{ // Corresponde con el Ejercicio 1. Cuaderno 2.2.
        private int x;
        private int y;

        public MyPoint(){ // Constructor predefinido.
            x = 0;
            y = 0;
        }

        public MyPoint(int x, int y){ // Constructor MyPoint.
            this.x = x;
            this.y = y;
        }

        // Getter y setter de la coordenada X, la coordenada Y, y ambas a la vez.
        public int getX() { return x;}
        public void setX(int x) { this.x = x;}
        public int getY() { return y;}
        public void setY(int y) { this.y = y;}
        public int[] getXY(){ return new int[]{x, y};}
        public void setXY(int x, int y){
            this.x = x;
            this.y = y;
        }

        public String toString(){
            return "(" + x + ", " + y + ")";
        }

        public double distance(int x, int y){
            return Math.sqrt(Math.pow(getX() - x, 2) + Math.pow(getY() - y, 2)); // Se retorna la distancia entre dos puntos dando coordenadas.
        }

        public double distance(MyPoint another){
            return Math.sqrt(Math.pow(getX() - another.getX(), 2) + Math.pow(getY() - another.getY(), 2)); // Se retorna la distancia entre dos puntos dando el punto.
        }

        public double distance(){
            return Math.sqrt(Math.pow(getX(), 2) + Math.pow(getY(), 2)); // Se retorna la distancia.
        }
    }


    public static class Circle { // Corresponde con el Ejercicio 1. Cuaderno 3.1.
        private double radius;
        private String color;

        public Circle() { // Constructor Circle predefinido.
            this.radius = 1.0;
            this.color = "red";
        }
        public Circle(double radius) { // Constructor Circle con el atributo color predefinido.
            this.radius = radius;
            this.color = "red";
        } // Se asignan los valores a las variables.

        public Circle(double radius, String color) { // Constructor Circle.
            this.radius = radius;
            this.color = color;
        }

        // Se retorna el valor actual de las variables.
        public double getRadius() {
            return this.radius;
        }
        public String getColor() {
            return this.color;
        }

        // Se modifica el valor de las variables.
        public void setRadius(double radius) {
            this.radius = radius;
        }
        public void setColor(String color) {
            this.color = color;
        }

        public double getArea() {
            return Math.PI * this.radius * this.radius;
        } // Se retorna el valor de área = PI*radio^2.

        @Override
        public String toString() {
            return "Circle[radius = " + this.radius + ", color = " + this.color + "]";
        } // Se retorna lo que el enunciado dice.
    }

    public static class Cylinder extends Circle { // Corresponde con el Ejercicio 1. Cuaderno 3.1.
        private double height;

        public Cylinder() { // Constructor Cylinder predefinido.
            super();
            this.height = 1.0;
        }
        public Cylinder(double radius) { // Constructor Cylinder con el atributo height predefinido.
            super(radius);
            this.height = 1.0;
        } // Con super(radius) se llama al constructor Circle(radius).
        public Cylinder(double radius, double height) { // Constructor Cylinder.
            super(radius); // Con super(radius) se llama al constructor Circle(radius).
            this.height = height; // Se asigna el valor con la variable.
        }

        public Cylinder(double radius, double height, String color) { // Constructor Cylinder.
            super(radius, color); // Con super(radius,color) se llama a Circle(radius, color).
            this.height = height; // Se asigna el valor con la variable height.
        }

        // Getter y setter de height.
        public double getHeight() {
            return this.height;
        } // Se retorna el valor actual de la altura.
        public void setHeight(double height) {
            this.height = height;
        } // Se modifica el valor de la altura.


        public double getVolume() {
            return super.getArea() * this.height;
        } // Se retorna el volúmen = área*altura.


        @Override
        public double getArea() {
            return (2 * Math.PI * getRadius() * this.height) + (2 * super.getArea());
        } // Se retorna el área = (2*PI*radio*altura)+(2*áreaCirculo).


        @Override
        public String toString() {
            return "Cylinder: subclase de: " + super.toString() + ", height = " + this.height + "."; // Se retorna lo que el enunciado pide.
        }
    }


    public static class Point2D { // Corresponde con el Ejercicio 1. Cuaderno 3.2.
        private float x;
        private float y;

        public Point2D(float x, float y) { // Constructor Point2D.
            this.x = x;
            this.y = y;
        }
        public Point2D() { // Constructor Point2D predefinido.
            this.x = 0f;
            this.y = 0f;
        }

        // Se retornan los valores actuales de las variables (getters).
        public float getX() {
            return this.x;
        }public float getY() {
            return this.y;
        }

        // Se modifica el valor de las variables (setters).
        public void setX(float x) {
            this.x = x;
        }
        public void setY(float y) {
            this.y = y;
        }

        public float[] getXY() { // Se retorna el valor de x e y juntos.
            float[] coord = {this.x, this.y};
            return coord;
        }
        public void setXY(float x, float y) { // Se modifica el valor de x e y.
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + this.x + "," + this.y + ")";
        } // Se retorna lo que pide el enunciado.
    }

    public static class Point3D extends Point2D { // Corresponde con el Ejercicio 1. Cuaderno 3.2.
        private float z;

        public Point3D(float x, float y, float z) { // Constructor Point3D.
            super(x,y); // Super(x,y) llama al constructor Point2D(x,y).
            this.z = z;
        }

        public Point3D() { //Constructor Point3D con el atributo z predefinido.
            super();
            this.z = 0f;
        } // Este constructor asigna un valor inicial a z.

        // Getter y setter de z.
        public float getZ() {
            return this.z;
        } // Se retorna el valor actual de z.
        public void setZ(float z) {
            this.z = z;
        } // Se modifica el valor de z.


        public float[] getXYZ() {
            float[] coords = {this.getX(), this.getY(), this.z}; // Se retornan las tres variables: x,y,z, juntas.
            return coords;
        }
        public void setXYZ(float x, float y, float z) { // Se modifica el valor de x,y, y z.
            this.setX(x);
            this.setY(y);
            this.z = z;
        }

        @Override
        public String toString() {
            return "(" + this.getX() + "," + this.getY() + "," + this.z + ")";
        } // Se retorna lo que dice el enunciado.
    }


    public interface Movable { // Interface movable. Corresponde con el Ejercicio 1. Cuaderno 4.1.
        void moveUp();
        void moveDown();
        void moveLeft();
        void moveRight();
    }

    public static class MovablePoint implements Movable { // La clase MovablePoint implementa la interfaz Movable. Corresponde con el Ejercicio 1. Cuaderno 4.1.
        private int x, y;
        private int xSpeed, ySpeed;

        public MovablePoint(int x, int y, int xSpeed, int ySpeed) { // Constructor MovablePoint.
            this.x = x;
            this.y = y;
            this.xSpeed = xSpeed;
            this.ySpeed = ySpeed;
        }

        @Override
        public void moveUp() {
            y += ySpeed;
        } // Se mueve el punto desde donde está con una velocidad Speed por el eje y.
        @Override
        public void moveDown() {
            y -= ySpeed;
        } // Se mueve el punto desde donde está con una velocidad Speed en sentido negativo del eje y.
        @Override
        public void moveLeft() {
            x -= xSpeed;
        } // Se mueve el punto desde donde está con una velocidad Speed en el eje x en sentido negativo.
        @Override
        public void moveRight() {
            x += xSpeed;
        } // Se mueve el punto desde donde está con una velocidad Speed en el eje x.

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        } // Retorna lo que dice el enunciado.
    }

    public static class MovableCircle implements Movable { // La clase MovableCircle implementa la interfaz Movable. Corresponde con el Ejercicio 1. Cuaderno 4.1.

        private MovablePoint center;// El centro es un punto MovablePoint.
        private int radius;

        public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) { // Constructor MovableCircle.
            center = new MovablePoint(x, y, xSpeed, ySpeed);
            this.radius = radius;
        }

        @Override
        public void moveUp() {
            center.moveUp();
        } // Se llama al metodo moveUp para subir el centro.
        @Override
        public void moveDown() {
            center.moveDown();
        } // Se llama al metodo moveDown para bajar el centro.
        @Override
        public void moveLeft() { center.moveLeft();} // Se llama al metodo moveLeft para mover a la izquierda el centro.
        @Override
        public void moveRight() { center.moveRight();} // Se llama al metodo moveRight para mover a la derecha el centro.

        @Override
        public String toString() {
            return "Circle center " + center + ", radius=" + radius;
        } // Se retorna lo que dice el enunciado.
    }


    public static abstract class Animal { // Corresponde con el Ejercicio 1. Cuaderno 4.2.
        //Metodo abstracto greets (saludar).
        // Cada subclase deberá implementar su propio sonido o saludo específico.
        abstract public void greeting ();
    }

    public static class Cat extends Animal { // Corresponde con el Ejercicio 1. Cuaderno 4.2.
        //Implementación obligatoria del metodo greeting().
        @Override
        public void greeting() {
            // Imprime el saludo específico del gato
            System.out.println("Miau");
        }
    }

    public static class Dog extends Animal { // Corresponde con el Ejercicio 1. Cuaderno 4.2.
        //Implementación obligatoria del metodo abstracto greeting() de Animal.
        @Override
        public void greeting() {
            // En esta versión el perro saluda con un "Buf"
            System.out.println("Buf");
        }
        //Sobrecarga del metodo greeting.
        public void greeting(Dog another) {
            // El saludo es más largo ("Wooooooof") cuando hay otro perro presente
            System.out.println("Wooooooof");
        }
    }


    public static class BigDog extends Dog { // Corresponde con el Ejercicio 1. Cuaderno 4.2.
        //Sobrescritura del metodo greeting sin parámetros.
        @Override
        public void greeting() {
            // Un BigDog saluda con un potente "Woow"
            System.out.println("Woow");
        }
        //Sobrescritura del metodo greeting que recibe a otro perro.
        @Override
        public void greeting(Dog another) {
            // Al interactuar con otro perro, el saludo es más prolongado
            System.out.println("Wooooow");
        }
    }

        static class Asignatura{ // Corresponde con el Ejercicio 4.
        private String nombre;
        private String docente;
        private String aula;
        private Estudiante[] estudiantes; // Es la lista de los alumnos.

        public Asignatura(String nombre, String docente, String aula, Estudiante[] estudiantes) { // Constructor Asignatura.
            this.nombre = nombre;
            this.docente = docente;
            this.aula = aula;
            this.estudiantes = estudiantes;
        }

        // Getter y setter de nombre.
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        // Getter y setter docente.
        public String getDocente() {
            return docente;
        }
        public void setDocente(String docente) {
            this.docente = docente;
        }

        // Getter y setter.
        public String getAula() {
            return aula;
        }
        public void setAula(String aula) {
            this.aula = aula;
        }

        // Getter y setter de estudiante.
        public Estudiante[] getEstudiantes() {
            return estudiantes;
        }
        public void setEstudiantes(Estudiante[] estudiantes) {
            this.estudiantes = estudiantes;
        }
    }

    static class Estudiante{ // Corresponde con el Ejercicio 4.
        private String nombre;
        private int edad;
        private String curso;

        public Estudiante(String nombre, int edad, String curso) { // Constructor de estudiante con sus atributos.
            this.nombre = nombre;
            this.edad = edad;
            this.curso = curso;
        }

        // Getter y setter de nombre.
        public String getNombre() { return nombre;}
        public void setNombre(String nombre) { this.nombre = nombre;}

        // Getter y setter de edad.
        public int getEdad() { return edad;}
        public void setEdad(int edad) {this.edad = edad;}

        // Getter y setter de curso.
        public String getCurso() { return curso;}
        public void setCurso(String curso) { this.curso = curso;}
    }

    // Ejercicio 5: Comparación entre JSON y la Serialización en JAVA:

    //// 1) Nosotros hemos estado usando JSON, que es legible, y la serialización se hace con bytes, que no es legible.
    //// Cita: "La serialización de objetos soporta la codificación de objetos y los objetos accesibles desde ellos, en una secuencia de bytes."

    //// 2) JSON no necesita de una interfaz, pero la Serialización si necesita de una interfaz.
    //// Cita: “Only objects that support the java.io.Serializable interface can be written to streams.”
    //// (No es directamente del enlace, he investigado un poco más).

    //// 3) JSON no es solo para JAVA, la serialización sí es solo para JAVA.
    //// Cita1: “permite que sistemas de distintos lenguajes puedan tratar con los datos almacenados”
    //// Cita2: "La serialización se utiliza para una persistencia ligera y para comunicación mediante sockets o Invocación de Métodos Remotas de Java (Java RMI)"
}
