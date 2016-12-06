/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.UsuarioDAO;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelos.Usuario;

/**
 *
 * @author nesquit
 */
@ManagedBean
@ViewScoped

public class UsuarioBean {

    private Usuario usuario = new Usuario();
    FacesContext context = null;
    String titulo, mensaje;
    
    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String iniciarSesion() throws SQLException, Exception {
        UsuarioDAO dao = new UsuarioDAO();
        context = FacesContext.getCurrentInstance();
        boolean userExist = dao.verificarUsuario(usuario);
        if(userExist) {
            boolean loginSuccess = dao.inciarSesion(usuario);
            if(loginSuccess) {
                titulo = "Éxito";
                mensaje = "Bienvenido";
            } else {
                titulo = "Error al iniciar sesión";
                mensaje = "No empatan las credenciales";
            }
        } else {
            titulo = "Error";
            mensaje = "El usuario no existe";
        }
        context.addMessage(null, new FacesMessage(titulo, mensaje));
        return "login";
    }
    
}
