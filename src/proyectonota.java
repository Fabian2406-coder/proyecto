import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Estudiante {
    private int id;
    private String nombre;
    private List<Integer> listaCalificaciones;

    public Estudiante(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.listaCalificaciones = new ArrayList<>();
    }

    public void agregarCalificacion(int calificacion) {
        if (calificacion >= 0 && calificacion <= 100) {
            listaCalificaciones.add(calificacion);
        } else {
            System.out.println("Calificación no válida. Debe estar entre 0 y 100.");
        }
    }

    public double calcularPromedio() {
        if (listaCalificaciones.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (int calificacion : listaCalificaciones) {
            sum += calificacion;
        }
        return (double) sum / listaCalificaciones.size();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Integer> getListaCalificaciones() {
        return listaCalificaciones;
    }
}

class GestorEstudiantes {
    private List<Estudiante> estudiantes;

    public GestorEstudiantes() {
        estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void ingresarCalificaciones(int id, int calificacion) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == id) {
                estudiante.agregarCalificacion(calificacion);
                break;
            }
        }
    }

    public void consultarEstudiantes() {
        for (Estudiante estudiante : estudiantes) {
            double promedio = estudiante.calcularPromedio();
            System.out.println("ID: " + estudiante.getId() + ", Nombre: " + estudiante.getNombre() + ", Promedio: " + promedio);
        }
    }

    public void eliminarEstudiante(int id) {
        estudiantes.removeIf(estudiante -> estudiante.getId() == id);
    }

    public void mostrarFichaTecnica() {
        System.out.println("\nEquipo: \nIntegrante 1:\nNombre: Diego Nicolás Torres Vega. Rol: Development team \nIntegrante 2: Nombre:jose omar leal miranda, Rol:Development\nEslogan: Nuestro eslogan.");
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Ingresar calificaciones");
            System.out.println("3. Consultar estudiantes y promedios");
            System.out.println("4. Eliminar estudiante");
            System.out.println("5. Acerca de");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID del estudiante: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
                    System.out.print("Ingrese nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    agregarEstudiante(new Estudiante(id, nombre));
                    break;
                case 2:
                    System.out.print("Ingrese ID del estudiante: ");
                    int idCal = scanner.nextInt();
                    System.out.print("Ingrese calificación: ");
                    int calificacion = scanner.nextInt();
                    ingresarCalificaciones(idCal, calificacion);
                    break;
                case 3:
                    consultarEstudiantes();
                    break;
                case 4:
                    System.out.print("Ingrese ID del estudiante a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    eliminarEstudiante(idEliminar);
                    break;
                case 5:
                    mostrarFichaTecnica();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    public static void main(String[] args) {
        GestorEstudiantes gestor = new GestorEstudiantes();
        gestor.mostrarMenu();
    }
}

