package tienda;

import java.time.LocalDate;

public class Producto {
    // Atributos de la clase Producto
    private int idProducto; // Identificador único del producto
    private String nombre; // Nombre del producto
    private LocalDate fechaEnvasado; // Fecha en que el producto fue envasado
    private int unidades; // Número de unidades disponibles del producto
    private double precio; // Precio del producto
    private boolean disponible; // Indica si el producto está disponible o no

    // Métodos getter y setter para cada atributo

    public int getIdProducto() {
        return idProducto; // Devuelve el ID del producto
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto; // Establece el ID del producto
    }

    public String getNombre() {
        return nombre; // Devuelve el nombre del producto
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; // Establece el nombre del producto
    }

    public LocalDate getFechaEnvasado() {
        return fechaEnvasado; // Devuelve la fecha de envasado del producto
    }

    public void setFechaEnvasado(LocalDate fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado; // Establece la fecha de envasado del producto
    }

    public int getUnidades() {
        return unidades; // Devuelve el número de unidades del producto
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades; // Establece el número de unidades del producto
    }

    public double getPrecio() {
        return precio; // Devuelve el precio del producto
    }

    public void setPrecio(double precio) {
        this.precio = precio; // Establece el precio del producto
    }

    public boolean getDisponible() {
        return disponible; // Devuelve si el producto está disponible o no
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible; // Establece si el producto está disponible o no
    }
}