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
                    break;
                case 3:
                    detallesReserva(sc);
                    break;
                case 4:
                    cancelarReserva(sc);
                    break;
                case 0:
                    Salir();
                    break;
                default:
                    System.out.println("Opción no valida. Intente de nuevo.");
                    break;

            }
        } while (opc != 0);
        System.out.println("\nPrograma finalizado correctamente");
        sc.close();
    }
    public static void Salir(){
        System.out.println("¡Muchas gracias por elegirnos, que tenga un buen viaje!");
    }

    public static void cancelarReserva(Scanner sc) {
        System.out.println("\n--- CANCELAR RESERVA ---");
        System.out.println("Escriba el código se su reserva");
        String codigoBuscado = sc.nextLine().toUpperCase();
        Reserva reservaEncontrada = null;
        String mensajeIncremento = "";

        if (reserva1 != null && reserva1.getCodigoReserva() != null
                && reserva1.getCodigoReserva().equals(codigoBuscado)) {
            reservaEncontrada = reserva1;

            Vuelo vueloCancelado = reservaEncontrada.getVuelo();
            vueloCancelado.incrementarAsientos();
            mensajeIncremento = "Asientos disponibles ahora: " + vueloCancelado.getAsientosDisponibles();

            reserva1 = null;
            System.out.println("\n Su reserva a sido cancelada exitosamente");
            System.out.println(mensajeIncremento);

        } else if (reserva2 != null && reserva2.getCodigoReserva() != null
                && reserva2.getCodigoReserva().equals(codigoBuscado)) {
            reservaEncontrada = reserva2;

            Vuelo vueloCancelado = reservaEncontrada.getVuelo();
            vueloCancelado.incrementarAsientos();
            mensajeIncremento = "Asientos disponibles ahora: " + vueloCancelado.getAsientosDisponibles();

            reserva2 = null;
            System.out.println("\n Su reserva a sido cancelada exitosamente");
            System.out.println(mensajeIncremento);

        }else{
            System.out.println("No se encuentra una reserva con ese código.");
        }
    }

    public static void detallesReserva(Scanner sc) {
        System.out.println("\n--- VER DETALLES DE RESERVA ---");
        System.out.println("Escriba el cdigo se su reserva para ver los detalles");
        String codigoBuscado = sc.nextLine().toUpperCase();

        Reserva reservaEncontrada = null;

        if (reserva1 != null && reserva1.getCodigoReserva() != null
                && reserva1.getCodigoReserva().equals(codigoBuscado)) {
            reservaEncontrada = reserva1;
        } else if (reserva2 != null && reserva2.getCodigoReserva() != null
                && reserva2.getCodigoReserva().equals(codigoBuscado)) {
            reservaEncontrada = reserva2;
        }

        if (reservaEncontrada != null) {
            System.out.println("\n Reserva encontrada. Detalles: ");
            System.out.println("Código de reserva: ");
            System.out.println("Código de reserva: " + reservaEncontrada.getCodigoReserva());
            reservaEncontrada.mostrarInformacion();
        } else {
            System.out.println("No se encontro ninguna reserva con ese código");
        }

    }

    public static void reservaVuelo(Scanner sc, Vuelo vuelo1, Vuelo vuelo2) {

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

            } else if (reserva2 == null) {
                reserva2 = nuevaReserva;
            }

            System.out.println("\n--- CONFIRMACIÓN ---");
            System.out.println("Tu reserva ha sido confirmada");
            System.out.println("Tu codigo de reserva: " + codigoReserva);

            nuevaReserva.mostrarInformacion();
            System.out.println("\nEstado del asiento: " + resultadoAsiento);
        } else {
            System.out.println("Lo sentimos no hay asientos disponibles");
        }

    }

    public static void mostrarVuelos(Vuelo vuelo1, Vuelo vuelo2) {
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
        System.out.print("Selección: ");
    }
}
