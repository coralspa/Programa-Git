package dao;

import config.Conexion;
import model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    // CREATE - Registrar cliente
    public boolean insertar(Cliente cliente) {

        String sql = "INSERT INTO cliente "
                + "(id_usuario, id_pais, nombre, apellido, telefono, direccion, fecha_nacimiento) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, cliente.getIdUsuario());
            sentencia.setInt(2, cliente.getIdPais());
            sentencia.setString(3, cliente.getNombre());
            sentencia.setString(4, cliente.getApellido());
            sentencia.setString(5, cliente.getTelefono());
            sentencia.setString(6, cliente.getDireccion());

            if (cliente.getFechaNacimiento() != null) {
                sentencia.setDate(7,
                        java.sql.Date.valueOf(cliente.getFechaNacimiento()));
            } else {
                sentencia.setNull(7, java.sql.Types.DATE);
            }

            int filas = sentencia.executeUpdate();

            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar cliente: " + e.getMessage());
            return false;
        }
    }

    // READ - Consultar todos los clientes
    public List<Cliente> listar() {

        List<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT id_cliente, id_usuario, id_pais, nombre, "
                + "apellido, telefono, direccion, fecha_nacimiento "
                + "FROM cliente";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {

                Cliente cliente = new Cliente();

                cliente.setIdCliente(resultado.getInt("id_cliente"));
                cliente.setIdUsuario(resultado.getInt("id_usuario"));
                cliente.setIdPais(resultado.getInt("id_pais"));
                cliente.setNombre(resultado.getString("nombre"));
                cliente.setApellido(resultado.getString("apellido"));
                cliente.setTelefono(resultado.getString("telefono"));
                cliente.setDireccion(resultado.getString("direccion"));

                if (resultado.getDate("fecha_nacimiento") != null) {
                    cliente.setFechaNacimiento(
                            resultado.getDate("fecha_nacimiento").toLocalDate()
                    );
                }

                clientes.add(cliente);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar clientes: " + e.getMessage());
        }

        return clientes;
    }

    // UPDATE - Actualizar cliente
    public boolean actualizar(Cliente cliente) {

        String sql = "UPDATE cliente SET "
                + "id_usuario = ?, "
                + "id_pais = ?, "
                + "nombre = ?, "
                + "apellido = ?, "
                + "telefono = ?, "
                + "direccion = ?, "
                + "fecha_nacimiento = ? "
                + "WHERE id_cliente = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, cliente.getIdUsuario());
            sentencia.setInt(2, cliente.getIdPais());
            sentencia.setString(3, cliente.getNombre());
            sentencia.setString(4, cliente.getApellido());
            sentencia.setString(5, cliente.getTelefono());
            sentencia.setString(6, cliente.getDireccion());

            if (cliente.getFechaNacimiento() != null) {
                sentencia.setDate(7,
                        java.sql.Date.valueOf(cliente.getFechaNacimiento()));
            } else {
                sentencia.setNull(7, java.sql.Types.DATE);
            }

            sentencia.setInt(8, cliente.getIdCliente());

            int filas = sentencia.executeUpdate();

            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
            return false;
        }
    }

    // DELETE - Eliminar cliente
    public boolean eliminar(int idCliente) {

        String sql = "DELETE FROM cliente WHERE id_cliente = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, idCliente);

            int filas = sentencia.executeUpdate();

            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
            return false;
        }
    }
}