/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ProveedorDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelos.Proveedor;

/**
 *
 * @author nesquit
 */
@ManagedBean
@ViewScoped
public class ProveedorBean {

    private Proveedor proveedor=new Proveedor();
    private List<Proveedor> listaProveedores;
    private String status;
    /**
     * Creates a new instance of ProveedorBean
     */
    public ProveedorBean() {
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(List<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }
    
    
    public void registrar() throws Exception{
        ProveedorDAO dao;
        try {
            dao=new ProveedorDAO();
            dao.registrar(proveedor);
            Mensajes.generarMensaje("Éxito", "El proveedor se ha registrado.");
        } catch (Exception e) {
            throw  e;
        }
        
    }
    
     public  void listar() throws Exception{
        ProveedorDAO dao;
        try {
            dao=new ProveedorDAO();
            listaProveedores=dao.Listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void boton(){
        try {
            registrar();
            listar();
        } catch (Exception ex) {
            Logger.getLogger(ProveedorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public  void leerID(Proveedor prov) throws Exception{
        Proveedor temp;
        ProveedorDAO dao;
        
        try {
            dao=new ProveedorDAO();
            temp=dao.leerID(prov);
            if (temp!=null) {
                this.proveedor=temp;                
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void clean(){
        proveedor=null;
    }
    
    public void modificar()throws Exception{
        ProveedorDAO dao;
        try {
            dao=new ProveedorDAO();
            dao.modificar(proveedor);
            this.listar();
        } catch (Exception e) {
        }
    }
    
    public void eliminar(Proveedor prov) throws Exception{
        ProveedorDAO dao;
        try {
            dao=new ProveedorDAO();
            dao.eliminar(prov);
            this.listar();
        } catch (Exception e) {
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
