/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.PedidoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import modelos.Boton;
import modelos.Cierre;
import modelos.Elastico;
import modelos.Material;
import modelos.Tela;
import modelos.MaterialesPrendaPedido;
import modelos.Prenda;

/**
 *
 * @author nesquit
 */
@ManagedBean
@ViewScoped

public class PedidoBean {

    private Tela telaPlayera = new Tela();
    private Tela telaPantalon = new Tela();
    private Tela telaCamisa = new Tela();
    private Tela telaFalda = new Tela();
    private Tela telaBlusa = new Tela();
    private List<Tela> listaTelas = new ArrayList();
    private Elastico elasticoPlayera = new Elastico();
    private Elastico elasticoBlusa = new Elastico();
    private List<Elastico> listaElasticos = new ArrayList();
    private Boton botonPantalon = new Boton();
    private Boton botonCamisa = new Boton();
    private List<Boton> listaBotones = new ArrayList();
    private Cierre cierrePantalon = new Cierre();
    private Cierre cierreFalda = new Cierre();
    private List<Cierre> listaCierres = new ArrayList();
    
    private MaterialesPrendaPedido materialesPrendaPedido;
    private List<MaterialesPrendaPedido> listaCarritoVenta = new ArrayList();
    
    private Prenda prendaPlayera = new Prenda();
    private Prenda prendaPantalon = new Prenda();
    private Prenda prendaCamisa = new Prenda();
    private Prenda prendaFalda = new Prenda();
    private Prenda prendaBlusa = new Prenda();
    private double telas;
    private int botones;
    private int cierres;
    private double elasticos;
    
    private double totalPedido;
        
    /**
     * Creates a new instance of PedidoBean
     * @throws java.lang.Exception
     */
    public PedidoBean() throws Exception {
        PedidoDAO dao = new PedidoDAO();
        listaTelas = dao.listarTelas();
        listaElasticos = dao.listarElasticos();
        listaBotones = dao.listarBotones();
        listaCierres = dao.listarCierres();
        telas = 2.5;
        botones = 5;
        cierres = 1;
        elasticos = 0.2;
    }
    
    public Prenda getPrendaPlayera() {
        return prendaPlayera;
    }

    public void setPrendaPlayera(Prenda prendaPlayera) {
        this.prendaPlayera = prendaPlayera;
    }

    public Prenda getPrendaPantalon() {
        return prendaPantalon;
    }

    public void setPrendaPantalon(Prenda prendaPantalon) {
        this.prendaPantalon = prendaPantalon;
    }

    public Prenda getPrendaCamisa() {
        return prendaCamisa;
    }

    public void setPrendaCamisa(Prenda prendaCamisa) {
        this.prendaCamisa = prendaCamisa;
    }

    public Prenda getPrendaFalda() {
        return prendaFalda;
    }

    public void setPrendaFalda(Prenda prendaFalda) {
        this.prendaFalda = prendaFalda;
    }

    public Prenda getPrendaBlusa() {
        return prendaBlusa;
    }

    public void setPrendaBlusa(Prenda prendaBlusa) {
        this.prendaBlusa = prendaBlusa;
    }

    public double getTelas() {
        return telas;
    }

    public void setTelas(double telas) {
        this.telas = telas;
    }

    public int getBotones() {
        return botones;
    }

    public void setBotones(int botones) {
        this.botones = botones;
    }

    public int getCierres() {
        return cierres;
    }

    public void setCierres(int cierres) {
        this.cierres = cierres;
    }

    public double getElasticos() {
        return elasticos;
    }

    public void setElasticos(double elasticos) {
        this.elasticos = elasticos;
    }
    
    public List<Tela> getListaTelas() {
        return listaTelas;
    }

    public void setListaTelas(List<Tela> listaTelas) {
        this.listaTelas = listaTelas;
    }

    public List<Elastico> getListaElasticos() {
        return listaElasticos;
    }

    public void setListaElasticos(List<Elastico> listaElasticos) {
        this.listaElasticos = listaElasticos;
    }

