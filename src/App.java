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
            System.out.println("4. exit");
            System.out.println("Por favor, elige una opción: ");
            opc = scanner.nextInt();
            switch (opc) {
                case 1:
                    selectPlanet();
                    break;
                case 2:
                    chooseAirplanet();
                    break;
                case 4:
                    System.out.println("Has salido del programa");
                    break;
                default:
                    System.out.println("opcion no válida");
                    break;
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
                System.out.println("Has seleccionado Marte");
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

    public static void chooseAirplanet() {

    }

    public static void calcularRecursos() {

    }
}
