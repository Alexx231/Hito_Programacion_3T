package herencia;

//Clase derivada de Vehiculo que sobrescribe el método conducir()
public class Sobreescritura extends Vehiculo {
 // Constructor que inicializa la marca del vehículo
 public Sobreescritura(String marca) {
     super(marca); // Llama al constructor de la superclase Vehiculo
 }

 // Sobrescribe el método conducir() de la clase Vehiculo
 public void conducir() {
     System.out.println(getMarca() + " casi se estrella");
 }
}