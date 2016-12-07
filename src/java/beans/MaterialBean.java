/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.MaterialDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelos.Boton;
import modelos.Cierre;
import modelos.Elastico;
import modelos.Material;
import modelos.Primario;
import modelos.Tela;

/**
 *
 * @author nesquit
 */
@ManagedBean
@ViewScoped

public class MaterialBean {

    private Boton boton = new Boton();
    private Cierre cierre = new Cierre();
    private Elastico elastico = new Elastico();
    private Primario primario = new Primario();
    private Tela tela = new Tela();
    private Material material = new Material();
    
    private List<Boton> listaBotones;
    private List<Cierre> listaCierres;
    private List<Elastico> listaElasticos;
    private List<Primario> listaPrimarios;
    private List<Tela> listaTelas;
    
    /**
     * Creates a new instance of MaterialBean
     */
    public MaterialBean() {
        
    }

    public Boton getBoton() {
        return boton;
    }

    public void setBoton(Boton boton) {
        this.boton = boton;
    }

    public Cierre getCierre() {
        return cierre;
    }

    public void setCierre(Cierre cierre) {
        this.cierre = cierre;
    }

    public Elastico getElastico() {
        return elastico;
    }

    public void setElastico(Elastico elastico) {
        this.elastico = elastico;
    }

    public Primario getPrimario() {
        return primario;
    }

    public void setPrimario(Primario primario) {
        this.primario = primario;
    }

    public Tela getTela() {
        return tela;
    }

    public void setTela(Tela tela) {
        this.tela = tela;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
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

    public List<Elastico> getListaElasticos() {
        return listaElasticos;
    }

    public void setListaElasticos(List<Elastico> listaElasticos) {
        this.listaElasticos = listaElasticos;
    }

    public List<Primario> getListaPrimarios() {
        return listaPrimarios;
    }

    public void setListaPrimarios(List<Primario> listaPrimarios) {
        this.listaPrimarios = listaPrimarios;
    }

    public List<Tela> getListaTelas() {
        return listaTelas;
    }

    public void setListaTelas(List<Tela> listaTelas) {
        this.listaTelas = listaTelas;
    }
    
    public void registrarBoton() throws Exception {
        MaterialDAO dao = new MaterialDAO();
        dao.registrarBoton(boton);
        listarBotones();
        Mensajes.generarMensaje("Éxito", "El botón ha sido registrado.");
    }
    
    public void listarBotones() throws Exception {
        MaterialDAO dao = new MaterialDAO();
        listaBotones = dao.listarBotones();
    }
    
    public void leerIdBoton(Boton boton2) throws Exception {
        MaterialDAO dao = new MaterialDAO();
        System.out.println("1");
        this.boton = dao.leerIdBoton(boton2);
        System.out.println("2");
        Mensajes.generarMensaje("ed", "daef");
    }

    public void actualizarBoton() throws Exception {
        MaterialDAO dao = new MaterialDAO();
        dao.actualizarBoton(boton);
        listarBotones();
        Mensajes.generarMensaje("Éxito", "El botón ha sido actualizado.");
    }
    
    public void registrarCierre() throws Exception {
        MaterialDAO dao = new MaterialDAO();
        dao.registrarCierre(cierre);
        listarCierres();
        Mensajes.generarMensaje("Éxito", "El cierre ha sido registrado.");
    }
    
    public void listarCierres() throws Exception {
        MaterialDAO dao = new MaterialDAO();
        listaCierres = dao.listarCierres();
    }
    
    public void leerIdCierre(Cierre cierre2) throws Exception {
        MaterialDAO dao = new MaterialDAO();
        this.cierre = dao.leerIdCierre(cierre2);
    }

    public void actualizarCierre() throws Exception {
        MaterialDAO dao = new MaterialDAO();
        dao.actualizarCierre(cierre);
        listarCierres();
        Mensajes.generarMensaje("Éxito", "El botón ha sido actualizado.");
    }
    
    public void registrarElastico() throws Exception {
        MaterialDAO dao = new MaterialDAO();
        dao.registrarElastico(elastico);
        listarElasticos();
        Mensajes.generarMensaje("Éxito", "El material elástico ha sido registrado.");
    }
    
    public void listarElasticos() throws Exception {
        MaterialDAO dao = new MaterialDAO();
        listaElasticos = dao.listarElasticos();
    }
    
    public void leerIdElastico(Elastico elastico2) throws Exception {
        MaterialDAO dao = new MaterialDAO();
        this.elastico = dao.leerIdElastico(elastico2);
    }

    public void actualizarElastico() throws Exception {
        MaterialDAO dao = new MaterialDAO();
        dao.actualizarElastico(elastico);
        listarElasticos();
        Mensajes.generarMensaje("Éxito", "El material elástico ha sido actualizado.");
    }
    
    public void registrarPrimario() throws Exception {
        MaterialDAO dao = new MaterialDAO();
        dao.registrarPrimario(primario);
        listarPrimarios();
        Mensajes.generarMensaje("Éxito", "El material primario ha sido registrado.");
    }
    
    public void listarPrimarios() throws Exception {
        MaterialDAO dao = new MaterialDAO();
        listaPrimarios = dao.listarPrimarios();
    }
    
    public void leerIdPrimario(Primario primario2) throws Exception {
        MaterialDAO dao = new MaterialDAO();
        this.primario = dao.leerIdPrimario(primario2);
    }

    public void actualizarPrimario() throws Exception {
        MaterialDAO dao = new MaterialDAO();
        dao.actualizarPrimario(primario);
        listarPrimarios();
        Mensajes.generarMensaje("Éxito", "El material primario ha sido actualizado.");
    }
    
    public void registrarTela() throws Exception {
        MaterialDAO dao = new MaterialDAO();
        dao.registrarTela(tela);
        listarTelas();
        Mensajes.generarMensaje("Éxito", "La tela ha sido registrado.");
    }
    
    public void listarTelas() throws Exception {
        MaterialDAO dao = new MaterialDAO();
        listaTelas = dao.listarTelas();
    }
    
    public void leerIdTela(Tela tela2) throws Exception {
        MaterialDAO dao = new MaterialDAO();
        this.tela = dao.leerIdTela(tela2);
    }

    public void actualizarTela() throws Exception {
        MaterialDAO dao = new MaterialDAO();
        dao.actualizarTela(tela);
        listarTelas();
        Mensajes.generarMensaje("Éxito", "La tela ha sido actualizado.");
    }
    
}
