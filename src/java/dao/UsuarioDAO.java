/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.Usuario;

/**
 *
 * @author nesquit
 */
public class UsuarioDAO extends DAO{
    
    boolean bandera;
    
    public boolean verificarUsuario(Usuario usuario) throws Exception {
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT * FROM Usuarios WHERE correo = ?");
            st.setString(1, usuario.getCorreo());
            rs = st.executeQuery();
            bandera = false;
            if(rs.first()) {
                bandera = true;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return bandera;
    }
    
    public boolean inciarSesion(Usuario usuario) throws SQLException {
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT * FROM Usuarios WHERE correo = ? AND contraseña = ?");
            st.setString(1, usuario.getCorreo());
            st.setString(2, usuario.getContraseña());
            rs = st.executeQuery();
            bandera = false;
            if(rs.first()) {
                bandera = true;
            }
        } catch(Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return bandera;
    }
    
    public boolean tipoUsuario(Usuario usuario) throws Exception {
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT tipo FROM Usuarios WHERE correo = ?");
            st.setString(1, usuario.getCorreo());
            rs = st.executeQuery();
            bandera = false;
            if(rs.next()) {
                if(rs.getBoolean("tipo")) {
                    bandera = true;
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return bandera;
    }
    
    public int registrarUsuario(Usuario usuario) throws Exception {
        ResultSet rs;
        int idUsuario = 0;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("INSERT INTO Usuarios VALUES(0, ?, ?, 0)");
            st.setString(1, usuario.getCorreo());
            st.setString(2, usuario.getContraseña());
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            while(rs.next()) {
                idUsuario = rs.getInt(1);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return idUsuario;
    }
    
}
