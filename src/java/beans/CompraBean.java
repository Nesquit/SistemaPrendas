/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.CompraDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import modelos.Compra;
import modelos.DetalleCompra;
import modelos.Material;

/**
 *
 * @author nesquit
 */
@ManagedBean
@ViewScoped

public class CompraBean {

    private Compra compra = new Compra();   
    
    private String categoria;
    private List<String> listaCategorias;
    private int idMaterial;
    private List<Material> listaMateriales; 
    private String stockExistente;
    private int cantidad = 1;
    private double totalCompra;
    private List<Compra> listaCompras = new ArrayList();
    private List<DetalleCompra> listaDetalleCompra = new ArrayList();   
    
    /**
     * Creates a new instance of CompraBean
     */
    public CompraBean() throws Exception {
        listaCategorias = new ArrayList();
        listaCategorias.add("botones");
        listaCategorias.add("cierres");
        listaCategorias.add("elasticos");
        listaCategorias.add("primarios");
        listaCategorias.add("telas");
        CompraDAO dao = new CompraDAO();
        listaMateriales = dao.obtenerMateriales("botones");
        stockExistente = dao.consultarStock(listaMateriales.get(0).getIdMaterial());
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<String> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(List<String> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public List<Material> getListaMateriales() {
        return listaMateriales;
    }

    public void setListaMateriales(List<Material> listaMateriales) {
        this.listaMateriales = listaMateriales;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }
    
    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }
    
    public void consultarStock() throws Exception {
        CompraDAO dao = new CompraDAO();
        stockExistente = dao.consultarStock(idMaterial);
    }
    
    public String getStockExistente() {
        return stockExistente;
    }

    public void setStockExistente(String stockExistente) {
        this.stockExistente = stockExistente;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<DetalleCompra> getListaDetalleCompra() {
        return listaDetalleCompra;
    }

    public void setListaDetalleCompra(List<DetalleCompra> listaDetalleCompra) {
        this.listaDetalleCompra = listaDetalleCompra;
    }
    
    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }
    
    public void obtenerMateriales(AjaxBehaviorEvent event) throws Exception {
        CompraDAO dao = new CompraDAO();
        listaMateriales = dao.obtenerMateriales(categoria);
    }
    
    public void agregarCarritoCompras() throws Exception {
        CompraDAO dao = new CompraDAO();
        Material material = dao.consultarMaterial(idMaterial);
        DetalleCompra detalleCompra = new DetalleCompra();
        detalleCompra.setIdMaterial(material.getIdMaterial());
        detalleCompra.setPrecioCompraMaterial(material.getPrecioCompra());
        detalleCompra.setTotalPrecioCompraMaterial(material.getPrecioCompra()*cantidad);
        detalleCompra.setTotalUnidadesMaterial(cantidad);
        listaDetalleCompra.add(detalleCompra);
        totalCompra = totalCompra + detalleCompra.getTotalPrecioCompraMaterial();
    }
    
    public void registrarCompra() throws Exception {
        CompraDAO dao = new CompraDAO();        
        int idCompra = dao.registrarCompra(totalCompra);
        for(int i=0; i<listaDetalleCompra.size(); i++) {
            dao.registrarDetalleCompra(listaDetalleCompra.get(i), idCompra);
        }
        listaDetalleCompra = null;
        totalCompra = 0;
        Mensajes.generarMensaje("Éxito", "La compra ha sido registrada.");
    }
    
    public void consultarCompras() throws Exception {
        CompraDAO dao = new CompraDAO();
        listaCompras = dao.consultarCompras();
    }
    
    public void verDetalleCompra(Compra compra) throws Exception {
        CompraDAO dao = new CompraDAO();
        listaDetalleCompra = dao.verDetalleCompra(compra);
    }
    
}
