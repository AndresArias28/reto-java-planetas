import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);
    static double[] distancias = { 78.0, 628.0, 1256.0 };

    public static void main(String[] args) throws Exception {
        Menu();
    }

    public static void Menu() {
        int opc;
        do {
            System.out.println("\n---Menú Principal---");
            System.out.println("1. Seleccion planeta de destino");
            System.out.println("2. Seleccionar una nave espacial");
            System.out.println("3. Iniciar la simulación del vuelo");
            System.out.println("4. Exit");
            System.out.println("Por favor, elige una opción: ");
            if (scanner.hasNextInt()) {
                opc = scanner.nextInt();
                switch (opc) {
                    case 1:
                        selectPlanet();
                        break;
                    case 2:
                        selectAirplanet();
                        break;
                    case 4:
                        System.out.println("Has salido del programa");
                        break;
                    default:
                        System.out.println("opción no valida");
                        break;
                }
            } else {
                System.out.println("Por favor, ingresa un número");
                scanner.next();
                opc = 6;
            }

        } while (opc != 4);

    }

    public static void selectPlanet() {
        System.out.println("\n---Seleccionar un planeta de destino---");
        System.out.println("1. Marte");
        System.out.println("2. Júpiter");
        System.out.println("3. Saturno");
        System.out.println("4. exit");
        System.out.println("elige una opción: ");
        var planet = scanner.nextInt();
        switch (planet) {
            case 1:
                double distanciaMarte = 10;
                System.out.println("Has seleccionado Marte");
                System.out.println("La distancia a Marte es: " + distancias[0] + " millones de km");
                System.out.println("La nave espacial seleccionada es: ");
                System.out.println("La nave espacial seleccionada es: ");
                System.out.println("El tiempo de viaje es de: " + distancias[0] + " meses");
                System.out.println("Se necesitan los siguientes recursos: ");
                System.out.println("Oxígeno: " + distancias[0] + " litros");
                System.out.println("Comida: " + distancias[0] + " kg");
                System.out.println("Agua: " + distancias[0] + " litros");
                break;
            case 2:
                System.out.println("Has seleccionado Júpiter");
                break;
            case 3:
                System.out.println("Has seleccionado Saturno");

                break;
            case 4:
                System.out.println("Has salido del programa");
                break;

            default:
                System.out.println("opcion no válida");
                break;
        }
    }

    public static void selectAirplanet() {

    }

    public static void calcularRecursos() {

    }
}
