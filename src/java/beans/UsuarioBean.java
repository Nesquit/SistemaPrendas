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
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelos.Usuario;

/**
 *
 * @author nesquit
 */
@ManagedBean
@ViewScoped
@SessionScoped

public class UsuarioBean {

    private Usuario usuario = new Usuario();
    
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
        if(dao.verificarUsuario(usuario)) {
            if(dao.inciarSesion(usuario)) {
                variablesSesion();
                if(dao.tipoUsuario(usuario)) {
                    return "indexAdmin";
                }
                else return "indexClient";
            } else {
                Mensajes.generarMensaje("Error al iniciar sesión", "No empatan las credenciales");
            }
        } else {
            Mensajes.generarMensaje("Error", "El usuario no existe");
        }
        return "login";
    }
    
    public String cerrarSesion() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().remove("usuario");
        return "login";
    }
    
    public void variablesSesion() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("usuario", usuario.getCorreo());
    }
    
}