    public List<Boton> getListaBotones() {
        return listaBotones;
    }

    public void setListaBotones(List<Boton> listaBotones) {
        this.listaBotones = listaBotones;
    }

    public List<Cierre> getListaCierres() {
        return listaCierres;
    }

    public void setListaCierres(List<Cierre> listaCierres) {
        this.listaCierres = listaCierres;
    }

    public MaterialesPrendaPedido getMaterialesPrendaPedido() {
        return materialesPrendaPedido;
    }

    public void setMaterialesPrendaPedido(MaterialesPrendaPedido materialesPrendaPedido) {
        this.materialesPrendaPedido = materialesPrendaPedido;
    }

    public List<MaterialesPrendaPedido> getListaCarritoVenta() {
        return listaCarritoVenta;
    }

    public void setListaCarritoVenta(List<MaterialesPrendaPedido> listaCarritoVenta) {
        this.listaCarritoVenta = listaCarritoVenta;
    }

    public double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(double totalPedido) {
        this.totalPedido = totalPedido;
    }

    public void actualizarCantidadPlayera(AjaxBehaviorEvent event) {
        if(prendaPlayera.getIdPrenda() == 1) { telas = 2.5; elasticos = 0.2; }
        if(prendaPlayera.getIdPrenda() == 2) { telas = 3; elasticos = 0.3; }
        if(prendaPlayera.getIdPrenda() == 3) { telas = 20; elasticos = 0.4; }
    }
    
    public void actualizarCantidadPantalon(AjaxBehaviorEvent event) {
        if(prendaPantalon.getIdPrenda() == 4) { telas = 3; botones = 1; cierres = 1; }
        if(prendaPantalon.getIdPrenda() == 5) { telas = 4; botones = 1; cierres = 1; }
        if(prendaPantalon.getIdPrenda() == 6) { telas = 5; botones = 1; cierres = 1; }
    }
    
    public void actualizarCantidadCamisa(AjaxBehaviorEvent event) {
        if(prendaCamisa.getIdPrenda() == 7) { telas = 3.5; botones = 6; }
        if(prendaCamisa.getIdPrenda() == 8) { telas = 4.5; botones = 7; }
        if(prendaCamisa.getIdPrenda() == 9) { telas = 5.5; botones = 8; }
    }
    
    public void actualizarCantidadFalda(AjaxBehaviorEvent event) {
        if(prendaFalda.getIdPrenda() == 10) { telas = 3; cierres = 1; }
        if(prendaFalda.getIdPrenda() == 11) { telas = 3.5; cierres = 1; }
        if(prendaFalda.getIdPrenda() == 12) { telas = 4; cierres = 1; }
    }
    
    public void actualizarCantidadBlusa(AjaxBehaviorEvent event) {
        if(prendaBlusa.getIdPrenda() == 13) { telas = 2.5; elasticos = 0.2; }
        if(prendaBlusa.getIdPrenda() == 14) { telas = 3; elasticos = 0.3; }
        if(prendaBlusa.getIdPrenda() == 15) { telas = 3.5; elasticos = 0.4; }
    }
    
