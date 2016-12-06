/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelos.Cliente;

/**
 *
 * @author nesquit
 */
public class ClienteDAO extends DAO{
    
    public void registrarCliente(Cliente cliente, int idUsuario) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("INSERT INTO clientes VALUES(0, ?, ?, ?, ?, ?, 1)");
            st.setInt(1, idUsuario);
            st.setString(2, cliente.getNombre());
            st.setString(3, cliente.getApellido());
            st.setString(4, cliente.getDireccion());
            st.setString(5, cliente.getTelefono());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            
        }
    }
    
    public Cliente buscarCliente(String usuario) throws Exception {
        Cliente cliente = null;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT * FROM clientes WHERE idUsuario = (SELECT id FROM usuarios WHERE correo = ?)");
            st.setString(1, usuario);
            rs = st.executeQuery();
            if(rs.next()) {
                cliente = new Cliente();
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getString("telefono"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return cliente;
    }
    
    public void actualizarCliente(Cliente cliente, String usuario) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("UPDATE clientes SET "
                    + "nombre = ?, "
                    + "apellido = ?, "
                    + "direccion = ?,"
                    + "telefono = ? "
                    + "WHERE idUsuario = (SELECT id FROM usuarios WHERE correo = ?)");
            st.setString(1, cliente.getNombre());
            st.setString(2, cliente.getApellido());
            st.setString(3, cliente.getDireccion());
            st.setString(4, cliente.getTelefono());
            st.setString(5, usuario);
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
}
