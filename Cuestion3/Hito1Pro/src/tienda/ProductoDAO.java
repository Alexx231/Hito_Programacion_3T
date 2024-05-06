package tienda;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class ProductoDAO {
    private Connection conn; // Conexión a la base de datos

    // Constructor que establece la conexión a la base de datos
    public ProductoDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        this.conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // Método para insertar un producto en la base de datos
    public void insertarProducto(Producto producto) throws SQLException {
        String sql = "INSERT INTO productos (nombre, fechaEnvasado, unidades, precio, disponible) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, producto.getNombre());
        statement.setDate(2, java.sql.Date.valueOf(producto.getFechaEnvasado()));
        statement.setInt(3, producto.getUnidades());
        statement.setDouble(4, producto.getPrecio());
        statement.setBoolean(5, producto.getDisponible());
        statement.executeUpdate();
    }

    // Método para eliminar un producto de la base de datos por su ID
    public boolean eliminarProducto(int idProducto) throws SQLException {
        String sql = "DELETE FROM productos where idProducto = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, idProducto);

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        return rowDeleted;
    }

    // Método para actualizar los detalles de un producto en la base de datos
    public boolean actualizarProducto(Producto producto) throws SQLException {
        String sql = "UPDATE productos SET nombre = ?, fechaEnvasado = ?, unidades = ?, precio = ?, disponible = ? WHERE idProducto = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, producto.getNombre());
        statement.setDate(2, java.sql.Date.valueOf(producto.getFechaEnvasado()));
        statement.setInt(3, producto.getUnidades());
        statement.setDouble(4, producto.getPrecio());
        statement.setBoolean(5, producto.getDisponible());
        statement.setInt(6, producto.getIdProducto());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        return rowUpdated;
    }

    // Método para buscar un producto en la base de datos por su ID
    public Producto buscarProducto(int idProducto) throws SQLException {
        Producto producto = null;
        String sql = "SELECT * FROM productos WHERE idProducto = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, idProducto);
        ResultSet result = statement.executeQuery();

        if (result.next()) {
            producto = new Producto();
            producto.setIdProducto(result.getInt("idProducto"));
            producto.setNombre(result.getString("nombre"));
            producto.setFechaEnvasado(result.getDate("fechaEnvasado").toLocalDate());
            producto.setUnidades(result.getInt("unidades"));
            producto.setPrecio(result.getDouble("precio"));
            producto.setDisponible(result.getBoolean("disponible"));
        }

        return producto;
    }

    // Método para obtener una lista de todos los productos en la base de datos
    public List<Producto> listarProductos() throws SQLException {
        List<Producto> listaProductos = new ArrayList<>();

        String sql = "SELECT * FROM productos";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            int id = result.getInt("idProducto");
            String nombre = result.getString("nombre");
            LocalDate fecha = result.getDate("fechaEnvasado").toLocalDate();
            int unidades = result.getInt("unidades");
            double precio = result.getDouble("precio");
            boolean disponible = result.getBoolean("disponible");

            Producto producto = new Producto();
            producto.setIdProducto(id);
            producto.setNombre(nombre);
            producto.setFechaEnvasado(fecha);
            producto.setUnidades(unidades);
            producto.setPrecio(precio);
            producto.setDisponible(disponible);

            listaProductos.add(producto);
        }

        return listaProductos;
    }
}