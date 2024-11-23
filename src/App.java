import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static double[] distances = { 54_600_000, 590_000_000, 1_200_000_000 }; // km
    // planets description
    static String[] descriptionPlanets = { 
        "Marte es el llamado planeta rojo en la mitología romana, seleccionado por su color rojizo, este planeta es el cuarto en el sistema solar y el segundo más pequeño después de Mercurio",
        " Júpiter es el planeta mas grande del sistema solar y el segundo mas grande despues de Marte",
        "Saturno es el planeta mas grande del sistema solar y el tercer mas grande despues de Júpiter"
     };
    // Datos de nave
    static String[] ships = { "Falcon 9", "Starship", "SLS" };
    static double[] velocitysShip = { 27_000, 40_000, 29_000 }; // en km/h
    static int[] capacidadPasajeros= { 2, 4, 3};
    // Datos de planetas
    static String[]   planets= { "Marte", "Jupiter", "Saturno"};
    static double velocity = 100_000; // km/h
    static double[] averages ={550, 1.7, 2.5, 350 };//{litros/dia, kg/dia , litros/dia,  Ton/dia}
    //ajustar recursos
    static double litrosOxigeno = 0;
    static double toneladasCombustible = 0;
    static boolean makeAdjust = false;
    //ajustes seleccionddaos
    static int shipSelected = 0;
    static int planetSelected = 0;

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
                System.out.println("estas seguro de selecionar " + planets[planet-1] + " (si/no)");
                confirm = scanner.next();

                if (confirm.equals("si")) {
                    showDataPlanets(planet);

                } else {
                    System.out.println("ingresaste mal la opción o excogiste NO");
                }
                break;

            case 2:
                System.out.println("estas seguro de selecionar Jupiter? (si/no)");
                confirm = scanner.next();
                if (confirm.equals("si")) {
                    showDataPlanets(planet);
                } else {
                    System.out.println("ingresaste mal la opción o excogiste NO");
                }
                break;

            case 3:
                System.out.println("estas seguro de selecionar Saturno? (si/no)");
                confirm = scanner.next();

                if (confirm.equals("si")) {
                    showDataPlanets(planet);
                } else {
                    System.out.println("ingresaste mal la opción o excogiste NO");
                }
                break;

            case 4:
                adjustResource();
                break;
                
            case 5:
                System.out.println("Has salido del programa");
                break;

            default:
                System.out.println("opcion no válida");
                break;
        }
    }

    private static void adjustResource() {
        System.out.println("revisar y ajustar recursos");
        System.out.println("Cuantos litros de oxigeno desea agregar: ");
        litrosOxigeno = scanner.nextDouble();
        System.out.println("Cuantas toneladas de combustible desea agregar: ");
        toneladasCombustible = scanner.nextDouble();
        System.out.println("Ajuste exitoso");
        makeAdjust = true;
    }

    private static void showDataPlanets(int planet) {
        double estimateTime = calculateTime(distances[planet-1]);
        System.out.println("Has seleccionado planeta " + planets[planet-1]);
        System.out.println( descriptionPlanets[planet-1] );
        System.out.println("La distancia a "+planets[planet-1]+" es: " + distances[planet-1] + " km");
       // System.out.printf("El tiempo de viaje a una velocidad de %.0f km/h tarda %.2f días%n", velocity, estimateTime);
        System.out.println("Se necesitan los siguientes recursos por persona para el viaje: ");
        System.out.printf("Oxígeno: %.2f litros%n", calculateResources(estimateTime, averages[0] ));
        System.out.printf("Comida: %.2f kg%n", calculateResources(estimateTime,  averages[1]));
        System.out.printf("Agua: %.2f litros%n", calculateResources(estimateTime,  averages[2]));
        System.out.printf("combustible: %.2f Ton%n", calculateResources(estimateTime,  averages[3]));
        planetSelected = planet;

    }

    private static double calculateResources(double dias, double estimateAverage ){
        return dias * estimateAverage;
    }

    private static double calculateTime(double distance) {
        double timeInHours = distance / velocity;
        double timeInDays = timeInHours / 24;
        return timeInDays;

    }

    public static void selectAirplanet() {
        System.out.println("\n--- ships Disponibles ---");
        for (int i = 0; i < ships.length; i++) {
            System.out.printf("%d. %s (%.0f km/h)\n", i + 1, ships[i], velocitysShip[i]);
        }
        System.out.print("Selecciona una nave (1-3): ");
        int naveIndex = scanner.nextInt() - 1;

    //     if (naveIndex >= 0 && naveIndex < ships.length) {
    //         shipseleccionada = ships[naveIndex];
    //         velocidadNave = velocitysShip[naveIndex];
    //         System.out.printf("Has seleccionado: %s (%.0f km/h)\n", shipseleccionada, velocidadNave);
    //     } else {
    //         System.out.println("Selección inválida.");
        

     }

    public static void calcularRecursos() {

    }
}
