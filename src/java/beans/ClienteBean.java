/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ClienteDAO;
import dao.UsuarioDAO;
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
        if(!daoUsuario.verificarUsuario(usuario)) {
            int idUsuario = daoUsuario.registrarUsuario(usuario);
            daoCliente.registrarCliente(cliente, idUsuario);
            if(daoUsuario.inciarSesion(usuario)) {
                variablesSesion();
                return "indexClient";
            }
        } else 
            Mensajes.generarMensaje("Error", "El usuario ya existe. Pruebe otro.");
        return "registerClient";
    }
    
    public void datosCliente(String user) throws Exception {
        ClienteDAO dao = new ClienteDAO();
        Cliente tmp;
        tmp = dao.buscarCliente(user);
        if(tmp!=null) {
            this.cliente = tmp;
        }
    }
    
    public void actualizarPerfil(String user) throws Exception {
        ClienteDAO dao = new ClienteDAO();
        dao.actualizarCliente(cliente, user);
        Mensajes.generarMensaje("Éxito", "La información ha sido actualizada.");
    }
    
    public void variablesSesion() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("usuario", usuario.getCorreo());
    }
    
}
