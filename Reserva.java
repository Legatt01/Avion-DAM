public class Reserva {
    private String nombrePasajero;
    private String numeroPasaporte;
    private Vuelo vuelo;

    public Reserva(String nombrePasajero, String numeroPasaporte, Vuelo vuelo){
        this.nombrePasajero = nombrePasajero;
        this.numeroPasaporte = numeroPasaporte;
        this.vuelo = vuelo;
    }

    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public String getNumeroPasaporte() {
        return numeroPasaporte;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void mostrarInformacion(){
        System.out.println("-----------INFORMACION DE PASAJERO-----------");
        System.out.println("Nombre Pasajero: " + nombrePasajero);
        System.out.println("---------------------------------------------");
        System.out.println("Numero de pasaport: " + numeroPasaporte);
        System.out.println("---------------------------------------------");
        System.out.println("Datos del vuelo: \n\n");
        System.out.println("---------------------------------------------");
        System.out.println("Numero de vuelo: " + getVuelo().getNumeroVuelo());
        System.out.println("---------------------------------------------");
        System.out.println("Origen; " + getVuelo().getOrigen());
        System.out.println("---------------------------------------------");
        System.out.println("Destino: " + getVuelo().getDestino());
        System.out.println("---------------------------------------------");
        System.out.println("Asientos disponibles" + getVuelo().getAsientosDisponibles());
        System.out.println("---------------------------------------------");
    }
}