    public void añadirPlayeraCarrito() throws Exception {
        PedidoDAO dao = new PedidoDAO();
        telaPlayera = dao.obtenerDatosTela(telaPlayera.getIdMaterial());
        elasticoPlayera = dao.obtenerDatosElastico(elasticoPlayera.getIdMaterial());
        if((telaPlayera.getStock()-telas) > 0) {
            MaterialesPrendaPedido materialesPrendaPedidoTela = new MaterialesPrendaPedido();
            materialesPrendaPedidoTela.setIdPrenda(prendaPlayera.getIdPrenda());
            materialesPrendaPedidoTela.setIdMaterial(telaPlayera.getIdMaterial());
            materialesPrendaPedidoTela.setCantidadMaterial(telas);
            materialesPrendaPedidoTela.setPrecioVentaMaterial(telaPlayera.getPrecioVenta());
            materialesPrendaPedidoTela.setSubtotalMaterial(telas*telaPlayera.getPrecioVenta());
            materialesPrendaPedidoTela.setTipoPrenda("Playera");
            materialesPrendaPedidoTela.setMaterial("Tela");
            if((elasticoPlayera.getStock()-elasticos) > 0) {
                MaterialesPrendaPedido materialesPrendaPedidoElastico = new MaterialesPrendaPedido();
                materialesPrendaPedidoElastico.setIdPrenda(prendaPlayera.getIdPrenda());
                materialesPrendaPedidoElastico.setIdMaterial(elasticoPlayera.getIdMaterial());
                materialesPrendaPedidoElastico.setCantidadMaterial(elasticos);
                materialesPrendaPedidoElastico.setPrecioVentaMaterial(elasticoPlayera.getPrecioVenta());
                materialesPrendaPedidoElastico.setSubtotalMaterial(elasticos*elasticoPlayera.getPrecioVenta());
                materialesPrendaPedidoElastico.setTipoPrenda("Playera");
                materialesPrendaPedidoElastico.setMaterial("Elástico");
                listaCarritoVenta.add(materialesPrendaPedidoTela);
                listaCarritoVenta.add(materialesPrendaPedidoElastico);
                totalPedido = totalPedido + materialesPrendaPedidoTela.getSubtotalMaterial();
                totalPedido = totalPedido + materialesPrendaPedidoElastico.getSubtotalMaterial();
            } else
                Mensajes.generarMensaje("Elástico insuficiente", "El material no es suficiente para cubrir la hechura de la playera.");
        } else
            Mensajes.generarMensaje("Tela insuficiente", "El material no es suficiente para cubrir la hechura de la playera.");
    }
    
    public void añadirPantalonCarrito() throws Exception {
        PedidoDAO dao = new PedidoDAO();
        telaPantalon = dao.obtenerDatosTela(telaPantalon.getIdMaterial());
        botonPantalon = dao.obtenerDatosBoton(botonPantalon.getIdMaterial());
        cierrePantalon = dao.obtenerDatosCierre(cierrePantalon.getIdMaterial());
        if ((telaPantalon.getStock()-telas) > 0) {
            MaterialesPrendaPedido materialesPrendaPedidoTela = new MaterialesPrendaPedido();
            materialesPrendaPedidoTela.setIdPrenda(prendaPantalon.getIdPrenda());
            materialesPrendaPedidoTela.setIdMaterial(telaPantalon.getIdMaterial());
            materialesPrendaPedidoTela.setCantidadMaterial(telas);
            materialesPrendaPedidoTela.setPrecioVentaMaterial(telaPantalon.getPrecioVenta());
            materialesPrendaPedidoTela.setSubtotalMaterial(telas*telaPantalon.getPrecioVenta());
            materialesPrendaPedidoTela.setTipoPrenda("Pantalón");
            materialesPrendaPedidoTela.setMaterial("Tela");
            if((botonPantalon.getStock()-botones) > 0) {
                MaterialesPrendaPedido materialesPrendaPedidoBoton = new MaterialesPrendaPedido();
                materialesPrendaPedidoBoton.setIdPrenda(prendaPantalon.getIdPrenda());
                materialesPrendaPedidoBoton.setIdMaterial(botonPantalon.getIdMaterial());
                materialesPrendaPedidoBoton.setCantidadMaterial(botones);
                materialesPrendaPedidoBoton.setPrecioVentaMaterial(botonPantalon.getPrecioVenta());
                materialesPrendaPedidoBoton.setSubtotalMaterial(botones*botonPantalon.getPrecioVenta());
                materialesPrendaPedidoBoton.setTipoPrenda("Pantalón");
                materialesPrendaPedidoBoton.setMaterial("Botón");
                if ((cierrePantalon.getStock()-cierres) > 0) {
                    MaterialesPrendaPedido materialesPrendaPedidoCierre = new MaterialesPrendaPedido();
                    materialesPrendaPedidoCierre.setIdPrenda(prendaPantalon.getIdPrenda());
                    materialesPrendaPedidoCierre.setIdMaterial(cierrePantalon.getIdMaterial());
                    materialesPrendaPedidoCierre.setCantidadMaterial(cierres);
                    materialesPrendaPedidoCierre.setPrecioVentaMaterial(cierrePantalon.getPrecioVenta());
                    materialesPrendaPedidoCierre.setSubtotalMaterial(cierres*cierrePantalon.getPrecioVenta());
                    materialesPrendaPedidoCierre.setTipoPrenda("Pantalón");
                    materialesPrendaPedidoCierre.setMaterial("Cierre");
                    listaCarritoVenta.add(materialesPrendaPedidoTela);
                    listaCarritoVenta.add(materialesPrendaPedidoBoton);
                    listaCarritoVenta.add(materialesPrendaPedidoCierre);
                    totalPedido = totalPedido + materialesPrendaPedidoTela.getSubtotalMaterial();
                    totalPedido = totalPedido + materialesPrendaPedidoBoton.getSubtotalMaterial();
                    totalPedido = totalPedido + materialesPrendaPedidoCierre.getSubtotalMaterial();
                } else 
                    Mensajes.generarMensaje("Botones insuficiente", "El material no es suficiente para cubrir la hechura del pantalón.");
            } else 
                Mensajes.generarMensaje("Botones insuficiente", "El material no es suficiente para cubrir la hechura del pantalón.");
        } else
            Mensajes.generarMensaje("Tela insuficiente", "El material no es suficiente para cubrir la hechura del pantalón.");
    }
    
