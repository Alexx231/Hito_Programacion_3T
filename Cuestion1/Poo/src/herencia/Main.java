package herencia;

public class Main {
    public static void main(String[] args) {
        // Crear un objeto de la clase Coche
        Coche miCoche = new Coche("Toyota");

        // Llamar a los métodos del objeto miCoche
        miCoche.conducir();
        miCoche.tocarBocina();

        // Imprimir la marca del coche
        System.out.println("La marca del coche es: " + miCoche.getMarca());
        
        System.out.println("---------------------");

        // Crear un objeto de la clase Sobreescritura
        Sobreescritura miVehiculo = new Sobreescritura("Ford");

        // Llamar al método conducir() del objeto miVehiculo
        miVehiculo.conducir();

        // Imprimir la marca del vehículo
        System.out.println("La marca del vehículo es: " + miVehiculo.getMarca());
    }
}