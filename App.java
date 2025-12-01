import java.util.Scanner;

public class App {

    public static int contadorReservas = 0;

    private static Reserva reserva1 = null;
    private static Reserva reserva2 = null;

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
                    reservaVuelo(sc, vuelo1, vuelo2);
                default:
                    break;
                case 3:

            }
        } while (opc !=0);
        System.out.println("\nPrograma finalizado correctamente");
        sc.close();
    }

    public static void detallesReserva(){
        System.out.println("Escriba el cdigo se su reserva para ver los detalles");

    }
    public static void reservaVuelo(Scanner sc, Vuelo vuelo1, Vuelo vuelo2){

        mostrarVuelos(vuelo1, vuelo2);
        System.out.println("\n---REALIZAR RESERVA---");
        System.out.print("Que vuelo desea reservar (ingrese 1 o 2): ");
        String numVUelo = sc.nextLine();
        Vuelo vueloSelecionado = null;
        if (numVUelo.equals("1")) {
            vueloSelecionado = vuelo1;
            System.out.println("Ha elegido el vuelo: " + numVUelo);
        } else if (numVUelo.equals("2")) {
            vueloSelecionado = vuelo2;
            System.out.println("Ha elegido el vuelo: " + numVUelo);
        }

        if (vueloSelecionado.getAsientosDisponibles() > 0) {
            System.out.println("Por favor, ahora es escriba el nombre del pasajero");
            String Nombre = sc.nextLine();
            System.out.println("Ingrese su número de pasaporte: ");
            String numPasaporte = sc.nextLine();
            String resultadoAsiento = vueloSelecionado.reservarAsiento();

            contadorReservas++;
            String codigoReserva = "R" + String.format("%03d", contadorReservas);

            Reserva nuevaReserva = new Reserva(Nombre, numPasaporte, vueloSelecionado);
            nuevaReserva.setCodigoReserva(codigoReserva);
            if (reserva1 == null) {
                reserva1 = nuevaReserva;
                
            }else if (reserva2 == null) {
                reserva2 = nuevaReserva;
            }

            System.out.println("\n--- CONFIRMACIÓN ---");
            System.out.println("Tu reserva ha sido confirmada");
            System.out.println("Tu codigo de reserva: " + codigoReserva);

            nuevaReserva.mostrarInformacion();
            System.out.println("\nEstado del asiento: " + resultadoAsiento);
        }else{
            System.out.println("Lo sentimos no hay asientos disponibles");
        }


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