    public void añadirCamisaCarrito() throws Exception {
        PedidoDAO dao = new PedidoDAO();
        telaCamisa = dao.obtenerDatosTela(telaCamisa.getIdMaterial());
        botonCamisa = dao.obtenerDatosBoton(botonCamisa.getIdMaterial());
        if((telaCamisa.getStock()-telas) > 0) {
            MaterialesPrendaPedido materialesPrendaPedidoTela = new MaterialesPrendaPedido();
            materialesPrendaPedidoTela.setIdPrenda(prendaCamisa.getIdPrenda());
            materialesPrendaPedidoTela.setIdMaterial(telaCamisa.getIdMaterial());
            materialesPrendaPedidoTela.setCantidadMaterial(telas);
            materialesPrendaPedidoTela.setPrecioVentaMaterial(telaCamisa.getPrecioVenta());
            materialesPrendaPedidoTela.setSubtotalMaterial(telas*telaCamisa.getPrecioVenta());
            materialesPrendaPedidoTela.setTipoPrenda("Camisa");
            materialesPrendaPedidoTela.setMaterial("Tela");
            if((botonCamisa.getStock()-botones) > 0) {
                MaterialesPrendaPedido materialesPrendaPedidoBoton = new MaterialesPrendaPedido();
                materialesPrendaPedidoBoton.setIdPrenda(prendaCamisa.getIdPrenda());
                materialesPrendaPedidoBoton.setIdMaterial(botonCamisa.getIdMaterial());
                materialesPrendaPedidoBoton.setCantidadMaterial(botones);
                materialesPrendaPedidoBoton.setPrecioVentaMaterial(botonCamisa.getPrecioVenta());
                materialesPrendaPedidoBoton.setSubtotalMaterial(botones*botonCamisa.getPrecioVenta());
                materialesPrendaPedidoBoton.setTipoPrenda("Camisa");
                materialesPrendaPedidoBoton.setMaterial("Botón");
                listaCarritoVenta.add(materialesPrendaPedidoTela);
                listaCarritoVenta.add(materialesPrendaPedidoBoton);
                totalPedido = totalPedido + materialesPrendaPedidoTela.getSubtotalMaterial();
                totalPedido = totalPedido + materialesPrendaPedidoBoton.getSubtotalMaterial();
            } else 
                Mensajes.generarMensaje("Botones insuficiente", "El material no es suficiente para cubrir la hechura de la camisa.");
        } else 
            Mensajes.generarMensaje("Tela insuficiente", "El material no es suficiente para cubrir la hechura de la camisa.");
    }
    
