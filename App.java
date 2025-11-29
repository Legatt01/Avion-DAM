import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc;
        Vuelo vuelo1 = new Vuelo("AA123", "Madrid", "Nueva York", 150);
        Vuelo vuelo2 = new Vuelo("IB456", "Barcelona", "Londres", 100);


        
        do {
            menu();
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    mostrarVuelos(vuelo1, vuelo2);
                    break;
                case 2:
                    mostrarVuelos(vuelo1, vuelo2);
                default:
                    break;
            }
        } while (opc !=0);
        System.out.println("\nPrograma finalizado correctamente");
        sc.close();
    }
    public static void datosUsuario(Scanner sc, Vuelo vuelo1, Vuelo vuelo2){
        Reserva r = new Reserva(null, null, vuelo2);
        mostrarVuelos(vuelo1, vuelo2);
        System.out.println("\n---REALIZAR RESERVA---");
        System.out.print("Que vuelo desea reservar (ingrese 1 o 2: ");
        String numVUelo = sc.nextLine();
        System.out.println("Ha elegido el vuelo: " + numVUelo);
        System.out.println("Por favor, ahora es escriba el nombre del pasajero");
        String Nombre = sc.nextLine();
        r.nombrePasajero(Nombre);

    }

    public static void mostrarVuelos(Vuelo vuelo1, Vuelo vuelo2){
        System.out.println("\n--- LISTA DE VUELOS DISPONIBLES ---");
        System.out.println("---------- Vuelo 1 -----------");
        vuelo1.informacionVuelo();
        System.out.println("---------- Vuelo 2 -----------");
        vuelo2.informacionVuelo();
        System.out.println("---------------------------------");

    }

    public static void menu() {
        System.out.println("=== SISTEMA DE GESTIÓN DE VUELOS ===\n" + //
                "1. Ver vuelos disponibles\n" + //
                "2. Realizar reserva\n" + //
                "3. Ver detalles de una reserva\n" + //
                "4. Cancelar reserva\n" + //
                "0. Salir");
    }
}
