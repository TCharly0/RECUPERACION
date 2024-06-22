import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estudiante {
    private String nombre;
    private String calificacion;

    public Estudiante(String nombre, int calificacion) {
        this.nombre = nombre;
        this.calificacion = calificacion + "";
    }

    public Estudiante() {

    }

    public static double calcualrPromedio(ArrayList<Estudiante> listaEstudiantes) {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificado) {
        this.calificacion = calificacion;
    }

    public static void main(String[] args) {
        List<Estudiante> listaEstudiantes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== Menú ===");
            System.out.println("1. Agregar Estudiante");
            System.out.println("2. Modificar calificacion ");
            System.out.println("3. Calcular el promedio de calificacion");
            System.out.println("4. Eliminar un estudiante de la lista ");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre de el estudiante ");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el calificacion de el estudiante ");
                    int calificacion = scanner.nextInt();
                    Estudiante nuevoEstudiante = new Estudiante(nombre, calificacion);
                    listaEstudiantes.add(nuevoEstudiante);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del estudiante cuya nota desea modificar: ");
                    String nombreEstudianteN = scanner.nextLine();
                    for (Estudiante estudiante : listaEstudiantes) {
                        if (estudiante.getNombre().equalsIgnoreCase(nombreEstudianteN)) {
                            System.out.print("Ingrese la nueva nota para el estudiante: ");
                            int nuevaNota = (int) Double.parseDouble(scanner.nextLine());
                            System.out.println("Nota modificada exitosamente.");
                            Opciones.pausa();
                            break;
                        }
                    }
                case 3:
                    double promedio = calcularPromedio(listaEstudiantes);
                    System.out.println("El promedio de calificaciones es de " + promedio);
                    Opciones.pausa();
                    break;
                case 4:
                    eliminarEstudiante(listaEstudiantes, scanner);
                    Opciones.pausa();
                    break;

                case 0:
                    System.out.println("Se ha finalizado el programa");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcion != 0);
        scanner.close();
    }


    public static double calcularPromedio(List<Estudiante> estudiantes) {
        if (estudiantes.isEmpty()) {
            return 0;
        }

        String sumaCalificaciones = String.valueOf(0);
        for (Estudiante estudiante : estudiantes) {
            sumaCalificaciones += estudiante.calificacion;
        }

    }
    public static void eliminarEstudiante(List<Estudiante> estudiantes, Scanner scanner) {
        System.out.print("Ingrese el nombre del estudiante a eliminar: ");
        String nombreEliminar = scanner.nextLine();
        boolean eliminado = false;

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNombre().equalsIgnoreCase(nombreEliminar)) {
                estudiantes.remove(estudiante);
                eliminado = true;
                System.out.println("Estudiante eliminado con éxito.");
                break;
            }
        }

        if (!eliminado) {
            System.out.println("No se encontró ningún estudiante con ese nombre en la lista.");
        }
    }

}