    public void añadirFaldaCarrito() throws Exception {
        PedidoDAO dao = new PedidoDAO();
        telaFalda = dao.obtenerDatosTela(telaFalda.getIdMaterial());
        cierreFalda = dao.obtenerDatosCierre(cierreFalda.getIdMaterial());
        if((telaFalda.getStock()-telas) > 0) {
            MaterialesPrendaPedido materialesPrendaPedidoTela = new MaterialesPrendaPedido();
            materialesPrendaPedidoTela.setIdPrenda(prendaFalda.getIdPrenda());
            materialesPrendaPedidoTela.setIdMaterial(telaFalda.getIdMaterial());
            materialesPrendaPedidoTela.setCantidadMaterial(telas);
            materialesPrendaPedidoTela.setPrecioVentaMaterial(telaFalda.getPrecioVenta());
            materialesPrendaPedidoTela.setSubtotalMaterial(telas*telaFalda.getPrecioVenta());
            materialesPrendaPedidoTela.setTipoPrenda("Falda");
            materialesPrendaPedidoTela.setMaterial("Tela");
            if((cierreFalda.getStock()-telas > 0)) {
                MaterialesPrendaPedido materialesPrendaPedidoCierre = new MaterialesPrendaPedido();
                materialesPrendaPedidoCierre.setIdPrenda(prendaFalda.getIdPrenda());
                materialesPrendaPedidoCierre.setIdMaterial(cierreFalda.getIdMaterial());
                materialesPrendaPedidoCierre.setCantidadMaterial(cierres);
                materialesPrendaPedidoCierre.setPrecioVentaMaterial(cierreFalda.getPrecioVenta());
                materialesPrendaPedidoCierre.setSubtotalMaterial(cierres*cierreFalda.getPrecioVenta());
                materialesPrendaPedidoCierre.setTipoPrenda("Falda");
                materialesPrendaPedidoCierre.setMaterial("Cierre");
                listaCarritoVenta.add(materialesPrendaPedidoTela);
                listaCarritoVenta.add(materialesPrendaPedidoCierre);
                totalPedido = totalPedido + materialesPrendaPedidoTela.getSubtotalMaterial();
                totalPedido = totalPedido + materialesPrendaPedidoCierre.getSubtotalMaterial();
            } else {
                Mensajes.generarMensaje("Cierre insuficiente", "El material no es suficiente para cubrir la hechura de la falda.");
            }
        } else     
            Mensajes.generarMensaje("Tela insuficiente", "El material no es suficiente para cubrir la hechura de la falda.");
    }
    
