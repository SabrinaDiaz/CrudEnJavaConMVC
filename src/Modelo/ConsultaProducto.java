package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaProducto extends Conexion {

    public boolean registrar(Producto producto) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "INSERT INTO producto (codigo, nombre, precio, cantidad) VALUES (?,?,?,?)";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getCantidad());
            ps.execute();

            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                //para cerrar la conexcion
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean modificar(Producto producto) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "UPDATE producto SET codigo=?, nombre=?, precio=?, cantidad=? WHERE id =? ";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getCantidad());
            ps.setInt(5, producto.getId());
            ps.execute();

            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                //para cerrar la conexcion
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean eliminar(Producto producto) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "DELETE producto WHERE id =? ";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, producto.getId());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                //para cerrar la conexcion
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean buscar(Producto producto) {
        PreparedStatement ps;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELEC * FROM producto SET WHERE codigo=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getCodigo());
            rs = ps.executeQuery();
            
            if(rs.next()){
                producto.setId(Integer.parseInt(rs.getString("id")));
                producto.setCodigo(rs.getString("codigo"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(Double.parseDouble(rs.getString("precio")));
                producto.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                //para cerrar la conexcion
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
