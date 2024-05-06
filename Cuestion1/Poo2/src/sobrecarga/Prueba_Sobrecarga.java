package sobrecarga;

public class Prueba_Sobrecarga {
    public int sumar(int a, int b) {
        return a + b;
    }
    public double sumar(double a, double b) {
        return a + b;
    }
    public int sumar(int a, int b, int c) {
        return a + b + c;
    }
}