    public void añadirBlusaCarrito() throws Exception {
        PedidoDAO dao = new PedidoDAO();
        telaBlusa = dao.obtenerDatosTela(telaBlusa.getIdMaterial());
        elasticoBlusa = dao.obtenerDatosElastico(elasticoBlusa.getIdMaterial());
        if((telaBlusa.getStock()-telas) > 0) {
            MaterialesPrendaPedido materialesPrendaPedidoTela = new MaterialesPrendaPedido();
            materialesPrendaPedidoTela.setIdPrenda(prendaBlusa.getIdPrenda());
            materialesPrendaPedidoTela.setIdMaterial(telaBlusa.getIdMaterial());
            materialesPrendaPedidoTela.setCantidadMaterial(telas);
            materialesPrendaPedidoTela.setPrecioVentaMaterial(telaBlusa.getPrecioVenta());
            materialesPrendaPedidoTela.setSubtotalMaterial(telas*telaBlusa.getPrecioVenta());
            materialesPrendaPedidoTela.setTipoPrenda("Blusa");
            materialesPrendaPedidoTela.setMaterial("Tela");
            if((elasticoBlusa.getStock()-elasticos) > 0) {
                MaterialesPrendaPedido materialesPrendaPedidoElastico = new MaterialesPrendaPedido();
                materialesPrendaPedidoElastico.setIdPrenda(prendaBlusa.getIdPrenda());
                materialesPrendaPedidoElastico.setIdMaterial(elasticoBlusa.getIdMaterial());
                materialesPrendaPedidoElastico.setCantidadMaterial(elasticos);
                materialesPrendaPedidoElastico.setPrecioVentaMaterial(elasticoBlusa.getPrecioVenta());
                materialesPrendaPedidoElastico.setSubtotalMaterial(elasticos*elasticoBlusa.getPrecioVenta());
                materialesPrendaPedidoElastico.setTipoPrenda("Blusa");
                materialesPrendaPedidoElastico.setMaterial("Elástico");
                listaCarritoVenta.add(materialesPrendaPedidoTela);
                listaCarritoVenta.add(materialesPrendaPedidoElastico);
                totalPedido = totalPedido + materialesPrendaPedidoTela.getSubtotalMaterial();
                totalPedido = totalPedido + materialesPrendaPedidoElastico.getSubtotalMaterial();
            } else 
                Mensajes.generarMensaje("Elástico insuficiente", "El material no es suficiente para cubrir la hechura de la blusa.");
        } else 
            Mensajes.generarMensaje("Tela insuficiente", "El material no es suficiente para cubrir la hechura de la blusa.");
    }
    
    public void registrarPedido(String user) throws Exception {
        PedidoDAO dao = new PedidoDAO();
        int idPedido = dao.registrarPedido(totalPedido, user);
        for(int i=0; i<listaCarritoVenta.size(); i++) {
            dao.registrarDetallePedido(listaCarritoVenta.get(i), idPedido);
        }
        listaCarritoVenta = null;
        totalPedido = 0;
        Mensajes.generarMensaje("Éxito", "Su pedido ha sido registrado.");
    }

    public Tela getTelaPlayera() {
        return telaPlayera;
    }

    public void setTelaPlayera(Tela telaPlayera) {
        this.telaPlayera = telaPlayera;
    }

    public Tela getTelaPantalon() {
        return telaPantalon;
    }

    public void setTelaPantalon(Tela telaPantalon) {
        this.telaPantalon = telaPantalon;
    }

    public Tela getTelaCamisa() {
        return telaCamisa;
    }

    public void setTelaCamisa(Tela telaCamisa) {
        this.telaCamisa = telaCamisa;
    }

    public Tela getTelaFalda() {
        return telaFalda;
    }

    public void setTelaFalda(Tela telaFalda) {
        this.telaFalda = telaFalda;
    }

    public Tela getTelaBlusa() {
        return telaBlusa;
    }

    public void setTelaBlusa(Tela telaBlusa) {
        this.telaBlusa = telaBlusa;
    }

    public Elastico getElasticoPlayera() {
        return elasticoPlayera;
    }

    public void setElasticoPlayera(Elastico elasticoPlayera) {
        this.elasticoPlayera = elasticoPlayera;
    }

    public Elastico getElasticoBlusa() {
        return elasticoBlusa;
    }

    public void setElasticoBlusa(Elastico elasticoBlusa) {
        this.elasticoBlusa = elasticoBlusa;
    }

    public Boton getBotonPantalon() {
        return botonPantalon;
    }

    public void setBotonPantalon(Boton botonPantalon) {
        this.botonPantalon = botonPantalon;
    }

    public Boton getBotonCamisa() {
        return botonCamisa;
    }

    public void setBotonCamisa(Boton botonCamisa) {
        this.botonCamisa = botonCamisa;
    }

    public Cierre getCierrePantalon() {
        return cierrePantalon;
    }

    public void setCierrePantalon(Cierre cierrePantalon) {
        this.cierrePantalon = cierrePantalon;
    }

    public Cierre getCierreFalda() {
        return cierreFalda;
    }

    public void setCierreFalda(Cierre cierreFalda) {
        this.cierreFalda = cierreFalda;
    }

}
