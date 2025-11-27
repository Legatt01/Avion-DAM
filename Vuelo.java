public class Vuelo {
    private String numeroVuelo;
    private String origen;
    private String destino;
    private int asientosDisponibles;

    public Vuelo(String numeroVuelo, String origen, String destino, int asientosDisponibles) {
        this.numeroVuelo = numeroVuelo;
        this.origen = origen;
        this.destino = destino;
        this.asientosDisponibles = asientosDisponibles;
    }
    public Vuelo(){
        this.numeroVuelo = "";
        this.origen = "";
        this.destino = "";
        this.asientosDisponibles = 0;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }


    public String reservarAsiento(){
        if (asientosDisponibles > 0) {
            this.asientosDisponibles -=1;
            return "Reserva de asiento exitose. Quedan " + this.asientosDisponibles + " asientos disponibles.";
        }
        else{
            return "No quedan asientos disponibles para reservar.";
        }
    }
    public void informacionVuelo(){
        System.out.println("---------------------------------------------");
        System.out.println("Numero de vuelo: " + numeroVuelo);
        System.out.println("---------------------------------------------");
        System.out.println("Origen; " + origen);
        System.out.println("---------------------------------------------");
        System.out.println("Destino: " + destino);
        System.out.println("---------------------------------------------");
        System.out.println("Asientos disponibles" + asientosDisponibles);
        System.out.println("---------------------------------------------");
    }




    


}
