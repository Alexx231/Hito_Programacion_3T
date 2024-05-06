package herencia;

//Clase base o superclase
public class Vehiculo {
private String marca; // Marca del vehículo

// Constructor que inicializa la marca del vehículo
public Vehiculo(String marca) {
   this.marca = marca;
}

// Método para obtener la marca del vehículo
public String getMarca() {
   return marca;
}

// Método que simula la acción de conducir el vehículo
public void conducir() {
   System.out.println(marca + " se esta conduciendo");
}
}