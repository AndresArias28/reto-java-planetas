import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);
    static double[] distancias = { 54_600_000, 590_000_000, 1_200_000_000 }; // km
    // static double[] oxygenResources = {12.7 ,54.0 , 78.3};
    // static double[] foodResources = { 10.0, 20.0, 30.0 };
    // static double[] waterResources = { 10.0, 20.0, 30.0 };
    static double velocity = 100_000; // km/h
    static double averageOxygen = 550; // litros/dia
    static double averageFood = 1.7; // kg/dia
    static double averageWater = 2.5; // litros/dia
    static double averageGas = 350; // Ton/dia
    static double litrosOxigeno = 0;
    static double toneladasCombustible = 0;

    static boolean makeAdjust = false;

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
                    case 3:
                        calcularRecursos();
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
        System.out.println("4. Revisar  y ajustar recursos");
        System.out.println("5. exit");
        System.out.println("elige una opción: ");
        var planet = scanner.nextInt();
        String confirm;
        switch (planet) {
            case 1:
                System.out.println("estas seguro de selecionar Marte? (si/no)");
                confirm = scanner.next();

                if (confirm.equals("si")) {
                    showDataMars();

                } else {
                    System.out.println("ingresaste mal la opción o excogiste NO");
                }
                break;
            case 2:
                System.out.println("estas seguro de selecionar Jupiter? (si/no)");
                confirm = scanner.next();
                if (confirm.equals("si")) {
                    showDataJupiter();
                } else {
                    System.out.println("ingresaste mal la opción o excogiste NO");
                }

                break;
            case 3:
                System.out.println("estas seguro de selecionar Saturno? (si/no)");
                confirm = scanner.next();

                if (confirm.equals("si")) {
                    showDataSaturn();
                } else {
                    System.out.println("ingresaste mal la opción o excogiste NO");
                }
                break;

            case 4:
                System.out.println("revisar y ajustar recursos");
                System.out.println("Cuantos litros de oxigeno desea agregar: ");
                 litrosOxigeno = scanner.nextDouble();
                System.out.println("Cuantas toneladas de combustible desea agregar: ");
                 toneladasCombustible = scanner.nextDouble();
                System.out.println("Ajuste exitoso");
                makeAdjust = true;
                break;
            case 5:
                System.out.println("Has salido del programa");
                break;

            default:
                System.out.println("opcion no válida");
                break;
        }
    }

    private static void showDataMars() {
        double estimateTime = calculateTime(distancias[0]);
        System.out.println("Has seleccionado Marte");
        System.out.println(  "Marte es el llamado plante rojo en la mitología romana, seleccionado por su color rojizo, este planeta es el cuarto en el sistema solar y el segundo más pequeño después de Mercurio");
        System.out.println("La distancia a Marte es: " + distancias[0] + " km");
        System.out.printf( "El tiempo de viaje a una velocidad de %.0f km/h tarda %.2f días%n", velocity, estimateTime);
        System.out.println("Se necesitan los siguientes recursos para eñ viaje: ");
        System.out.printf("Oxígeno: %.2f litros%n", calculateOxygen(estimateTime));
        System.out.printf("Comida: %.2f kg%n", calculateFood(estimateTime));
        System.out.printf("Agua: %.2f litros%n", calculateWater(estimateTime));
        System.out.printf("combustible: %.2f Ton%n", calculateGas(estimateTime));
    }

    private static void showDataJupiter() {
        double estimateTime = calculateTime(distancias[1]);
        System.out.println("Has seleccionado Júpiter");
        System.out.println("Júpiter es el planeta mas grande del sistema solar y el segundo mas grande despues de Marte");
        System.out.println("La distancia a Júpiter es: " + distancias[1] + " km");
        System.out.printf( "El tiempo de viaje a una velocidad de %.0f km/h tarda %.2f días%n", velocity, estimateTime);
        System.out.println("Se necesitan los siguientes recursos para eñ viaje: ");
        System.out.printf("Oxígeno: %.2f litros%n", calculateOxygen(estimateTime));
        System.out.printf("Comida: %.2f kg%n", calculateFood(estimateTime));
        System.out.printf("Agua: %.2f litros%n", calculateWater(estimateTime));
    }

    private static void showDataSaturn() {
        double estimateTime = calculateTime(distancias[2]);
        System.out.println("Has seleccionado Saturno");
        System.out.println( "Saturno es el planeta mas grande del sistema solar y el tercer mas grande despues de Júpiter");
        System.out.println("La distancia a Saturno es: " + distancias[2] + " km");
        System.out.printf( "El tiempo de viaje a una velocidad de %.0f km/h tarda %.2f días%n", velocity, estimateTime);
        System.out.println("Se necesitan los siguientes recursos para eñ viaje: ");
        System.out.printf("Oxígeno: %.2f litros%n", calculateOxygen(estimateTime));
        System.out.printf("Comida: %.2f kg%n", calculateFood(estimateTime));
        System.out.printf("Agua: %.2f litros%n", calculateWater(estimateTime));

    }

    private static double calculateOxygen(double dias) {
        return dias * averageOxygen;
    }

    private static double calculateFood(double dias) {
        return dias * averageFood;
    }

    private static double calculateWater(double dias) {
        return dias * averageWater;
    }

    private static double calculateGas(double dias) {
        return dias * averageGas;
    }

    private static double calculateTime(double distance) {
        double timeInHours = distance / velocity;
        double timeInDays = timeInHours / 24;
        // double timeInMonths = timeInHours / 24 / 30;
        // double timeInYears = timeInMonths / 12;
        return timeInDays;

    }

    public static void selectAirplanet() {

    }

    public static void calcularRecursos() {

    }
}
