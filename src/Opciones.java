import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Opciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

        int opcion;

        do {
            System.out.println("Menu");
            System.out.println("1. Agregar Estudiante");
            System.out.println("2. Modificar calificacion");
            System.out.println("3. Calcular el promedio de la calificacion");
            System.out.println("4. Eliminar estudiante");
            System.out.println("0. salir");
            System.out.print("Elije una opcion:");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del estudiante");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la calificacion del estudiante: ");
                    int calificacion = scanner.nextInt();
                    Estudiante nuevoEstudiante = new Estudiante(nombre, calificacion);
                    listaEstudiantes.add(nuevoEstudiante);
                    pausa();
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
                    double promedio = Estudiante.calcualrPromedio(listaEstudiantes);
                    System.out.println("El promedio es: " + promedio);
                    pausa();
                    break;
                case 4:
                    Estudiante.eliminarEstudiante(listaEstudiantes, scanner);
                    Opciones.pausa();
                    break;

            }


        }while(opcion != 0);
        scanner.close();
    }
    public static void pausa() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }


}
