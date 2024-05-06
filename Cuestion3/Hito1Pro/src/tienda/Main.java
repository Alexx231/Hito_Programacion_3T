package tienda;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class Main {
    private static ProductoDAO productoDAO; // DAO para interactuar con la base de datos de productos

    public static void main(String[] args) {
        try {
            // Inicializa el DAO con la URL de la base de datos, el nombre de usuario y la contraseña
            productoDAO = new ProductoDAO("jdbc:mysql://localhost:3306/productosDB", "root", "");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                // Muestra un menú de opciones
                System.out.println("1. Añadir producto");
                System.out.println("2. Eliminar producto");
                System.out.println("3. Actualizar producto");
                System.out.println("4. Mostrar productos");
                System.out.println("5. Buscar productos");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt(); // Lee la opción del usuario

                switch (opcion) {
                    case 1: // Añadir producto
                        // Solicita al usuario los detalles del producto
                        System.out.println("Introduce el nombre del producto:");
                        String nombre = scanner.next();
                        System.out.println("Introduce la fecha de envasado (yyyy-mm-dd):");
                        String fecha = scanner.next();
                        LocalDate fechaEnvasado = fecha != null && !fecha.isEmpty() ? LocalDate.parse(fecha) : LocalDate.now();
                        System.out.println("Introduce las unidades:");
                        int unidades = scanner.nextInt();
                        System.out.println("Introduce el precio:");
                        double precio = scanner.nextDouble();
                        System.out.println("¿Está disponible? (true/false):");
                        boolean disponible = scanner.nextBoolean();

                        // Crea un nuevo producto con los detalles proporcionados
                        Producto producto = new Producto();
                        producto.setNombre(nombre);
                        producto.setFechaEnvasado(fechaEnvasado);
                        producto.setUnidades(unidades);
                        producto.setPrecio(precio);
                        producto.setDisponible(disponible);

                        // Inserta el producto en la base de datos
                        productoDAO.insertarProducto(producto);
                        break;
                    case 2: // Eliminar producto
                        // Solicita al usuario el ID del producto a eliminar
                        System.out.println("Introduce el ID del producto a eliminar:");
                        int id = scanner.nextInt();

                        // Elimina el producto de la base de datos
                        productoDAO.eliminarProducto(id);
                        break;
                    case 3: // Actualizar producto
                        // Solicita al usuario los nuevos detalles del producto
                        System.out.println("Introduce el ID del producto a actualizar:");
                        int idToUpdate = scanner.nextInt();
                        System.out.println("Introduce el nuevo nombre del producto:");
                        String newNombre = scanner.next();
                        System.out.println("Introduce la nueva fecha de envasado (yyyy-mm-dd):");
                        String newFecha = scanner.next();
                        System.out.println("Introduce las nuevas unidades:");
                        int newUnidades = scanner.nextInt();
                        System.out.println("Introduce el nuevo precio:");
                        double newPrecio = scanner.nextDouble();
                        System.out.println("¿Está disponible? (true/false):");
                        boolean newDisponible = scanner.nextBoolean();

                        // Crea un nuevo producto con los detalles proporcionados
                        Producto newProducto = new Producto();
                        newProducto.setIdProducto(idToUpdate);
                        newProducto.setNombre(newNombre);
                        newProducto.setFechaEnvasado(LocalDate.parse(newFecha));
                        newProducto.setUnidades(newUnidades);
                        newProducto.setPrecio(newPrecio);
                        newProducto.setDisponible(newDisponible);

                        // Actualiza el producto en la base de datos
                        productoDAO.actualizarProducto(newProducto);
                        break;
                    case 4: // Mostrar productos
                        // Obtiene la lista de productos de la base de datos
                        List<Producto> listaProductos = productoDAO.listarProductos();

                        // Imprime los detalles de cada producto
                        for (Producto p : listaProductos) {
                            System.out.println("Producto: ");
                            System.out.println("ID: " + p.getIdProducto());
                            System.out.println("Nombre: " + p.getNombre());
                            System.out.println("Fecha de Envasado: " + p.getFechaEnvasado());
                            System.out.println("Unidades: " + p.getUnidades());
                            System.out.println("Precio: " + p.getPrecio());
                            System.out.println("Disponible: " + (p.getDisponible() ? "Sí" : "No"));
                            System.out.println("------------------------");
                        }
                        break;
                    case 5: // Buscar productos
                        // Solicita al usuario el ID del producto a buscar
                        System.out.println("Introduce el ID del producto a buscar:");
                        int idToSearch = scanner.nextInt();

                        // Busca el producto en la base de datos
                        Producto productoBuscado = productoDAO.buscarProducto(idToSearch);

                        // Imprime los detalles del producto o un mensaje de error si no se encontró el producto
                        if (productoBuscado != null) {
                            System.out.println("Producto: ");
                            System.out.println("ID: " + productoBuscado.getIdProducto());
                            System.out.println("Nombre: " + productoBuscado.getNombre());
                            System.out.println("Fecha de Envasado: " + productoBuscado.getFechaEnvasado());
                            System.out.println("Unidades: " + productoBuscado.getUnidades());
                            System.out.println("Precio: " + productoBuscado.getPrecio());
                            System.out.println("Disponible: " + (productoBuscado.getDisponible() ? "Sí" : "No"));
                        } else {
                            System.out.println("No se encontró ningún producto con el ID " + idToSearch);
                        }
                        break;
                    case 6: // Salir
                        // Termina el programa
                        System.exit(0);
                }
            }
        } catch (SQLException ex) {
            // Imprime los detalles de cualquier error de SQL que ocurra
            ex.printStackTrace();
        }
    }
}