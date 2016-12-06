/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ClienteDAO;
import dao.UsuarioDAO;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelos.Cliente;
import modelos.Usuario;


/**
 *
 * @author nesquit
 */
@ManagedBean
@ViewScoped
@SessionScoped

public class ClienteBean {

    private Cliente cliente = new Cliente();
    private Usuario usuario = new Usuario();
    
    /**
     * Creates a new instance of ClienteBean
     */
    public ClienteBean() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String registrarCliente() throws Exception {
        ClienteDAO daoCliente = new ClienteDAO();
        UsuarioDAO daoUsuario = new UsuarioDAO();
        int idUsuario = daoUsuario.registrarUsuario(usuario);
        if(idUsuario != 0) {
            Mensajes.generarMensaje("bien", "se generó " + idUsuario);
        } else {
            Mensajes.generarMensaje("Error al registrar", "Hubo un problema con generar la nueva cuenta. Vuelva a intentarlo.");
        }
        return "registerClient";
    }
    
}
