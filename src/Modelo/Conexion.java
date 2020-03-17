/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author sonia
 */
public class Conexion {
    //variables que todos van a poder usar

    private final String URL = "jdbc:mysql://localhost:3306/tienda";
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    private Connection con = null;

    public Connection getConexion() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            //con esto se realiza la conexion
            con = (Connection) DriverManager.getConnection(this.URL, this.USERNAME, this.PASSWORD);
            JOptionPane.showMessageDialog(null, "conexion exitosa");

        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
        return con;
    }
}
