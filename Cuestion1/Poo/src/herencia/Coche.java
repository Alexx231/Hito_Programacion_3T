package herencia;

//Clase derivada o subclase
public class Coche extends Vehiculo {
// Constructor que inicializa la marca del coche
public Coche(String marca) {
   super(marca); // Llama al constructor de la superclase Vehiculo
}

// Método que simula la acción de un coche tocando la bocina
public void tocarBocina() {
   System.out.println(getMarca() + " está tocando la bocina");
}
}